package com.example.weather;

public class Money {

    private String ID;
    private String CurrencyName;
    private String ForexSelling;
    private String ForexBuying;
    private String date;

    public Money(String ID, String currencyName, String forexSelling, String forexBuying, String date) {
        this.ID = ID;
        CurrencyName = currencyName;
        ForexSelling = forexSelling;
        ForexBuying = forexBuying;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public String getForexSelling() {
        return ForexSelling;
    }

    public void setForexSelling(String forexSelling) {
        ForexSelling = forexSelling;
    }

    public String getForexBuying() {
        return ForexBuying;
    }

    public void setForexBuying(String forexBuying) {
        ForexBuying = forexBuying;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
