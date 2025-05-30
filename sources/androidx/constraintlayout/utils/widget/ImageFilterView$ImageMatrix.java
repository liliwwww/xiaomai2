package androidx.constraintlayout.utils.widget;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ImageFilterView$ImageMatrix {
    float[] m = new float[20];
    ColorMatrix mColorMatrix = new ColorMatrix();
    ColorMatrix mTmpColorMatrix = new ColorMatrix();
    float mBrightness = 1.0f;
    float mSaturation = 1.0f;
    float mContrast = 1.0f;
    float mWarmth = 1.0f;

    ImageFilterView$ImageMatrix() {
    }

    private void brightness(float f) {
        float[] fArr = this.m;
        fArr[0] = f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    private void saturation(float f) {
        float f2 = 1.0f - f;
        float f3 = 0.2999f * f2;
        float f4 = 0.587f * f2;
        float f5 = f2 * 0.114f;
        float[] fArr = this.m;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    private void warmth(float f) {
        float log;
        float f2;
        if (f <= 0.0f) {
            f = 0.01f;
        }
        float f3 = (5000.0f / f) / 100.0f;
        if (f3 > 66.0f) {
            double d = f3 - 60.0f;
            f2 = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
            log = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
        } else {
            log = (((float) Math.log(f3)) * 99.4708f) - 161.11957f;
            f2 = 255.0f;
        }
        float log2 = f3 < 66.0f ? f3 > 19.0f ? (((float) Math.log(f3 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
        float min = Math.min(255.0f, Math.max(f2, 0.0f));
        float min2 = Math.min(255.0f, Math.max(log, 0.0f));
        float min3 = Math.min(255.0f, Math.max(log2, 0.0f));
        float log3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
        float log4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
        float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
        float min5 = Math.min(255.0f, Math.max(log3, 0.0f));
        float min6 = min3 / Math.min(255.0f, Math.max(log4, 0.0f));
        float[] fArr = this.m;
        fArr[0] = min / min4;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = min2 / min5;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = min6;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    void updateMatrix(ImageView imageView) {
        boolean z;
        this.mColorMatrix.reset();
        float f = this.mSaturation;
        boolean z2 = true;
        if (f != 1.0f) {
            saturation(f);
            this.mColorMatrix.set(this.m);
            z = true;
        } else {
            z = false;
        }
        float f2 = this.mContrast;
        if (f2 != 1.0f) {
            this.mTmpColorMatrix.setScale(f2, f2, f2, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            z = true;
        }
        float f3 = this.mWarmth;
        if (f3 != 1.0f) {
            warmth(f3);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            z = true;
        }
        float f4 = this.mBrightness;
        if (f4 != 1.0f) {
            brightness(f4);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        } else {
            z2 = z;
        }
        if (z2) {
            imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
        } else {
            imageView.clearColorFilter();
        }
    }
}
