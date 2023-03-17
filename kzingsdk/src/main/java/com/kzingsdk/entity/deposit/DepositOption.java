package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static com.kzingsdk.entity.deposit.PaymentType.EWALLET;
import static com.kzingsdk.entity.deposit.PaymentType.PHONE;
import static com.kzingsdk.entity.deposit.PaymentType.PREPAIDCARD;
import static com.kzingsdk.entity.deposit.PaymentType.THIRD_PARTY;


public class DepositOption implements Parcelable {

    private boolean isProcessing;
    private boolean isAllowDeposit;
    private boolean isAllowDecimal;
    private boolean isPrepaidCard;
    private boolean isV2 = false;
    private boolean useRotate = false;
    private boolean allowUploadDepositCredential = false;
    private boolean depositMustBindBankcard = false;
    private boolean isUploadCrypto = false;
    private boolean isUploadCredentialCrypto = false;
    private boolean depositRealNameVerify = false;
    private Integer pgAllowPendingCount = 0;
    private Integer pgProcessPendingCount = 0;
    private Integer atmAllowPendingCount = 0;
    private Integer atmProcessPendingCount = 0;
    private BigDecimal cryptoAtmExchangeRate = BigDecimal.ZERO;
    private ArrayList<PaymentGroup> paymentGroupList = new ArrayList<>();
    private HashMap<String, String> activityMap = new HashMap<>();
    private ArrayList<QuickLinkDeposit> quickLinkDepositList = new ArrayList<>();
    private ArrayList<Crypto> cryptoList = new ArrayList<>();
    private String bankDepositDesc = "";
    private String thirdPartyDesc = "";
    private String qrDesc = "";
    private String phoneDepositDesc = "";
    private String cryptoDepositDesc = "";
    private String depositFooterDesc = "";
    private String bank2DepositDesc = "";
    private ArrayList<PayOptionSortData> payOptionSortDataList = new ArrayList<>();
    private ArrayList<AvailablePaymentGroup> availablePaymentGroupList = new ArrayList<>();
    private ArrayList<ExcludeTLCBankTransfer> excludeTLCBankTransferList = new ArrayList<>();

    public DepositOption() {

    }

    public DepositOption(Parcel in) {
        isProcessing = in.readInt() == 1;
        isAllowDeposit = in.readInt() == 1;
        isAllowDecimal = in.readInt() == 1;
        isV2 = in.readInt() == 1;
        useRotate = in.readInt() == 1;
        allowUploadDepositCredential = in.readInt() == 1;
        depositMustBindBankcard = in.readInt() == 1;
        isUploadCrypto = in.readInt() == 1;
        isUploadCredentialCrypto = in.readInt() == 1;
        depositRealNameVerify = in.readInt() == 1;
        pgAllowPendingCount = in.readInt();
        pgProcessPendingCount = in.readInt();
        atmAllowPendingCount = in.readInt();
        atmProcessPendingCount = in.readInt();
        cryptoAtmExchangeRate = new BigDecimal(in.readString());
        bankDepositDesc = in.readString();
        thirdPartyDesc = in.readString();
        qrDesc = in.readString();
        phoneDepositDesc = in.readString();
        cryptoDepositDesc = in.readString();
        depositFooterDesc = in.readString();
        bank2DepositDesc = in.readString();
        int i = 0;
        Object[] customObjects = in.readArray(DepositOption.class.getClassLoader());
        paymentGroupList = (ArrayList<PaymentGroup>) customObjects[i++];
        activityMap = (HashMap<String, String>) customObjects[i++];
        quickLinkDepositList = (ArrayList<QuickLinkDeposit>) customObjects[i++];
        cryptoList = (ArrayList<Crypto>) customObjects[i++];
        payOptionSortDataList = (ArrayList<PayOptionSortData>) customObjects[i++];
        availablePaymentGroupList = (ArrayList<AvailablePaymentGroup>) customObjects[i++];
        excludeTLCBankTransferList = (ArrayList<ExcludeTLCBankTransfer>) customObjects[i++];


    }

    public static DepositOption newInstance(JSONObject rootObject) {
        DepositOption item = new DepositOption();
        double atmMinAmount = rootObject.optDouble("amin", 0d);
        double atmMaxAmount = rootObject.optDouble("amax", 0d);
        double atmTpMinAmount = rootObject.optDouble("atpmin", 0d);
        double atmTpMaxAmount = rootObject.optDouble("atpmax", 0d);
        double cMinAmount = rootObject.optDouble("cmin", 0d);
        double cMaxAmount = rootObject.optDouble("cmax", 0d);

        int atmBankPosition = rootObject.optInt("atmbank_position", 0);
        item.isPrepaidCard = rootObject.optBoolean("isPrepaidCard", false);
        item.isV2 = rootObject.optBoolean("isV2", false);
        item.useRotate = rootObject.optBoolean("useRotate", false);
        item.allowUploadDepositCredential = rootObject.optBoolean("isUpload", false);
        item.depositMustBindBankcard = rootObject.optBoolean("depositMustBindBankcard", false);
        item.isUploadCrypto = rootObject.optBoolean("isUploadCrypto", false);
        item.isUploadCredentialCrypto = rootObject.optBoolean("uploadCredentialCrypto", false);
        item.depositRealNameVerify = rootObject.optBoolean("depositrealnameverify", false);

        item.pgAllowPendingCount = rootObject.optInt("pgAllowPendingCount", 0);
        item.pgProcessPendingCount = rootObject.optInt("pgProcessPendingCount", 0);
        item.atmAllowPendingCount = rootObject.optInt("atmAllowPendingCount", 0);
        item.atmProcessPendingCount = rootObject.optInt("atmProcessPendingCount", 0);
        item.cryptoAtmExchangeRate = BigDecimalUtil.optBigDecimal(rootObject, "cryptoAtm_exchange_rate");
        String prepaidCardIcon = rootObject.optString("prepaidCardicon");
        item.setProcessing(rootObject.optBoolean("process"));
        item.setAllowDeposit(rootObject.optBoolean("allowdeposit"));
        item.setAllowDecimal(rootObject.optBoolean("allowDecimal"));

        JSONArray actArray = rootObject.optJSONArray("actid");
        if (actArray != null) {
            for (int i = 0; i < actArray.length(); i++) {
                item.activityMap.put(actArray.optJSONObject(i).optString("actid"), actArray.optJSONObject(i).optString("actname"));
            }
        }

        JSONArray newPayOptionSortData = rootObject.optJSONArray("newPayOptionSortData");
        if (newPayOptionSortData != null) {
            for (int i = 0; i < newPayOptionSortData.length(); i++) {
                item.payOptionSortDataList.add(PayOptionSortData.newInstance(newPayOptionSortData.optJSONObject(i)));
            }
        }

        JSONArray availablePaymentGroup = rootObject.optJSONArray("availablePaymentGroup");
        if (availablePaymentGroup != null) {
            for (int i = 0; i < availablePaymentGroup.length(); i++) {
                item.availablePaymentGroupList.add(AvailablePaymentGroup.newInstance(availablePaymentGroup.optJSONObject(i)));
            }
        }
        JSONArray excludeTLCBankTransfer = rootObject.optJSONArray("excludeTLCBankTransfer");
        if (excludeTLCBankTransfer != null) {
            for (int i = 0; i < excludeTLCBankTransfer.length(); i++) {
                item.excludeTLCBankTransferList.add(ExcludeTLCBankTransfer.newInstance(excludeTLCBankTransfer.optJSONObject(i)));
            }
        }

        JSONObject depositDescObject = rootObject.optJSONObject("depositdesc");
        if (depositDescObject != null) {
            item.bankDepositDesc = depositDescObject.optString("bank_deposit_desc");
            item.thirdPartyDesc = depositDescObject.optString("thirdparty_desc");
            item.qrDesc = depositDescObject.optString("qr_desc");
            item.phoneDepositDesc = depositDescObject.optString("phone_deposit_desc");
            item.cryptoDepositDesc = depositDescObject.optString("crypto_deposit_desc");
            item.depositFooterDesc = depositDescObject.optString("deposit_footer_desc");
            item.bank2DepositDesc = depositDescObject.optString("bank2_deposit_desc");
        }

        JSONArray paymentTypeJArray = rootObject.optJSONArray("paymentType");
        JSONArray paymentAtmTypeJArray = rootObject.optJSONArray("paymentAtmType");
        JSONArray cryptoAtmTypeJArray = rootObject.optJSONArray("cryptoAtmType");
        JSONArray paymentAtmMicroTypeJArray = rootObject.optJSONArray("paymentAtmMicroType");
        JSONArray quickLinkJArray = rootObject.optJSONArray("quicklinkdeposit");
        JSONArray atmSortSettingJArray = rootObject.optJSONArray("atmSortSetting");
        HashMap<String, ArrayList<ThirdPartyPayment>> thirdPartyPaymentMap = createThirdPartyPaymentMap(paymentTypeJArray);
        ArrayList<AtmPayment> atmPaymentList = createAtmPaymentList(paymentAtmTypeJArray, atmSortSettingJArray, false);
        ArrayList<AtmPayment> qrcodePaymentList = createAtmPaymentList(paymentAtmTypeJArray, atmSortSettingJArray, true);
        ArrayList<CryptoAtmPayment> cryptoAtmPaymentList = createCryptoAtmPaymentList(cryptoAtmTypeJArray);
        ArrayList<MicroAtmPayment> paymentAtmMicroList = createPaymentAtmMicroList(paymentAtmMicroTypeJArray);

        JSONArray sortArrJArray = rootObject.optJSONArray("sortArr");
        JSONArray paymentGroupJArray = rootObject.optJSONArray("payOptionSortInfo");
        if (quickLinkJArray != null) {
            for (int i = 0; i < quickLinkJArray.length(); i++) {
                JSONObject quickLinkObject = quickLinkJArray.optJSONObject(i);
                item.quickLinkDepositList.add(QuickLinkDeposit.newInstance(quickLinkObject));
            }
        }

        JSONArray cryptoJArray = rootObject.optJSONArray("crypto_list");
        if (cryptoJArray != null) {
            for (int i = 0; i < cryptoJArray.length(); i++) {
                JSONObject cryptoObject = cryptoJArray.optJSONObject(i);
                item.cryptoList.add(Crypto.newInstance(cryptoObject));
            }
        }

        if (sortArrJArray != null && paymentGroupJArray != null) {
            for (int i = 0; i < sortArrJArray.length(); i++) {
                JSONObject cateSortingObject = sortArrJArray.optJSONObject(i);
                String option = cateSortingObject.optString("option");
                int j;
                switch (option) {
                    case "1":
                        for (j = 0; j < paymentGroupJArray.length(); j++) {
                            PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                            if (paymentGroup.getPaymentType() == THIRD_PARTY) {
                                item.paymentGroupList.add(paymentGroup);
                            }
                        }
                        break;
                    case "99": // prepaid card
                        if (!item.isPrepaidCard) break;
                        String displayName = cateSortingObject.optString("displayName");
                        String bankcss = cateSortingObject.optString("bankcss");
                        PaymentGroup paymentGroupPrepaid = new PaymentGroup();
                        paymentGroupPrepaid.setName(displayName);
                        paymentGroupPrepaid.setImage(bankcss);
                        paymentGroupPrepaid.setPaymentType(PREPAIDCARD);
                        paymentGroupPrepaid.setIcon(prepaidCardIcon);
                        item.paymentGroupList.add(paymentGroupPrepaid);
                        break;
                    case "3":
                        //ignored
                        break;
                    case "4":
                        for (j = 0; j < paymentGroupJArray.length(); j++) {
                            PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                            if (paymentGroup.getPaymentType() == PaymentType.valueOfTypeId("atm") &&
                                    paymentGroup.getId().equalsIgnoreCase("0")) {
                                item.paymentGroupList.add(paymentGroup);
                            }
                        }
                        break;
                    case "2":
                    case "69":
                    case "73":
                    case "101"://micro
                        for (j = 0; j < paymentGroupJArray.length(); j++) {
                            PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                            if (paymentGroup.getPaymentType() == PaymentType.valueOfTypeId(option) &&
                                    !paymentGroup.getId().equalsIgnoreCase("0")) {
                                item.paymentGroupList.add(paymentGroup);
                            }
                        }
                        break;
                    case "5"://crypto
                        for (j = 0; j < paymentGroupJArray.length(); j++) {
                            PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                            if (paymentGroup.getPaymentType() == PaymentType.valueOfTypeId("crypto")) {
                                item.paymentGroupList.add(paymentGroup);
                            }
                        }
                        break;
//                default: // other
//                    for (j = 0; j < paymentGroupJArray.length(); j++) {
//                        PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
//                        if (paymentGroup.getId().equalsIgnoreCase("0")) {
//                            paymentGroup.setPaymentType(OTHER);
//                            item.paymentGroupList.add(paymentGroup);
//                        }
//                    }
//                    break;
                }
            }
        }

        for (PaymentGroup paymentGroup : item.paymentGroupList) {
            String key = paymentGroup.getId();
            for (BasePaymentMethod basePaymentMethod : paymentGroup.getPaymentList()) {
                basePaymentMethod.setAllowDecimal(item.isAllowDecimal);
            }
            switch (paymentGroup.getPaymentType()) {
                case ATM:
                    boolean isQrcode = key.equalsIgnoreCase("0");
                    for (AtmPayment payment : (isQrcode ? qrcodePaymentList : atmPaymentList)) {
                        payment.setMinAmount(isQrcode ? atmTpMinAmount : atmMinAmount);
                        payment.setMaxAmount(isQrcode ? atmTpMaxAmount : atmMaxAmount);
                        paymentGroup.getPaymentList().add(payment);
                    }
                    break;
                case THIRD_PARTY:
                    if (thirdPartyPaymentMap.containsKey(key)) {
                        paymentGroup.getPaymentList().addAll(thirdPartyPaymentMap.getOrDefault(key, new ArrayList<>()));
                    }
                    break;
                case CRYPTO:
                    for (CryptoAtmPayment cryptoAtmPayment : cryptoAtmPaymentList) {
                        cryptoAtmPayment.setMinAmount(cMinAmount);
                        cryptoAtmPayment.setMaxAmount(cMaxAmount);
                        paymentGroup.getPaymentList().add(cryptoAtmPayment);
                    }
                    break;
                case MICRO:
                    for (MicroAtmPayment microAtmPayment : paymentAtmMicroList) {
                        microAtmPayment.setMinAmount(cMinAmount);
                        microAtmPayment.setMaxAmount(cMaxAmount);
                        paymentGroup.getPaymentList().add(microAtmPayment);
                    }
                    break;

            }
        }
        return item;
    }

    private static ArrayList<CryptoAtmPayment> createCryptoAtmPaymentList(JSONArray jArray) {
        ArrayList<CryptoAtmPayment> cryptoAtmPaymentList = new ArrayList<>();
        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject cryptoAtmJObject = jArray.optJSONObject(i);
                CryptoAtmPayment cryptoAtmPayment = CryptoAtmPayment.newInstance(cryptoAtmJObject);
                cryptoAtmPaymentList.add(cryptoAtmPayment);
            }
            cryptoAtmPaymentList.sort(Comparator.comparingInt(BasePaymentMethod::getDisplayOrder));
        }
        return cryptoAtmPaymentList;
    }

    private static ArrayList<MicroAtmPayment> createPaymentAtmMicroList(JSONArray jArray) {
        ArrayList<MicroAtmPayment> microAtmPaymentList = new ArrayList<>();
        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject microAtmPaymentJObject = jArray.optJSONObject(i);
                MicroAtmPayment cryptoAtmPayment = MicroAtmPayment.newInstance(microAtmPaymentJObject);
                microAtmPaymentList.add(cryptoAtmPayment);
            }
            microAtmPaymentList.sort(Comparator.comparingInt(BasePaymentMethod::getDisplayOrder));
        }
        return microAtmPaymentList;
    }

    private static ArrayList<AtmPayment> createAtmPaymentList(JSONArray jArray, JSONArray sortingArray, boolean isQrcode) {
        ArrayList<AtmPayment> atmPaymentList = new ArrayList<>();
        if (sortingArray == null) {
            return atmPaymentList;
        }
        JSONArray sortingItemsArray = null;
        for (int i = 0; i < sortingArray.length(); i++) {
            JSONObject itemsJObject = sortingArray.optJSONObject(i);
            int option = itemsJObject.optInt("option", 0);
            if (isQrcode && option == 3) {
                sortingItemsArray = itemsJObject.optJSONArray("items");
            } else if (!isQrcode && option == 1) {
                sortingItemsArray = itemsJObject.optJSONArray("items");
            }
        }

        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject atmJObject = jArray.optJSONObject(i);
                if (isQrcode && !atmJObject.optString("key").equalsIgnoreCase("0") ||
                        !isQrcode && atmJObject.optString("key").equalsIgnoreCase("0")) continue;
                int bcid = atmJObject.optInt("bcid");
                int order = 99999;
                if (sortingItemsArray != null) {
                    for (int j = 0; j < sortingItemsArray.length(); j++) {
                        JSONObject itemsJObject = sortingItemsArray.optJSONObject(j);
                        if (itemsJObject.optInt("bcid") == bcid) {
                            order = itemsJObject.optInt("order");
                            break;
                        }
                    }
                }
                AtmPayment atmPayment = AtmPayment.newInstance(atmJObject);
                atmPayment.setDisplayOrder(order);
                atmPayment.setIsQrcode(isQrcode);
                atmPaymentList.add(atmPayment);
            }
        }
        atmPaymentList.sort(Comparator.comparingInt(BasePaymentMethod::getDisplayOrder));
        return atmPaymentList;
    }

    private static HashMap<String, ArrayList<ThirdPartyPayment>> createThirdPartyPaymentMap(JSONArray jArray) {
        HashMap<String, ArrayList<ThirdPartyPayment>> thirdPartyPaymentMap = new HashMap<>();
        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject atmJObject = jArray.optJSONObject(i);
                JSONArray thirdPartyPaymentArray = atmJObject.optJSONArray("value");
                if (thirdPartyPaymentArray == null) {
                    continue;
                }
                String key = atmJObject.optString("key");
                ArrayList<ThirdPartyPayment> thirdPartyPaymentList =
                        thirdPartyPaymentMap.getOrDefault(key, new ArrayList<>());
                for (int j = 0; j < thirdPartyPaymentArray.length(); j++) {
                    if (EWALLET.getId().equalsIgnoreCase(key)) {
                        thirdPartyPaymentList.add(EWalletPayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    } else if (PHONE.getId().equalsIgnoreCase(key)) {
                        thirdPartyPaymentList.add(PhonePayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    } else {
                        thirdPartyPaymentList.add(ThirdPartyPayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    }
                    thirdPartyPaymentMap.put(key, thirdPartyPaymentList);
                }
            }
        }
        for (ArrayList<ThirdPartyPayment> thirdPartyPaymentList : thirdPartyPaymentMap.values()) {
            thirdPartyPaymentList.sort(Comparator.comparingInt(BasePaymentMethod::getDisplayOrder));
        }
        return thirdPartyPaymentMap;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    public boolean isAllowDeposit() {
        return isAllowDeposit;
    }

    public void setAllowDeposit(boolean allowDeposit) {
        isAllowDeposit = allowDeposit;
    }

    public boolean isAllowDecimal() {
        return isAllowDecimal;
    }

    public void setAllowDecimal(boolean allowDecimal) {
        isAllowDecimal = allowDecimal;
    }

    public boolean isPrepaidCard() {
        return isPrepaidCard;
    }

    public void setPrepaidCard(boolean prepaidCard) {
        isPrepaidCard = prepaidCard;
    }

    public ArrayList<PaymentGroup> getPaymentGroupList() {
        return paymentGroupList;
    }

    public void setPaymentGroupList(ArrayList<PaymentGroup> paymentGroupList) {
        this.paymentGroupList = paymentGroupList;
    }

    public boolean isV2() {
        return isV2;
    }

    public void setV2(boolean v2) {
        isV2 = v2;
    }

    public boolean isUseRotate() {
        return useRotate;
    }

    public void setUseRotate(boolean useRotate) {
        this.useRotate = useRotate;
    }

    public boolean isAllowUploadDepositCredential() {
        return allowUploadDepositCredential;
    }

    public void setAllowUploadDepositCredential(boolean allowUploadDepositCredential) {
        this.allowUploadDepositCredential = allowUploadDepositCredential;
    }

    public boolean isDepositMustBindBankcard() {
        return depositMustBindBankcard;
    }

    public void setDepositMustBindBankcard(boolean depositMustBindBankcard) {
        this.depositMustBindBankcard = depositMustBindBankcard;
    }

    public boolean isUploadCrypto() {
        return isUploadCrypto;
    }

    public void setUploadCrypto(boolean uploadCrypto) {
        isUploadCrypto = uploadCrypto;
    }

    public boolean isUploadCredentialCrypto() {
        return isUploadCredentialCrypto;
    }

    public void setUploadCredentialCrypto(boolean uploadCredentialCrypto) {
        isUploadCredentialCrypto = uploadCredentialCrypto;
    }

    public boolean isDepositRealNameVerify() {
        return depositRealNameVerify;
    }

    public void setDepositRealNameVerify(boolean depositRealNameVerify) {
        this.depositRealNameVerify = depositRealNameVerify;
    }

    public Integer getPgAllowPendingCount() {
        return pgAllowPendingCount;
    }

    public void setPgAllowPendingCount(Integer pgAllowPendingCount) {
        this.pgAllowPendingCount = pgAllowPendingCount;
    }

    public Integer getPgProcessPendingCount() {
        return pgProcessPendingCount;
    }

    public void setPgProcessPendingCount(Integer pgProcessPendingCount) {
        this.pgProcessPendingCount = pgProcessPendingCount;
    }

    public Integer getAtmAllowPendingCount() {
        return atmAllowPendingCount;
    }

    public void setAtmAllowPendingCount(Integer atmAllowPendingCount) {
        this.atmAllowPendingCount = atmAllowPendingCount;
    }

    public Integer getAtmProcessPendingCount() {
        return atmProcessPendingCount;
    }

    public void setAtmProcessPendingCount(Integer atmProcessPendingCount) {
        this.atmProcessPendingCount = atmProcessPendingCount;
    }

    public HashMap<String, String> getActivityMap() {
        return activityMap;
    }

    public void setActivityMap(HashMap<String, String> activityMap) {
        this.activityMap = activityMap;
    }

    public ArrayList<QuickLinkDeposit> getQuickLinkDepositList() {
        return quickLinkDepositList;
    }

    public void setQuickLinkDepositList(ArrayList<QuickLinkDeposit> quickLinkDepositList) {
        this.quickLinkDepositList = quickLinkDepositList;
    }

    public BigDecimal getCryptoAtmExchangeRate() {
        return cryptoAtmExchangeRate;
    }

    public void setCryptoAtmExchangeRate(BigDecimal cryptoAtmExchangeRate) {
        this.cryptoAtmExchangeRate = cryptoAtmExchangeRate;
    }

    public ArrayList<Crypto> getCryptoList() {
        return cryptoList;
    }

    public void setCryptoList(ArrayList<Crypto> cryptoList) {
        this.cryptoList = cryptoList;
    }

    public String getBankDepositDesc() {
        return bankDepositDesc;
    }

    public void setBankDepositDesc(String bankDepositDesc) {
        this.bankDepositDesc = bankDepositDesc;
    }

    public String getThirdPartyDesc() {
        return thirdPartyDesc;
    }

    public void setThirdPartyDesc(String thirdPartyDesc) {
        this.thirdPartyDesc = thirdPartyDesc;
    }

    public String getQrDesc() {
        return qrDesc;
    }

    public void setQrDesc(String qrDesc) {
        this.qrDesc = qrDesc;
    }

    public String getPhoneDepositDesc() {
        return phoneDepositDesc;
    }

    public void setPhoneDepositDesc(String phoneDepositDesc) {
        this.phoneDepositDesc = phoneDepositDesc;
    }

    public String getCryptoDepositDesc() {
        return cryptoDepositDesc;
    }

    public void setCryptoDepositDesc(String cryptoDepositDesc) {
        this.cryptoDepositDesc = cryptoDepositDesc;
    }

    public String getDepositFooterDesc() {
        return depositFooterDesc;
    }

    public void setDepositFooterDesc(String depositFooterDesc) {
        this.depositFooterDesc = depositFooterDesc;
    }

    public String getBank2DepositDesc() {
        return bank2DepositDesc;
    }

    public void setBank2DepositDesc(String bank2DepositDesc) {
        this.bank2DepositDesc = bank2DepositDesc;
    }

    public ArrayList<PayOptionSortData> getPayOptionSortDataList() {
        return payOptionSortDataList;
    }

    public void setPayOptionSortDataList(ArrayList<PayOptionSortData> payOptionSortDataList) {
        this.payOptionSortDataList = payOptionSortDataList;
    }

    public ArrayList<AvailablePaymentGroup> getAvailablePaymentGroupList() {
        return availablePaymentGroupList;
    }

    public void setAvailablePaymentGroupList(ArrayList<AvailablePaymentGroup> availablePaymentGroupList) {
        this.availablePaymentGroupList = availablePaymentGroupList;
    }

    public ArrayList<ExcludeTLCBankTransfer> getExcludeTLCBankTransferList() {
        return excludeTLCBankTransferList;
    }

    public void setExcludeTLCBankTransferList(ArrayList<ExcludeTLCBankTransfer> excludeTLCBankTransferList) {
        this.excludeTLCBankTransferList = excludeTLCBankTransferList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(isProcessing ? 1 : 0);
        dest.writeInt(isAllowDeposit ? 1 : 0);
        dest.writeInt(isAllowDecimal ? 1 : 0);
        dest.writeInt(isV2 ? 1 : 0);
        dest.writeInt(useRotate ? 1 : 0);
        dest.writeInt(allowUploadDepositCredential ? 1 : 0);
        dest.writeInt(depositMustBindBankcard ? 1 : 0);
        dest.writeInt(isUploadCrypto ? 1 : 0);
        dest.writeInt(isUploadCredentialCrypto ? 1 : 0);
        dest.writeInt(depositRealNameVerify ? 1 : 0);
        dest.writeInt(pgAllowPendingCount);
        dest.writeInt(pgProcessPendingCount);
        dest.writeInt(atmAllowPendingCount);
        dest.writeInt(atmProcessPendingCount);
        dest.writeString(cryptoAtmExchangeRate.toString());
        dest.writeString(bankDepositDesc);
        dest.writeString(thirdPartyDesc);
        dest.writeString(qrDesc);
        dest.writeString(phoneDepositDesc);
        dest.writeString(cryptoDepositDesc);
        dest.writeString(depositFooterDesc);
        dest.writeString(bank2DepositDesc);
        dest.writeArray(new Object[]{
                paymentGroupList,
                activityMap,
                quickLinkDepositList,
                cryptoList,
                payOptionSortDataList,
                availablePaymentGroupList,
                excludeTLCBankTransferList,
        });
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DepositOption createFromParcel(Parcel in) {
            return new DepositOption(in);
        }

        public DepositOption[] newArray(int size) {
            return new DepositOption[size];
        }
    };

    @Override
    public String toString() {
        return "DepositOption{" +
                "isProcessing=" + isProcessing +
                ", isAllowDeposit=" + isAllowDeposit +
                ", isV2=" + isV2 +
                ", useRotate=" + useRotate +
                ", allowUploadDepositCredential=" + allowUploadDepositCredential +
                ", paymentGroupList=" + paymentGroupList +
                '}';
    }
}
