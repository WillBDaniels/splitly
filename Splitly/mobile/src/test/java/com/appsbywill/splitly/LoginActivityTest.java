package com.appsbywill.splitly;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import com.google.gson.Gson;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class LoginActivityTest  {
    Gson gson = new Gson();

    /*
    @Test
    public void testrst_S_2(){
        JSONHolder jh = new JSONHolder();
        merchant merch = new merchant();
        terminal terminal = new terminal();
        card card= new card();
        address addr = new address();
        transaction trans = new transaction();
        merch.setNetworkRouting("2j");
        merch.setCashierNumber(12345678);
        merch.setLaneNumber(123);
        merch.setDivisionNumber(000);
        merch.setChainCode(70110);
        merch.setMerchantID("4445012916098");
        terminal.setTerminalID(1);
        terminal.setEntryMode("manual");
        terminal.setIpv4Address("192.168.2.235");
        terminal.setTerminalEnvironmentalCode("electronic_cash_register");
        terminal.setPinEntry("none");
        terminal.setBalanceInquiry(false);
        terminal.setHostAdjustment(false);
        terminal.setDeviceType("Software");
        terminal.setCardInputCode("ManualKeyed");
        trans.setTransactionID(123456);
        trans.setPaymentType("single");
        trans.setReferenceNumber(100001);
        trans.setDraftLocatorID(100000001);
        trans.setClerkNumber(1234);
        trans.setMarketCode("present");
        trans.setTransactionTimestamp("2000-12-04T14:00:00");
        trans.setSystemTraceID(100002);
        trans.setTokenRequested(false);
        trans.setTransactionAmount(new BigDecimal(10.00));
        trans.setPartialApprovalCode("not_supported");
        addr.setBillingAddress1("1111 something st");
        addr.setBillingZipcode("33606");
        card.setCardType("masterCard");
        card.setCardNumber("5444009999222205");
        card.setCVV("322");
        card.setExpirationMonth(02);
        card.setExpirationYear(2017);
        jh.setAddress(addr);
        jh.setCard(card);
        jh.setMerchant(merch);
        jh.setTransaction(trans);
        jh.setTerminal(terminal);
        LoginActivity la = new LoginActivity();
        la.sendHttpPost("https://apis.cert.vantiv.com/v1/credit/sale?sp=1", "5cd07ecb9583427ba635cbb0308b4b88$$#$$OX9Wk75ADK6AzK8gAS0PuAElPv9RwKC0$$#$$2016-04-25$$#$$dev_key$$#$$SHA512withRSA$$#$$RSA$$#$$1$$#$$71F8B24E8A0256850A2DE5DE8DE49A662D4F1D0551A0F3F6D58918B07AEA68886A8D141C9E864C9E371AEC8F6E8CCCA7B24855A9AFE49D87025936B4CE935E1C2F77EBD346E6098A9D83A678AC40AA9780427DB2C1345BF2A0364E27A369EDFB04E9B09390B7FA2DDBEE9CA9DB3AA7C739E6ED8BF44F888C3726E0E2B4902E0D9756EC99B746B167060BA4C38B4536FFF567A6FBFC63B6883D6C7882536DDFC0A2DF2DCD6C9B920EB6BEC92F8AC3F507AFB29A8D68F3ECD15045EF8348B0E7CCDB537D11EE1702FB94360B223FFBBC1F2B010410BA8C78E0BCFA83FFA1893690E6399D899F92C3D44EF8454F80004F38696C7EC779094D3634F41D46C1DA6BE4", gson.toJson(jh, JSONHolder.class));
    }*/
}