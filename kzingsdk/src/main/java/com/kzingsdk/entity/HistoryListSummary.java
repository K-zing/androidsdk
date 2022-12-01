package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class HistoryListSummary implements Parcelable {

    public static final Creator<HistoryListSummary> CREATOR = new Creator<HistoryListSummary>() {
        @Override
        public HistoryListSummary createFromParcel(Parcel in) {
            return new HistoryListSummary(in);
        }

        @Override
        public HistoryListSummary[] newArray(int size) {
            return new HistoryListSummary[size];
        }
    };
    private String total = "";
    private String totalBet = "";
    private String totalWin = "";
    private String totalBetAmt = "";
    private String totalValidBetAmt = "";
    private ArrayList<HistoryListItem> betItems = new ArrayList<>();
    private HashMap<String, HistoryListCurrencySummary> currencySummaryMap = new HashMap<>();
    private boolean noMoreData = false;

    public HistoryListSummary() {

    }

    public HistoryListSummary(Parcel in) {
        total = in.readString();
        totalBet = in.readString();
        totalWin = in.readString();
        totalBetAmt = in.readString();
        totalValidBetAmt = in.readString();
        noMoreData = in.readInt() == 1;
        Object[] objectArray = in.readArray(HistoryListSummary.class.getClassLoader());
        betItems = (ArrayList<HistoryListItem>) objectArray[0];
        currencySummaryMap = (HashMap<String, HistoryListCurrencySummary>) objectArray[1];

    }

    public static HistoryListSummary newInstance(JSONObject rootObject) {
        HistoryListSummary historyListSummary = new HistoryListSummary();
        JSONObject imageObject = rootObject.optJSONObject("imgurl");
        HashMap<String, String> gpidMap = new HashMap<>();
        if (imageObject != null) {
            Iterator<?> keys = imageObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                gpidMap.put(key, imageObject.optJSONObject(key).optString("an"));
            }
        }

        historyListSummary.setNoMoreData(imageObject == null);
        historyListSummary.setTotal(rootObject.optString("total"));
        historyListSummary.setTotalBet(rootObject.optString("totalbets"));
        historyListSummary.setTotalWin(rootObject.optString("totalwin"));
        historyListSummary.setTotalBetAmt(rootObject.optString("totalbetamt"));
        historyListSummary.setTotalValidBetAmt(rootObject.optString("totalvalidbetamt"));
        JSONArray betsJSONArray = rootObject.optJSONArray("bets");
        if (betsJSONArray != null) {
            for (int i = 0; i < betsJSONArray.length(); i++) {
                JSONObject betObject = betsJSONArray.optJSONObject(i);
                HistoryListItem historyListItem = HistoryListItem.newInstance(betObject);
                historyListItem.setGpImage(gpidMap.get(historyListItem.getGpid()));
                historyListSummary.betItems.add(historyListItem);
            }
        }

        JSONArray currencyTotalJSONArray = rootObject.optJSONArray("currencytotal");
        if (currencyTotalJSONArray != null) {
            for (int i = 0; i < currencyTotalJSONArray.length(); i++) {
                JSONObject betObject = currencyTotalJSONArray.optJSONObject(i);
                HistoryListCurrencySummary historyListCurrencySummary = HistoryListCurrencySummary.newInstance(betObject);
                historyListSummary.currencySummaryMap.put(historyListCurrencySummary.getCurrency(), historyListCurrencySummary);
            }
        }
        return historyListSummary;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalBet() {
        return totalBet;
    }

    public void setTotalBet(String totalBet) {
        this.totalBet = totalBet;
    }

    public String getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(String totalWin) {
        this.totalWin = totalWin;
    }

    public String getTotalBetAmt() {
        return totalBetAmt;
    }

    public void setTotalBetAmt(String totalBetAmt) {
        this.totalBetAmt = totalBetAmt;
    }

    public String getTotalValidBetAmt() {
        return totalValidBetAmt;
    }

    public void setTotalValidBetAmt(String totalValidBetAmt) {
        this.totalValidBetAmt = totalValidBetAmt;
    }

    public ArrayList<HistoryListItem> getBetItems() {
        return betItems;
    }

    public void setBetItems(ArrayList<HistoryListItem> betItems) {
        this.betItems = betItems;
    }

    public boolean isNoMoreData() {
        return noMoreData;
    }

    public void setNoMoreData(boolean noMoreData) {
        this.noMoreData = noMoreData;
    }

    public HashMap<String, HistoryListCurrencySummary> getCurrencySummaryMap() {
        return currencySummaryMap;
    }

    public void setCurrencySummaryMap(HashMap<String, HistoryListCurrencySummary> currencySummaryMap) {
        this.currencySummaryMap = currencySummaryMap;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(total);
        dest.writeString(totalBet);
        dest.writeString(totalWin);
        dest.writeString(totalBetAmt);
        dest.writeString(totalValidBetAmt);
        dest.writeInt(noMoreData ? 1 : 0);
        dest.writeArray(new Object[]{
                betItems,
                currencySummaryMap
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "HistoryListSummary{" +
                "totalWin='" + totalWin + '\'' +
                ", totalBet='" + totalBet + '\'' +
                ", totalBetAmt='" + totalBetAmt + '\'' +
                ", totalValidBetAmt='" + totalValidBetAmt + '\'' +
                ", betItems=" + betItems +
                ", noMoreData=" + noMoreData +
                '}';
    }
}
