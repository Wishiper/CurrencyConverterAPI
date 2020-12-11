package demoprojects.currencyconverterapi.services.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import demoprojects.currencyconverterapi.models.dto.response.ConvertCurrencyResponseDTO;
import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;

public interface CurrencyService {

    ConvertCurrencyResponseDTO convertCurrency(ConvertCurrencyRequestDTO convertCurrencyResponseDTO);
    double getExchangeRate(String toCurrencty) throws JsonProcessingException;
}
