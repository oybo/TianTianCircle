package com.tt.circle.app.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.tt.circle.app.R;
import com.tt.circle.app.entity.MediaEntity;
import com.tt.circle.app.manager.ImageLoadManager;
import com.tt.circle.app.ui.base.BaseActivity;
import com.tt.circle.app.widget.CircleImageView;

import butterknife.Bind;

/**
 * ================================================
 * author: O
 * created on: 2017/7/10 14:03
 * description:
 * ================================================
 */
public class MediaDetailActivity extends BaseActivity {

    @Bind(R.id.toolbar_title) TextView toolbarTitle;
    @Bind(R.id.media_detail_head_image) CircleImageView mHeadImage;
    @Bind(R.id.media_detail_name_txt) TextView mNameTxt;
    @Bind(R.id.media_detail_date_txt) TextView mDateTxt;
    @Bind(R.id.media_detail_looknum_txt) TextView mLooknumTxt;

    private MediaEntity mMediaEntity;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_media_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        mMediaEntity = (MediaEntity) getIntent().getSerializableExtra("mediaEntity");

        initView();
        initData();
    }

    private void initData() {
        ImageLoadManager.setImage(mMediaEntity.getAvatar(), mHeadImage);

        mNameTxt.setText(mMediaEntity.getScreen_name());

        mNameTxt.setText(mMediaEntity.getCreated_at());

        mNameTxt.setText(String.valueOf(mMediaEntity.getPlays_count()));
    }

    private void initView() {


    }

}
