package com.tt.circle.app.entity;

import java.io.Serializable;

/**
 * Created by O on 2017/7/3.
 */

public class MediaEntity implements Serializable{


    /**
     * id : 779799409
     * user_id : 39781296
     * url : http://www.meipai.com/media/779799409
     * cover_pic : http://mvimg1.meitudata.com/594261212dbc39135.jpg!thumb320
     * screen_name : .隔壁的老王
     * caption : 心灵污鸡汤#搞笑##我要进热门#评论+点赞，系统随机抽取5名幸运儿，送红包哟😊6月19日开奖😘😘https://college.meipai.com/welfare/78ed2ef808464060老王微信:wo987no
     * avatar : http://mvavatar1.meitudata.com/5761f4680b7063198.jpg
     * plays_count : 816209
     * comments_count : 803
     * likes_count : 10728
     * created_at : 1497522460
     */

    private int id;
    private int user_id;
    private String url;
    private String cover_pic;
    private String screen_name;
    private String caption;
    private String avatar;
    private int plays_count;
    private int comments_count;
    private int likes_count;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPlays_count() {
        return plays_count;
    }

    public void setPlays_count(int plays_count) {
        this.plays_count = plays_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
