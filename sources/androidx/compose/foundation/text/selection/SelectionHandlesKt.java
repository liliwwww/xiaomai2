package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyKey;
import androidx.compose.p004ui.unit.C0856Dp;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SelectionHandlesKt {
    private static final float HandleHeight;
    private static final float HandleWidth;

    @NotNull
    private static final SemanticsPropertyKey<SelectionHandleInfo> SelectionHandleInfoKey = new SemanticsPropertyKey<>("SelectionHandleInfo", null, 2, null);

    static {
        float f = 25;
        HandleWidth = C0856Dp.m5216constructorimpl(f);
        HandleHeight = C0856Dp.m5216constructorimpl(f);
    }

    /* renamed from: getAdjustedCoordinates-k-4lQ0M, reason: not valid java name */
    public static final long m1843getAdjustedCoordinatesk4lQ0M(long j) {
        return OffsetKt.Offset(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j) - 1.0f);
    }

    public static final float getHandleHeight() {
        return HandleHeight;
    }

    public static final float getHandleWidth() {
        return HandleWidth;
    }

    @NotNull
    public static final SemanticsPropertyKey<SelectionHandleInfo> getSelectionHandleInfoKey() {
        return SelectionHandleInfoKey;
    }
}
