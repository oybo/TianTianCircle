package com.tt.circle.app.manager;

import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageLoadManager {

    public static void setImage(String url, final ImageView imageView) {
        try {
            Glide.with(imageView.getContext().getApplicationContext())
                    .load(url)
                    .dontAnimate()
                    .fitCenter()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImage(String url, final ImageView imageView, int errorId) {
        try {
            Glide.with(imageView.getContext().getApplicationContext())
                    .load(url)
                    .dontAnimate()
                    .error(errorId)
                    .fitCenter()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImage(String url, final ImageView imageView, int loadId, int errorId) {
        try {
            Glide.with(imageView.getContext().getApplicationContext())
                    .load(url)
                    .dontAnimate()
                    .placeholder(loadId)
                    .error(errorId)
                    .fitCenter()
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
