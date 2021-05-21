package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class D11News {

    private String id;
    private String title;
    private String content;
    private String createAt;
    private Integer tryPlatform;

    public D11News() {

    }

    public static D11News newInstance(JSONObject rootObject) {
        D11News d11News = new D11News();
        d11News.setId(rootObject.optString("id"));
        d11News.setTitle(rootObject.optString("title"));
        d11News.setContent(rootObject.optString("content"));
        d11News.setCreateAt(rootObject.optString("create_at"));
        d11News.setTryPlatform(rootObject.optInt("try_platform"));
        return d11News;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Integer getTryPlatform() {
        return tryPlatform;
    }

    public void setTryPlatform(Integer tryPlatform) {
        this.tryPlatform = tryPlatform;
    }
}


