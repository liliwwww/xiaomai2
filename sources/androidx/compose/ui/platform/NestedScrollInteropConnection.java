package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {

    @NotNull
    private final int[] consumedScrollCache;

    @NotNull
    private final NestedScrollingChildHelper nestedScrollChildHelper;

    @NotNull
    private final View view;

    public NestedScrollInteropConnection(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m1780onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl(j2)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl(j2)), true)) {
            j2 = Velocity.Companion.m2239getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.box-impl(j2);
    }

    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m1781onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(j2), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(i))) {
            return Offset.Companion.getZero-F1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m848getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m849getYimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m848getXimpl(j2)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m849getYimpl(j2)), (int[]) null, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(i), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.access$toOffset-Uv8p0NA(this.consumedScrollCache, j2);
    }

    @Nullable
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m1782onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl(j)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl(j)))) {
            j = Velocity.Companion.m2239getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.box-impl(j);
    }

    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m1783onPreScrollOzD1aCk(long j, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(j), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(i))) {
            return Offset.Companion.getZero-F1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m848getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m849getYimpl(j)), this.consumedScrollCache, (int[]) null, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(i));
        return NestedScrollInteropConnectionKt.access$toOffset-Uv8p0NA(this.consumedScrollCache, j);
    }
}
