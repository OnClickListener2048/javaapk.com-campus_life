package com.yhx.app.common;

import android.content.Intent;
import android.net.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.exception.HttpException;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lyt on 2017/10/12.
 */

public abstract class JsonCallBack<T> extends AbsCallback<T> {
    String TAG = JsonCallBack.class.getSimpleName();
    private Type type;
    private Class<T> clazz;

    protected JsonCallBack(Type type) {
        this.type = type;
    }

    protected JsonCallBack(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
    }


    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public T convertResponse(Response response) {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }

        T data = null;
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonReader jsonReader = new JsonReader(body.charStream());
        if (type != null) {
            data = gson.fromJson(jsonReader, type);
        }
        if (clazz != null) {
            data = gson.fromJson(jsonReader, clazz);
        }
        return data;
    }

    @Override
    public void onError(com.lzy.okgo.model.Response<T> response) {
        super.onError(response);

    }


    @Override
    public void onCacheSuccess(com.lzy.okgo.model.Response<T> response) {
        super.onCacheSuccess(response);
    }

}
