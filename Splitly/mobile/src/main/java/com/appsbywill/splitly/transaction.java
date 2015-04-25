package com.appsbywill.splitly;

import java.math.BigDecimal;

/**
 * Created by William on 4/25/2015.
 */
public class transaction {
    int TransactionID = 0;
    String PaymentType = "";
    int ReferenceNumber = 0;
    int DraftLocatorID = 0;
    int ClerkNumber = 0;
    String MarketCode = "";
    String TransactionTimestamp = "";
    int SystemTraceID = 0;
    boolean TokenRequested = false;
    BigDecimal TransactionAmount = new BigDecimal(0.0);
    String PartialApprovalCode = "";

    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int transactionID) {
        TransactionID = transactionID;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public int getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        ReferenceNumber = referenceNumber;
    }

    public int getDraftLocatorID() {
        return DraftLocatorID;
    }

    public void setDraftLocatorID(int draftLocatorID) {
        DraftLocatorID = draftLocatorID;
    }

    public int getClerkNumber() {
        return ClerkNumber;
    }

    public void setClerkNumber(int clerkNumber) {
        ClerkNumber = clerkNumber;
    }

    public String getMarketCode() {
        return MarketCode;
    }

    public void setMarketCode(String marketCode) {
        MarketCode = marketCode;
    }

    public String getTransactionTimestamp() {
        return TransactionTimestamp;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        TransactionTimestamp = transactionTimestamp;
    }

    public int getSystemTraceID() {
        return SystemTraceID;
    }

    public void setSystemTraceID(int systemTraceID) {
        SystemTraceID = systemTraceID;
    }

    public boolean isTokenRequested() {
        return TokenRequested;
    }

    public void setTokenRequested(boolean tokenRequested) {
        TokenRequested = tokenRequested;
    }

    public BigDecimal getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public String getPartialApprovalCode() {
        return PartialApprovalCode;
    }

    public void setPartialApprovalCode(String partialApprovalCode) {
        PartialApprovalCode = partialApprovalCode;
    }
}
