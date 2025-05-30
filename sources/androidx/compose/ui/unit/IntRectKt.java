package androidx.compose.ui.unit;

import android.taobao.windvane.extra.uc.AliRequestAdapter;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IntRectKt {
    @Stable
    @NotNull
    /* renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m2674IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j), IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m2675IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j), IntOffset.m2643getXimpl(j) + IntSize.m2685getWidthimpl(j2), IntOffset.m2644getYimpl(j) + IntSize.m2684getHeightimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m2676IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m2643getXimpl(j) - i, IntOffset.m2644getYimpl(j) - i, IntOffset.m2643getXimpl(j) + i, IntOffset.m2644getYimpl(j) + i);
    }

    @Stable
    @NotNull
    public static final IntRect lerp(@NotNull IntRect intRect, @NotNull IntRect intRect2, float f) {
        Intrinsics.checkNotNullParameter(intRect, "start");
        Intrinsics.checkNotNullParameter(intRect2, AliRequestAdapter.PHASE_STOP);
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }
}
