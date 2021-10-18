package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class DepositRecord implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public DepositRecord createFromParcel(Parcel in) {
            return new DepositRecord(in);
        }

        public DepositRecord[] newArray(int size) {
            return new DepositRecord[size];
        }
    };
    private String dno;
    private String transType;
    private String created;
    private String requestAmount;
    private String actualDepositAmount;
    private String status;
    private String remark;
    private String payName;
    private String currency;
    private String device;
    private String network;
    private StatusCode statusCode;

    public DepositRecord() {

    }


    public static DepositRecord newInstance(JSONObject rootObject) {
        DepositRecord item = new DepositRecord();
        item.setDno(rootObject.optString("dno"));
        item.setTransType(rootObject.optString("transtype"));
        item.setCreated(rootObject.optString("created"));
        item.setRequestAmount(rootObject.optString("amount"));
        item.setActualDepositAmount(rootObject.optString("actual"));
        item.setRemark(rootObject.optString("remark"));
        item.setStatus(rootObject.optString("status"));
        item.setPayName(rootObject.optString("payname"));
        item.setCurrency(rootObject.optString("currency"));
        item.setDevice(rootObject.optString("device"));
        item.setNetwork(rootObject.optString("network"));
        item.setStatusCode(StatusCode.valueOfId(rootObject.optInt("status_code")));
        return item;
    }

    /**
     * @return ID of the deposit record.
     */
    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getActualDepositAmount() {
        return actualDepositAmount;
    }

    public void setActualDepositAmount(String actualDepositAmount) {
        this.actualDepositAmount = actualDepositAmount;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(transType);
        dest.writeString(created);
        dest.writeString(requestAmount);
        dest.writeString(actualDepositAmount);
        dest.writeString(status);
        dest.writeString(remark);
        dest.writeString(payName);
        dest.writeString(currency);
        dest.writeString(device);
        dest.writeString(network);
        dest.writeInt(statusCode.getId());
    }

    public DepositRecord(Parcel in) {
        transType = in.readString();
        created = in.readString();
        requestAmount = in.readString();
        actualDepositAmount = in.readString();
        status = in.readString();
        remark = in.readString();
        payName = in.readString();
        currency = in.readString();
        device = in.readString();
        network = in.readString();
        statusCode = StatusCode.valueOfId(in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "DepositRecord{" +
                "dno='" + dno + '\'' +
                ", transType='" + transType + '\'' +
                ", created='" + created + '\'' +
                ", requestAmount='" + requestAmount + '\'' +
                ", actualDepositAmount='" + actualDepositAmount + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }

    public enum StatusCode {
        DEPOSIT_AWAIT(0),
        DEPOSIT_PROCESS(11),
        DEPOSIT_FAIL(22),
        DEPOSIT_SUCCESS(33),
        ;

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
}
