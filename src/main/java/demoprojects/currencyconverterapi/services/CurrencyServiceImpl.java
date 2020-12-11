package demoprojects.currencyconverterapi.services;

import demoprojects.currencyconverterapi.models.dto.response.ConvertCurrencyResponseDTO;
import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;
import demoprojects.currencyconverterapi.models.dto.request.ExchangeRatesRequestDTO;
import demoprojects.currencyconverterapi.services.base.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.Objects;

@Service
@Configuration
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private Environment env;


    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ConvertCurrencyResponseDTO convertCurrency(ConvertCurrencyRequestDTO request) {
        ConvertCurrencyResponseDTO response = new ConvertCurrencyResponseDTO();
        double exchangeRate = getExchangeRate(request.getToCurrency());
        double exchangeFeeRate = Double.parseDouble(Objects.requireNonNull(
                env.getProperty(request.getToCurrency().toLowerCase(Locale.ROOT) + ".fee")));
        double exchangeFeeAmount = request.getAmount() * exchangeFeeRate;
        double result = (request.getAmount() - exchangeFeeAmount) * exchangeRate;


        if(exchangeRate!=0) {
            response.setSuccess(true);
            response.setQuery(request);
            response.setExchangeRate(exchangeRate);
            response.setExchangeFeeRate(exchangeFeeRate);
            response.setExchangeFeeAmount(exchangeFeeAmount);
            response.setResult(result);
        }if(exchangeRate==0){
            response.setSuccess(false);
            response.setQuery(request);
        }

        return response;
    }

    @Override
    public double getExchangeRate(String toCurrency) {
        String exchangeRatesUrl = env.getProperty("exchange.rate.url") + env.getProperty("fixer.io.api.key");
        ExchangeRatesRequestDTO ratesRequest = restTemplate.getForObject(exchangeRatesUrl, ExchangeRatesRequestDTO.class);
        assert ratesRequest != null;
        return ratesRequest.getRates().getOrDefault(toCurrency,0d);

    }
}
