package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class WithdrawRecord implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public WithdrawRecord createFromParcel(Parcel in) {
            return new WithdrawRecord(in);
        }

        public WithdrawRecord[] newArray(int size) {
            return new WithdrawRecord[size];
        }
    };
    private String dno;
    private String transType;
    private String created;
    private String requestAmount;
    private String successAmount;
    private String actualWithdrawAmount;
    private String withdrawFee;
    private String cardNum;
    private String bankName;
    private String status;
    private String currency;
    private Boolean canCancel;
    private String device;
    private String network;
    private StatusCode statusCode;


    public WithdrawRecord() {

    }

    public WithdrawRecord(Parcel in) {
        transType = in.readString();
        created = in.readString();
        requestAmount = in.readString();
        successAmount = in.readString();
        actualWithdrawAmount = in.readString();
        withdrawFee = in.readString();
        cardNum = in.readString();
        bankName = in.readString();
        status = in.readString();
        currency = in.readString();
        canCancel = in.readInt() == 1;
        device = in.readString();
        network = in.readString();
        statusCode = StatusCode.valueOfId(in.readInt());
    }

    public static WithdrawRecord newInstance(JSONObject rootObject) {
        WithdrawRecord item = new WithdrawRecord();
        item.setDno(rootObject.optString("dno"));
        item.setTransType(rootObject.optString("transtype"));
        item.setCreated(rootObject.optString("created"));
        item.setRequestAmount(rootObject.optString("amount"));
        item.setSuccessAmount(rootObject.optString("successAmount"));
        item.setActualWithdrawAmount(rootObject.optString("actual"));
        item.setWithdrawFee(rootObject.optString("wfee"));
        item.setCardNum(rootObject.optString("cardnum"));
        item.setBankName(rootObject.optString("bankname"));
        item.setStatus(rootObject.optString("status"));
        item.setCurrency(rootObject.optString("currency"));
        item.setCanCancel(rootObject.optBoolean("canCancel"));
        item.setDevice(rootObject.optString("device"));
        item.setNetwork(rootObject.optString("network"));


        item.setStatusCode(StatusCode.valueOfId(rootObject.optInt("status_code")));
        return item;
    }

    /**
     * @return ID of the withdraw record.
     */
    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getActualWithdrawAmount() {
        return actualWithdrawAmount;
    }

    public void setActualWithdrawAmount(String actualWithdrawAmount) {
        this.actualWithdrawAmount = actualWithdrawAmount;
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

    public String getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(String withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Boolean canCancel() {
        return canCancel;
    }

    public void setCanCancel(Boolean canCancel) {
        this.canCancel = canCancel;
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

    public String getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(String successAmount) {
        this.successAmount = successAmount;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(transType);
        dest.writeString(created);
        dest.writeString(requestAmount);
        dest.writeString(successAmount);
        dest.writeString(actualWithdrawAmount);
        dest.writeString(withdrawFee);
        dest.writeString(cardNum);
        dest.writeString(bankName);
        dest.writeString(status);
        dest.writeString(currency);
        dest.writeInt(canCancel ? 1 : 0);
        dest.writeInt(statusCode.getId());
        dest.writeString(device);
        dest.writeString(network);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "WithdrawRecord{" +
                "dno='" + dno + '\'' +
                ", transType='" + transType + '\'' +
                ", created='" + created + '\'' +
                ", requestAmount='" + requestAmount + '\'' +
                ", actualWithdrawAmount='" + actualWithdrawAmount + '\'' +
                ", withdrawFee='" + withdrawFee + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", name='" + bankName + '\'' +
                ", status='" + status + '\'' +
                ", canCancel='" + canCancel + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }

    public enum StatusCode {
        WITHDRAW_AWAIT(0),
        WITHDRAW_PROCESS(11),
        WITHDRAW_FAIL(22),
        WITHDRAW_SUCCESS(33),
        WITHDRAW_CANCELED(44),
        WITHDRAW_COMPLETE(50);
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
