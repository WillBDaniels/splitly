package com.appsbywill.splitly;

/**
 * Created by William on 4/25/2015.
 */
public class terminal {
    int TerminalID = 0;
    String EntryMode = "";
    String Ipv4Address = "";
    String TerminalEnvironmentalCode = "";
    String PinEntry = "";
    boolean BalanceInquiry = false;
    boolean HostAdjustment = false;
    String DeviceType = "";
    String CardInputCode = "";

    public int getTerminalID() {
        return TerminalID;
    }

    public void setTerminalID(int terminalID) {
        TerminalID = terminalID;
    }

    public String getEntryMode() {
        return EntryMode;
    }

    public void setEntryMode(String entryMode) {
        EntryMode = entryMode;
    }

    public String getIpv4Address() {
        return Ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        Ipv4Address = ipv4Address;
    }

    public String getTerminalEnvironmentalCode() {
        return TerminalEnvironmentalCode;
    }

    public void setTerminalEnvironmentalCode(String terminalEnvironmentalCode) {
        TerminalEnvironmentalCode = terminalEnvironmentalCode;
    }

    public String getPinEntry() {
        return PinEntry;
    }

    public void setPinEntry(String pinEntry) {
        PinEntry = pinEntry;
    }

    public boolean isBalanceInquiry() {
        return BalanceInquiry;
    }

    public void setBalanceInquiry(boolean balanceInquiry) {
        BalanceInquiry = balanceInquiry;
    }

    public boolean isHostAdjustment() {
        return HostAdjustment;
    }

    public void setHostAdjustment(boolean hostAdjustment) {
        HostAdjustment = hostAdjustment;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getCardInputCode() {
        return CardInputCode;
    }

    public void setCardInputCode(String cardInputCode) {
        CardInputCode = cardInputCode;
    }
}
