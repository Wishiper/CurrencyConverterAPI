package demoprojects.currencyconverterapi.models.dto.request;

public class ConvertCurrencyRequestDTO {
    private String fromCurrency;
    private String toCurrency;
    private double amount;


    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }
}
