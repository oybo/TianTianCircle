package com.tt.circle.app.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tt.circle.app.R;
import com.tt.circle.app.widget.LoadingView;

import java.util.List;

/**
 * Created by sunger on 2015/12/3.
 */
public abstract class RefreshAndLoadFragment<T> extends LoadMoreRecyclerFragemnt implements SwipeRefreshLayout.OnRefreshListener {

    protected final static int STATE_REFRESH = 2;
    private SwipeRefreshLayout mSwipeRefreshWidget;

    private LoadingView mLoadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmet_video_refresh_loadmore_layout, container, false);
    }

    protected LoadingView getLoadingView() {
        if(mLoadingView == null) {
            mLoadingView = (LoadingView) getView().findViewById(R.id.fragment_loading_stateView);
            mLoadingView.setOnRetryClickListener(new LoadingView.OnRetryClickListener() {
                @Override
                public void onRetryClick() {
                    retryLoad();
                }
            });
        }

        return mLoadingView;
    }

    protected abstract void retryLoad();

    @Override
    protected void onFragmentCreate() {
        mSwipeRefreshWidget = (SwipeRefreshLayout) getView().findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshWidget.setOnRefreshListener(this);
    }

    public void showRefreshData(final List<T> dataList) {
        int delay = 0;
        if (System.currentTimeMillis() - currentTime < DEF_DELAY) {
            delay = DEF_DELAY;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentState = STATE_NORMAL;
                mSwipeRefreshWidget.setRefreshing(false);
                currentPage = 2;
                mAdapter.getList().clear();
                mAdapter.appendToList(dataList);
                mAdapter.notifyDataSetChanged();
            }
        }, delay);
    }


    public abstract void onRefreshData();

    @Override
    public void onRefresh() {
        if (currentState == STATE_NORMAL) {
            currentState = STATE_REFRESH;
            currentTime = System.currentTimeMillis();
            mAdapter.setHasFooter(true);
            onRefreshData();
        } else {
            getHolder().showMsgInBottom(R.string.msg_waitting_loding);
        }
    }

    public SwipeRefreshLayout getSwipeRefreshWidget() {
        return mSwipeRefreshWidget;
    }


}
