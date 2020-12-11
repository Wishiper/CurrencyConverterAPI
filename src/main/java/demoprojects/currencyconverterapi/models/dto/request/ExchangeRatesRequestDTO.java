package demoprojects.currencyconverterapi.models.dto.request;

import java.util.Map;

public class ExchangeRatesRequestDTO {
    private boolean success;
    private String timestamp;
    private String base;
    private String date;
    private Map<String,Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
