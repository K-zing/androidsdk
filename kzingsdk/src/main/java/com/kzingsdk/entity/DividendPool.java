package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class DividendPool {

    private String min;
    private String max;
    private String limit;
    private Long end;
    private BigDecimal playerToken;
    private BigDecimal poolTotalToken;
    private BigDecimal poolTotalTokenConvert;
    private BigDecimal playerTokenUsd;
    private BigDecimal playerTotalToken;
    private BigDecimal playerTotalTokenConvert;
    private BigDecimal rateTotal;

    private CryptoDividend ethCryptoDividend;
    private CryptoDividend mbtcCryptoDividend;
    private CryptoDividend usdtCryptoDividend;

    public DividendPool() {

    }

    public static DividendPool newInstance(JSONObject rootObject) {
        DividendPool dividendPool = new DividendPool();
        dividendPool.setMin(rootObject.optString("min"));
        dividendPool.setMax(rootObject.optString("max"));
        dividendPool.setLimit(rootObject.optString("limit"));
        dividendPool.setEnd(rootObject.optLong("end"));
        dividendPool.setPlayerToken(BigDecimalUtil.optBigDecimal(rootObject, "player_token"));
        dividendPool.setPoolTotalToken(BigDecimalUtil.optBigDecimal(rootObject, "pool_Total_token"));
        dividendPool.setPoolTotalTokenConvert(BigDecimalUtil.optBigDecimal(rootObject, "pool_Total_token_convert"));
        dividendPool.setPlayerTokenUsd(BigDecimalUtil.optBigDecimal(rootObject, "player_token_usd"));
        dividendPool.setPlayerTotalToken(BigDecimalUtil.optBigDecimal(rootObject, "player_Total_token"));
        dividendPool.setPlayerTotalTokenConvert(BigDecimalUtil.optBigDecimal(rootObject, "player_Total_token_convert"));
        dividendPool.setRateTotal(BigDecimalUtil.optBigDecimal(rootObject, "rate_Total"));
        dividendPool.setEthCryptoDividend(CryptoDividend.newInstance(rootObject.optJSONObject("ETH")));
        dividendPool.setMbtcCryptoDividend(CryptoDividend.newInstance(rootObject.optJSONObject("mBTC")));
        dividendPool.setUsdtCryptoDividend(CryptoDividend.newInstance(rootObject.optJSONObject("USDT")));
        return dividendPool;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public BigDecimal getPlayerToken() {
        return playerToken;
    }

    public void setPlayerToken(BigDecimal playerToken) {
        this.playerToken = playerToken;
    }

    public BigDecimal getPoolTotalToken() {
        return poolTotalToken;
    }

    public void setPoolTotalToken(BigDecimal poolTotalToken) {
        this.poolTotalToken = poolTotalToken;
    }

    public BigDecimal getPoolTotalTokenConvert() {
        return poolTotalTokenConvert;
    }

    public void setPoolTotalTokenConvert(BigDecimal poolTotalTokenConvert) {
        this.poolTotalTokenConvert = poolTotalTokenConvert;
    }

    public BigDecimal getPlayerTokenUsd() {
        return playerTokenUsd;
    }

    public void setPlayerTokenUsd(BigDecimal playerTokenUsd) {
        this.playerTokenUsd = playerTokenUsd;
    }

    public BigDecimal getPlayerTotalToken() {
        return playerTotalToken;
    }

    public void setPlayerTotalToken(BigDecimal playerTotalToken) {
        this.playerTotalToken = playerTotalToken;
    }

    public BigDecimal getPlayerTotalTokenConvert() {
        return playerTotalTokenConvert;
    }

    public void setPlayerTotalTokenConvert(BigDecimal playerTotalTokenConvert) {
        this.playerTotalTokenConvert = playerTotalTokenConvert;
    }

    public BigDecimal getRateTotal() {
        return rateTotal;
    }

    public void setRateTotal(BigDecimal rateTotal) {
        this.rateTotal = rateTotal;
    }

    public CryptoDividend getEthCryptoDividend() {
        return ethCryptoDividend;
    }

    public void setEthCryptoDividend(CryptoDividend ethCryptoDividend) {
        this.ethCryptoDividend = ethCryptoDividend;
    }

    public CryptoDividend getMbtcCryptoDividend() {
        return mbtcCryptoDividend;
    }

    public void setMbtcCryptoDividend(CryptoDividend mbtcCryptoDividend) {
        this.mbtcCryptoDividend = mbtcCryptoDividend;
    }

    public CryptoDividend getUsdtCryptoDividend() {
        return usdtCryptoDividend;
    }

    public void setUsdtCryptoDividend(CryptoDividend usdtCryptoDividend) {
        this.usdtCryptoDividend = usdtCryptoDividend;
    }
}

