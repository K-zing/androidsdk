package com.kzingsdk.entity;

import com.kzingsdk.entity.gameplatform.GamePlatform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlatformMaintenanceApiResult extends SimpleApiResult {

    protected ArrayList<PlatformMaintenance> platformMaintenanceList = new ArrayList<>();

    public static PlatformMaintenanceApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        PlatformMaintenanceApiResult result = new PlatformMaintenanceApiResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());

        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                result.platformMaintenanceList.add(PlatformMaintenance.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return result;
    }

    public ArrayList<PlatformMaintenance> getPlatformMaintenanceList() {
        return platformMaintenanceList;
    }

    public void setPlatformMaintenanceList(ArrayList<PlatformMaintenance> platformMaintenanceList) {
        this.platformMaintenanceList = platformMaintenanceList;
    }
}
