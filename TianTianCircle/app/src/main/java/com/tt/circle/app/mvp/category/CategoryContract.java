package com.tt.circle.app.mvp.category;

import com.tt.circle.app.entity.CategoryEntity;
import com.tt.circle.app.mvp.BasePresenter;
import com.tt.circle.app.mvp.BaseView;
import com.tt.circle.app.mvp.media.MediaContract;

/**
 * Created by O on 2017/7/4.
 */

public interface CategoryContract {

    interface View extends BaseView<MediaContract.Presenter> {

        void showError(String message);

        void addCategoryInfo(CategoryEntity entity);

        void bindCategoryData();
    }

    interface Presenter extends BasePresenter {
        void getCategory();
    }
    
}
