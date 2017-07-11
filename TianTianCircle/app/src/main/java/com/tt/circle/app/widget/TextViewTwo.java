package com.tt.circle.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 项目名称：TextViewSelf
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/2/23 11:27
 * 修改人：Administrator
 * 修改时间：2016/2/23 11:27
 * 修改备注：
 *
 * @param
 */
public class TextViewTwo extends TextView {

    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate;

    public TextViewTwo(Context context) {
        super(context,null);
    }

    public TextViewTwo(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public TextViewTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if(mViewWidth > 0){
                mPaint = getPaint();
                // 创建LinearGradient并设置渐变颜色数组
                // 第一个,第二个参数表示渐变起点 可以设置起点终点在对角等任意位置
                // 第三个,第四个参数表示渐变终点
                // 第五个参数表示渐变颜色
                // 第六个参数可以为空,表示坐标,值为0-1 new float[] {0.25f, 0.5f, 0.75f, 1 }
                // 如果这是空的，颜色均匀分布，沿梯度线。
                // 第七个表示平铺方式
                // CLAMP重复最后一个颜色至最后
                // MIRROR重复着色的图像水平或垂直方向已镜像方式填充会有翻转效果
                // REPEAT重复着色的图像水平或垂直方向
                mLinearGradient = new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,Color.YELLOW,Color.BLUE},null, Shader.TileMode.REPEAT);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix!= null){
            //控制线性渲染色彩的移动速度
            mTranslate += mViewWidth/30;
            if(mTranslate > 2*mViewWidth){
                mTranslate = -mViewWidth;
            }

            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            //设置延时刷新时间
            postInvalidateDelayed(150);
        }
    }
}