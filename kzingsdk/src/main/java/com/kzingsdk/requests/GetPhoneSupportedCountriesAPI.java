package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PhoneCountry;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPhoneSupportedCountriesAPI extends CoreRequest {


    GetPhoneSupportedCountriesAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPhoneSupportedCountries;
    }

    @Override
    public Observable<ArrayList<PhoneCountry>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONArray countryListArray = jsonResponse.optJSONArray("response");
            ArrayList<PhoneCountry> phoneCountryList = new ArrayList<>();
            if (countryListArray != null) {
                for (int i = 0; i < countryListArray.length(); i++) {
                    phoneCountryList.add(PhoneCountry.newInstance(countryListArray.optJSONObject(i)));
                }
            }
            return phoneCountryList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(phoneCountryArrayList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPhoneSupportedCountriesCallBack) kzingCallBack).onSuccess(phoneCountryArrayList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPhoneSupportedCountriesAPI addRegParamCallBack(GetPhoneSupportedCountriesCallBack getPhoneSupportedCountriesCallBack) {
        kzingCallBackList.add(getPhoneSupportedCountriesCallBack);
        return this;
    }

    public interface GetPhoneSupportedCountriesCallBack extends KzingCallBack {
        void onSuccess(ArrayList<PhoneCountry> phoneCountryArrayList);
    }

}
