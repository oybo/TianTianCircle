package com.tt.circle.app.mvp.media;

import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.entity.MediaDetailEntity;
import com.tt.circle.app.entity.MediaEntity;
import com.tt.circle.app.mvp.BasePresenter;
import com.tt.circle.app.mvp.BaseView;

import java.util.List;

/**
 * Created by O on 2017/7/4.
 */

public interface MediaContract {

    interface View extends BaseView<Presenter> {

        void showError(String message);

        void refreshView(List<MediaEntity> entities);

        void loadMoreView(List<MediaEntity> entities);
    }

    interface MediaDetailView extends BaseView<Presenter> {

        void showError(String message);

        void showMediaData(MediaDetailEntity mediaEntity);

        void refreshComment(List<CommentEntity> entities);

        void showMoreComments(List<CommentEntity> entities);
    }

    interface Presenter extends BasePresenter {

        void refresh(int id);

        void loadMedias(int id, int page);

        void loadMediaDetail(int id);

        void refreshComment(int id);

        void loadMediasComment(int id, int page);

    }

}
