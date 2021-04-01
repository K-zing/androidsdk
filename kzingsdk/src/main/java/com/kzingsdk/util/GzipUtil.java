package com.kzingsdk.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class GzipUtil {

    public static String decompress(String zipText) throws IOException {
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(Base64Utils.decode(zipText)));
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8));
        StringBuilder outStr = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) {
            outStr.append(line);
        }
        return outStr.toString();
    }

}
