package br.com.api.models.utils;

public enum CurrencyEnum {
    REAL("Real"),
    DOLAR("Dólar"),
    LIBRA("Libra"),
    EURO("Euro");

    private String selectedCurrency;

    CurrencyEnum(String selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }

    public String getSelectedCurrency() {
        return selectedCurrency;
    }
}
