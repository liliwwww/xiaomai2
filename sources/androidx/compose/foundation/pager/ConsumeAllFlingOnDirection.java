package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ConsumeAllFlingOnDirection implements NestedScrollConnection {

    @NotNull
    private final Orientation orientation;

    public ConsumeAllFlingOnDirection(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
    }

    /* renamed from: consumeOnOrientation-8S9VItk, reason: not valid java name */
    public final long m335consumeOnOrientation8S9VItk(long j, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == Orientation.Vertical ? Offset.m842copydBAh8RU$default(j, 0.0f, 0.0f, 2, null) : Offset.m842copydBAh8RU$default(j, 0.0f, 0.0f, 1, null);
    }

    /* renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m336consumeOnOrientationQWom1Mo(long j, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == Orientation.Vertical ? Velocity.copy-OhffZ5M$default(j, 0.0f, 0.0f, 2, (Object) null) : Velocity.copy-OhffZ5M$default(j, 0.0f, 0.0f, 1, (Object) null);
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m337onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        return Velocity.box-impl(m336consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m338onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollSource.m1401equalsimpl0(i, NestedScrollSource.Companion.m1407getFlingWNlRxjI()) ? m335consumeOnOrientation8S9VItk(j2, this.orientation) : Offset.Companion.getZero-F1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public /* synthetic */ Object m339onPreFlingQWom1Mo(long j, Continuation continuation) {
        return wz2.c(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public /* synthetic */ long m340onPreScrollOzD1aCk(long j, int i) {
        return wz2.d(this, j, i);
    }
}
