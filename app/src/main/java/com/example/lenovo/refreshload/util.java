package com.example.lenovo.refreshload;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by zhengzhihua on 2018/10/31.10:17
 * Update 2018/10/31 10:17
 * Describe
 */

public class util {
//    /**传递进来的源图片*/
//    private Bitmap source;
//    /**图片的配文*/
//    private String text;
//    /**图片加上配文后生成的新图片*/
//    private Bitmap newBitmap;
    /**配文的颜色*/
//    private static int textColor = Color.BLACK;
    /**配文的字体大小*/
    private static float textSize = 500;
    /**图片的宽度*/
    private static int bitmapWidth;
    /**图片的高度*/
    private static int bitmapHeight;
    /**画图片的画笔*/
    private static Paint bitmapPaint=new Paint();
    /**画文字的画笔*/
    private static Paint textPaint=new Paint();



    public static Bitmap creatnew(Bitmap source,String text){
        /**配文与图片间的距离*/
       float padding =100;
        /**配文行与行之间的距离*/
        float linePadding = 5;
        int textColor = Color.BLACK;
        bitmapWidth = source.getWidth();
        bitmapHeight = source.getHeight();

//一行可以显示文字的个数
        int lineTextCount = (int) ((source.getWidth()-50)/textSize);
//一共要把文字分为几行
        int line = (int) Math.ceil(Double.valueOf(text.length())/Double.valueOf(lineTextCount));

//新创建一个新图片比源图片多出一部分，后续用来与文字叠加用
       Bitmap newBitmap = Bitmap.createBitmap(bitmapWidth,
                (int) (bitmapHeight+padding+textSize*line+linePadding*line), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(newBitmap);
//把图片画上来
        canvas.drawBitmap(source,0,0,bitmapPaint);

//在图片下边画一个白色矩形块用来放文字，防止文字是透明背景，在有些情况下保存到本地后看不出来
        textPaint.setColor(Color.WHITE);
        canvas.drawRect(0,source.getHeight(),source.getWidth(),
                source.getHeight()+padding+textSize*line+linePadding*line,textPaint);
//        source.getHeight()+padding+textSize*line+linePadding*line
//把文字画上来
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        Rect bounds = new Rect();

//开启循环直到画完所有行的文字
        for (int i=0; i<line; i++) { String s;
            if (i == line-1) {//如果是最后一行，则结束位置就是文字的长度，别下标越界哦
                s = text.substring(i*lineTextCount, text.length());
            } else {//不是最后一行
                s = text.substring(i*lineTextCount, (i+1)*lineTextCount);
            } //获取文字的字宽高以便把文字与图片中心对齐
            textPaint.getTextBounds(s,0,s.length(),bounds);
            //画文字的时候高度需要注意文字大小以及文字行间距
            canvas.drawText(s,source.getWidth()/2-bounds.width()/2,
                    source.getHeight()+padding+i*textSize+i*linePadding+bounds.height()/2,textPaint);
        } canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
       return newBitmap;
    }
}
