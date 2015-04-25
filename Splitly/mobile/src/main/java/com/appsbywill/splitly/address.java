package com.appsbywill.splitly;

/**
 * Created by William on 4/25/2015.
 */
public class address {
    String BillingAddress1 = "";
    String BillingZipcode = "";

    public String getBillingZipcode() {
        return BillingZipcode;
    }

    public void setBillingZipcode(String billingZipcode) {
        BillingZipcode = billingZipcode;
    }

    public String getBillingAddress1() {
        return BillingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        BillingAddress1 = billingAddress1;
    }
}
