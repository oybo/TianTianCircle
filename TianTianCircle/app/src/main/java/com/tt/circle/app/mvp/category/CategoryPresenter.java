package com.tt.circle.app.mvp.category;

import com.lzy.okgo.OkGo;
import com.tt.circle.app.callback.JsonBeanCallback;
import com.tt.circle.app.config.UrlConfig;
import com.tt.circle.app.entity.CategoryEntity;

import java.util.List;

/**
 * Created by O on 2017/7/4.
 */

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View view) {
        mView = view;
    }

    @Override
    public void getCategory() {

        OkGo.<List<CategoryEntity>>get(UrlConfig.URL_CATEGORYS)
                .tag(this)
                .execute(new JsonBeanCallback<List<CategoryEntity>>() {
                    @Override
                    public void success(List<CategoryEntity> categorys) {

                        if (categorys != null && categorys.size() > 0) {
                            for (CategoryEntity category : categorys) {
                                mView.addCategoryInfo(category);
                            }
                        }

                        mView.bindCategoryData();
                    }

                    @Override
                    public void error(String message) {

                        mView.showError(message);
                    }
                });

    }


}
