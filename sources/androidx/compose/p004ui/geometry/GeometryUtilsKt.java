package androidx.compose.p004ui.geometry;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class GeometryUtilsKt {
    @NotNull
    public static final String toStringAsFixed(float f, int i) {
        int max = Math.max(i, 0);
        float pow = (float) Math.pow(10.0f, max);
        float f2 = f * pow;
        int i2 = (int) f2;
        if (f2 - i2 >= 0.5f) {
            i2++;
        }
        float f3 = i2 / pow;
        return max > 0 ? String.valueOf(f3) : String.valueOf((int) f3);
    }
}
