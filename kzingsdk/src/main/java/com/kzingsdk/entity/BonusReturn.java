package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class BonusReturn implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public BonusReturn createFromParcel(Parcel in) {
            return new BonusReturn(in);
        }

        public BonusReturn[] newArray(int size) {
            return new BonusReturn[size];
        }
    };

    private String actName = "";
    private String dno = "";
    private String amount = "";
    private String validBet = "";
    private String gp = "";
    private String type = "";
    private String typeId = "";
    private String created = "";
    private String currency = "";


    public BonusReturn() {

    }

    public BonusReturn(Parcel in) {
        actName = in.readString();
        dno = in.readString();
        amount = in.readString();
        validBet = in.readString();
        gp = in.readString();
        type = in.readString();
        typeId = in.readString();
        created = in.readString();
        currency = in.readString();
    }

    public static BonusReturn newInstance(JSONObject rootObject) {
        BonusReturn bonusReturn = new BonusReturn();
        bonusReturn.setActName(rootObject.optString("actname"));
        bonusReturn.setDno(rootObject.optString("dno"));
        bonusReturn.setAmount(rootObject.optString("money"));
        bonusReturn.setValidBet(rootObject.optString("validbet"));
        bonusReturn.setGp(rootObject.optString("gp"));
        bonusReturn.setType(rootObject.optString("type"));
        bonusReturn.setTypeId(rootObject.optString("type_id"));
        bonusReturn.setCreated(rootObject.optString("time"));
        bonusReturn.setCurrency(rootObject.optString("currency"));
        return bonusReturn;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    /**
     * @return ID of the Bonus or Return record.
     */
    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getValidBet() {
        return validBet;
    }

    public void setValidBet(String validBet) {
        this.validBet = validBet;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(actName);
        dest.writeString(dno);
        dest.writeString(amount);
        dest.writeString(validBet);
        dest.writeString(gp);
        dest.writeString(type);
        dest.writeString(typeId);
        dest.writeString(created);
        dest.writeString(currency);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "BonusReturn{" +
                "dno='" + dno + '\'' +
                ", amount='" + amount + '\'' +
                ", gp='" + gp + '\'' +
                ", type='" + type + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}

