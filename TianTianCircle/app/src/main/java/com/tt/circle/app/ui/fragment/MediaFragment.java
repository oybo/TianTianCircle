package com.tt.circle.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.tt.circle.app.adapter.MediaAdapter;
import com.tt.circle.app.entity.MediaEntity;
import com.tt.circle.app.mvp.media.MediaContract;
import com.tt.circle.app.mvp.media.MediaPresenter;
import com.tt.circle.app.ui.activity.MediaDetailActivity;
import com.tt.circle.app.ui.base.RefreshAndLoadFragment;
import com.tt.circle.app.widget.refresh.BaseLoadMoreRecyclerAdapter;

import java.util.List;

/**
 * Created by O on 2017/7/4.
 */

public class MediaFragment extends RefreshAndLoadFragment implements MediaContract.View {

    private RecyclerView mRecyclerView;

    private MediaContract.Presenter mPresenter;
    private MediaAdapter mAdapter;

    private int mVideoId;
    private boolean loadState;

    public static MediaFragment newInstance(int id) {
        MediaFragment mediaFragment = new MediaFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        mediaFragment.setArguments(bundle);

        return mediaFragment;
    }

    @Override
    protected void retryLoad() {
        onRefreshData();
    }

    @Override
    protected void onFragmentCreate() {
        super.onFragmentCreate();
        getLoadingView().showLoading();

        mVideoId = getArguments().getInt("id", 1);    // 默认1=热门
        mPresenter = new MediaPresenter(this);

        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = getRecyclerView();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }

    private void initData() {
        mAdapter = new MediaAdapter(getActivity());
        setAdapter(mAdapter);
        mAdapter.setHasMoreData(true);
        mRecyclerView.setAdapter(mAdapter);

        onRefreshData();

        mAdapter.setOnItemClickListener(new BaseLoadMoreRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int pos) {
                // 跳转到详情页
                Intent intent = new Intent(getActivity(), MediaDetailActivity.class);
                intent.putExtra("mediaEntity", mAdapter.getItem(pos));
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError() {
        currentState = 0;
        if (getSwipeRefreshWidget().isRefreshing()) {
            getSwipeRefreshWidget().setRefreshing(false);
        } else {
            mAdapter.setHasFooter(false);
        }

        if (!loadState) {
            getLoadingView().showLoadError();
        }
    }

    @Override
    public void refreshView(List<MediaEntity> entities) {
        showRefreshData(entities);

        loadState = true;
        getLoadingView().hideLoading();
    }

    @Override
    public void loadMoreView(List<MediaEntity> entities) {
        showMoreData(entities);
    }

    @Override
    protected void onFragmentLoadMore() {
        mPresenter.loadMedias(mVideoId, getCurrentPage());
    }

    @Override
    public void onRefreshData() {
        mPresenter.refresh(mVideoId);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

}
