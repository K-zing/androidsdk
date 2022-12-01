package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class HistoryListCurrencySummary implements Parcelable {

    public static final Creator<HistoryListCurrencySummary> CREATOR = new Creator<HistoryListCurrencySummary>() {
        @Override
        public HistoryListCurrencySummary createFromParcel(Parcel in) {
            return new HistoryListCurrencySummary(in);
        }

        @Override
        public HistoryListCurrencySummary[] newArray(int size) {
            return new HistoryListCurrencySummary[size];
        }
    };
    private String total = "";
    private String win = "";
    private String betAmt = "";
    private String payout = "";
    private String validAmt = "";
    private String invalidBet = "";
    private String winlossAsValidBet = "";
    private String currency = "";

    public HistoryListCurrencySummary() {

    }

    public HistoryListCurrencySummary(Parcel in) {
        total = in.readString();
        win = in.readString();
        betAmt = in.readString();
        payout = in.readString();
        validAmt = in.readString();
        invalidBet = in.readString();
        winlossAsValidBet = in.readString();
        currency = in.readString();
    }

    public static HistoryListCurrencySummary newInstance(JSONObject rootObject) {
        HistoryListCurrencySummary historyListCurrencySummary = new HistoryListCurrencySummary();
        historyListCurrencySummary.setTotal(rootObject.optString("total"));
        historyListCurrencySummary.setWin(rootObject.optString("win"));
        historyListCurrencySummary.setBetAmt(rootObject.optString("betamt"));
        historyListCurrencySummary.setPayout(rootObject.optString("payout"));
        historyListCurrencySummary.setValidAmt(rootObject.optString("validamt"));
        historyListCurrencySummary.setInvalidBet(rootObject.optString("invalidbet"));
        historyListCurrencySummary.setWinlossAsValidBet(rootObject.optString("winlossasvalidbet"));
        historyListCurrencySummary.setCurrency(rootObject.optString("currency"));
        return historyListCurrencySummary;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(String betAmt) {
        this.betAmt = betAmt;
    }

    public String getPayout() {
        return payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public String getValidAmt() {
        return validAmt;
    }

    public void setValidAmt(String validAmt) {
        this.validAmt = validAmt;
    }

    public String getWinlossAsValidBet() {
        return winlossAsValidBet;
    }

    public void setWinlossAsValidBet(String winlossAsValidBet) {
        this.winlossAsValidBet = winlossAsValidBet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInvalidBet() {
        return invalidBet;
    }

    public void setInvalidBet(String invalidBet) {
        this.invalidBet = invalidBet;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(total);
        dest.writeString(win);
        dest.writeString(betAmt);
        dest.writeString(payout);
        dest.writeString(validAmt);
        dest.writeString(invalidBet);
        dest.writeString(winlossAsValidBet);
        dest.writeString(currency);

    }

    @Override
    public int describeContents() {
        return 0;
    }

}
