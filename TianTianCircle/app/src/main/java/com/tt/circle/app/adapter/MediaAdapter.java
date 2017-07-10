package com.tt.circle.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.tt.circle.app.R;
import com.tt.circle.app.entity.MediaEntity;
import com.tt.circle.app.manager.ImageLoadManager;
import com.tt.circle.app.utils.SizeUtils;
import com.tt.circle.app.widget.TextImageView;
import com.tt.circle.app.widget.refresh.BaseLoadMoreRecyclerAdapter;
import com.tt.circle.app.widget.refresh.RecyclerViewHolder;

/**
 * Created by O on 2017/7/3.
 */

public class MediaAdapter extends BaseLoadMoreRecyclerAdapter<MediaEntity, RecyclerViewHolder> {

    public MediaAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_home_media_layout;
    }

    /**
     * support  for StaggeredGridLayoutManager to load
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            StaggeredGridLayoutManager.LayoutParams clp = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            if (clp != null)
                clp.setFullSpan(true);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public void bindData(RecyclerViewHolder holder, int position, MediaEntity item) {

        ImageView imageView = holder.getImageView(R.id.item_imageview_cover_pic);
        imageView.setAdjustViewBounds(true);

        String pic = item.getCover_pic().split("!")[0];
        ImageLoadManager.setImage(pic, imageView);

        ImageLoadManager.setImage(item.getAvatar(), holder.getImageView(R.id.item_imageview_author_pic));

        holder.setText(R.id.item_textvuew_info, item.getCaption());

        TextImageView likeTxtView = (TextImageView) holder.getView(R.id.textView_likes_count);
        likeTxtView.setTextImageStart(SizeUtils.dp2px(5), R.drawable.ic_thumb_up_gray_18dp, String.valueOf(item.getLikes_count()));

    }


}
