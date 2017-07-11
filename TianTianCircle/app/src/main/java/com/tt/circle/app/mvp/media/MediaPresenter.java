package com.tt.circle.app.mvp.media;

import android.os.Handler;

import com.tt.circle.app.callback.JsonBeanCallback;
import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.entity.MediaDetailEntity;
import com.tt.circle.app.entity.MediaEntity;

import java.util.List;

/**
 * Created by O on 2017/7/4.
 */

public class MediaPresenter implements MediaContract.Presenter {

    //请求一次默认最短时间
    private static final int DEF_DELAY = (int) (1 * 1000);

    private final static int PAGR_SIZE = 20;
    private final static int FRIST_PAGE = 1;

    private MediaContract.MediaDetailView mMediaDetailView;
    private MediaContract.View mView;
    private MediaModel mModel;

    public MediaPresenter(MediaContract.View view) {
        mView = view;
        mModel = new MediaModel();
    }

    public MediaPresenter(MediaContract.MediaDetailView view) {
        mMediaDetailView = view;
        mModel = new MediaModel();
    }

    /**
     * 加载频道视频列表
     * @param id
     * @param page
     */
    private void loadData(int id, final int page) {
        //这里设一个变量标记时间，避免UI刷新过快
        final long current_time = System.currentTimeMillis();

        mView.showLoading();
        mModel.getMedias(id, page, PAGR_SIZE, new JsonBeanCallback<List<MediaEntity>>() {

            @Override
            public void success(List<MediaEntity> list) {

                int delay = 0;
                if (System.currentTimeMillis() - current_time < DEF_DELAY) {
                    //延时一秒
                    delay = DEF_DELAY;
                }
                updateView(list, delay, page);
            }

            @Override
            public void error(String message) {
                mView.showError(message);
            }
        });
    }

    private void updateView(final List<MediaEntity> entities, int delay, final int page) {
        //定时器延时刷新接界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (page == FRIST_PAGE) {
                    mView.refreshView(entities);
                } else {
                    mView.loadMoreView(entities);
                }
                mView.hideLoading();
            }
        }, delay);
    }

    /**
     * 加载视频评论
     * @param id
     * @param page
     */
    private void loadCommentData(int id, final int page) {
        final long current_time = System.currentTimeMillis();
        mModel.getComments(id, page, new JsonBeanCallback<List<CommentEntity>>() {
            @Override
            public void success(List<CommentEntity> list) {
                int delay = 0;
                if (System.currentTimeMillis() - current_time < DEF_DELAY) {
                    //延时一秒
                    delay = DEF_DELAY;
                }
                updateCommentView(list, delay, FRIST_PAGE);
            }

            @Override
            public void error(String message) {
            }
        });
    }

    private void updateCommentView(final List<CommentEntity> commentEntityList, int delay, final int page) {
        //定时器延时刷新接界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (page == 1) {
                    mMediaDetailView.refreshComment(commentEntityList);
                } else {
                    mMediaDetailView.showMoreComments(commentEntityList);
                }
            }
        }, delay);
    }

    @Override
    public void refresh(int id) {
        loadData(id, FRIST_PAGE);
    }

    @Override
    public void loadMedias(int id, int page) {
        loadData(id, page);
    }

    @Override
    public void loadMediaDetail(int id) {
        // 获取视频详情
        mModel.getMediaDetail(id, new JsonBeanCallback<MediaDetailEntity>() {
            @Override
            public void success(MediaDetailEntity entity) {
                mMediaDetailView.showMediaData(entity);
            }

            @Override
            public void error(String message) {
                mMediaDetailView.showError(message);
            }
        });
    }

    @Override
    public void refreshComment(int id) {
        loadCommentData(id, FRIST_PAGE);
    }

    @Override
    public void loadMediasComment(int id, int page) {
        loadCommentData(id, page);
    }

}
