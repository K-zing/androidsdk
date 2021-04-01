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
    private String dno = "";
    private String amount = "";
    private String gp = "";
    private String type = "";
    private String created = "";

    public BonusReturn() {

    }

    public BonusReturn(Parcel in) {
        dno = in.readString();
        amount = in.readString();
        gp = in.readString();
        type = in.readString();
        created = in.readString();
    }

    public static BonusReturn newInstance(JSONObject rootObject) {
        BonusReturn bonusReturn = new BonusReturn();
        bonusReturn.setDno(rootObject.optString("dno"));
        bonusReturn.setAmount(rootObject.optString("money"));
        bonusReturn.setGp(rootObject.optString("gp"));
        bonusReturn.setType(rootObject.optString("type"));
        bonusReturn.setCreated(rootObject.optString("time"));
        return bonusReturn;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dno);
        dest.writeString(amount);
        dest.writeString(gp);
        dest.writeString(type);
        dest.writeString(created);
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

