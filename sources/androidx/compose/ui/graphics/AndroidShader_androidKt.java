package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidShader_androidKt {
    @NotNull
    /* renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m965ActualImageShaderF49vj9s(@NotNull ImageBitmap imageBitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), AndroidTileMode_androidKt.m970toAndroidTileMode0vamqd0(i), AndroidTileMode_androidKt.m970toAndroidTileMode0vamqd0(i2));
    }

    @NotNull
    /* renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m966ActualLinearGradientShaderVjE6UOU(long j, long j2, @NotNull List<Color> list, @Nullable List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new android.graphics.LinearGradient(Offset.m848getXimpl(j), Offset.m849getYimpl(j), Offset.m848getXimpl(j2), Offset.m849getYimpl(j2), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m970toAndroidTileMode0vamqd0(i));
    }

    @NotNull
    /* renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m967ActualRadialGradientShader8uybcMk(long j, float f, @NotNull List<Color> list, @Nullable List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new android.graphics.RadialGradient(Offset.m848getXimpl(j), Offset.m849getYimpl(j), f, makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m970toAndroidTileMode0vamqd0(i));
    }

    @NotNull
    /* renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m968ActualSweepGradientShader9KIMszo(long j, @NotNull List<Color> list, @Nullable List<Float> list2) {
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new SweepGradient(Offset.m848getXimpl(j), Offset.m849getYimpl(j), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors));
    }

    @VisibleForTesting
    public static final int countTransparentColors(@NotNull List<Color> list) {
        Intrinsics.checkNotNullParameter(list, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i = 0;
        for (int i2 = 1; i2 < lastIndex; i2++) {
            if (Color.m1052getAlphaimpl(list.get(i2).m1060unboximpl()) == 0.0f) {
                i++;
            }
        }
        return i;
    }

    @VisibleForTesting
    @NotNull
    public static final int[] makeTransparentColors(@NotNull List<Color> list, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(list, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ColorKt.m1074toArgb8_81llA(list.get(i3).m1060unboximpl());
            }
            return iArr;
        }
        int[] iArr2 = new int[list.size() + i];
        int lastIndex = CollectionsKt.getLastIndex(list);
        int size2 = list.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size2; i5++) {
            long m1060unboximpl = list.get(i5).m1060unboximpl();
            if (Color.m1052getAlphaimpl(m1060unboximpl) == 0.0f) {
                if (i5 == 0) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m1074toArgb8_81llA(Color.m1049copywmQWz5c$default(list.get(1).m1060unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else if (i5 == lastIndex) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m1074toArgb8_81llA(Color.m1049copywmQWz5c$default(list.get(i5 - 1).m1060unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else {
                    int i6 = i4 + 1;
                    iArr2[i4] = ColorKt.m1074toArgb8_81llA(Color.m1049copywmQWz5c$default(list.get(i5 - 1).m1060unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                    i4 = i6 + 1;
                    iArr2[i6] = ColorKt.m1074toArgb8_81llA(Color.m1049copywmQWz5c$default(list.get(i5 + 1).m1060unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
                i4 = i2;
            } else {
                iArr2[i4] = ColorKt.m1074toArgb8_81llA(m1060unboximpl);
                i4++;
            }
        }
        return iArr2;
    }

    @VisibleForTesting
    @Nullable
    public static final float[] makeTransparentStops(@Nullable List<Float> list, @NotNull List<Color> list2, int i) {
        Intrinsics.checkNotNullParameter(list2, "colors");
        if (i == 0) {
            if (list != null) {
                return CollectionsKt.toFloatArray(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i];
        fArr[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int lastIndex = CollectionsKt.getLastIndex(list2);
        int i2 = 1;
        for (int i3 = 1; i3 < lastIndex; i3++) {
            long m1060unboximpl = list2.get(i3).m1060unboximpl();
            float floatValue = list != null ? list.get(i3).floatValue() : i3 / CollectionsKt.getLastIndex(list2);
            int i4 = i2 + 1;
            fArr[i2] = floatValue;
            if (Color.m1052getAlphaimpl(m1060unboximpl) == 0.0f) {
                i2 = i4 + 1;
                fArr[i4] = floatValue;
            } else {
                i2 = i4;
            }
        }
        fArr[i2] = list != null ? list.get(CollectionsKt.getLastIndex(list2)).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
