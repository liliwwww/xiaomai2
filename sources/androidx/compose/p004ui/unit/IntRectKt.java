package androidx.compose.p004ui.unit;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class IntRectKt {
    @Stable
    @NotNull
    /* renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m5365IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j), IntOffset.m5334getXimpl(j2), IntOffset.m5335getYimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m5366IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j), IntOffset.m5334getXimpl(j) + IntSize.m5376getWidthimpl(j2), IntOffset.m5335getYimpl(j) + IntSize.m5375getHeightimpl(j2));
    }

    @Stable
    @NotNull
    /* renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m5367IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m5334getXimpl(j) - i, IntOffset.m5335getYimpl(j) - i, IntOffset.m5334getXimpl(j) + i, IntOffset.m5335getYimpl(j) + i);
    }

    @Stable
    @NotNull
    public static final IntRect lerp(@NotNull IntRect intRect, @NotNull IntRect intRect2, float f) {
        Intrinsics.checkNotNullParameter(intRect, "start");
        Intrinsics.checkNotNullParameter(intRect2, AliRequestAdapter.PHASE_STOP);
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }
}
