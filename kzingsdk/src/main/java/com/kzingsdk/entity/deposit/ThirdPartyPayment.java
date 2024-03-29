package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class ThirdPartyPayment extends BasePaymentMethod implements Parcelable, Cloneable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ThirdPartyPayment createFromParcel(Parcel in) {
            return new ThirdPartyPayment(in);
        }

        public ThirdPartyPayment[] newArray(int size) {
            return new ThirdPartyPayment[size];
        }
    };
    private boolean useRotate = false;
    private String optionId = "";
    private String oriOptionId = "";
    private String[] fixAmounts = new String[]{};
    private String[] fixAmtArr = new String[]{};
    private ArrayList<ThirdPartyPaymentBank> paymentBankList = new ArrayList<>();
    private ArrayList<BigDecimal> fixAmtArray = new ArrayList<>();
    private String name = "";

    private Double rootMinAmount = 0d;
    private Double rootMaxAmount = 0d;
    private BigDecimal randMax = BigDecimal.ZERO;
    private BigDecimal randMin = BigDecimal.ZERO;
    private Integer randType = -1;
    private BigDecimal promoRate = BigDecimal.ZERO;
    private BigDecimal sDealsRate = BigDecimal.ZERO;
    private ArrayList<COption> cOptionList = new ArrayList<>();
    private String code = "";
    //extra for phone deposit
    private Integer bcid = -1;
    private ArrayList<BigDecimal> fixAmountList = new ArrayList<>();
    private BigDecimal maxDpt = BigDecimal.ZERO;
    private BigDecimal minDpt = BigDecimal.ZERO;
    private String pNum = "";
    private String cryptoCurrency = "";
    private String rebateMethod = "";
    private ArrayList<String> cryptoCurrencyList = new ArrayList<>();
    private BigDecimal pRate = BigDecimal.ZERO;
    private BigDecimal rebateRate = BigDecimal.ZERO;
    private Integer random = -1;
    private boolean displayDepositName = false;
    private boolean isQrScanMethod = false;
    private boolean quickAmountFlag = false;
    private ArrayList<BigDecimal> quickAmountList = new ArrayList<>();
    private Integer waiveCountBal = 0;

    public ThirdPartyPayment() {
    }

    public ThirdPartyPayment(Parcel in) {
        id = in.readString();
        paymentName = in.readString();
        image = in.readString();
        bankCode = in.readString();
        displayOrder = in.readInt();
        random = in.readInt();
        waiveCountBal = in.readInt();
        name = in.readString();
        rootMinAmount = in.readDouble();
        rootMaxAmount = in.readDouble();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
        optionId = in.readString();
        oriOptionId = in.readString();
        useRotate = in.readInt() == 1;
        isAllowDecimal = in.readInt() == 1;
        displayDepositName = in.readInt() == 1;
        randMax = new BigDecimal(in.readString());
        randMin = new BigDecimal(in.readString());
        randType = in.readInt();
        bcid = in.readInt();
        pNum = in.readString();
        cryptoCurrency = in.readString();
        maxDpt = new BigDecimal(in.readString());
        minDpt = new BigDecimal(in.readString());
        pRate = new BigDecimal(in.readString());
        promoRate = new BigDecimal(in.readString());
        sDealsRate = new BigDecimal(in.readString());
        rebateRate = new BigDecimal(in.readString());
        rebateMethod = in.readString();
        code = in.readString();
        formType = in.readString();
        quickAmountFlag = in.readInt() == 1;
        isQrScanMethod = in.readInt() == 1;
        Object[] customObjects = in.readArray(ThirdPartyPayment.class.getClassLoader());
        int i = 0;
        fixAmounts = (String[]) customObjects[i++];
        paymentBankList = (ArrayList<ThirdPartyPaymentBank>) customObjects[i++];
        fixAmtArray = (ArrayList<BigDecimal>) customObjects[i++];
        fixAmountList = (ArrayList<BigDecimal>) customObjects[i++];
        cOptionList = (ArrayList<COption>) customObjects[i++];
        quickAmountList = (ArrayList<BigDecimal>) customObjects[i++];
        cryptoCurrencyList = (ArrayList<String>) customObjects[i++];
        fixAmtArr = (String[]) customObjects[i++];
    }

    public static ThirdPartyPayment newInstance(JSONObject rootObject, JSONObject rootRootObject, String optionId) {
        ThirdPartyPayment item = new ThirdPartyPayment();
        item.bcid = rootObject.optInt("bcid", -1);
        JSONObject extraJSONObject = rootObject.optJSONObject("extra");
        if (extraJSONObject != null) {
            if (extraJSONObject.has("bcid"))
                item.bcid = extraJSONObject.optInt("bcid", -1);
            String fixamount = extraJSONObject.optString("fixamount", "");
            String maxdpt = extraJSONObject.optString("maxdpt", "0");
            String mindpt = extraJSONObject.optString("mindpt", "0");
            String p_rate = extraJSONObject.optString("p_rate", "0");
            if (fixamount.length() > 0) {
                String[] fixamountArray = fixamount.split(",");
                for (String amount : fixamountArray) {
                    item.fixAmountList.add(new BigDecimal(amount));
                }
            }
            item.maxDpt = maxdpt.length() > 0 ? new BigDecimal(maxdpt) : BigDecimal.ZERO;
            item.minDpt = mindpt.length() > 0 ? new BigDecimal(mindpt) : BigDecimal.ZERO;
            item.pRate = p_rate.length() > 0 ? new BigDecimal(p_rate) : BigDecimal.ZERO;
            item.pNum = extraJSONObject.optString("p_num", "");
            item.random = extraJSONObject.optInt("random", -1);
        }

        item.setId(rootObject.optString("ppid"));
        item.setOriOptionId(rootObject.optString("orioptionid"));
        item.setPaymentName(rootObject.optString("ptalias"));
        item.setBankCode(rootObject.optString("bankcode"));
        item.setCode(rootObject.optString("code"));
        item.setImage(rootObject.optString("bankcss"));
        item.setDisplayOrder(rootObject.optInt("sort"));
        item.setFormType(rootObject.optString("formtype"));
        item.setOptionId(optionId);
        item.setUseRotate(rootObject.optBoolean("useRotate", false));
        item.setRootMinAmount(rootObject.optDouble("min", 0d));
        item.setRootMaxAmount(rootObject.optDouble("max", 0d));
        item.importSettingFromJson(rootObject);
        item.setName(rootRootObject.optString("name"));
        item.setRandMax(BigDecimalUtil.optBigDecimal(rootRootObject, "randMax", BigDecimal.ZERO));
        item.setRandMin(BigDecimalUtil.optBigDecimal(rootRootObject, "randMin", BigDecimal.ZERO));
        item.setRandType(rootRootObject.optInt("randType", -1));
        item.setPromoRate(BigDecimalUtil.optBigDecimal(rootObject, "promorate", BigDecimal.ZERO));
        item.setSDealsRate(BigDecimalUtil.optBigDecimal(rootObject, "sdealsrate", BigDecimal.ZERO));
        item.setDisplayDepositName(rootObject.optInt("displaydepositname", 0) == 1);

        item.paymentBankList = new ArrayList<>();
        JSONArray channelArray = rootObject.optJSONArray("bank_json");
        if (channelArray != null) {
            for (int i = 0; i < channelArray.length(); i++) {
                JSONObject channelJObject = channelArray.optJSONObject(i);
                item.paymentBankList.add(ThirdPartyPaymentBank.newInstance(channelJObject, item));
            }
        }

        JSONObject displayAddressObject = rootObject.optJSONObject("displayAddress");
        if (displayAddressObject != null) {
            item.setQrScanMethod(displayAddressObject.optBoolean("isQrScanMethod"));
            JSONArray cryptocurrencyArray = displayAddressObject.optJSONArray("cryptocurrency");
            if (cryptocurrencyArray != null) {
                for (int i = 0; i < cryptocurrencyArray.length(); i++) {
                    item.cryptoCurrencyList.add(cryptocurrencyArray.optString(i));
                }
            }
        }

        JSONArray fixAmtArray = rootRootObject.optJSONArray("fixAmtArray");
        if (fixAmtArray != null) {
            for (int i = 0; i < fixAmtArray.length(); i++) {
                String fixAmt = fixAmtArray.optString(i);
                item.fixAmtArray.add(fixAmt.length() > 0 ? new BigDecimal(fixAmt) : BigDecimal.ZERO);
            }
        }

        return item;
    }

    public ThirdPartyPayment clone() throws CloneNotSupportedException {
        ThirdPartyPayment clone = (ThirdPartyPayment) super.clone();
        clone.paymentBankList = new ArrayList<>();
        return clone;
    }

    public void importSettingFromJson(JSONObject rootObject) {
        JSONObject settingObject = rootObject.optJSONObject("v2PgInfo");
        if (settingObject == null) {
            return;
        }
        JSONArray cOptionArray = settingObject.optJSONArray("coption");
        cOptionList = new ArrayList<>();
        if (cOptionArray != null) {
            for (int i = 0; i < cOptionArray.length(); i++) {
                cOptionList.add(COption.newInstance(cOptionArray.optJSONObject(i)));
            }
        }

        waiveCountBal = settingObject.optInt("waiveCountBal", 0);
        random = settingObject.optInt("random", 0);
        minAmount = settingObject.optDouble("min", 0d);
        maxAmount = settingObject.optDouble("max", 0d);
        rebateMethod = settingObject.optString("rebatemethod");
        rebateRate = BigDecimalUtil.optBigDecimal(settingObject, "rebaterate", BigDecimal.ZERO);

        quickAmountFlag = settingObject.optInt("quickamountflag") == 1;
        String quickamountString = settingObject.optString("quickamount");
        String[] quickamountStrings = quickamountString.split(",");
        ArrayList<BigDecimal> quickAmountList = new ArrayList<>();
        for (String quickamount : quickamountStrings) {
            if (quickamount.length() > 0) {
                quickAmountList.add(new BigDecimal(quickamount));
            }
            this.quickAmountList = quickAmountList;
        }
        fixAmounts = settingObject.optString("fixamount", "").split(",");

        JSONArray fixAmountArray = settingObject.optJSONArray("fixAmtArr");
        if (fixAmountArray != null) {
            String[] items = new String[fixAmountArray.length()];
            for (int i = 0; i < fixAmountArray.length(); i++) {
                String fixAmount = fixAmountArray.optString(i);
                items[i] = fixAmount;
            }
            fixAmtArr = items;
        }

    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOriOptionId() {
        return oriOptionId;
    }

    public void setOriOptionId(String oriOptionId) {
        this.oriOptionId = oriOptionId;
    }

    public ArrayList<ThirdPartyPaymentBank> getPaymentBankList() {
        return paymentBankList;
    }

    public void setPaymentBankList(ArrayList<ThirdPartyPaymentBank> paymentBankList) {
        this.paymentBankList = paymentBankList;
    }

    public boolean isUseRotate() {
        return useRotate;
    }

    public void setUseRotate(boolean useRotate) {
        this.useRotate = useRotate;
    }

    public String[] getFixAmounts() {
        return fixAmounts;
    }

    public void setFixAmounts(String[] fixAmounts) {
        this.fixAmounts = fixAmounts;
    }

    public String[] getFixAmtArr() {
        return fixAmtArr;
    }

    public void setFixAmtArr(String[] fixAmtArr) {
        this.fixAmtArr = fixAmtArr;
    }

    public ArrayList<BigDecimal> getFixAmtArray() {
        return fixAmtArray;
    }

    public void setFixAmtArray(ArrayList<BigDecimal> fixAmtArray) {
        this.fixAmtArray = fixAmtArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRandMax() {
        return randMax;
    }

    public void setRandMax(BigDecimal randMax) {
        this.randMax = randMax;
    }

    public BigDecimal getRandMin() {
        return randMin;
    }

    public void setRandMin(BigDecimal randMin) {
        this.randMin = randMin;
    }

    public Integer getRandType() {
        return randType;
    }

    public void setRandType(Integer randType) {
        this.randType = randType;
    }

    public BigDecimal getPromoRate() {
        return promoRate;
    }

    public void setPromoRate(BigDecimal promoRate) {
        this.promoRate = promoRate;
    }

    public BigDecimal getSDealsRate() {
        return sDealsRate;
    }

    public void setSDealsRate(BigDecimal sDealsRate) {
        this.sDealsRate = sDealsRate;
    }

    public boolean isDisplayDepositName() {
        return displayDepositName;
    }

    public void setDisplayDepositName(boolean displayDepositName) {
        this.displayDepositName = displayDepositName;
    }

    public boolean isQrScanMethod() {
        return isQrScanMethod;
    }

    public void setQrScanMethod(boolean qrScanMethod) {
        isQrScanMethod = qrScanMethod;
    }

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    public ArrayList<BigDecimal> getFixAmountList() {
        return fixAmountList;
    }

    public void setFixAmountList(ArrayList<BigDecimal> fixAmountList) {
        this.fixAmountList = fixAmountList;
    }

    public BigDecimal getMaxDpt() {
        return maxDpt;
    }

    public void setMaxDpt(BigDecimal maxDpt) {
        this.maxDpt = maxDpt;
    }

    public BigDecimal getMinDpt() {
        return minDpt;
    }

    public void setMinDpt(BigDecimal minDpt) {
        this.minDpt = minDpt;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public BigDecimal getpRate() {
        return pRate;
    }

    public void setpRate(BigDecimal pRate) {
        this.pRate = pRate;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    public Integer getWaiveCountBal() {
        return waiveCountBal;
    }

    public void setWaiveCountBal(Integer waiveCountBal) {
        this.waiveCountBal = waiveCountBal;
    }

    public ArrayList<COption> getcOptionList() {
        return cOptionList;
    }

    public void setcOptionList(ArrayList<COption> cOptionList) {
        this.cOptionList = cOptionList;
    }

    public boolean isQuickAmountFlag() {
        return quickAmountFlag;
    }

    public void setQuickAmountFlag(boolean quickAmountFlag) {
        this.quickAmountFlag = quickAmountFlag;
    }

    public ArrayList<BigDecimal> getQuickAmountList() {
        return quickAmountList;
    }

    public void setQuickAmountList(ArrayList<BigDecimal> quickAmountList) {
        this.quickAmountList = quickAmountList;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public ThirdPartyPayment setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ThirdPartyPayment setCode(String code) {
        this.code = code;
        return this;
    }

    public ArrayList<String> getCryptoCurrencyList() {
        return cryptoCurrencyList;
    }

    public void setCryptoCurrencyList(ArrayList<String> cryptoCurrencyList) {
        this.cryptoCurrencyList = cryptoCurrencyList;
    }

    public BigDecimal getRebateRate() {
        return rebateRate;
    }

    public void setRebateRate(BigDecimal rebateRate) {
        this.rebateRate = rebateRate;
    }

    public String getRebateMethod() {
        return rebateMethod;
    }

    public void setRebateMethod(String rebateMethod) {
        this.rebateMethod = rebateMethod;
    }

    public Double getRootMinAmount() {
        return rootMinAmount;
    }

    public void setRootMinAmount(Double rootMinAmount) {
        this.rootMinAmount = rootMinAmount;
    }

    public Double getRootMaxAmount() {
        return rootMaxAmount;
    }

    public void setRootMaxAmount(Double rootMaxAmount) {
        this.rootMaxAmount = rootMaxAmount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(paymentName);
        dest.writeString(image);
        dest.writeString(bankCode);
        dest.writeInt(displayOrder);
        dest.writeInt(random);
        dest.writeInt(waiveCountBal);
        dest.writeString(name);
        dest.writeDouble(rootMinAmount);
        dest.writeDouble(rootMaxAmount);
        dest.writeDouble(minAmount);
        dest.writeDouble(maxAmount);
        dest.writeString(optionId);
        dest.writeString(oriOptionId);
        dest.writeInt(useRotate ? 1 : 0);
        dest.writeInt(isAllowDecimal ? 1 : 0);
        dest.writeInt(displayDepositName ? 1 : 0);
        dest.writeString(randMax.toString());
        dest.writeString(randMin.toString());
        dest.writeInt(randType);
        dest.writeInt(bcid);
        dest.writeString(pNum);
        dest.writeString(cryptoCurrency);
        dest.writeString(maxDpt.toString());
        dest.writeString(minDpt.toString());
        dest.writeString(pRate.toString());
        dest.writeString(promoRate.toString());
        dest.writeString(sDealsRate.toString());
        dest.writeString(rebateRate.toString());
        dest.writeString(rebateMethod);
        dest.writeString(code);
        dest.writeString(formType);
        dest.writeInt(quickAmountFlag ? 1 : 0);
        dest.writeInt(isQrScanMethod ? 1 : 0);
        dest.writeArray(new Object[]{
                fixAmounts,
                paymentBankList,
                fixAmtArray,
                fixAmountList,
                cOptionList,
                quickAmountList,
                cryptoCurrencyList,
                fixAmtArr,
        });
    }

    @Override
    public String toString() {
        return "ThirdPartyPayment{" +
                "useRotate=" + useRotate +
                ", optionId='" + optionId + '\'' +
                ", fixAmounts=" + Arrays.toString(fixAmounts) +
                ", paymentBankList=" + paymentBankList +
                "} " + super.toString();
    }

}

