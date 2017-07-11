package com.tt.circle.app.entity;

/**
 * ================================================
 * author: O
 * created on: 2017/7/11 14:10
 * description:
 * ================================================
 */
public class MediaDetailEntity {

    /**
     * id : 800012
     * caption : #女人也很凶
     * weibo_share_caption : 分享@Joker-Xes 的美拍“#女人也很凶”，快来看看>>
     * facebook_share_caption :
     * weixin_share_caption : 分享 Mars 的美拍
     * weixin_friendfeed_share_caption : #女人也很凶
     * qzone_share_caption : #女人也很凶
     * qq_share_caption : #女人也很凶
     * instagram_share_caption : 分享Mars的美拍“#女人也很凶”，快来看看！
     * weixin_share_sub_caption : #女人也很凶
     * weixin_friendfeed_share_sub_caption :
     * qzone_share_sub_caption :
     * qq_share_sub_caption :
     * geo : null
     * video : http://mvvideo11.meitudata.com/536b72c8c50cc3967.mp4
     * url : http://www.meipai.com/media/800012
     * cover_pic : http://mvimg10.meitudata.com/536b72fd9f54c7336.jpg
     * pic_size : 480*480
     * category : 1
     * time : 13
     * is_long : false
     * show_controls : false
     * created_at : 1399550721
     * comments_count : 1
     * likes_count : 9
     * reposts_count : 0
     * is_popular : false
     * user : {"id":10014061,"screen_name":"Mars","country":2630000,"province":2633200,"city":2633217,"avatar":"http://mvavatar2
     * .meitudata.com/536a6824dadee9151.jpg","gender":"m","birthday":"","age":"","constellation":"","verified":false,
     * "followers_count":18,"friends_count":3,"reposts_count":0,"videos_count":15,"real_videos_count":15,"photos_count":0,
     * "locked_videos_count":0,"real_locked_videos_count":0,"locked_photos_count":0,"be_liked_count":82,"following":false,
     * "followed_by":false,"url":"http://www.meipai.com/user/10014061","created_at":1399453330,"has_password":false,"status":"1",
     * "is_funy_core_user":false,"funy_core_user_created_at":0,"last_publish_time":0,"level":2,"show_pendant":true,"has_assoc_phone":false}
     * feed_id : 5870141191068124479
     * locked : false
     * caption_url_params : null
     * privacy_config : {"allow_save_medias":1,"forbid_stranger_comment":0}
     * has_watermark : 0
     * new_music : null
     * liked : false
     * plays_count : 189
     * show_plays_count : true
     */

    private int id;
    private String caption;
    private String weibo_share_caption;
    private String facebook_share_caption;
    private String weixin_share_caption;
    private String weixin_friendfeed_share_caption;
    private String qzone_share_caption;
    private String qq_share_caption;
    private String instagram_share_caption;
    private String weixin_share_sub_caption;
    private String weixin_friendfeed_share_sub_caption;
    private String qzone_share_sub_caption;
    private String qq_share_sub_caption;
    private Object geo;
    private String video;
    private String url;
    private String cover_pic;
    private String pic_size;
    private int category;
    private int time;
    private boolean is_long;
    private boolean show_controls;
    private String created_at;
    private int comments_count;
    private int likes_count;
    private int reposts_count;
    private boolean is_popular;
    /**
     * id : 10014061
     * screen_name : Mars
     * country : 2630000
     * province : 2633200
     * city : 2633217
     * avatar : http://mvavatar2.meitudata.com/536a6824dadee9151.jpg
     * gender : m
     * birthday :
     * age :
     * constellation :
     * verified : false
     * followers_count : 18
     * friends_count : 3
     * reposts_count : 0
     * videos_count : 15
     * real_videos_count : 15
     * photos_count : 0
     * locked_videos_count : 0
     * real_locked_videos_count : 0
     * locked_photos_count : 0
     * be_liked_count : 82
     * following : false
     * followed_by : false
     * url : http://www.meipai.com/user/10014061
     * created_at : 1399453330
     * has_password : false
     * status : 1
     * is_funy_core_user : false
     * funy_core_user_created_at : 0
     * last_publish_time : 0
     * level : 2
     * show_pendant : true
     * has_assoc_phone : false
     */

    private UserNameBean user;
    private String feed_id;
    private boolean locked;
    private Object caption_url_params;
    /**
     * allow_save_medias : 1
     * forbid_stranger_comment : 0
     */

    private PrivacyConfigNameBean privacy_config;
    private int has_watermark;
    private Object new_music;
    private boolean liked;
    private int plays_count;
    private boolean show_plays_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getWeibo_share_caption() {
        return weibo_share_caption;
    }

    public void setWeibo_share_caption(String weibo_share_caption) {
        this.weibo_share_caption = weibo_share_caption;
    }

    public String getFacebook_share_caption() {
        return facebook_share_caption;
    }

    public void setFacebook_share_caption(String facebook_share_caption) {
        this.facebook_share_caption = facebook_share_caption;
    }

    public String getWeixin_share_caption() {
        return weixin_share_caption;
    }

    public void setWeixin_share_caption(String weixin_share_caption) {
        this.weixin_share_caption = weixin_share_caption;
    }

    public String getWeixin_friendfeed_share_caption() {
        return weixin_friendfeed_share_caption;
    }

    public void setWeixin_friendfeed_share_caption(String weixin_friendfeed_share_caption) {
        this.weixin_friendfeed_share_caption = weixin_friendfeed_share_caption;
    }

    public String getQzone_share_caption() {
        return qzone_share_caption;
    }

    public void setQzone_share_caption(String qzone_share_caption) {
        this.qzone_share_caption = qzone_share_caption;
    }

    public String getQq_share_caption() {
        return qq_share_caption;
    }

    public void setQq_share_caption(String qq_share_caption) {
        this.qq_share_caption = qq_share_caption;
    }

    public String getInstagram_share_caption() {
        return instagram_share_caption;
    }

    public void setInstagram_share_caption(String instagram_share_caption) {
        this.instagram_share_caption = instagram_share_caption;
    }

    public String getWeixin_share_sub_caption() {
        return weixin_share_sub_caption;
    }

    public void setWeixin_share_sub_caption(String weixin_share_sub_caption) {
        this.weixin_share_sub_caption = weixin_share_sub_caption;
    }

    public String getWeixin_friendfeed_share_sub_caption() {
        return weixin_friendfeed_share_sub_caption;
    }

    public void setWeixin_friendfeed_share_sub_caption(String weixin_friendfeed_share_sub_caption) {
        this.weixin_friendfeed_share_sub_caption = weixin_friendfeed_share_sub_caption;
    }

    public String getQzone_share_sub_caption() {
        return qzone_share_sub_caption;
    }

    public void setQzone_share_sub_caption(String qzone_share_sub_caption) {
        this.qzone_share_sub_caption = qzone_share_sub_caption;
    }

    public String getQq_share_sub_caption() {
        return qq_share_sub_caption;
    }

    public void setQq_share_sub_caption(String qq_share_sub_caption) {
        this.qq_share_sub_caption = qq_share_sub_caption;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public String getPic_size() {
        return pic_size;
    }

    public void setPic_size(String pic_size) {
        this.pic_size = pic_size;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isIs_long() {
        return is_long;
    }

    public void setIs_long(boolean is_long) {
        this.is_long = is_long;
    }

    public boolean isShow_controls() {
        return show_controls;
    }

    public void setShow_controls(boolean show_controls) {
        this.show_controls = show_controls;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public boolean isIs_popular() {
        return is_popular;
    }

    public void setIs_popular(boolean is_popular) {
        this.is_popular = is_popular;
    }

    public UserNameBean getUser() {
        return user;
    }

    public void setUser(UserNameBean user) {
        this.user = user;
    }

    public String getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(String feed_id) {
        this.feed_id = feed_id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Object getCaption_url_params() {
        return caption_url_params;
    }

    public void setCaption_url_params(Object caption_url_params) {
        this.caption_url_params = caption_url_params;
    }

    public PrivacyConfigNameBean getPrivacy_config() {
        return privacy_config;
    }

    public void setPrivacy_config(PrivacyConfigNameBean privacy_config) {
        this.privacy_config = privacy_config;
    }

    public int getHas_watermark() {
        return has_watermark;
    }

    public void setHas_watermark(int has_watermark) {
        this.has_watermark = has_watermark;
    }

    public Object getNew_music() {
        return new_music;
    }

    public void setNew_music(Object new_music) {
        this.new_music = new_music;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getPlays_count() {
        return plays_count;
    }

    public void setPlays_count(int plays_count) {
        this.plays_count = plays_count;
    }

    public boolean isShow_plays_count() {
        return show_plays_count;
    }

    public void setShow_plays_count(boolean show_plays_count) {
        this.show_plays_count = show_plays_count;
    }

    public static class UserNameBean {
        private int id;
        private String screen_name;
        private int country;
        private int province;
        private int city;
        private String avatar;
        private String gender;
        private String birthday;
        private String age;
        private String constellation;
        private boolean verified;
        private int followers_count;
        private int friends_count;
        private int reposts_count;
        private int videos_count;
        private int real_videos_count;
        private int photos_count;
        private int locked_videos_count;
        private int real_locked_videos_count;
        private int locked_photos_count;
        private int be_liked_count;
        private boolean following;
        private boolean followed_by;
        private String url;
        private int created_at;
        private boolean has_password;
        private String status;
        private boolean is_funy_core_user;
        private int funy_core_user_created_at;
        private int last_publish_time;
        private int level;
        private boolean show_pendant;
        private boolean has_assoc_phone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getFriends_count() {
            return friends_count;
        }

        public void setFriends_count(int friends_count) {
            this.friends_count = friends_count;
        }

        public int getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(int reposts_count) {
            this.reposts_count = reposts_count;
        }

        public int getVideos_count() {
            return videos_count;
        }

        public void setVideos_count(int videos_count) {
            this.videos_count = videos_count;
        }

        public int getReal_videos_count() {
            return real_videos_count;
        }

        public void setReal_videos_count(int real_videos_count) {
            this.real_videos_count = real_videos_count;
        }

        public int getPhotos_count() {
            return photos_count;
        }

        public void setPhotos_count(int photos_count) {
            this.photos_count = photos_count;
        }

        public int getLocked_videos_count() {
            return locked_videos_count;
        }

        public void setLocked_videos_count(int locked_videos_count) {
            this.locked_videos_count = locked_videos_count;
        }

        public int getReal_locked_videos_count() {
            return real_locked_videos_count;
        }

        public void setReal_locked_videos_count(int real_locked_videos_count) {
            this.real_locked_videos_count = real_locked_videos_count;
        }

        public int getLocked_photos_count() {
            return locked_photos_count;
        }

        public void setLocked_photos_count(int locked_photos_count) {
            this.locked_photos_count = locked_photos_count;
        }

        public int getBe_liked_count() {
            return be_liked_count;
        }

        public void setBe_liked_count(int be_liked_count) {
            this.be_liked_count = be_liked_count;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public boolean isFollowed_by() {
            return followed_by;
        }

        public void setFollowed_by(boolean followed_by) {
            this.followed_by = followed_by;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public boolean isHas_password() {
            return has_password;
        }

        public void setHas_password(boolean has_password) {
            this.has_password = has_password;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isIs_funy_core_user() {
            return is_funy_core_user;
        }

        public void setIs_funy_core_user(boolean is_funy_core_user) {
            this.is_funy_core_user = is_funy_core_user;
        }

        public int getFuny_core_user_created_at() {
            return funy_core_user_created_at;
        }

        public void setFuny_core_user_created_at(int funy_core_user_created_at) {
            this.funy_core_user_created_at = funy_core_user_created_at;
        }

        public int getLast_publish_time() {
            return last_publish_time;
        }

        public void setLast_publish_time(int last_publish_time) {
            this.last_publish_time = last_publish_time;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public boolean isShow_pendant() {
            return show_pendant;
        }

        public void setShow_pendant(boolean show_pendant) {
            this.show_pendant = show_pendant;
        }

        public boolean isHas_assoc_phone() {
            return has_assoc_phone;
        }

        public void setHas_assoc_phone(boolean has_assoc_phone) {
            this.has_assoc_phone = has_assoc_phone;
        }
    }

    public static class PrivacyConfigNameBean {
        private int allow_save_medias;
        private int forbid_stranger_comment;

        public int getAllow_save_medias() {
            return allow_save_medias;
        }

        public void setAllow_save_medias(int allow_save_medias) {
            this.allow_save_medias = allow_save_medias;
        }

        public int getForbid_stranger_comment() {
            return forbid_stranger_comment;
        }

        public void setForbid_stranger_comment(int forbid_stranger_comment) {
            this.forbid_stranger_comment = forbid_stranger_comment;
        }
    }
}
