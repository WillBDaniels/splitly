package com.appsbywill.splitly;

import java.math.BigDecimal;

/**
 * Created by William on 4/25/2015.
 */
public class JSONHolder {

	private merchant merchant;
    private terminal terminal;
    private transaction transaction;
    private address address;
    private card card;

    public merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(merchant merchant) {
        this.merchant = merchant;
    }

    public terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(terminal terminal) {
        this.terminal = terminal;
    }

    public transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }

    public address getAddress() {
        return address;
    }

    public void setAddress(address address) {
        this.address = address;
    }

    public card getCard() {
        return card;
    }

    public void setCard(card card) {
        this.card = card;
    }
}
