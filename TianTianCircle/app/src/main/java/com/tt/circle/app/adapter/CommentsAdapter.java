package com.tt.circle.app.adapter;

import android.content.Context;

import com.tt.circle.app.R;
import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.manager.ImageLoadManager;
import com.tt.circle.app.utils.TimeUtils;
import com.tt.circle.app.widget.comment.CommentTextView;
import com.tt.circle.app.widget.refresh.BaseLoadMoreRecyclerAdapter;
import com.tt.circle.app.widget.refresh.RecyclerViewHolder;

/**
 * Created by sunger on 15/11/8.
 */
public class CommentsAdapter extends BaseLoadMoreRecyclerAdapter<CommentEntity, RecyclerViewHolder> {

    public CommentsAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_video_comment_layout;
    }

    @Override
    public void bindData(RecyclerViewHolder holder, int position, CommentEntity item) {

        ImageLoadManager.setImage(item.getUser().getAvatar(), holder.getImageView(R.id.item_media_detail_comment_head_image));

        holder.setText(R.id.item_media_detail_comment_name_txt, item.getUser().getScreen_name());

        // 创建时间
        long createTime = Long.parseLong(item.getCreated_at()) * 1000;
        holder.setText(R.id.item_media_detail_comment_date_txt, TimeUtils.getFriendlyTimeSpanByNow(createTime));

        CommentTextView commentTextView = (CommentTextView) holder.getView(R.id.item_media_detail_comment_content_txt);
        commentTextView.setData(item.getContent(), new
                CommentTextView.OnSpanonClickListener() {
                    @Override
                    public void onClick(String spanStr) {

                    }
                });

        // 赞
        if(item.getLiked_count() > 0) {
            holder.setText(R.id.item_media_detail_comment_liked_count_txt, String.valueOf(item.getLiked_count()));
        }

    }


}
