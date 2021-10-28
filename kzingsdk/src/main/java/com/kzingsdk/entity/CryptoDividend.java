package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class CryptoDividend {

    private BigDecimal poolDiv;
    private BigDecimal poolDivConvert;
    private BigDecimal playerRedeem;
    private BigDecimal playerRedeemConvert;
    private BigDecimal rate;

    public CryptoDividend() {

    }

    public static CryptoDividend newInstance(JSONObject rootObject) {
        CryptoDividend cryptoDividend = new CryptoDividend();
        cryptoDividend.setPoolDiv(BigDecimalUtil.optBigDecimal(rootObject, "pool_div"));
        cryptoDividend.setPoolDivConvert(BigDecimalUtil.optBigDecimal(rootObject, "pool_div_convert"));
        cryptoDividend.setPlayerRedeem(BigDecimalUtil.optBigDecimal(rootObject, "player_redeem"));
        cryptoDividend.setPlayerRedeemConvert(BigDecimalUtil.optBigDecimal(rootObject, "player_redeem_convert"));
        cryptoDividend.setRate(BigDecimalUtil.optBigDecimal(rootObject, "rate"));
        return cryptoDividend;
    }

    public BigDecimal getPoolDiv() {
        return poolDiv;
    }

    public void setPoolDiv(BigDecimal poolDiv) {
        this.poolDiv = poolDiv;
    }

    public BigDecimal getPoolDivConvert() {
        return poolDivConvert;
    }

    public void setPoolDivConvert(BigDecimal poolDivConvert) {
        this.poolDivConvert = poolDivConvert;
    }

    public BigDecimal getPlayerRedeem() {
        return playerRedeem;
    }

    public void setPlayerRedeem(BigDecimal playerRedeem) {
        this.playerRedeem = playerRedeem;
    }

    public BigDecimal getPlayerRedeemConvert() {
        return playerRedeemConvert;
    }

    public void setPlayerRedeemConvert(BigDecimal playerRedeemConvert) {
        this.playerRedeemConvert = playerRedeemConvert;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}

