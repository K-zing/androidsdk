package com.kzingsdk.util;

import java.security.NoSuchAlgorithmException;

public final class MD5Utils {

    private MD5Utils() {

    }

    public static String md5(String md5) throws NoSuchAlgorithmException {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte anArray : array) {
            stringBuilder.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
        }
        return stringBuilder.toString();

    }

}