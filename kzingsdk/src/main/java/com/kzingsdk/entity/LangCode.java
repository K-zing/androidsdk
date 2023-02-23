package com.kzingsdk.entity;

public enum LangCode {
    CHS, ENG, THA, IND, VIT, BEN, JPN, KOR, TEL, HIN;

    public static LangCode valueOfName(String name) {
        for (LangCode type : LangCode.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return CHS;
    }
}
