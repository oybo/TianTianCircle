package com.tt.circle.app.adapter;

/**
 *  Created by O on 2017/7/3.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tt.circle.app.entity.CategoryEntity;
import com.tt.circle.app.ui.fragment.MediaFragment;
import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private List<CategoryEntity> mCategoryLists = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    public void addItem(CategoryEntity entity) {
        mCategoryLists.add(entity);
        mFragments.add(MediaFragment.newInstance(entity.getId()));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategoryLists.get(position).getName().replace("#", "");
    }

    /**
     * Override this method to save Fragment state
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }


}