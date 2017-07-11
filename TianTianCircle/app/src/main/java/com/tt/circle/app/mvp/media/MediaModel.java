package com.tt.circle.app.mvp.media;

import com.lzy.okgo.OkGo;
import com.tt.circle.app.callback.JsonBeanCallback;
import com.tt.circle.app.config.ApiParamsMap;
import com.tt.circle.app.config.UrlConfig;
import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.entity.MediaDetailEntity;
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

    /**
     * 获取视频列表
     *
     * @param id
     * @param page
     * @param count
     * @param callback
     */
    public void getMedias(int id, int page, int count, JsonBeanCallback callback) {
        OkGo.<List<MediaEntity>>get(UrlConfig.URL_VIDEO_LIST)
                .tag(UrlConfig.URL_VIDEO_LIST)
                .params("id", id)
                .params("count", count)
                .params("page", page)
                .execute(callback);
    }

    /**
     * 视频详情页
     * @param id
     * @param callback
     */
    public void getMediaDetail(int id, JsonBeanCallback callback) {
        OkGo.<MediaDetailEntity>get(UrlConfig.URL_VIDEO_DETAIL)
                .tag(UrlConfig.URL_VIDEO_DETAIL)
                .params(new ApiParamsMap())
                .params("id", id)
                .execute(callback);
    }

    /**
     * 获取视频评论集合
     *
     * @param id
     * @param page
     * @param callback
     */
    public void getComments(int id, int page, JsonBeanCallback callback) {
        OkGo.<List<CommentEntity>>get(UrlConfig.URL_VIDEO_COMMENT_LIST)
                .tag(UrlConfig.URL_VIDEO_COMMENT_LIST)
                .params(new ApiParamsMap())
                .params("id", id)
                .params("page", page)
                .execute(callback);
    }

}
