package comt.king.mypaints;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PaintView extends View {
    public static int Brush_size = 10;
    public static final int Default_color = Color.RED;
    public static final int Default_BG_color = Color.WHITE;
    private static final float TOUCH_TOLERANCE = 4;
    private float mX;
    private float mY;
    private Path mPath;
    private Paint mPaint;
    private ArrayList<fingerPath> paths = new ArrayList<>();
    private int currentcolor;
    private int backgroundcolor = Default_BG_color;
    private int strokeWidth;
    private boolean emboss;
    private boolean blur;
    private MaskFilter mEmboss;
    private MaskFilter mBlur;
    private Bitmap mbitmap;
    private Canvas mCanvas;
    private Paint mbitmapPaints = new Paint(Paint.DITHER_FLAG);

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Default_color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setXfermode(null);
        mPaint.setAlpha(0xff);

        mEmboss = new EmbossMaskFilter(new float[]{1, 1, 1}, 0.4f, 6, 3.5f);
        mBlur = new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL);

    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int Width = metrics.heightPixels;

        mbitmap = Bitmap.createBitmap(Width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mbitmap);

        currentcolor = Default_BG_color;
        strokeWidth = Brush_size;

    }

    public void normal() {
        emboss = false;
        blur = false;
    }

    public void blur() {
        emboss = true;
        blur = true;
    }

    public void clear() {
        backgroundcolor = Default_BG_color;
        paths.clear();
        normal();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas Canvas) {
        Canvas.save();
        mCanvas.drawColor(backgroundcolor);

        for (fingerPath fp : paths) {
            mPaint.setColor(fp.color);
            mPaint.setStrokeWidth(fp.strokeWidtgh);
            mPaint.setMaskFilter(null);

            if (fp.emboss)
                mPaint.setMaskFilter(mEmboss);
            else if (fp.blur)
                mPaint.setMaskFilter(mBlur);

            mCanvas.drawBitmap(fp.path,mPaint);
        }
        Canvas.drawBitmap(mbitmap, 0, 0, mbitmapPaints);
        Canvas.restore();

    }

    private void touchSTarts(float x, float y) {
        mPath = new Path();
        fingerPath fp = new fingerPath(currentcolor, emboss, blur, strokeWidth, mPath);
        paths.add(fp);

        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }
    private void touch(float x, float y){
        float dx = Math.abs(x-mX);
        float dy = Math.abs(y-mY);

        if (dx >+ TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE){
            mPath . quadTo(mX, mY (X + mX) / 2,(Y +mY)/2);
            mX = X;
            mY = y;
        }

    }
    private void touch(){
        mPath.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                touchSTarts(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch();
                invalidate();
                break;
        }

        return true;
    }

    public void emboss() {
    }
}

