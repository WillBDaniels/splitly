package com.appsbywill.splitly;

/**
 * Created by William on 4/25/2015.
 */
public class merchant {
    String NetworkRouting = "";
    int CashierNumber = 0;
    int LaneNumber = 0;
    int DivisionNumber = 0;
    int ChainCode = 0;
    int StoreNumber = 0;
    String MerchantID = "";

    public String getNetworkRouting() {
        return NetworkRouting;
    }

    public void setNetworkRouting(String networkRouting) {
        NetworkRouting = networkRouting;
    }

    public int getCashierNumber() {
        return CashierNumber;
    }

    public void setCashierNumber(int cashierNumber) {
        CashierNumber = cashierNumber;
    }

    public int getLaneNumber() {
        return LaneNumber;
    }

    public void setLaneNumber(int laneNumber) {
        LaneNumber = laneNumber;
    }

    public int getDivisionNumber() {
        return DivisionNumber;
    }

    public void setDivisionNumber(int divisionNumber) {
        DivisionNumber = divisionNumber;
    }

    public int getChainCode() {
        return ChainCode;
    }

    public void setChainCode(int chainCode) {
        ChainCode = chainCode;
    }

    public int getStoreNumber() {
        return StoreNumber;
    }

    public void setStoreNumber(int storeNumber) {
        StoreNumber = storeNumber;
    }

    public String  getMerchantID() {
        return MerchantID;
    }

    public void setMerchantID(String merchantID) {
        MerchantID = merchantID;
    }
}
