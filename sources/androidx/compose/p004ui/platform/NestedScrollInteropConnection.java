package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo1290onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5441getXimpl(j2));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5442getYimpl(j2));
        if (!nestedScrollingChildHelper.dispatchNestedFling(viewVelocity, viewVelocity2, true)) {
            j2 = Velocity.Companion.m5452getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5432boximpl(j2);
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo1291onPostScrollDzOQY0M(long j, long j2, int i) {
        int m4555getScrollAxesk4lQ0M;
        int m4557toViewTypeGyEprt8;
        int m4557toViewTypeGyEprt82;
        long m4556toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m4555getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m4555getScrollAxesk4lQ0M(j2);
        m4557toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m4557toViewTypeGyEprt8(i);
        if (!nestedScrollingChildHelper.startNestedScroll(m4555getScrollAxesk4lQ0M, m4557toViewTypeGyEprt8)) {
            return Offset.Companion.m2572getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2556getXimpl(j));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2557getYimpl(j));
        int composeToViewOffset3 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2556getXimpl(j2));
        int composeToViewOffset4 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2557getYimpl(j2));
        m4557toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m4557toViewTypeGyEprt8(i);
        nestedScrollingChildHelper2.dispatchNestedScroll(composeToViewOffset, composeToViewOffset2, composeToViewOffset3, composeToViewOffset4, null, m4557toViewTypeGyEprt82, this.consumedScrollCache);
        m4556toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m4556toOffsetUv8p0NA(this.consumedScrollCache, j2);
        return m4556toOffsetUv8p0NA;
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* renamed from: onPreFling-QWom1Mo */
    public Object mo1292onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5441getXimpl(j));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5442getYimpl(j));
        if (!nestedScrollingChildHelper.dispatchNestedPreFling(viewVelocity, viewVelocity2)) {
            j = Velocity.Companion.m5452getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5432boximpl(j);
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1293onPreScrollOzD1aCk(long j, int i) {
        int m4555getScrollAxesk4lQ0M;
        int m4557toViewTypeGyEprt8;
        int m4557toViewTypeGyEprt82;
        long m4556toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m4555getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m4555getScrollAxesk4lQ0M(j);
        m4557toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m4557toViewTypeGyEprt8(i);
        if (!nestedScrollingChildHelper.startNestedScroll(m4555getScrollAxesk4lQ0M, m4557toViewTypeGyEprt8)) {
            return Offset.Companion.m2572getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2556getXimpl(j));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2557getYimpl(j));
        int[] iArr = this.consumedScrollCache;
        m4557toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m4557toViewTypeGyEprt8(i);
        nestedScrollingChildHelper2.dispatchNestedPreScroll(composeToViewOffset, composeToViewOffset2, iArr, null, m4557toViewTypeGyEprt82);
        m4556toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m4556toOffsetUv8p0NA(this.consumedScrollCache, j);
        return m4556toOffsetUv8p0NA;
    }
}
