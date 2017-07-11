package com.tt.circle.app.config;

/**
 * Created by O on 2017/7/4.
 */

public class UrlConfig {

    private static final String IP = "https://newapi.meipai.com";

    /**   获取所有频道     */
    public static final String URL_CATEGORYS = IP + "/channels/header_list.json?language=zh-Hans";

    /**   获取频道视频列表     */
    public final static String URL_VIDEO_LIST = IP + "/output/channels_topics_timeline.json";

    /**   获取频道视频详情     */
    public final static String URL_VIDEO_DETAIL = IP + "/medias/show.json";

    /**   获取频道视频详情评论     */
    public final static String URL_VIDEO_COMMENT_LIST = IP + "/comments/show.json";

}
