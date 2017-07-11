package com.tt.circle.app.adapter;

import android.content.Context;

import com.tt.circle.app.R;
import com.tt.circle.app.entity.CommentEntity;
import com.tt.circle.app.utils.TimeUtils;
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

//        ImageLoadManager.setImage(item.get);

        holder.setText(R.id.item_media_detail_comment_name_txt, item.getCreated_at());

        // 创建时间
        long createTime = Long.parseLong(item.getCreated_at()) * 1000;
        holder.setText(R.id.item_media_detail_comment_date_txt, TimeUtils.getFriendlyTimeSpanByNow(createTime));

        holder.setText(R.id.item_media_detail_comment_content_txt, item.getContent());
    }


}
