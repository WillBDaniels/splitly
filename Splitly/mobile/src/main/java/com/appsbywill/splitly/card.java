package com.appsbywill.splitly;

/**
 * Created by William on 4/25/2015.
 */
public class card {
    String CardType = "";
    String CardNumber = "";
    String CVV = "";
    int ExpirationMonth = 0;
    int ExpirationYear = 0;

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public int getExpirationMonth() {
        return ExpirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        ExpirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return ExpirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        ExpirationYear = expirationYear;
    }
}
