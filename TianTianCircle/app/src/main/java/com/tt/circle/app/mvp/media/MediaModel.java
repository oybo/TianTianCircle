package com.tt.circle.app.mvp.media;

import com.lzy.okgo.OkGo;
import com.tt.circle.app.callback.JsonBeanCallback;
import com.tt.circle.app.config.UrlConfig;
import com.tt.circle.app.entity.MediaEntity;

import java.util.List;

/**
 * ================================================
 * author: O
 * created on: 2017/7/4 15:43
 * description:
 * ================================================
 */
public class MediaModel {

    public void getMedias(int id, int page, int count, JsonBeanCallback callback) {

        OkGo.<List<MediaEntity>>get(UrlConfig.URL_VIDEO_LIST)
                .tag(this)
                .params("id", id)
                .params("count", count)
                .params("page", page)
                .execute(callback);

    }

}
