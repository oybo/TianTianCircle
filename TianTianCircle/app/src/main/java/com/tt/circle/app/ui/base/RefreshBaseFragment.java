package com.tt.circle.app.ui.base;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by sunger on 15/12/1.
 */
public class RefreshBaseFragment extends BaseFragment {

    private BaseActivity holder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            holder = (BaseActivity) context;
        }
    }

    public BaseActivity getHolder() {
        if (holder == null) {
            throw new IllegalArgumentException("the acticity must be extends BaseCompatActivity");
        }
        return holder;
    }

    @Override
    protected void retryLoad() {

    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }
}
