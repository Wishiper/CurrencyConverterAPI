package demoprojects.currencyconverterapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;
import demoprojects.currencyconverterapi.services.CurrencyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(CurrencyController.class)
class CurrencyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CurrencyServiceImpl currencyService;

    @Test
    void convertCurrency() throws Exception {

        ConvertCurrencyRequestDTO request = new ConvertCurrencyRequestDTO();
        request.setFromCurrency("EUR");
        request.setToCurrency("USD");
        request.setAmount(100);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(get("/api/currency/convert")
                .contentType(MediaType.APPLICATION_JSON).content(json).content(json).characterEncoding("utf-8"));

        verify(currencyService, times(1)).convertCurrency(ArgumentMatchers.any());

    }
}