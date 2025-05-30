package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class GradientColorInflaterCompat$ColorStops {
    final int[] mColors;
    final float[] mOffsets;

    GradientColorInflaterCompat$ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
        int size = list.size();
        this.mColors = new int[size];
        this.mOffsets = new float[size];
        for (int i = 0; i < size; i++) {
            this.mColors[i] = list.get(i).intValue();
            this.mOffsets[i] = list2.get(i).floatValue();
        }
    }

    GradientColorInflaterCompat$ColorStops(@ColorInt int i, @ColorInt int i2) {
        this.mColors = new int[]{i, i2};
        this.mOffsets = new float[]{0.0f, 1.0f};
    }

    GradientColorInflaterCompat$ColorStops(@ColorInt int i, @ColorInt int i2, @ColorInt int i3) {
        this.mColors = new int[]{i, i2, i3};
        this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
    }
}
