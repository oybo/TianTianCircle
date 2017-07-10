package com.tt.circle.app.callback;

import com.lzy.okgo.model.Response;

/**
 * ================================================
 * 作    者：O
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：默认将返回的数据解析成需要的Bean,可以是 BaseBean，String，List，Map
 * ================================================
 */
public abstract class JsonBeanCallback<T> extends JsonCallback<T> {

    @Override
    public void onSuccess(Response<T> response) {

        if(response != null) {
            success(response.body());
        } else {

            error("加载失败");
        }
    }

    @Override
    public void onError(Response<T> response) {
        super.onError(response);

        error("网络请求失败");
    }

    public abstract void success(T list);

    public abstract void error(String message);

}