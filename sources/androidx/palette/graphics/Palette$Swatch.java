package androidx.palette.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Palette$Swatch {
    private final int mBlue;
    private int mBodyTextColor;
    private boolean mGeneratedTextColors;
    private final int mGreen;

    @Nullable
    private float[] mHsl;
    private final int mPopulation;
    private final int mRed;
    private final int mRgb;
    private int mTitleTextColor;

    public Palette$Swatch(@ColorInt int i, int i2) {
        this.mRed = Color.red(i);
        this.mGreen = Color.green(i);
        this.mBlue = Color.blue(i);
        this.mRgb = i;
        this.mPopulation = i2;
    }

    private void ensureTextColorsGenerated() {
        if (this.mGeneratedTextColors) {
            return;
        }
        int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 4.5f);
        int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
        if (calculateMinimumAlpha != -1 && calculateMinimumAlpha2 != -1) {
            this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
            this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
            this.mGeneratedTextColors = true;
            return;
        }
        int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 4.5f);
        int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 3.0f);
        if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
            this.mBodyTextColor = calculateMinimumAlpha != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
            this.mTitleTextColor = calculateMinimumAlpha2 != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
            this.mGeneratedTextColors = true;
        } else {
            this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
            this.mTitleTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
            this.mGeneratedTextColors = true;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Palette$Swatch.class != obj.getClass()) {
            return false;
        }
        Palette$Swatch palette$Swatch = (Palette$Swatch) obj;
        return this.mPopulation == palette$Swatch.mPopulation && this.mRgb == palette$Swatch.mRgb;
    }

    @ColorInt
    public int getBodyTextColor() {
        ensureTextColorsGenerated();
        return this.mBodyTextColor;
    }

    @NonNull
    public float[] getHsl() {
        if (this.mHsl == null) {
            this.mHsl = new float[3];
        }
        ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
        return this.mHsl;
    }

    public int getPopulation() {
        return this.mPopulation;
    }

    @ColorInt
    public int getRgb() {
        return this.mRgb;
    }

    @ColorInt
    public int getTitleTextColor() {
        ensureTextColorsGenerated();
        return this.mTitleTextColor;
    }

    public int hashCode() {
        return (this.mRgb * 31) + this.mPopulation;
    }

    public String toString() {
        return Palette$Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
    }

    Palette$Swatch(int i, int i2, int i3, int i4) {
        this.mRed = i;
        this.mGreen = i2;
        this.mBlue = i3;
        this.mRgb = Color.rgb(i, i2, i3);
        this.mPopulation = i4;
    }

    Palette$Swatch(float[] fArr, int i) {
        this(ColorUtils.HSLToColor(fArr), i);
        this.mHsl = fArr;
    }
}
