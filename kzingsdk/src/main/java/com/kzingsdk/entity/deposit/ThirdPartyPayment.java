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

    private boolean useRotate = false;
    private String optionId = "";
    private String[] fixAmounts = new String[]{};
    private String[] fixAmtArr = new String[]{};
    private ArrayList<ThirdPartyPaymentBank> paymentBankList = new ArrayList<>();
    private ArrayList<BigDecimal> fixAmtArray = new ArrayList<>();
    private String name = "";
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
    private ArrayList<String> cryptoCurrencyList = new ArrayList<>();
    private BigDecimal pRate = BigDecimal.ZERO;
    private Integer random = -1;
    private boolean displayDepositName = false;

    private boolean quickAmountFlag = false;
    private ArrayList<BigDecimal> quickAmountList = new ArrayList<>();

    public ThirdPartyPayment() {
    }

    public ThirdPartyPayment clone() throws CloneNotSupportedException {
        ThirdPartyPayment clone = (ThirdPartyPayment) super.clone();
        clone.paymentBankList = new ArrayList<>();
        return clone;
    }

    public static ThirdPartyPayment newInstance(JSONObject rootObject, JSONObject rootRootObject, String optionId) {
        ThirdPartyPayment item = new ThirdPartyPayment();

        JSONObject extraJSONObject = rootObject.optJSONObject("extra");
        if (extraJSONObject != null) {
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
        item.setPaymentName(rootObject.optString("ptalias"));
        item.setBankCode(rootObject.optString("bankcode"));
        item.setCode(rootObject.optString("code"));
        item.setImage(rootObject.optString("bankcss"));
        item.setDisplayOrder(rootObject.optInt("sort"));
        item.setFormType(rootObject.optString("formtype"));
        item.setOptionId(optionId);
        item.setUseRotate(rootObject.optBoolean("useRotate", false));
        item.importSettingFromJson(rootObject);
        item.setName(rootRootObject.optString("name"));
        item.setRandMax(BigDecimalUtil.optBigDecimal(rootRootObject, "randMax", BigDecimal.ZERO));
        item.setRandMin(BigDecimalUtil.optBigDecimal(rootRootObject, "randMin", BigDecimal.ZERO));
        item.setRandType(rootRootObject.optInt("randType", -1));
        item.setPromoRate(BigDecimalUtil.optBigDecimal(rootObject, "promorate", BigDecimal.ZERO));
        item.setSDealsRate(BigDecimalUtil.optBigDecimal(rootObject, "sdealsrate", BigDecimal.ZERO));
        item.setDisplayDepositName(rootObject.optInt("displaydepositname", 0) == 1);

        JSONObject displayAddressObject = rootObject.optJSONObject("displayAddress");
        if (displayAddressObject != null) {
            JSONArray cryptocurrencyArray = displayAddressObject.optJSONArray("cryptocurrency");
            if (cryptocurrencyArray != null) {
                for (int i = 0; i < cryptocurrencyArray.length(); i++) {
                    String fixAmt = cryptocurrencyArray.optString(i);
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
        random = settingObject.optInt("random", 0);
        minAmount = settingObject.optDouble("min", 0d);
        maxAmount = settingObject.optDouble("max", 0d);

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

        paymentBankList = new ArrayList<>();
        JSONArray channelArray = rootObject.optJSONArray("bank_json");
        for (int i = 0; i < channelArray.length(); i++) {
            JSONObject channelJObject = channelArray.optJSONObject(i);
            paymentBankList.add(ThirdPartyPaymentBank.newInstance(channelJObject, this));
        }
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
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

    public ThirdPartyPayment setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        return this;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ThirdPartyPayment createFromParcel(Parcel in) {
            return new ThirdPartyPayment(in);
        }

        public ThirdPartyPayment[] newArray(int size) {
            return new ThirdPartyPayment[size];
        }
    };


    public ThirdPartyPayment(Parcel in) {
        id = in.readString();
        paymentName = in.readString();
        image = in.readString();
        bankCode = in.readString();
        displayOrder = in.readInt();
        random = in.readInt();
        name = in.readString();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
        optionId = in.readString();
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
        code = in.readString();
        formType = in.readString();
        quickAmountFlag = in.readInt() == 1;
        Object[] customObjects = in.readArray(ThirdPartyPayment.class.getClassLoader());
        fixAmounts = (String[]) customObjects[0];
        paymentBankList = (ArrayList<ThirdPartyPaymentBank>) customObjects[1];
        fixAmtArray = (ArrayList<BigDecimal>) customObjects[2];
        fixAmountList = (ArrayList<BigDecimal>) customObjects[3];
        cOptionList = (ArrayList<COption>) customObjects[4];
        quickAmountList = (ArrayList<BigDecimal>) customObjects[5];
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
        dest.writeString(name);
        dest.writeDouble(minAmount);
        dest.writeDouble(maxAmount);
        dest.writeString(optionId);
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
        dest.writeString(code);
        dest.writeString(formType);
        dest.writeInt(quickAmountFlag ? 1 : 0);
        Object[] customObjects = new Object[6];
        customObjects[0] = fixAmounts;
        customObjects[1] = paymentBankList;
        customObjects[2] = fixAmtArray;
        customObjects[3] = fixAmountList;
        customObjects[4] = cOptionList;
        customObjects[5] = quickAmountList;
        dest.writeArray(customObjects);
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

