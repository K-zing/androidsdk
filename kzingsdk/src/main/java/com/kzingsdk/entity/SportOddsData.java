package com.kzingsdk.entity;

import org.json.JSONObject;


public class SportOddsData {


    private String awayId;
    private String awayName;
    private String awayOdd;
    private String competitionId;
    private String competitionName;
    private String extraCol;
    private String gpid;
    private String homeId;
    private String homeName;
    private String homeOdd;
    private String lang;
    private String matchDate;
    private String matchId;
    private String sportId;


    public SportOddsData() {

    }

    public static SportOddsData newInstance(JSONObject rootObject) {
        SportOddsData item = new SportOddsData();
        item.setAwayId(rootObject.optString("awayid"));
        item.setAwayName(rootObject.optString("awayname"));
        item.setAwayOdd(rootObject.optString("awayodd"));
        item.setCompetitionId(rootObject.optString("competitionid"));
        item.setCompetitionName(rootObject.optString("competitionname"));
        item.setExtraCol(rootObject.optString("extracol"));
        item.setGpid(rootObject.optString("gpid"));
        item.setHomeId(rootObject.optString("homeid"));
        item.setHomeName(rootObject.optString("homename"));
        item.setHomeOdd(rootObject.optString("homeodd"));
        item.setLang(rootObject.optString("lang"));
        item.setMatchDate(rootObject.optString("matchdate"));
        item.setMatchId(rootObject.optString("matchid"));
        item.setSportId(rootObject.optString("sportid"));
        return item;
    }

    public String getAwayId() {
        return awayId;
    }

    public void setAwayId(String awayId) {
        this.awayId = awayId;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getAwayOdd() {
        return awayOdd;
    }

    public void setAwayOdd(String awayOdd) {
        this.awayOdd = awayOdd;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getExtraCol() {
        return extraCol;
    }

    public void setExtraCol(String extraCol) {
        this.extraCol = extraCol;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomeOdd() {
        return homeOdd;
    }

    public void setHomeOdd(String homeOdd) {
        this.homeOdd = homeOdd;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }
}
