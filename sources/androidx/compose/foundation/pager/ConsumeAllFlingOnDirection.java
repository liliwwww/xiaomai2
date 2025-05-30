package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p004ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ConsumeAllFlingOnDirection implements NestedScrollConnection {

    @NotNull
    private final Orientation orientation;

    public ConsumeAllFlingOnDirection(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
    }

    /* renamed from: consumeOnOrientation-8S9VItk, reason: not valid java name */
    public final long m1644consumeOnOrientation8S9VItk(long j, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == Orientation.Vertical ? Offset.m2550copydBAh8RU$default(j, 0.0f, 0.0f, 2, null) : Offset.m2550copydBAh8RU$default(j, 0.0f, 0.0f, 1, null);
    }

    /* renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m1645consumeOnOrientationQWom1Mo(long j, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == Orientation.Vertical ? Velocity.m5437copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null) : Velocity.m5437copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null);
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo1290onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        return Velocity.m5432boximpl(m1645consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo1291onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollSource.m3988equalsimpl0(i, NestedScrollSource.Companion.m3994getFlingWNlRxjI()) ? m1644consumeOnOrientation8S9VItk(j2, this.orientation) : Offset.Companion.m2572getZeroF1C5BW0();
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo1292onPreFlingQWom1Mo(long j, Continuation continuation) {
        return wz2.c(this, j, continuation);
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public /* synthetic */ long mo1293onPreScrollOzD1aCk(long j, int i) {
        return wz2.d(this, j, i);
    }
}
