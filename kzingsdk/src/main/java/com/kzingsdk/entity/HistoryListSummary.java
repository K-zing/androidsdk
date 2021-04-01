package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class HistoryListSummary implements Parcelable {

    private String totalBet = "";
    private String totalWin = "";
    private String totalBetAmt = "";
    private String totalValidBetAmt = "";
    private ArrayList<HistoryListItem> betItems = new ArrayList<>();
    private boolean noMoreData = false;

    public HistoryListSummary() {

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
        return historyListSummary;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(totalBet);
        dest.writeString(totalWin);
        dest.writeString(totalBetAmt);
        dest.writeString(totalValidBetAmt);
        dest.writeInt(noMoreData ? 1 : 0);
        dest.writeArray(new Object[]{
                betItems
        });
    }

    public HistoryListSummary(Parcel in) {
        totalBet = in.readString();
        totalWin = in.readString();
        totalBetAmt = in.readString();
        totalValidBetAmt = in.readString();
        noMoreData = in.readInt() == 1;
        betItems = (ArrayList<HistoryListItem>) in.readArray(HistoryListSummary.class.getClassLoader())[0];
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
