package androidx.compose.p004ui.geometry;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RectKt {
    @Stable
    @NotNull
    /* renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m2594Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m2595Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m2556getXimpl(j) - f, Offset.m2557getYimpl(j) - f, Offset.m2556getXimpl(j) + f, Offset.m2557getYimpl(j) + f);
    }

    @Stable
    @NotNull
    /* renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m2596Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2), Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2));
    }

    @Stable
    @NotNull
    public static final Rect lerp(@NotNull Rect rect, @NotNull Rect rect2, float f) {
        Intrinsics.checkNotNullParameter(rect, "start");
        Intrinsics.checkNotNullParameter(rect2, AliRequestAdapter.PHASE_STOP);
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
