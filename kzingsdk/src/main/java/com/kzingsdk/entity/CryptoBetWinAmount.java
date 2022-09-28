package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class CryptoBetWinAmount {

    private String currency;
    private String playerName;
    private String game;
    private BigDecimal payout;

    public CryptoBetWinAmount() {

    }

    public static CryptoBetWinAmount newInstance(JSONObject rootObject) {
        CryptoBetWinAmount activityBonus = new CryptoBetWinAmount();
        activityBonus.setCurrency(rootObject.optString("currency"));
        activityBonus.setPlayerName(rootObject.optString("playername"));
        activityBonus.setGame(rootObject.optString("game"));
        activityBonus.setPayout(BigDecimalUtil.optBigDecimal(rootObject, "payout"));
        return activityBonus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }
}

