package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ColorCutQuantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new 1();
    final int[] mColors;
    final Palette$Filter[] mFilters;
    final int[] mHistogram;
    final List<Palette$Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];

    @Nullable
    final TimingLogger mTimingLogger = null;

    ColorCutQuantizer(int[] iArr, int i, Palette$Filter[] palette$FilterArr) {
        this.mFilters = palette$FilterArr;
        int[] iArr2 = new int[AccessibilityNodeInfoCompat.ACTION_PASTE];
        this.mHistogram = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i2]);
            iArr[i2] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 32768; i4++) {
            if (iArr2[i4] > 0 && shouldIgnoreColor(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i3++;
            }
        }
        int[] iArr3 = new int[i3];
        this.mColors = iArr3;
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        if (i3 > i) {
            this.mQuantizedColors = quantizePixels(i);
            return;
        }
        this.mQuantizedColors = new ArrayList();
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = iArr3[i7];
            this.mQuantizedColors.add(new Palette$Swatch(approximateToRgb888(i8), iArr2[i8]));
        }
    }

    static int approximateToRgb888(int i, int i2, int i3) {
        return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8));
    }

    private List<Palette$Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Vbox> it = collection.iterator();
        while (it.hasNext()) {
            Palette$Swatch averageColor = it.next().getAverageColor();
            if (!shouldIgnoreColor(averageColor)) {
                arrayList.add(averageColor);
            }
        }
        return arrayList;
    }

    static void modifySignificantOctet(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = quantizedBlue(i4) | (quantizedGreen(i4) << 10) | (quantizedRed(i4) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = quantizedRed(i5) | (quantizedBlue(i5) << 10) | (quantizedGreen(i5) << 5);
            i2++;
        }
    }

    private static int modifyWordWidth(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    private static int quantizeFromRgb888(int i) {
        return modifyWordWidth(Color.blue(i), 8, 5) | (modifyWordWidth(Color.red(i), 8, 5) << 10) | (modifyWordWidth(Color.green(i), 8, 5) << 5);
    }

    private List<Palette$Swatch> quantizePixels(int i) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(this, 0, this.mColors.length - 1));
        splitBoxes(priorityQueue, i);
        return generateAverageColors(priorityQueue);
    }

    static int quantizedBlue(int i) {
        return i & 31;
    }

    static int quantizedGreen(int i) {
        return (i >> 5) & 31;
    }

    static int quantizedRed(int i) {
        return (i >> 10) & 31;
    }

    private boolean shouldIgnoreColor(int i) {
        int approximateToRgb888 = approximateToRgb888(i);
        ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
        return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox poll;
        while (priorityQueue.size() < i && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
            priorityQueue.offer(poll.splitBox());
            priorityQueue.offer(poll);
        }
    }

    List<Palette$Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private boolean shouldIgnoreColor(Palette$Swatch palette$Swatch) {
        return shouldIgnoreColor(palette$Swatch.getRgb(), palette$Swatch.getHsl());
    }

    private static int approximateToRgb888(int i) {
        return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
    }

    private boolean shouldIgnoreColor(int i, float[] fArr) {
        Palette$Filter[] palette$FilterArr = this.mFilters;
        if (palette$FilterArr != null && palette$FilterArr.length > 0) {
            int length = palette$FilterArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.mFilters[i2].isAllowed(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
