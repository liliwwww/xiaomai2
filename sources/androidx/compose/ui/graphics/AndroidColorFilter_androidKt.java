package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidColorFilter_androidKt {
    @NotNull
    /* renamed from: actualColorMatrixColorFilter-jHG-Opc, reason: not valid java name */
    public static final ColorFilter m1033actualColorMatrixColorFilterjHGOpc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "colorMatrix");
        return new ColorFilter(new ColorMatrixColorFilter(fArr));
    }

    @NotNull
    /* renamed from: actualLightingColorFilter--OWjLjI, reason: not valid java name */
    public static final ColorFilter m1034actualLightingColorFilterOWjLjI(long j, long j2) {
        return new ColorFilter(new LightingColorFilter(ColorKt.toArgb-8_81llA(j), ColorKt.toArgb-8_81llA(j2)));
    }

    @NotNull
    /* renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final ColorFilter m1035actualTintColorFilterxETnrds(long j, int i) {
        return new ColorFilter(Build.VERSION.SDK_INT >= 29 ? BlendModeColorFilterHelper.INSTANCE.m1043BlendModeColorFilterxETnrds(j, i) : new PorterDuffColorFilter(ColorKt.toArgb-8_81llA(j), AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(i)));
    }

    @NotNull
    public static final ColorFilter asAndroidColorFilter(@NotNull ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(colorFilter, "<this>");
        return colorFilter.getNativeColorFilter$ui_graphics_release();
    }

    @NotNull
    public static final ColorFilter asComposeColorFilter(@NotNull ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(colorFilter, "<this>");
        return new ColorFilter(colorFilter);
    }
}
