package com.kzingsdk.entity;

import org.json.JSONObject;

public class QpWallet {

    private String id;
    private String ptName = "";

    public static QpWallet newInstance(JSONObject rootObject) {
        QpWallet qpWallet = new QpWallet();
        qpWallet.setId(rootObject.optString("id"));
        qpWallet.setPtName(rootObject.optString("ptname"));
        return qpWallet;
    }


    public String getId() {
        return id;
    }

    public QpWallet setId(String id) {
        this.id = id;
        return this;
    }

    public String getPtName() {
        return ptName;
    }

    public QpWallet setPtName(String ptName) {
        this.ptName = ptName;
        return this;
    }
}
