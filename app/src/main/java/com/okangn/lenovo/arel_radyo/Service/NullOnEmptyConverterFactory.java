package com.okangn.lenovo.arel_radyo.Service;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public  class NullOnEmptyConverterFactory extends Converter.Factory {
    private static final String TAG = "anasayfa";

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
        Log.d(TAG, "responseBodyConverter: creating the NULL converter");
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody body) throws IOException {
                Log.d(TAG, "convert: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (body.contentLength() == 0) {
                    Log.d(TAG, "convert: returning null");
                    return null;
                } else {
                    Log.d(TAG, "convert: returning the delegate.convert result");
                    return delegate.convert(body);
                }
            }
        };
    }
}