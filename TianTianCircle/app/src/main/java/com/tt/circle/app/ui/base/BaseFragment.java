package com.tt.circle.app.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tt.circle.app.R;
import com.tt.circle.app.widget.LoadingView;
import butterknife.ButterKnife;

/**
 * Created by O on 2017/7/3.
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext = null;
    protected View rootView;

    private LoadingView mLoadingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getLayoutResource() != 0) {
            rootView = inflater.inflate(getLayoutResource(), null);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        ButterKnife.bind(this, rootView);

        mLoadingView = (LoadingView) rootView.findViewById(R.id.fragment_loading_stateView);
        mLoadingView.setOnRetryClickListener(new LoadingView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                retryLoad();
            }
        });

        init(savedInstanceState);
        return rootView;
    }

    protected LoadingView getLoadingView() {
        return mLoadingView;
    }

    protected abstract void retryLoad();

    protected void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    protected abstract int getLayoutResource();

    protected abstract void init(Bundle savedInstanceState);

}
