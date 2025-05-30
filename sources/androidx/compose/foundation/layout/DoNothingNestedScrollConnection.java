package androidx.compose.foundation.layout;

import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {

    @NotNull
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    private DoNothingNestedScrollConnection() {
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public /* synthetic */ Object mo1290onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return wz2.a(this, j, j2, continuation);
    }

    @Override // androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public /* synthetic */ long mo1291onPostScrollDzOQY0M(long j, long j2, int i) {
        return wz2.b(this, j, j2, i);
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
