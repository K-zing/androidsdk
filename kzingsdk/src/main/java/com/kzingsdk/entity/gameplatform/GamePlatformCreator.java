package com.kzingsdk.entity.gameplatform;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static com.kzingsdk.entity.gameplatform.GamePlatform.PlayStatus.ENABLE_APP;
import static com.kzingsdk.entity.gameplatform.GamePlatform.PlayStatus.ENABLE_H5;

public final class GamePlatformCreator {

    private final String TAG = "GamePlatformCreator";
    private JSONArray containerJsonArray = null;
    private JSONArray subGameJsonObject = null;

    public GamePlatformCreator setContainerJsonArray(JSONArray containerJsonArray) {
        this.containerJsonArray = containerJsonArray;
        return this;
    }

    public GamePlatformCreator setSubGameJsonObject(JSONArray subGameJsonObject) {
        this.subGameJsonObject = subGameJsonObject;
        return this;
    }

    public ArrayList<GamePlatformContainer> build() {
        if (containerJsonArray == null) {
            return null;
        }
        try {
            ArrayList<GamePlatformContainer> gamePlatformContainerList = intiGamePlatform(containerJsonArray);
            if (subGameJsonObject != null) {
                intiGamePlatformChildNormal(subGameJsonObject, gamePlatformContainerList);
                intiGamePlatformChildCustom(subGameJsonObject, gamePlatformContainerList);
            }
            return gamePlatformContainerList;
        } catch (JSONException e) {
            return null;
        }
    }

    private ArrayList<GamePlatformContainer> intiGamePlatform(JSONArray response) throws JSONException {
        ArrayList<GamePlatformContainer> gamePlatformContainerList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            ArrayList<GamePlatform> gamePlatformListList = new ArrayList<>();

            JSONObject responseType = response.optJSONObject(i);
            GamePlatformType type = GamePlatformType.valueOfTypeId(responseType.optInt("gptype"));
            if (type == null) {
                continue;
            }
            type.setName(responseType.optString("gptypename"));
            JSONArray gamePlatformArray = responseType.optJSONArray("gp");
            if (gamePlatformArray != null && gamePlatformArray.length() > 0) {
                for (int j = 0; j < gamePlatformArray.length(); j++) {
                    GamePlatform gp;
                    String gpid = gamePlatformArray.optJSONObject(j).optString("gpid");
                    if (gpid.length() < 6) {
                        gp = GamePlatformCustom.newInstance(gamePlatformArray.optJSONObject(j));
                    } else {
                        gp = GamePlatform.newInstance(gamePlatformArray.optJSONObject(j));
                    }
                    if (gp.getPlayStatus().contains(ENABLE_H5) || gp.getPlayStatus().contains(ENABLE_APP)) {
                        if (!(gp instanceof GamePlatformCustom)) {
                            if (!gp.getUrl().isEmpty()) {
                                gamePlatformListList.add(gp);
                            }
                        } else {
                            gamePlatformListList.add(gp);
                        }
                    }
                }
            }
            if (gamePlatformListList.size() > 0) {
                gamePlatformContainerList.add(new GamePlatformContainer(type, gamePlatformListList));
            }
        }
        return gamePlatformContainerList;
    }

    private ArrayList<GamePlatformContainer> intiGamePlatformChildNormal(JSONArray response, ArrayList<GamePlatformContainer> gamePlatformContainerList) throws JSONException {
        for (GamePlatformContainer gpContainer : gamePlatformContainerList) {
            for (GamePlatform gpPlatform : gpContainer.getGamePlatformList()) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject listDetails = response.optJSONObject(i);
                    String listGPID = listDetails.optString("gpid");
                    String gpid = gpPlatform instanceof GamePlatformCustom ? ((GamePlatformCustom) gpPlatform).getCustomgpid() : gpPlatform.getGpid();
                    if (!listGPID.equals(gpid)) {
                        continue;
                    }
                    JSONArray categorysArray = listDetails.optJSONArray("categories");
                    JSONArray childGroupArray = listDetails.optJSONArray("childgroups");
                    if (childGroupArray == null || childGroupArray.length() < 1) {
                        continue;
                    }
                    JSONArray childsArrayObject = childGroupArray.optJSONObject(0).optJSONArray("childs");
                    if (!(gpPlatform instanceof GamePlatformCustom)) {
                        ArrayList<GamePlatformCategory> categoryList = new ArrayList<>();
                        ArrayList<GamePlatformChild> childList = new ArrayList<>();
                        ArrayList<GamePlatformGroup> groupsList = new ArrayList<>();
                        if (categorysArray != null) {
                            for (int j = 0; j < categorysArray.length(); j++) {
                                categoryList.add(GamePlatformCategory.newInstance(categorysArray.optJSONObject(j)));
                            }
                        }
                        gpPlatform.setCategoryArrayList(categoryList);
                        if (childGroupArray.length() == 1) {
                            for (int b = 0; b < childsArrayObject.length(); b++) {
                                GamePlatformChild gpChild;
                                gpChild = GamePlatformChild.newInstance(childsArrayObject.optJSONObject(b), gpPlatform);
                                if (gpChild.isEnabled()) {
                                    childList.add(gpChild);
                                }
                            }
                            gpPlatform.setChildArrayList(childList);
                            if (gpPlatform.getGpid().equalsIgnoreCase("5434054984301")) {
                                Log.d("Creator", "gpPlatform 5434054984301 = " + gpPlatform.getChildArrayList().size());
                            }
                            if (gpPlatform.getGpid().equalsIgnoreCase("7295220587201")) {
                                Log.d("Creator", "gpPlatform 7295220587201 = " + gpPlatform.getChildArrayList().size());
                            }
                        } else if (childGroupArray.length() > 1) {
                            for (int cg = 0; cg < childGroupArray.length(); cg++) {
                                GamePlatformGroup group = GamePlatformGroup.newInstance(childGroupArray.optJSONObject(cg), gpPlatform);
                                if (group.getChildArrayList().size() == 0) {
                                    continue;
                                }
                                ArrayList<GamePlatformCategory> categoryOfGroupArrayList = new ArrayList<>();
                                for (GamePlatformCategory category : gpPlatform.getCategoryArrayList()) {
                                    if (group.getChildGroupId().equals(category.getChildGroupId())) {
                                        HashSet<Integer> checkGroupCatagorySet = new HashSet<>();
                                        for (GamePlatformChild child : group.getChildArrayList()) {
                                            if (child.isEnabled()) {
                                                checkGroupCatagorySet.addAll(child.getCategorysSet());
                                            }
                                        }
                                        if (checkGroupCatagorySet.contains(Integer.parseInt(category.getChildCategoryId()))) {
                                            categoryOfGroupArrayList.add(category);
                                        }
                                    }
                                }
                                group.setCategoryArrayList(categoryOfGroupArrayList);
                                groupsList.add(group);
                            }
                            gpPlatform.setGroupArrayList(groupsList);
                        }
                    }
                }
            }
        }

        return gamePlatformContainerList;
    }

    private ArrayList<GamePlatformContainer> intiGamePlatformChildCustom(JSONArray response, ArrayList<GamePlatformContainer> gamePlatformContainerList) throws JSONException {
        for (GamePlatformContainer gpContainer : gamePlatformContainerList) {
            for (GamePlatform gpPlatform : gpContainer.getGamePlatformList()) {
                if (!(gpPlatform instanceof GamePlatformCustom)) {
                    continue;
                }
                String gpid = ((GamePlatformCustom) gpPlatform).getCustomgpid();
                for (int i = 0; i < response.length(); i++) {
                    JSONObject listDetails = response.optJSONObject(i);
                    String listGPID = listDetails.optString("gpid");
                    if (!listGPID.equals(gpid)) {
                        continue;
                    }
//                    JSONArray categorysArray = listDetails.optJSONArray("categories");
                    JSONArray childGroupArray = listDetails.optJSONArray("childgroups");
                    if (childGroupArray == null || childGroupArray.length() < 1) {
                        continue;
                    }
                    JSONArray childsArrayObject = childGroupArray.optJSONObject(0).optJSONArray("childs");
                    for (int chi = 0; chi < childsArrayObject.length(); chi++) {
                        JSONObject childsResponse = childsArrayObject.optJSONObject(chi);
                        String customGPID = childsResponse.optString("gpid");
                        String customGpchildid = childsResponse.optString("gpchildid");
                        int customDisplayorder = childsResponse.optInt("displayorder");
                        GamePlatform gp = GamePlatformContainer.findGamePlatform(gamePlatformContainerList, customGPID);
                        if (gp == null) {
                            continue;
                        }
                        GamePlatform gpClone = gp.clone();
                        if (customGpchildid != null) {
                            if (customGpchildid.equals("0")) {
                                gpClone.setDisplayorder(customDisplayorder);
                                ((GamePlatformCustom) gpPlatform).getPlayableArrayList().add(gpClone.clone());
                            } else {
                                ArrayList<GamePlatformChild> findChildList = getAllGpChildList(gpClone);
                                for (GamePlatformChild findChild : findChildList) {
                                    GamePlatformChild findChildClone = findChild.clone();
                                    findChildClone.setDisplayorder(customDisplayorder);
                                    if (findChildClone.getGamePlatform() != null && findChildClone.getGpChildId().equals(customGpchildid) && findChildClone.isEnabled()) {
                                        ((GamePlatformCustom) gpPlatform).getPlayableArrayList().add(findChildClone);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    Collections.sort(((GamePlatformCustom) gpPlatform).getPlayableArrayList(),
                            (o1, o2) -> o1.getDisplayorder() - o2.getDisplayorder()
                    );
                }
            }
        }

        return gamePlatformContainerList;
    }

    private ArrayList<GamePlatformChild> getAllGpChildList(GamePlatform gamePlatform) {
        ArrayList<GamePlatformChild> allGpChildList = new ArrayList<>();
        allGpChildList.addAll(gamePlatform.getChildArrayList());
        for (GamePlatformGroup group : gamePlatform.getGroupArrayList()) {
            allGpChildList.addAll(group.getChildArrayList());
        }
        return allGpChildList;
    }

}
