package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class TransferRecord implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public TransferRecord createFromParcel(Parcel in) {
            return new TransferRecord(in);
        }

        public TransferRecord[] newArray(int size) {
            return new TransferRecord[size];
        }
    };
    private String dno;
    private String created;
    private String remark;
    private String finalResult;
    private String transAmount;
    private String successAmount;
    private String inGpid;
    private String inGpName;
    private String inGpImage;
    private String outGpid;
    private String outGpName;
    private String outGpImage;
    private String currency;
    private StatusCode statusCode;


    public TransferRecord() {

    }

    public static TransferRecord newInstance(JSONObject rootObject) {
        TransferRecord item = new TransferRecord();
        item.setDno(rootObject.optString("dno"));
        item.setCreated(rootObject.optString("created"));
        item.setRemark(rootObject.optString("remark").replace("&rarr;", "→"));
        item.setFinalResult(rootObject.optString("finalresult"));
        item.setStatusCode(StatusCode.valueOfId(rootObject.optInt("finalresult_code")));
        item.setTransAmount(rootObject.optString("transamount"));
        item.setSuccessAmount(rootObject.optString("successAmount"));
        item.setInGpid(rootObject.optString("ingpid"));
        item.setInGpName(rootObject.optString("ingpname"));
        item.setInGpImage(rootObject.optString("in_image_an"));
        item.setOutGpName(rootObject.optString("outgpname"));
        item.setOutGpid(rootObject.optString("outgpid"));
        item.setOutGpImage(rootObject.optString("out_image_an"));
        item.setCurrency(rootObject.optString("currency"));
        return item;
    }

    public static Creator getCREATOR() {
        return CREATOR;
    }

    /**
     * @return ID of the transfer record.
     */
    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getRemark() {
        return remark.replace("&rarr;", "→");
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getInGpid() {
        return inGpid;
    }

    public void setInGpid(String inGpid) {
        this.inGpid = inGpid;
    }

    public String getInGpName() {
        return inGpName;
    }

    public void setInGpName(String inGpName) {
        this.inGpName = inGpName;
    }

    public String getOutGpid() {
        return outGpid;
    }

    public void setOutGpid(String outGpid) {
        this.outGpid = outGpid;
    }

    public String getOutGpName() {
        return outGpName;
    }

    public void setOutGpName(String outGpName) {
        this.outGpName = outGpName;
    }

    public String getInGpImage() {
        return inGpImage;
    }

    public void setInGpImage(String inGpImage) {
        this.inGpImage = inGpImage;
    }

    public String getOutGpImage() {
        return outGpImage;
    }

    public void setOutGpImage(String outGpImage) {
        this.outGpImage = outGpImage;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(String successAmount) {
        this.successAmount = successAmount;
    }

    public TransferRecord(Parcel in) {
        created = in.readString();
        remark = in.readString();
        finalResult = in.readString();
        transAmount = in.readString();
        successAmount = in.readString();
        inGpid = in.readString();
        inGpName = in.readString();
        outGpid = in.readString();
        outGpName = in.readString();
        inGpImage = in.readString();
        outGpImage = in.readString();
        currency = in.readString();
        statusCode = StatusCode.valueOfId(in.readInt());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created);
        dest.writeString(remark);
        dest.writeString(finalResult);
        dest.writeString(transAmount);
        dest.writeString(successAmount);
        dest.writeString(inGpid);
        dest.writeString(inGpName);
        dest.writeString(outGpid);
        dest.writeString(outGpName);
        dest.writeString(inGpImage);
        dest.writeString(outGpImage);
        dest.writeString(currency);
        dest.writeInt(statusCode.getId());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public enum StatusCode {
        STATUS_PENDING(0),
        STATUS_SUCCESS(1),
        STATUS_FAIL(2);

        private final int id;

        StatusCode(int id) {
            this.id = id;
        }

        public static StatusCode valueOfId(int typeId) {
            for (StatusCode type : StatusCode.values()) {
                if (type.getId() == typeId) {
                    return type;
                }
            }
            return null;
        }

        public int getId() {
            return id;
        }
    }

    @Override
    public String toString() {
        return "TransferRecord{" +
                "dno='" + dno + '\'' +
                ", created='" + created + '\'' +
                ", remark='" + remark + '\'' +
                ", finalResult='" + finalResult + '\'' +
                ", transAmount='" + transAmount + '\'' +
                ", inGpid='" + inGpid + '\'' +
                ", inGpName='" + inGpName + '\'' +
                ", inGpImage='" + inGpImage + '\'' +
                ", outGpid='" + outGpid + '\'' +
                ", outGpName='" + outGpName + '\'' +
                ", outGpImage='" + outGpImage + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
