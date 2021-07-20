package br.com.api.models.utils;

public enum Currency {
    REAL("Real"),
    DOLAR("Dólar"),
    LIBRA("Libra"),
    EURO("Euro");

    private String selectedCurrency;

    Currency(String selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }

    public String getSelectedCurrency() {
        return selectedCurrency;
    }
}
