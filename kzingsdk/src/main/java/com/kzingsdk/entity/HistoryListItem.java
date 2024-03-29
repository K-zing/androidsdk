package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class HistoryListItem implements Parcelable {

    public static final Creator<HistoryListItem> CREATOR = new Creator<HistoryListItem>() {
        @Override
        public HistoryListItem createFromParcel(Parcel in) {
            return new HistoryListItem(in);
        }

        @Override
        public HistoryListItem[] newArray(int size) {
            return new HistoryListItem[size];
        }
    };
    private String betTime = "";
    private String gpType = "";
    private String gpTypeCode = "";
    private String gpid = "";
    private String betNo = "";
    private String betContent = "";
    private String settleName = "";
    private String settleId = "";
    private String betAmt = "";
    private String payout = "";
    private String win = "";
    private String validAmt = "";
    private String gpImage = "";
    private String eventDateTime = "";
    private String comboType = "";
    private String resultScore = "";
    private String potentialPayout = "";
    private Integer tokenStatus = 0;
    private Integer oddStatus = 0;
    private String token = "";
    private String currency = "";
    private String conversion = "";
    private String conversionCurrency = "";
    private ArrayList<Parlay> parlayList = new ArrayList<>();


    public HistoryListItem() {

    }

    public HistoryListItem(Parcel in) {
        betTime = in.readString();
        gpType = in.readString();
        gpTypeCode = in.readString();
        gpid = in.readString();
        betNo = in.readString();
        betContent = in.readString();
        settleName = in.readString();
        settleId = in.readString();
        betAmt = in.readString();
        payout = in.readString();
        win = in.readString();
        validAmt = in.readString();
        gpImage = in.readString();
        eventDateTime = in.readString();
        comboType = in.readString();
        resultScore = in.readString();
        potentialPayout = in.readString();
        tokenStatus = in.readInt();
        oddStatus = in.readInt();
        token = in.readString();
        currency = in.readString();
        conversion = in.readString();
        conversionCurrency = in.readString();
    }

    public static HistoryListItem newInstance(JSONObject rootObject) {
        HistoryListItem historyListItem = new HistoryListItem();
        historyListItem.setBetTime(rootObject.optString("bettime"));
        historyListItem.setGpType(rootObject.optString("gp_type"));
        historyListItem.setGpTypeCode(rootObject.optString("gptype"));
        historyListItem.setGpid(rootObject.optString("gpid"));
        historyListItem.setBetNo(rootObject.optString("bet_no"));
        historyListItem.setBetContent(rootObject.optString("bet_content").replace("<br />", ""));
        historyListItem.setSettleName(rootObject.optString("settleName"));
        historyListItem.setSettleId(rootObject.optString("settleId"));
        historyListItem.setBetAmt(rootObject.optString("betamt"));
        historyListItem.setPayout(rootObject.optString("payout"));
        historyListItem.setWin(rootObject.optString("win"));
        historyListItem.setValidAmt(rootObject.optString("valid_amt"));
        historyListItem.setEventDateTime(rootObject.optString("event_dt"));
        historyListItem.setComboType(rootObject.optString("combotype"));
        historyListItem.setResultScore(rootObject.optString("result_score"));
        historyListItem.setPotentialPayout(rootObject.optString("potentialPayout"));
        historyListItem.setTokenStatus(rootObject.optInt("tokenstatus"));
        historyListItem.setOddStatus(rootObject.optInt("oddstatus"));
        historyListItem.setToken(rootObject.optString("token"));
        historyListItem.setCurrency(rootObject.optString("currency"));
        historyListItem.setConversion(rootObject.optString("conversion"));
        historyListItem.setConversionCurrency(rootObject.optString("conversioncurrency"));

        JSONArray parlayArray = rootObject.optJSONArray("data");
        if (parlayArray != null) {
            ArrayList<Parlay> parlayList = new ArrayList<>();
            for (int i = 0; i < parlayArray.length(); i++) {
                parlayList.add(Parlay.newInstance(parlayArray.optJSONObject(i)));
            }
            historyListItem.setParlayList(parlayList);
        }
        return historyListItem;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getGpImage() {
        return gpImage;
    }

    public void setGpImage(String gpImage) {
        this.gpImage = gpImage;
    }

    public String getSettleId() {
        return settleId;
    }

    public void setSettleId(String settleId) {
        this.settleId = settleId;
    }

    public String getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(String betAmt) {
        this.betAmt = betAmt;
    }

    public String getBetContent() {
        return betContent;
    }

    public void setBetContent(String betContent) {
        this.betContent = betContent;
    }

    public String getBetNo() {
        return betNo;
    }

    public void setBetNo(String betNo) {
        this.betNo = betNo;
    }

    public String getBetTime() {
        return betTime;
    }

    public void setBetTime(String betTime) {
        this.betTime = betTime;
    }

    public String getGpType() {
        return gpType;
    }

    public void setGpType(String gpType) {
        this.gpType = gpType;
    }

    public String getGpTypeCode() {
        return gpTypeCode;
    }

    public void setGpTypeCode(String gpTypeCode) {
        this.gpTypeCode = gpTypeCode;
    }

    public String getPayout() {
        return payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public String getSettleName() {
        return settleName;
    }

    public void setSettleName(String settleName) {
        this.settleName = settleName;
    }

    public String getValidAmt() {
        return validAmt;
    }

    public void setValidAmt(String validAmt) {
        this.validAmt = validAmt;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getComboType() {
        return comboType;
    }

    public void setComboType(String comboType) {
        this.comboType = comboType;
    }

    public String getResultScore() {
        return resultScore;
    }

    public void setResultScore(String resultScore) {
        this.resultScore = resultScore;
    }

    public String getPotentialPayout() {
        return potentialPayout;
    }

    public void setPotentialPayout(String potentialPayout) {
        this.potentialPayout = potentialPayout;
    }

    public ArrayList<Parlay> getParlayList() {
        return parlayList;
    }

    public void setParlayList(ArrayList<Parlay> parlayList) {
        this.parlayList = parlayList;
    }

    public Integer getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(Integer tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Integer getOddStatus() {
        return oddStatus;
    }

    public void setOddStatus(Integer oddStatus) {
        this.oddStatus = oddStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getConversionCurrency() {
        return conversionCurrency;
    }

    public void setConversionCurrency(String conversionCurrency) {
        this.conversionCurrency = conversionCurrency;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(betTime);
        dest.writeString(gpType);
        dest.writeString(gpTypeCode);
        dest.writeString(gpid);
        dest.writeString(betNo);
        dest.writeString(betContent);
        dest.writeString(settleName);
        dest.writeString(settleId);
        dest.writeString(betAmt);
        dest.writeString(payout);
        dest.writeString(win);
        dest.writeString(validAmt);
        dest.writeString(gpImage);
        dest.writeString(eventDateTime);
        dest.writeString(comboType);
        dest.writeString(resultScore);
        dest.writeString(potentialPayout);
        dest.writeInt(tokenStatus);
        dest.writeInt(oddStatus);
        dest.writeString(token);
        dest.writeString(currency);
        dest.writeString(conversion);
        dest.writeString(conversionCurrency);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "HistoryListItem{" +
                "betTime='" + betTime + '\'' +
                ", gpType='" + gpType + '\'' +
                ", gpid='" + gpid + '\'' +
                ", betNo='" + betNo + '\'' +
                ", betContent='" + betContent + '\'' +
                ", settleName='" + settleName + '\'' +
                ", settleId='" + settleId + '\'' +
                ", betAmt='" + betAmt + '\'' +
                ", payout='" + payout + '\'' +
                ", win='" + win + '\'' +
                ", validAmt='" + validAmt + '\'' +
                ", eventDateTime='" + eventDateTime + '\'' +
                ", comboType='" + comboType + '\'' +
                ", resultScore='" + resultScore + '\'' +
                ", potentialPayout='" + potentialPayout + '\'' +
                ", gpImage='" + gpImage + '\'' +
                '}';
    }
}
