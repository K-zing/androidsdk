package com.kzingsdk.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


final class KzingConverterFactory extends Converter.Factory {

    private KzingConverterFactory() {
    }

    public static KzingConverterFactory create() {
        return new KzingConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        if (type == Bitmap.class) {
            return KZingConverter.ByteArrayResponseBodyConverter.INSTANCE;
        }
        return KZingConverter.StringResponseBodyConverter.INSTANCE;

    }

    private static final class KZingConverter {

        private KZingConverter() {
        }

        static final class StringResponseBodyConverter implements Converter<ResponseBody, String> {
            static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();

            @Override
            public String convert(ResponseBody value) throws IOException {
                byte[] returnByte = value.bytes();
                String returnString = new String(returnByte, StandardCharsets.UTF_8);
                value.close();
                return returnString;
            }
        }

        static final class ByteArrayResponseBodyConverter implements Converter<ResponseBody, Bitmap> {
            static final ByteArrayResponseBodyConverter INSTANCE = new ByteArrayResponseBodyConverter();

            @Override
            public Bitmap convert(ResponseBody value) throws IOException {
                Bitmap bitmap = BitmapFactory.decodeStream(value.byteStream());
                value.close();
                return bitmap;
            }
        }

    }


}
