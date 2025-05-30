package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect;
import androidx.compose.ui.graphics.StampedPathEffectStyle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidPathEffect_androidKt {
    @NotNull
    public static final PathEffect actualChainPathEffect(@NotNull PathEffect pathEffect, @NotNull PathEffect pathEffect2) {
        Intrinsics.checkNotNullParameter(pathEffect, "outer");
        Intrinsics.checkNotNullParameter(pathEffect2, "inner");
        return new AndroidPathEffect(new ComposePathEffect(((AndroidPathEffect) pathEffect).getNativePathEffect(), ((AndroidPathEffect) pathEffect2).getNativePathEffect()));
    }

    @NotNull
    public static final PathEffect actualCornerPathEffect(float f) {
        return new AndroidPathEffect(new CornerPathEffect(f));
    }

    @NotNull
    public static final PathEffect actualDashPathEffect(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "intervals");
        return new AndroidPathEffect(new DashPathEffect(fArr, f));
    }

    @NotNull
    /* renamed from: actualStampedPathEffect-7aD1DOk, reason: not valid java name */
    public static final PathEffect m963actualStampedPathEffect7aD1DOk(@NotNull Path path, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(path, "shape");
        if (path instanceof AndroidPath) {
            return new AndroidPathEffect(new PathDashPathEffect(((AndroidPath) path).getInternalPath(), f, f2, m964toAndroidPathDashPathEffectStyleoQv6xUo(i)));
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @NotNull
    public static final android.graphics.PathEffect asAndroidPathEffect(@NotNull PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "<this>");
        return ((AndroidPathEffect) pathEffect).getNativePathEffect();
    }

    @NotNull
    /* renamed from: toAndroidPathDashPathEffectStyle-oQv6xUo, reason: not valid java name */
    public static final PathDashPathEffect.Style m964toAndroidPathDashPathEffectStyleoQv6xUo(int i) {
        StampedPathEffectStyle.Companion companion = StampedPathEffectStyle.Companion;
        return StampedPathEffectStyle.m1237equalsimpl0(i, companion.m1241getMorphYpspkwk()) ? PathDashPathEffect.Style.MORPH : StampedPathEffectStyle.m1237equalsimpl0(i, companion.m1242getRotateYpspkwk()) ? PathDashPathEffect.Style.ROTATE : StampedPathEffectStyle.m1237equalsimpl0(i, companion.m1243getTranslateYpspkwk()) ? PathDashPathEffect.Style.TRANSLATE : PathDashPathEffect.Style.TRANSLATE;
    }

    @NotNull
    public static final PathEffect toComposePathEffect(@NotNull android.graphics.PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "<this>");
        return new AndroidPathEffect(pathEffect);
    }
}
