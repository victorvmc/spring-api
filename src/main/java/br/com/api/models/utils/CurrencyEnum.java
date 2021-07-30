package br.com.api.models.utils;

public enum CurrencyEnum {
    REAL(1,"Real"),
    DOLAR(2,"Dólar"),
    LIBRA(3,"Libra"),
    EURO(4,"Euro");

    private Integer code;
    private String selectedCurrency;

    CurrencyEnum(Integer code, String selectedCurrency) {
        this.code = code;
        this.selectedCurrency = selectedCurrency;
    }

    public String getSelectedCurrency() {
        return selectedCurrency;
    }
}
