package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PhoneCountry;

import org.json.JSONArray;
import org.json.JSONObject;

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
    public Observable<GetPhoneSupportedCountriesResponse> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return GetPhoneSupportedCountriesResponse.newInstance(jsonResponse);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getPhoneSupportedCountriesResponse -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPhoneSupportedCountriesCallBack) kzingCallBack).onSuccess(getPhoneSupportedCountriesResponse);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPhoneSupportedCountriesAPI addRegParamCallBack(GetPhoneSupportedCountriesCallBack getPhoneSupportedCountriesCallBack) {
        kzingCallBackList.add(getPhoneSupportedCountriesCallBack);
        return this;
    }

    public interface GetPhoneSupportedCountriesCallBack extends KzingCallBack {
        void onSuccess(GetPhoneSupportedCountriesResponse getPhoneSupportedCountriesResponse);
    }

    public static class GetPhoneSupportedCountriesResponse {
        private ArrayList<PhoneCountry> phoneCountryArrayList;
        private ArrayList<String> popularList;

        public static GetPhoneSupportedCountriesResponse newInstance(JSONObject rootObject) {
            GetPhoneSupportedCountriesResponse getPhoneSupportedCountriesResponse = new GetPhoneSupportedCountriesResponse();
            JSONArray popularArray = rootObject.optJSONArray("popular");
            ArrayList<String> popularList = new ArrayList<>();
            if (popularArray != null) {
                for (int i = 0; i < popularArray.length(); i++) {
                    popularList.add(popularArray.optString(i));
                }
            }

            JSONArray countryListArray = rootObject.optJSONArray("response");
            ArrayList<PhoneCountry> phoneCountryArrayList = new ArrayList<>();
            if (countryListArray != null) {
                for (int i = 0; i < countryListArray.length(); i++) {
                    phoneCountryArrayList.add(PhoneCountry.newInstance(countryListArray.optJSONObject(i)));
                }
            }
            getPhoneSupportedCountriesResponse.popularList = popularList;
            getPhoneSupportedCountriesResponse.phoneCountryArrayList = phoneCountryArrayList;
            return getPhoneSupportedCountriesResponse;
        }

        public ArrayList<PhoneCountry> getPhoneCountryArrayList() {
            return phoneCountryArrayList;
        }

        public void setPhoneCountryArrayList(ArrayList<PhoneCountry> phoneCountryArrayList) {
            this.phoneCountryArrayList = phoneCountryArrayList;
        }

        public ArrayList<String> getPopularList() {
            return popularList;
        }

        public void setPopularList(ArrayList<String> popularList) {
            this.popularList = popularList;
        }
    }

}
