package com.kzingsdk.entity;

import org.json.JSONObject;

public class RecommendGames {

    protected Long competitionId;
    protected String awayLogo;
    protected Long matchDate;
    protected String awayName;
    protected String competitionLogo;
    protected String competitionName;
    protected String homeLogo;
    protected Long awayId;
    protected String homeName;
    protected String lang;
    protected Long homeId;
    protected Long matchId;
    protected String matchDateString;


    public static RecommendGames newInstance(JSONObject rootObject) {
        RecommendGames bankCard = new RecommendGames();
        bankCard.setCompetitionId(rootObject.optLong("competitionid"));
        bankCard.setAwayLogo(rootObject.optString("away_logo"));
        bankCard.setMatchDate(rootObject.optLong("matchdate"));
        bankCard.setAwayName(rootObject.optString("awayname"));
        bankCard.setCompetitionLogo(rootObject.optString("competition_logo"));
        bankCard.setCompetitionName(rootObject.optString("competitionname"));
        bankCard.setHomeLogo(rootObject.optString("home_logo"));
        bankCard.setAwayId(rootObject.optLong("awayid"));
        bankCard.setHomeName(rootObject.optString("homename"));
        bankCard.setLang(rootObject.optString("lang"));
        bankCard.setHomeId(rootObject.optLong("homeid"));
        bankCard.setMatchId(rootObject.optLong("matchid"));
        bankCard.setMatchDateString(rootObject.optString("matchdatestring"));
        return bankCard;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getAwayLogo() {
        return awayLogo;
    }

    public void setAwayLogo(String awayLogo) {
        this.awayLogo = awayLogo;
    }

    public Long getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Long matchDate) {
        this.matchDate = matchDate;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getCompetitionLogo() {
        return competitionLogo;
    }

    public void setCompetitionLogo(String competitionLogo) {
        this.competitionLogo = competitionLogo;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getHomeLogo() {
        return homeLogo;
    }

    public void setHomeLogo(String homeLogo) {
        this.homeLogo = homeLogo;
    }

    public Long getAwayId() {
        return awayId;
    }

    public void setAwayId(Long awayId) {
        this.awayId = awayId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getMatchDateString() {
        return matchDateString;
    }

    public void setMatchDateString(String matchDateString) {
        this.matchDateString = matchDateString;
    }

    @Override
    public String toString() {
        return "RecommendGames{" +
                "competitionId=" + competitionId +
                ", awayLogo='" + awayLogo + '\'' +
                ", matchDate=" + matchDate +
                ", awayName='" + awayName + '\'' +
                ", competitionLogo='" + competitionLogo + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", homeLogo='" + homeLogo + '\'' +
                ", awayId=" + awayId +
                ", homeName='" + homeName + '\'' +
                ", lang='" + lang + '\'' +
                ", homeId=" + homeId +
                ", matchId=" + matchId +
                '}';
    }
}
