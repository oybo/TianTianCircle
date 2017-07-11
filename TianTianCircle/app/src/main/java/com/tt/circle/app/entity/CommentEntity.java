package com.tt.circle.app.entity;

/**
 * ================================================
 * author: O
 * created on: 2017/7/11 10:44
 * description:
 * ================================================
 */
public class CommentEntity {
    private int id;

    private String content;

    private int media_id;

    private String created_at;

    private boolean liked;

    private int liked_count;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public int getMedia_id() {
        return this.media_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean getLiked() {
        return this.liked;
    }

    public void setLiked_count(int liked_count) {
        this.liked_count = liked_count;
    }

    public int getLiked_count() {
        return this.liked_count;
    }

}
