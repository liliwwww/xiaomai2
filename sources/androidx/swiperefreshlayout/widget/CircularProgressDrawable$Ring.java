package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class CircularProgressDrawable$Ring {
    int mAlpha;
    Path mArrow;
    int mArrowHeight;
    final Paint mArrowPaint;
    float mArrowScale;
    int mArrowWidth;
    final Paint mCirclePaint;
    int mColorIndex;
    int[] mColors;
    int mCurrentColor;
    float mEndTrim;
    final Paint mPaint;
    float mRingCenterRadius;
    float mRotation;
    boolean mShowArrow;
    float mStartTrim;
    float mStartingEndTrim;
    float mStartingRotation;
    float mStartingStartTrim;
    float mStrokeWidth;
    final RectF mTempBounds = new RectF();

    CircularProgressDrawable$Ring() {
        Paint paint = new Paint();
        this.mPaint = paint;
        Paint paint2 = new Paint();
        this.mArrowPaint = paint2;
        Paint paint3 = new Paint();
        this.mCirclePaint = paint3;
        this.mStartTrim = 0.0f;
        this.mEndTrim = 0.0f;
        this.mRotation = 0.0f;
        this.mStrokeWidth = 5.0f;
        this.mArrowScale = 1.0f;
        this.mAlpha = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    void draw(Canvas canvas, Rect rect) {
        RectF rectF = this.mTempBounds;
        float f = this.mRingCenterRadius;
        float f2 = (this.mStrokeWidth / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect)) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        }
        rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
        float f3 = this.mStartTrim;
        float f4 = this.mRotation;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((this.mEndTrim + f4) * 360.0f) - f5;
        this.mPaint.setColor(this.mCurrentColor);
        this.mPaint.setAlpha(this.mAlpha);
        float f7 = this.mStrokeWidth / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, this.mPaint);
        drawTriangle(canvas, f5, f6, rectF);
    }

    void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
        if (this.mShowArrow) {
            Path path = this.mArrow;
            if (path == null) {
                Path path2 = new Path();
                this.mArrow = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f3 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path path3 = this.mArrow;
            float f4 = this.mArrowWidth;
            float f5 = this.mArrowScale;
            path3.lineTo((f4 * f5) / 2.0f, this.mArrowHeight * f5);
            this.mArrow.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.mStrokeWidth / 2.0f));
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            canvas.save();
            canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
            canvas.drawPath(this.mArrow, this.mArrowPaint);
            canvas.restore();
        }
    }

    int getAlpha() {
        return this.mAlpha;
    }

    float getArrowHeight() {
        return this.mArrowHeight;
    }

    float getArrowScale() {
        return this.mArrowScale;
    }

    float getArrowWidth() {
        return this.mArrowWidth;
    }

    int getBackgroundColor() {
        return this.mCirclePaint.getColor();
    }

    float getCenterRadius() {
        return this.mRingCenterRadius;
    }

    int[] getColors() {
        return this.mColors;
    }

    float getEndTrim() {
        return this.mEndTrim;
    }

    int getNextColor() {
        return this.mColors[getNextColorIndex()];
    }

    int getNextColorIndex() {
        return (this.mColorIndex + 1) % this.mColors.length;
    }

    float getRotation() {
        return this.mRotation;
    }

    boolean getShowArrow() {
        return this.mShowArrow;
    }

    float getStartTrim() {
        return this.mStartTrim;
    }

    int getStartingColor() {
        return this.mColors[this.mColorIndex];
    }

    float getStartingEndTrim() {
        return this.mStartingEndTrim;
    }

    float getStartingRotation() {
        return this.mStartingRotation;
    }

    float getStartingStartTrim() {
        return this.mStartingStartTrim;
    }

    Paint.Cap getStrokeCap() {
        return this.mPaint.getStrokeCap();
    }

    float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    void goToNextColor() {
        setColorIndex(getNextColorIndex());
    }

    void resetOriginals() {
        this.mStartingStartTrim = 0.0f;
        this.mStartingEndTrim = 0.0f;
        this.mStartingRotation = 0.0f;
        setStartTrim(0.0f);
        setEndTrim(0.0f);
        setRotation(0.0f);
    }

    void setAlpha(int i) {
        this.mAlpha = i;
    }

    void setArrowDimensions(float f, float f2) {
        this.mArrowWidth = (int) f;
        this.mArrowHeight = (int) f2;
    }

    void setArrowScale(float f) {
        if (f != this.mArrowScale) {
            this.mArrowScale = f;
        }
    }

    void setBackgroundColor(int i) {
        this.mCirclePaint.setColor(i);
    }

    void setCenterRadius(float f) {
        this.mRingCenterRadius = f;
    }

    void setColor(int i) {
        this.mCurrentColor = i;
    }

    void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setColorIndex(int i) {
        this.mColorIndex = i;
        this.mCurrentColor = this.mColors[i];
    }

    void setColors(@NonNull int[] iArr) {
        this.mColors = iArr;
        setColorIndex(0);
    }

    void setEndTrim(float f) {
        this.mEndTrim = f;
    }

    void setRotation(float f) {
        this.mRotation = f;
    }

    void setShowArrow(boolean z) {
        if (this.mShowArrow != z) {
            this.mShowArrow = z;
        }
    }

    void setStartTrim(float f) {
        this.mStartTrim = f;
    }

    void setStrokeCap(Paint.Cap cap) {
        this.mPaint.setStrokeCap(cap);
    }

    void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mPaint.setStrokeWidth(f);
    }

    void storeOriginals() {
        this.mStartingStartTrim = this.mStartTrim;
        this.mStartingEndTrim = this.mEndTrim;
        this.mStartingRotation = this.mRotation;
    }
}
