package demoprojects.currencyconverterapi.models.dto.response;

import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;

/**
 * Holds details about the currency that is to be converted.
 */
public class ConvertCurrencyResponseDTO {

    private boolean success;
    private ConvertCurrencyRequestDTO query;
    private double exchangeRate;
    private double exchangeFeeRate;
    private double exchangeFeeAmount;
    private double result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ConvertCurrencyRequestDTO getQuery() {
        return query;
    }

    public void setQuery(ConvertCurrencyRequestDTO query) {
        this.query = query;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeFeeRate() {
        return exchangeFeeRate;
    }

    public void setExchangeFeeRate(double exchangeFeeRate) {
        this.exchangeFeeRate = exchangeFeeRate;
    }

    public double getExchangeFeeAmount() {
        return exchangeFeeAmount;
    }

    public void setExchangeFeeAmount(double exchangeFeeAmount) {
        this.exchangeFeeAmount = exchangeFeeAmount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}