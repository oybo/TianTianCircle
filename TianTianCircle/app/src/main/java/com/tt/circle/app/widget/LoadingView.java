package com.tt.circle.app.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.tt.circle.app.R;


/**
 * Created by zzz40500 on 15/4/6.
 */
public class LoadingView extends LinearLayout {

    private static final int ANIMATION_DURATION = 500;

    private static final float FACTOR = 1.2f;

    private static float mDistance = 200;

    private ShapeLoadingView mShapeLoadingView;

    private ImageView mIndicationIm;

    private TextView mLoadTextView;
    private int mTextAppearance;

    private String mLoadText;
    private AnimatorSet mUpAnimatorSet;
    private AnimatorSet mDownAnimatorSet;

    private boolean mStopped = false;

    private int mDelay;

    public LoadingView(Context context) {
        super(context);
        init(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        setOrientation(VERTICAL);
        mDistance = dip2px(context, 54f);
        LayoutInflater.from(context).inflate(R.layout.view_load_layout, this, true);
        mShapeLoadingView = (ShapeLoadingView) findViewById(R.id.shapeLoadingView);
        mIndicationIm = (ImageView) findViewById(R.id.indication);
        mLoadTextView = (TextView) findViewById(R.id.promptTV);
        ViewHelper.setScaleX(mIndicationIm, 0.2f);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView);
        String loadText = typedArray.getString(R.styleable.LoadingView_loadingText);
        int textAppearance = typedArray.getResourceId(R.styleable.LoadingView_loadingText, -1);
        mDelay = typedArray.getInteger(R.styleable.LoadingView_delay, 80);
        typedArray.recycle();

        if (textAppearance != -1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mLoadTextView.setTextAppearance(textAppearance);
            } else {
                mLoadTextView.setTextAppearance(getContext(), textAppearance);
            }
        }
        setLoadingText(loadText);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnRetryClickListener != null) {
                    if(getResources().getString(R.string.text_retry).equals(mLoadTextView.getText())) {
                        // 点击重新加载
                        mOnRetryClickListener.onRetryClick();
                    }
                }
            }
        });
    }

    /**
     * 开始加载
     */
    public void showLoading() {
        mShapeLoadingView.setVisibility(View.VISIBLE);
        mIndicationIm.setVisibility(View.VISIBLE);
        setVisibility(View.VISIBLE);

        startLoading(mDelay);
    }

    /**
     * 完成加载
     */
    public void hideLoading() {
        setVisibility(View.GONE);
    }

    /**
     * 加载错误
     */
    public void showLoadError() {
        mShapeLoadingView.setVisibility(View.INVISIBLE);
        mIndicationIm.setVisibility(View.INVISIBLE);

        mLoadTextView.setText(getResources().getString(R.string.text_retry));
    }

    private int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private Runnable mFreeFallRunnable = new Runnable() {
        @Override
        public void run() {
            ViewHelper.setRotation(mShapeLoadingView, 180f);
            ViewHelper.setTranslationY(mShapeLoadingView, 0f);
            ViewHelper.setScaleX(mIndicationIm, 0.2f);
            mStopped = false;
            freeFall();
        }
    };

    private void startLoading(long delay) {
        mLoadTextView.setText(getResources().getString(R.string.text_load_in));

        if (mDownAnimatorSet != null && mDownAnimatorSet.isRunning()) {
            return;
        }
        this.removeCallbacks(mFreeFallRunnable);
        if (delay > 0) {
            this.postDelayed(mFreeFallRunnable, delay);
        } else {
            this.post(mFreeFallRunnable);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoading();
    }

    private void stopLoading() {
        mStopped = true;
        if (mUpAnimatorSet != null) {
            if (mUpAnimatorSet.isRunning()) {
                mUpAnimatorSet.cancel();
            }
            mUpAnimatorSet.removeAllListeners();
            for (Animator animator : mUpAnimatorSet.getChildAnimations()) {
                animator.removeAllListeners();
            }
            mUpAnimatorSet = null;
        }
        if (mDownAnimatorSet != null) {
            if (mDownAnimatorSet.isRunning()) {
                mDownAnimatorSet.cancel();
            }
            mDownAnimatorSet.removeAllListeners();
            for (Animator animator : mDownAnimatorSet.getChildAnimations()) {
                animator.removeAllListeners();
            }
            mDownAnimatorSet = null;
        }
        this.removeCallbacks(mFreeFallRunnable);
    }

    @Override
    public void setVisibility(int visibility) {
        this.setVisibility(visibility, mDelay);
    }

    public void setVisibility(int visibility, int delay) {
        super.setVisibility(visibility);
        if (visibility == View.VISIBLE) {
            startLoading(delay);
        } else {
            stopLoading();
        }
    }

    public void setDelay(int delay) {
        mDelay = delay;
    }

    public int getDelay() {
        return mDelay;
    }

    public void setLoadingText(CharSequence loadingText) {
        if (TextUtils.isEmpty(loadingText)) {
            mLoadTextView.setVisibility(GONE);
        } else {
            mLoadTextView.setVisibility(VISIBLE);
        }

        mLoadTextView.setText(loadingText);
    }

    public CharSequence getLoadingText(){
        return mLoadTextView.getText();
    }

    /**
     * 上抛
     */
    public void upThrow() {

        if (mUpAnimatorSet == null) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mShapeLoadingView, "translationY", mDistance, 0);
            ObjectAnimator scaleIndication = ObjectAnimator.ofFloat(mIndicationIm, "scaleX", 1f, 0.2f);

            ObjectAnimator objectAnimator1 = null;
            switch (mShapeLoadingView.getShape()) {
                case SHAPE_RECT:

                    objectAnimator1 = ObjectAnimator.ofFloat(mShapeLoadingView, "rotation", 0, 180);

                    break;
                case SHAPE_CIRCLE:
                    objectAnimator1 = ObjectAnimator.ofFloat(mShapeLoadingView, "rotation", 0, 180);

                    break;
                case SHAPE_TRIANGLE:

                    objectAnimator1 = ObjectAnimator.ofFloat(mShapeLoadingView, "rotation", 0, 180);

                    break;
            }

            mUpAnimatorSet = new AnimatorSet();
            mUpAnimatorSet.playTogether(objectAnimator, objectAnimator1, scaleIndication);

            mUpAnimatorSet.setDuration(ANIMATION_DURATION);
            mUpAnimatorSet.setInterpolator(new DecelerateInterpolator(FACTOR));

            mUpAnimatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (!mStopped) {
                        freeFall();
                    }

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        mUpAnimatorSet.start();


    }

    /**
     * 下落
     */
    public void freeFall() {

        if (mDownAnimatorSet == null) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mShapeLoadingView, "translationY", 0, mDistance);
            ObjectAnimator scaleIndication = ObjectAnimator.ofFloat(mIndicationIm, "scaleX", 0.2f, 1f);

            mDownAnimatorSet = new AnimatorSet();
            mDownAnimatorSet.playTogether(objectAnimator, scaleIndication);
            mDownAnimatorSet.setDuration(ANIMATION_DURATION);
            mDownAnimatorSet.setInterpolator(new AccelerateInterpolator(FACTOR));
            mDownAnimatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (!mStopped) {
                        mShapeLoadingView.changeShape();
                        upThrow();
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        mDownAnimatorSet.start();

    }

    private OnRetryClickListener mOnRetryClickListener;

    public void setOnRetryClickListener(OnRetryClickListener listener) {
        mOnRetryClickListener = listener;
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

}
