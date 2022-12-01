package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class Message implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    private String id;
    private String title;
    private String content;
    private String typeId;
    private boolean isRead;
    private boolean isImportant;
    private String created;

    public Message() {

    }

    public Message(Parcel in) {
        id = in.readString();
        title = in.readString();
        content = in.readString();
        typeId = in.readString();
        created = in.readString();
        isRead = in.readInt() == 1;
        isImportant = in.readInt() == 1;
    }

    public static Message newInstance(JSONObject rootObject) {
        Message item = new Message();
        item.setId(rootObject.optString("id"));
        item.setTitle(rootObject.optString("title"));
        item.setContent(rootObject.optString("content"));
        item.setTypeId(rootObject.optString("msgtypeid"));
        item.setIsRead(rootObject.optString("readStatus").equals("1"));
        item.setIsImportant(rootObject.optString("important").equals("1"));
        item.setCreated(rootObject.optString("created"));
        return item;
    }


    public static Creator getCREATOR() {
        return CREATOR;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean important) {
        isImportant = important;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(typeId);
        dest.writeString(created);
        dest.writeInt(isRead ? 1 : 0);
        dest.writeInt(isImportant ? 1 : 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isRead='" + isRead + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
