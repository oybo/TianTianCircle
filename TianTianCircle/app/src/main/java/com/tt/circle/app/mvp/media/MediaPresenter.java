package com.tt.circle.app.mvp.media;

import android.os.Handler;
import com.tt.circle.app.callback.JsonBeanCallback;
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

    private MediaContract.View mView;
    private MediaModel mModel;

    public MediaPresenter(MediaContract.View view) {
        mView = view;
        mModel = new MediaModel();
    }

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
                mView.showError();
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

    @Override
    public void refresh(int id) {
        loadData(id, FRIST_PAGE);
    }

    @Override
    public void loadMedias(int id, int page) {
        loadData(id, page);
    }

}
