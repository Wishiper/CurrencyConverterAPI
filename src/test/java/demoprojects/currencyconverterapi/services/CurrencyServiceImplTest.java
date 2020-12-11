package demoprojects.currencyconverterapi.services;

import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;
import demoprojects.currencyconverterapi.models.dto.request.ExchangeRatesRequestDTO;
import demoprojects.currencyconverterapi.models.dto.response.ConvertCurrencyResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @Mock
    Environment env;

    @Mock RestTemplate restTemplate;

    @InjectMocks
    private static final CurrencyServiceImpl currencyService = new CurrencyServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertCurrencyShouldReturn_109_6986_WithAmount_100_FeeAmount_9_34_And_USD_ExchangeRate_1_21() {
        double eurFee = 0.0934;
        double exchangeFeeAmount = 9.34;
        double exchangeRateUSD = 1.21;

        ConvertCurrencyRequestDTO request = new ConvertCurrencyRequestDTO();
        request.setFromCurrency("EUR");
        request.setToCurrency("USD");
        request.setAmount(100);

        Map<String,Double> map = new HashMap<>();
        map.put("USD",exchangeRateUSD);
        ExchangeRatesRequestDTO exchangeRatesRequestDTO = new ExchangeRatesRequestDTO();

        exchangeRatesRequestDTO.setRates(map);

        when(env.getProperty(request.getToCurrency().
                toLowerCase(Locale.ROOT) + ".fee")).thenReturn(String.valueOf(eurFee));
        when(env.getProperty("exchange.rate.url")).thenReturn("");
        when(env.getProperty("fixer.io.api.key")).thenReturn("");

        when(restTemplate.getForObject(Mockito.anyString(),
               Mockito.any())).thenReturn(exchangeRatesRequestDTO);

        ConvertCurrencyResponseDTO response = currencyService.convertCurrency(request);
        double result = (100 - exchangeFeeAmount) * exchangeRateUSD;

        assertTrue(response.isSuccess());
        assertEquals(exchangeFeeAmount,response.getExchangeFeeAmount());
        assertEquals(result, response.getResult());
        assertEquals(request,response.getQuery());
        assertEquals(exchangeRateUSD,response.getExchangeRate());
        assertEquals(eurFee,response.getExchangeFeeRate());

    }
}