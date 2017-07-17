package com.tt.circle.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tt.circle.app.R;
import com.tt.circle.app.adapter.CommentsAdapter;
import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.entity.MediaDetailEntity;
import com.tt.circle.app.entity.MediaEntity;
import com.tt.circle.app.listener.NoDoubleClickListener;
import com.tt.circle.app.manager.ImageLoadManager;
import com.tt.circle.app.mvp.media.MediaContract;
import com.tt.circle.app.mvp.media.MediaPresenter;
import com.tt.circle.app.ui.base.BaseActivity;
import com.tt.circle.app.utils.SizeUtils;
import com.tt.circle.app.utils.TimeUtils;
import com.tt.circle.app.widget.BlingTextView;
import com.tt.circle.app.widget.CircleImageView;
import com.tt.circle.app.widget.TextImageView;
import com.tt.circle.app.widget.floatingactionbutton.FloatingActionsMenu;
import com.tt.circle.app.widget.refresh.BaseLoadMoreRecyclerAdapter;
import com.tt.circle.app.widget.refresh.OnRecycleViewScrollListener;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

import butterknife.Bind;

/**
 * ================================================
 * author: O
 * created on: 2017/7/10 14:03
 * description:
 * ================================================
 */
public class MediaDetailActivity extends BaseActivity implements MediaContract.MediaDetailView {

    public final static String MEDIAS_ENTITY_KEY = "media_entity";

    @Bind(R.id.media_detail_logo_view) BlingTextView mBlingTextView;
    @Bind(R.id.media_detail_nice_video_player) NiceVideoPlayer mNiceVideoPlayer;
    @Bind(R.id.media_detail_recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.media_detail_float_bt) FloatingActionsMenu mFloatingMenu;
    @Bind(R.id.media_detail_head_image) CircleImageView mHeadImage;
    @Bind(R.id.media_detail_name_txt) TextView mNameTxt;
    @Bind(R.id.media_detail_date_txt) TextView mDateTxt;
    @Bind(R.id.media_detail_looknum_txt) TextImageView mLooknumTxt;

    private int mVideoId;
    private int current_comment_page = 1;
    private MediaContract.Presenter mPresenter;
    private CommentsAdapter mAdapter;

    public static Intent createIntent(Context context, MediaEntity mediaEntity) {
        Intent intent = new Intent(context, MediaDetailActivity.class);
        intent.putExtra(MEDIAS_ENTITY_KEY, mediaEntity);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_media_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        setStatusTransparent();
        initView();
        initData();
    }

    private void initData() {
        MediaEntity mediaEntity = (MediaEntity) getIntent().getSerializableExtra(MEDIAS_ENTITY_KEY);
        mVideoId = mediaEntity.getId();
        setMediaDetailData(mediaEntity);

        mAdapter = new CommentsAdapter(this);
        mAdapter.setHasMoreData(true);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new MediaPresenter(this);
        // 获取详情
        mPresenter.loadMediaDetail(mVideoId);
        // 获取评论
        mPresenter.refreshComment(mVideoId);

        mAdapter.setOnInViewClickListener(R.id.item_media_detail_comment_link_layout, new BaseLoadMoreRecyclerAdapter.onInternalClickListener() {
            @Override
            public void OnClickListener(View parentV, View v, Integer position) {
                showToast("点赞");
            }
        });
    }

    private void setMediaDetailData(MediaEntity mediaEntity) {
        // 头像
        ImageLoadManager.setImage(mediaEntity.getAvatar(), mHeadImage);
        // 姓名
        mNameTxt.setText(mediaEntity.getScreen_name());
        // 创建时间
        long createTime = Long.parseLong(mediaEntity.getCreated_at()) * 1000;
        mDateTxt.setText(TimeUtils.getFriendlyTimeSpanByNow(createTime));
        // 浏览次数
        mLooknumTxt.setTextImageStart(SizeUtils.dp2px(5), R.drawable.ic_visibility_white_24dp, String.valueOf(mediaEntity.getPlays_count()));
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 监听加载更多
        mRecyclerView.addOnScrollListener(new OnRecycleViewScrollListener() {
            @Override
            public void onLoadMore() {
                try {
                    mAdapter.setHasFooter(true);
                    mPresenter.loadMediasComment(mVideoId, current_comment_page);
                    mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                if(mFloatingMenu.issh)
            }
        });

//        mFloatingMenu.setic

        mHeadImage.setOnClickListener(listener);
    }

    private NoDoubleClickListener listener = new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.media_detail_head_image:
                    finish();
                    break;
            }
        }
    };

    @Override
    public void refreshComment(List<CommentEntity> entities) {
        current_comment_page = 2;
        mAdapter.clear();
        mAdapter.appendToList(entities);
        mAdapter.notifyDataSetChanged();

        if(mBlingTextView != null) {
            mBlingTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMoreComments(List<CommentEntity> entities) {
        if(entities != null && entities.size() > 0) {
            current_comment_page++;
            mAdapter.appendToList(entities);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMediaData(MediaDetailEntity mediaEntity) {
        initVideo(mediaEntity);
    }

    private void initVideo(MediaDetailEntity mediaEntity) {
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        mNiceVideoPlayer.setUp(mediaEntity.getVideo(), null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle(mediaEntity.getCaption());
        controller.setLenght(mediaEntity.getTime() * 1000);
        ImageLoadManager.setImage(mediaEntity.getCover_pic(), controller.imageView());
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mFloatingMenu, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

/**
 id	int	视频 id
 user_id	int	用户id
 url	string	视频链接
 cover_pic	string	视频封面
 screen_name	string	视频作者昵称
 caption	string	视频描述
 avatar	string	视频作者头像
 plays_count	int	播放数
 comments_count	int	评论数
 likes_count	int	点赞数
 created_at	int	视频创建时间（时间戳）
 */