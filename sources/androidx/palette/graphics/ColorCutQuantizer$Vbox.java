package androidx.palette.graphics;

import androidx.palette.graphics.Palette;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ColorCutQuantizer$Vbox {
    private int mLowerIndex;
    private int mMaxBlue;
    private int mMaxGreen;
    private int mMaxRed;
    private int mMinBlue;
    private int mMinGreen;
    private int mMinRed;
    private int mPopulation;
    private int mUpperIndex;
    final /* synthetic */ ColorCutQuantizer this$0;

    ColorCutQuantizer$Vbox(ColorCutQuantizer colorCutQuantizer, int i, int i2) {
        this.this$0 = colorCutQuantizer;
        this.mLowerIndex = i;
        this.mUpperIndex = i2;
        fitBox();
    }

    final boolean canSplit() {
        return getColorCount() > 1;
    }

    final int findSplitPoint() {
        int longestColorDimension = getLongestColorDimension();
        ColorCutQuantizer colorCutQuantizer = this.this$0;
        int[] iArr = colorCutQuantizer.mColors;
        int[] iArr2 = colorCutQuantizer.mHistogram;
        ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
        Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
        ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
        int i = this.mPopulation / 2;
        int i2 = this.mLowerIndex;
        int i3 = 0;
        while (true) {
            int i4 = this.mUpperIndex;
            if (i2 > i4) {
                return this.mLowerIndex;
            }
            i3 += iArr2[iArr[i2]];
            if (i3 >= i) {
                return Math.min(i4 - 1, i2);
            }
            i2++;
        }
    }

    final void fitBox() {
        ColorCutQuantizer colorCutQuantizer = this.this$0;
        int[] iArr = colorCutQuantizer.mColors;
        int[] iArr2 = colorCutQuantizer.mHistogram;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = 0;
        for (int i8 = this.mLowerIndex; i8 <= this.mUpperIndex; i8++) {
            int i9 = iArr[i8];
            i7 += iArr2[i9];
            int quantizedRed = ColorCutQuantizer.quantizedRed(i9);
            int quantizedGreen = ColorCutQuantizer.quantizedGreen(i9);
            int quantizedBlue = ColorCutQuantizer.quantizedBlue(i9);
            if (quantizedRed > i4) {
                i4 = quantizedRed;
            }
            if (quantizedRed < i) {
                i = quantizedRed;
            }
            if (quantizedGreen > i5) {
                i5 = quantizedGreen;
            }
            if (quantizedGreen < i2) {
                i2 = quantizedGreen;
            }
            if (quantizedBlue > i6) {
                i6 = quantizedBlue;
            }
            if (quantizedBlue < i3) {
                i3 = quantizedBlue;
            }
        }
        this.mMinRed = i;
        this.mMaxRed = i4;
        this.mMinGreen = i2;
        this.mMaxGreen = i5;
        this.mMinBlue = i3;
        this.mMaxBlue = i6;
        this.mPopulation = i7;
    }

    final Palette.Swatch getAverageColor() {
        ColorCutQuantizer colorCutQuantizer = this.this$0;
        int[] iArr = colorCutQuantizer.mColors;
        int[] iArr2 = colorCutQuantizer.mHistogram;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = this.mLowerIndex; i5 <= this.mUpperIndex; i5++) {
            int i6 = iArr[i5];
            int i7 = iArr2[i6];
            i2 += i7;
            i += ColorCutQuantizer.quantizedRed(i6) * i7;
            i3 += ColorCutQuantizer.quantizedGreen(i6) * i7;
            i4 += i7 * ColorCutQuantizer.quantizedBlue(i6);
        }
        float f = i2;
        return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(i / f), Math.round(i3 / f), Math.round(i4 / f)), i2);
    }

    final int getColorCount() {
        return (this.mUpperIndex + 1) - this.mLowerIndex;
    }

    final int getLongestColorDimension() {
        int i = this.mMaxRed - this.mMinRed;
        int i2 = this.mMaxGreen - this.mMinGreen;
        int i3 = this.mMaxBlue - this.mMinBlue;
        if (i < i2 || i < i3) {
            return (i2 < i || i2 < i3) ? -1 : -2;
        }
        return -3;
    }

    final int getVolume() {
        return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
    }

    final ColorCutQuantizer$Vbox splitBox() {
        if (!canSplit()) {
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
        int findSplitPoint = findSplitPoint();
        ColorCutQuantizer$Vbox colorCutQuantizer$Vbox = new ColorCutQuantizer$Vbox(this.this$0, findSplitPoint + 1, this.mUpperIndex);
        this.mUpperIndex = findSplitPoint;
        fitBox();
        return colorCutQuantizer$Vbox;
    }
}
