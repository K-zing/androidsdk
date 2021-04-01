package com.kzingsdk.entity;

import org.json.JSONObject;

public class IplMatchesData {

    protected String awayId;
    protected String awayName;
    protected String awayOdd;
    protected String competitionId;
    protected String competitionName;
    protected String extraCol;
    protected String gpid;
    protected String homeId;
    protected String homeName;
    protected String homeOdd;
    protected String lang;
    protected String matchDate;
    protected String matchId;
    protected String sportId;

    public static IplMatchesData newInstance(JSONObject rootObject) {
        IplMatchesData iplMatchesData = new IplMatchesData();
        iplMatchesData.setAwayId(rootObject.optString("awayid"));
        iplMatchesData.setAwayName(rootObject.optString("awayname"));
        iplMatchesData.setAwayOdd(rootObject.optString("awayodd"));
        iplMatchesData.setCompetitionId(rootObject.optString("competitionid"));
        iplMatchesData.setCompetitionName(rootObject.optString("competitionname"));
        iplMatchesData.setExtraCol(rootObject.optString("extracol"));
        iplMatchesData.setGpid(rootObject.optString("gpid"));
        iplMatchesData.setHomeId(rootObject.optString("homeid"));
        iplMatchesData.setHomeName(rootObject.optString("homename"));
        iplMatchesData.setHomeOdd(rootObject.optString("homeodd"));
        iplMatchesData.setLang(rootObject.optString("lang"));
        iplMatchesData.setMatchDate(rootObject.optString("matchdate"));
        iplMatchesData.setMatchId(rootObject.optString("matchid"));
        iplMatchesData.setSportId(rootObject.optString("sportid"));
        return iplMatchesData;
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
