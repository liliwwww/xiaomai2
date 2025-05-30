package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    public static final int composeToViewOffset(float f) {
        return ((int) ceilAwayFromZero(f)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final int m4555getScrollAxesk4lQ0M(long j) {
        int i = Math.abs(Offset.m2556getXimpl(j)) >= 0.5f ? 1 : 0;
        return Math.abs(Offset.m2557getYimpl(j)) >= 0.5f ? i | 2 : i;
    }

    @Composable
    @NotNull
    public static final NestedScrollConnection rememberNestedScrollInteropConnection(@Nullable View view, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1260107652);
        if ((i2 & 1) != 0) {
            view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1260107652, i, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.kt:231)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(view);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new NestedScrollInteropConnection(view);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return nestedScrollInteropConnection;
    }

    private static final float reverseAxis(int i) {
        return i * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    public static final long m4556toOffsetUv8p0NA(int[] iArr, long j) {
        return OffsetKt.Offset(Offset.m2556getXimpl(j) >= 0.0f ? RangesKt.coerceAtMost(reverseAxis(iArr[0]), Offset.m2556getXimpl(j)) : RangesKt.coerceAtLeast(reverseAxis(iArr[0]), Offset.m2556getXimpl(j)), Offset.m2557getYimpl(j) >= 0.0f ? RangesKt.coerceAtMost(reverseAxis(iArr[1]), Offset.m2557getYimpl(j)) : RangesKt.coerceAtLeast(reverseAxis(iArr[1]), Offset.m2557getYimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m4557toViewTypeGyEprt8(int i) {
        return !NestedScrollSource.m3988equalsimpl0(i, NestedScrollSource.Companion.m3993getDragWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toViewVelocity(float f) {
        return f * (-1.0f);
    }
}
