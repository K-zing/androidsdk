package com.kzingsdk.entity;

public enum SocialRegisterPlatform {
    facebook, google, telegram;

    public static SocialRegisterPlatform valueOfName(String name) {
        for (SocialRegisterPlatform type : SocialRegisterPlatform.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}