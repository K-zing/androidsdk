package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetFriendRefLogResult {

    private Integer totalItems;
    private Integer totalPages;
    private Integer pageCount;
    private ArrayList<FriendRefLog> friendRefLogList = new ArrayList<>();

    public static GetFriendRefLogResult newInstance(JSONObject rootObject) {
        GetFriendRefLogResult getFriendRefLogResult = new GetFriendRefLogResult();
        JSONObject pageObject = rootObject.optJSONObject("page");
        getFriendRefLogResult.setTotalItems(pageObject.optInt("totalItems", 0));
        getFriendRefLogResult.setTotalPages(pageObject.optInt("totalPages", 0));
        getFriendRefLogResult.setPageCount(pageObject.optInt("pageCount", 0));
        JSONArray friendRefArray = rootObject.optJSONArray("friendRef");
        if (friendRefArray != null) {
            for (int i = 0; i < friendRefArray.length(); i++) {
                getFriendRefLogResult.friendRefLogList.add(FriendRefLog.newInstance(friendRefArray.optJSONObject(i)));
            }
        }
        return getFriendRefLogResult;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<FriendRefLog> getFriendRefLogList() {
        return friendRefLogList;
    }

    public void setFriendRefLogList(ArrayList<FriendRefLog> friendRefLogList) {
        this.friendRefLogList = friendRefLogList;
    }

    @Override
    public String toString() {
        return "GetFriendRefLogResult{" +
                "totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                ", pageCount=" + pageCount +
                ", friendRefLogList=" + friendRefLogList +
                '}';
    }
}
