package androidx.compose.material.pullrefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {
    private final boolean enabled;

    @NotNull
    private final Function1<Float, Float> onPull;

    @NotNull
    private final Function2<Float, Continuation<? super Unit>, Object> onRelease;

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshNestedScrollConnection(@NotNull Function1<? super Float, Float> function1, @NotNull Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> function2, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "onPull");
        Intrinsics.checkNotNullParameter(function2, "onRelease");
        this.onPull = function1;
        this.onRelease = function2;
        this.enabled = z;
    }

    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public /* synthetic */ Object m720onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return wz2.a(this, j, j2, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m721onPostScrollDzOQY0M(long j, long j2, int i) {
        return !this.enabled ? Offset.Companion.getZero-F1C5BW0() : (!NestedScrollSource.m1401equalsimpl0(i, NestedScrollSource.Companion.m1406getDragWNlRxjI()) || Offset.m849getYimpl(j2) <= 0.0f) ? Offset.Companion.getZero-F1C5BW0() : OffsetKt.Offset(0.0f, ((Number) this.onPull.invoke(Float.valueOf(Offset.m849getYimpl(j2)))).floatValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m722onPreFlingQWom1Mo(long r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1 r0 = (androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1 r0 = new androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.functions.Function2<java.lang.Float, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r4.onRelease
            float r5 = androidx.compose.ui.unit.Velocity.getY-impl(r5)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r0.label = r3
            java.lang.Object r5 = r7.invoke(r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r5.m2239getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.box-impl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection.m722onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m723onPreScrollOzD1aCk(long j, int i) {
        return !this.enabled ? Offset.Companion.getZero-F1C5BW0() : (!NestedScrollSource.m1401equalsimpl0(i, NestedScrollSource.Companion.m1406getDragWNlRxjI()) || Offset.m849getYimpl(j) >= 0.0f) ? Offset.Companion.getZero-F1C5BW0() : OffsetKt.Offset(0.0f, ((Number) this.onPull.invoke(Float.valueOf(Offset.m849getYimpl(j)))).floatValue());
    }
}
