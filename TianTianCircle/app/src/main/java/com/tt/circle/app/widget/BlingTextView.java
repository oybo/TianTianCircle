package com.tt.circle.app.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Xuan on 2016/3/3.
 */
public class BlingTextView extends TextView {

    /**渲染器，用于显示本例中的颜色效果*/
    private LinearGradient mLinearGradient;
    /**矩阵，用于确定渲染范围*/
    private Matrix mGradientMatrix;
    /**渲染的起始位置*/
    private int mViewWidth = 0;
    /**渲染的终止距离*/
    private int mTranslate = 0;
    /**是否启动动画*/
    private boolean mAnimating = true;
    /**多少毫秒刷新一次*/
    private int speed = 50;
    private Paint mPaint;
    public BlingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = getPaint();
        mGradientMatrix = new Matrix();
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewWidth = getMeasuredWidth();
        //可以尝试一下，使用不同的模式可以得到不同的效果
        mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[] { Color.BLACK, Color.WHITE, Color.BLACK }, null, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAnimating && mGradientMatrix != null) {
            mTranslate += mViewWidth / 10;//每次移动屏幕的1/10宽
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);//在指定矩阵上渲染
            postInvalidateDelayed(speed);
        }
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i("bqt", w + "--" + h);
    }
}
