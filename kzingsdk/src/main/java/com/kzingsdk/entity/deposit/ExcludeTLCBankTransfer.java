package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExcludeTLCBankTransfer implements Parcelable {

    private String key;
    private String name;
    private String randMin;
    private String randMax;
    private String randType;
    private ArrayList<String> fixAmtArray = new ArrayList<>();
    private ArrayList<ThirdPartyPayment> valueArray = new ArrayList<>();

    public ExcludeTLCBankTransfer() {

    }


    public static ExcludeTLCBankTransfer newInstance(JSONObject rootObject) {
        ExcludeTLCBankTransfer item = new ExcludeTLCBankTransfer();
        item.key = rootObject.optString("key");
        item.name = rootObject.optString("name");
        item.randMin = rootObject.optString("randMin");
        item.randMax = rootObject.optString("randMax");
        item.randType = rootObject.optString("randType");
        JSONArray fixAmtArray = rootObject.optJSONArray("fixAmtArray");
        if (fixAmtArray != null) {
            for (int i = 0; i < fixAmtArray.length(); i++) {
                item.fixAmtArray.add(fixAmtArray.optString(i));
            }
        }
        JSONArray valueArray = rootObject.optJSONArray("value");
        if (valueArray != null) {
            for (int i = 0; i < valueArray.length(); i++) {
                item.valueArray.add(ThirdPartyPayment.newInstance(valueArray.optJSONObject(i), rootObject, item.key));
            }
        }
        return item;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ExcludeTLCBankTransfer createFromParcel(Parcel in) {
            return new ExcludeTLCBankTransfer(in);
        }

        public ExcludeTLCBankTransfer[] newArray(int size) {
            return new ExcludeTLCBankTransfer[size];
        }
    };

    public ExcludeTLCBankTransfer(Parcel in) {
        key = in.readString();
        name = in.readString();
        randMin = in.readString();
        randMax = in.readString();
        randType = in.readString();
        int i = 0;
        Object[] customObjects = in.readArray(ThirdPartyPayment.class.getClassLoader());
        fixAmtArray = (ArrayList<String>) customObjects[i++];
        valueArray = (ArrayList<ThirdPartyPayment>) customObjects[i++];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(name);
        dest.writeString(randMin);
        dest.writeString(randMax);
        dest.writeString(randType);
        dest.writeArray(new Object[]{
                fixAmtArray,
                valueArray
        });
    }
}
