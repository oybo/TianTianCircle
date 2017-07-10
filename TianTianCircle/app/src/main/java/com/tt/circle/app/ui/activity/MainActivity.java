package com.tt.circle.app.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.tt.circle.app.R;
import com.tt.circle.app.adapter.FragmentAdapter;
import com.tt.circle.app.entity.CategoryEntity;
import com.tt.circle.app.mvp.category.CategoryContract;
import com.tt.circle.app.mvp.category.CategoryPresenter;
import com.tt.circle.app.ui.base.BaseActivity;
import butterknife.Bind;

public class MainActivity extends BaseActivity implements CategoryContract.View {

    @Bind(R.id.tool_bar) Toolbar mToolbar;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @Bind(R.id.tab_layout) TabLayout mTabLayout;
    @Bind(R.id.view_pager) ViewPager mViewPager;
    private FragmentAdapter mAdapter;

    private CategoryContract.Presenter mPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusTransparent();

        initView();
        initData();
    }

    private void initData() {
        mPresenter = new CategoryPresenter(this);

        mPresenter.getCategory();
    }

    private void initView() {
        initToolBar(mToolbar, false, R.string.app_name);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mAdapter = new FragmentAdapter(getSupportFragmentManager());
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addCategoryInfo(CategoryEntity entity) {
        mAdapter.addItem(entity);
        mTabLayout.addTab(mTabLayout.newTab());
    }

    @Override
    public void bindCategoryData() {
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }


}
