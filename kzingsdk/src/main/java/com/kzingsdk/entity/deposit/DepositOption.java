package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
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
    private ArrayList<PaymentGroup> paymentGroupList = new ArrayList<>();
    private HashMap<String, String> activityMap = new HashMap<>();
    private ArrayList<QuickLinkDeposit> quickLinkDepositList = new ArrayList<>();

    public DepositOption() {

    }

    public static DepositOption newInstance(JSONObject rootObject) {
        DepositOption item = new DepositOption();
        double atmMinAmount = rootObject.optDouble("amin", 0d);
        double atmMaxAmount = rootObject.optDouble("amax", 0d);
        double atmTpMinAmount = rootObject.optDouble("atpmin", 0d);
        double atmTpMaxAmount = rootObject.optDouble("atpmax", 0d);
        int atmBankPosition = rootObject.optInt("atmbank_position", 0);
        item.isPrepaidCard = rootObject.optBoolean("isPrepaidCard", false);
        item.isV2 = rootObject.optBoolean("isV2", false);
        item.useRotate = rootObject.optBoolean("useRotate", false);
        item.allowUploadDepositCredential = rootObject.optBoolean("isUpload", false);
        item.depositMustBindBankcard = rootObject.optBoolean("depositMustBindBankcard", false);

        item.setProcessing(rootObject.optBoolean("process"));
        item.setAllowDeposit(rootObject.optBoolean("allowdeposit"));
        item.setAllowDecimal(rootObject.optBoolean("allowDecimal"));


        JSONArray actArray = rootObject.optJSONArray("actid");
        if (actArray != null) {
            for (int i = 0; i < actArray.length(); i++) {
                item.activityMap.put(actArray.optJSONObject(i).optString("actid"), actArray.optJSONObject(i).optString("actname"));
            }
        }

        JSONArray paymentTypeJArray = rootObject.optJSONArray("paymentType");
        JSONArray paymentAtmTypeJArray = rootObject.optJSONArray("paymentAtmType");
        JSONArray quickLinkJArray = rootObject.optJSONArray("quicklinkdeposit");
        JSONArray atmSortSettingJArray = rootObject.optJSONArray("atmSortSetting");
        HashMap<String, ArrayList<ThirdPartyPayment>> thirdPartyPaymentMap = createThirdPartyPaymentMap(paymentTypeJArray);
        ArrayList<AtmPayment> atmPaymentList = createAtmPaymentList(paymentAtmTypeJArray, atmSortSettingJArray, false);
        ArrayList<AtmPayment> qrcodePaymentList = createAtmPaymentList(paymentAtmTypeJArray, atmSortSettingJArray, true);

        JSONArray sortArrJArray = rootObject.optJSONArray("sortArr");
        JSONArray paymentGroupJArray = rootObject.optJSONArray("payOptionSortInfo");

        if (quickLinkJArray != null) {
            for (int i = 0; i < quickLinkJArray.length(); i++) {
                JSONObject quickLinkObject = quickLinkJArray.optJSONObject(i);
                item.quickLinkDepositList.add(QuickLinkDeposit.newInstance(quickLinkObject));
            }
        }

        for (int i = 0; i < sortArrJArray.length(); i++) {
            JSONObject cateSortingObject = sortArrJArray.optJSONObject(i);
            int option = cateSortingObject.optInt("option");
            int j;
            switch (option) {
                case 1:
                    for (j = 0; j < paymentGroupJArray.length(); j++) {
                        PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                        if (paymentGroup.getPaymentType() == THIRD_PARTY) {
                            item.paymentGroupList.add(paymentGroup);
                        }
                    }
                    break;
                case 99: // prepaid card
                    if (!item.isPrepaidCard) break;
                    String displayName = cateSortingObject.optString("displayName");
                    String bankcss = cateSortingObject.optString("bankcss");
                    PaymentGroup paymentGroupPrepaid = new PaymentGroup();
                    paymentGroupPrepaid.setName(displayName);
                    paymentGroupPrepaid.setImage(bankcss);
                    paymentGroupPrepaid.setPaymentType(PREPAIDCARD);
                    item.paymentGroupList.add(paymentGroupPrepaid);
                    break;
                case 3:
                    //ignored
                    break;
                case 2:
                case 4:
                case 69:
                case 73:
                    for (j = 0; j < paymentGroupJArray.length(); j++) {
                        PaymentGroup paymentGroup = PaymentGroup.newInstance(paymentGroupJArray.optJSONObject(j));
                        if (paymentGroup.getPaymentType() == PaymentType.valueOfTypeId(option)) {
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
                        paymentGroup.getPaymentList().addAll(thirdPartyPaymentMap.get(key));
                    }
                    break;
            }
        }
        return item;
    }

    private static ArrayList<AtmPayment> createAtmPaymentList(JSONArray jArray, JSONArray sortingArray, boolean isQrcode) {
        ArrayList<AtmPayment> atmPaymentList = new ArrayList<>();
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
        Collections.sort(atmPaymentList,
                (o1, o2) -> o1.getDisplayOrder() - o2.getDisplayOrder()
        );
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
                        thirdPartyPaymentMap.containsKey(key) ?
                                thirdPartyPaymentMap.get(key) : new ArrayList<>();
                for (int j = 0; j < thirdPartyPaymentArray.length(); j++) {
                    if (Integer.parseInt(key) == EWALLET.getId()) {
                        thirdPartyPaymentList.add(EWalletPayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    } else if (Integer.parseInt(key) == PHONE.getId()) {
                        thirdPartyPaymentList.add(PhonePayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    } else {
                        thirdPartyPaymentList.add(ThirdPartyPayment.newInstance(thirdPartyPaymentArray.optJSONObject(j), atmJObject, key));
                    }
                    thirdPartyPaymentMap.put(key, thirdPartyPaymentList);
                }
            }
        }
        for (ArrayList<ThirdPartyPayment> thirdPartyPaymentList : thirdPartyPaymentMap.values()) {
            Collections.sort(thirdPartyPaymentList,
                    (o1, o2) -> o1.getDisplayOrder() - o2.getDisplayOrder()
            );
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

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DepositOption createFromParcel(Parcel in) {
            return new DepositOption(in);
        }

        public DepositOption[] newArray(int size) {
            return new DepositOption[size];
        }
    };

    public DepositOption(Parcel in) {
        isProcessing = in.readInt() == 1;
        isAllowDeposit = in.readInt() == 1;
        isAllowDecimal = in.readInt() == 1;
        isV2 = in.readInt() == 1;
        useRotate = in.readInt() == 1;
        allowUploadDepositCredential = in.readInt() == 1;
        depositMustBindBankcard = in.readInt() == 1;
        Object[] customObjects = in.readArray(ThirdPartyPayment.class.getClassLoader());
        paymentGroupList = (ArrayList<PaymentGroup>) customObjects[0];
        activityMap = (HashMap<String, String>) customObjects[1];
        quickLinkDepositList = (ArrayList<QuickLinkDeposit>) customObjects[2];
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

        Object[] customObjects = new Object[3];
        customObjects[0] = paymentGroupList;
        customObjects[1] = activityMap;
        customObjects[2] = quickLinkDepositList;
        dest.writeArray(customObjects);
    }

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
