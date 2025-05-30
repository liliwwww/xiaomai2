package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RectKt {
    @Stable
    @NotNull
    /* renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m872Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m848getXimpl(j), Offset.m849getYimpl(j), Offset.m848getXimpl(j2), Offset.m849getYimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m873Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m848getXimpl(j) - f, Offset.m849getYimpl(j) - f, Offset.m848getXimpl(j) + f, Offset.m849getYimpl(j) + f);
    }

    @Stable
    @NotNull
    /* renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m874Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m848getXimpl(j), Offset.m849getYimpl(j), Offset.m848getXimpl(j) + Size.m903getWidthimpl(j2), Offset.m849getYimpl(j) + Size.m900getHeightimpl(j2));
    }

    @Stable
    @NotNull
    public static final Rect lerp(@NotNull Rect rect, @NotNull Rect rect2, float f) {
        Intrinsics.checkNotNullParameter(rect, "start");
        Intrinsics.checkNotNullParameter(rect2, "stop");
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
