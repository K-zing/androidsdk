package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class Parlay implements Parcelable {

    private String period = "";
    private String betTypeDesc = "";
    private String awayTeamHtScore = "";
    private String handicap = "";
    private String wagerHomeTeamScore = "";
    private String awayTeamFtScore = "";
    private String type = "";
    private String homeTeamFtScore = "";
    private String market = "";
    private String awayTeamName = "";
    private String selection = "";
    private String competitionName = "";
    private String homeTeamName = "";
    private String odds = "";
    private String oddType = "";
    private String homeTeamHtScore = "";
    private String eventDateTime = "";
    private String wagerAwayTeamScore = "";

    public Parlay() {

    }

    public static Parlay newInstance(JSONObject rootObject) {
        Parlay parlay = new Parlay();
        parlay.setPeriod(rootObject.optString("period"));
        parlay.setBetTypeDesc(rootObject.optString("bettypedesc"));
        parlay.setAwayTeamHtScore(rootObject.optString("awayteamhtscore"));
        parlay.setHandicap(rootObject.optString("handicap"));
        parlay.setWagerHomeTeamScore(rootObject.optString("wagerhometeamscore"));
        parlay.setAwayTeamFtScore(rootObject.optString("awayteamftscore"));
        parlay.setType(rootObject.optString("type"));
        parlay.setHomeTeamFtScore(rootObject.optString("hometeamftscore"));
        parlay.setMarket(rootObject.optString("market"));
        parlay.setAwayTeamName(rootObject.optString("awayteamname"));
        parlay.setSelection(rootObject.optString("selection"));
        parlay.setCompetitionName(rootObject.optString("competitionname"));
        parlay.setHomeTeamName(rootObject.optString("hometeamname"));
        parlay.setOdds(rootObject.optString("odds"));
        parlay.setOddType(rootObject.optString("oddtype"));
        parlay.setHomeTeamHtScore(rootObject.optString("hometeamhtscore"));
        parlay.setEventDateTime(rootObject.optString("eventdatetime"));
        parlay.setWagerAwayTeamScore(rootObject.optString("wagerawayteamscore"));
        return parlay;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBetTypeDesc() {
        return betTypeDesc;
    }

    public void setBetTypeDesc(String betTypeDesc) {
        this.betTypeDesc = betTypeDesc;
    }

    public String getAwayTeamHtScore() {
        return awayTeamHtScore;
    }

    public void setAwayTeamHtScore(String awayTeamHtScore) {
        this.awayTeamHtScore = awayTeamHtScore;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getWagerHomeTeamScore() {
        return wagerHomeTeamScore;
    }

    public void setWagerHomeTeamScore(String wagerHomeTeamScore) {
        this.wagerHomeTeamScore = wagerHomeTeamScore;
    }

    public String getAwayTeamFtScore() {
        return awayTeamFtScore;
    }

    public void setAwayTeamFtScore(String awayTeamFtScore) {
        this.awayTeamFtScore = awayTeamFtScore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHomeTeamFtScore() {
        return homeTeamFtScore;
    }

    public void setHomeTeamFtScore(String homeTeamFtScore) {
        this.homeTeamFtScore = homeTeamFtScore;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getOddType() {
        return oddType;
    }

    public void setOddType(String oddType) {
        this.oddType = oddType;
    }

    public String getHomeTeamHtScore() {
        return homeTeamHtScore;
    }

    public void setHomeTeamHtScore(String homeTeamHtScore) {
        this.homeTeamHtScore = homeTeamHtScore;
    }

    public String getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getWagerAwayTeamScore() {
        return wagerAwayTeamScore;
    }

    public void setWagerAwayTeamScore(String wagerAwayTeamScore) {
        this.wagerAwayTeamScore = wagerAwayTeamScore;
    }

    public static final Creator<Parlay> CREATOR = new Creator<Parlay>() {
        @Override
        public Parlay createFromParcel(Parcel in) {
            return new Parlay(in);
        }

        @Override
        public Parlay[] newArray(int size) {
            return new Parlay[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(period);
        dest.writeString(betTypeDesc);
        dest.writeString(awayTeamHtScore);
        dest.writeString(handicap);
        dest.writeString(wagerHomeTeamScore);
        dest.writeString(awayTeamFtScore);
        dest.writeString(type);
        dest.writeString(homeTeamFtScore);
        dest.writeString(market);
        dest.writeString(awayTeamName);
        dest.writeString(selection);
        dest.writeString(competitionName);
        dest.writeString(homeTeamName);
        dest.writeString(odds);
        dest.writeString(oddType);
        dest.writeString(homeTeamHtScore);
        dest.writeString(eventDateTime);
        dest.writeString(wagerAwayTeamScore);
    }

    public Parlay(Parcel in) {
        period = in.readString();
        betTypeDesc = in.readString();
        awayTeamHtScore = in.readString();
        handicap = in.readString();
        wagerHomeTeamScore = in.readString();
        awayTeamFtScore = in.readString();
        type = in.readString();
        homeTeamFtScore = in.readString();
        market = in.readString();
        awayTeamName = in.readString();
        selection = in.readString();
        competitionName = in.readString();
        homeTeamName = in.readString();
        odds = in.readString();
        oddType = in.readString();
        homeTeamHtScore = in.readString();
        eventDateTime = in.readString();
        wagerAwayTeamScore = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Parlay{" +
                "period='" + period + '\'' +
                ", betTypeDesc='" + betTypeDesc + '\'' +
                ", awayTeamHtScore='" + awayTeamHtScore + '\'' +
                ", handicap='" + handicap + '\'' +
                ", wagerHomeTeamScore='" + wagerHomeTeamScore + '\'' +
                ", awayTeamFtScore='" + awayTeamFtScore + '\'' +
                ", type='" + type + '\'' +
                ", homeTeamFtScore='" + homeTeamFtScore + '\'' +
                ", market='" + market + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", selection='" + selection + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", odds='" + odds + '\'' +
                ", oddType='" + oddType + '\'' +
                ", homeTeamHtScore='" + homeTeamHtScore + '\'' +
                ", eventDateTime='" + eventDateTime + '\'' +
                ", wagerAwayTeamScore='" + wagerAwayTeamScore + '\'' +
                '}';
    }
}
