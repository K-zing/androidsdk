package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetMessageListResult {

    private Integer count = 0;
    private Integer unreadCount = 0;
    private ArrayList<Message> messageList = new ArrayList<>();
    private ArrayList<Message> importantMessageList = new ArrayList<>();

    public GetMessageListResult() {

    }

    public static GetMessageListResult newInstance(JSONObject rootObject) {
        GetMessageListResult getMessageListResult = new GetMessageListResult();
        getMessageListResult.count = rootObject.optInt("count");
        getMessageListResult.unreadCount = rootObject.optInt("unreadcount");
        JSONArray importantMsg = rootObject.optJSONArray("important_msg");
        for (int i = 0; i < importantMsg.length(); i++) {
            getMessageListResult.importantMessageList.add(Message.newInstance(importantMsg.optJSONObject(i)));
        }
        JSONArray response = rootObject.optJSONArray("response");
        for (int i = 0; i < response.length(); i++) {
            getMessageListResult.messageList.add(Message.newInstance(response.optJSONObject(i)));
        }
        return getMessageListResult;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public ArrayList<Message> getImportantMessageList() {
        return importantMessageList;
    }

    public void setImportantMessageList(ArrayList<Message> importantMessageList) {
        this.importantMessageList = importantMessageList;
    }
}

