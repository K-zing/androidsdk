package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;


public class CryptoTransaction {

    private String id;
    private String created;
    private BigDecimal redeemToken;
    private HashMap<String, BigDecimal> trxDetail = new HashMap<>();

    public CryptoTransaction() {

    }

    public static CryptoTransaction newInstance(JSONObject rootObject) {
        CryptoTransaction cryptoTransaction = new CryptoTransaction();
        cryptoTransaction.setId(rootObject.optString("id"));
        cryptoTransaction.setCreated(rootObject.optString("created"));
        cryptoTransaction.setRedeemToken(BigDecimalUtil.optBigDecimal(rootObject, "redeemtoken"));
        JSONObject trxDetailObject = rootObject.optJSONObject("trx_detail");
        if (trxDetailObject != null) {
            cryptoTransaction.trxDetail.put("ETH", BigDecimalUtil.optBigDecimal(trxDetailObject, "ETH"));
            cryptoTransaction.trxDetail.put("mBTC", BigDecimalUtil.optBigDecimal(trxDetailObject, "mBTC"));
            cryptoTransaction.trxDetail.put("USDT", BigDecimalUtil.optBigDecimal(trxDetailObject, "USDT"));
        }
        return cryptoTransaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public BigDecimal getRedeemToken() {
        return redeemToken;
    }

    public void setRedeemToken(BigDecimal redeemToken) {
        this.redeemToken = redeemToken;
    }

    public HashMap<String, BigDecimal> getTrxDetail() {
        return trxDetail;
    }

    public void setTrxDetail(HashMap<String, BigDecimal> trxDetail) {
        this.trxDetail = trxDetail;
    }
}

