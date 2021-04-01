package com.kzingsdk.entity.deposit;

public abstract class BasePaymentMethod {

    protected String id;
    protected String paymentName;
    protected String image;
    protected String bankCode;
    protected int displayOrder = 99999;
    protected Integer random = 0;
    protected Double minAmount = 0d;
    protected Double maxAmount = 0d;
    protected String formType;
    protected boolean isAllowDecimal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public boolean isAllowDecimal() {
        return isAllowDecimal;
    }

    public void setAllowDecimal(boolean allowDecimal) {
        isAllowDecimal = allowDecimal;
    }

    @Override
    public String toString() {
        return "BasePaymentMethod{" +
                "id='" + id + '\'' +
                ", paymentName='" + paymentName + '\'' +
                ", image='" + image + '\'' +
                ", bid=" + bankCode +
                ", displayOrder=" + displayOrder +
                ", formType=" + formType +
                ", random=" + random +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                '}';
    }
}
