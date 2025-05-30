package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {

    @NotNull
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    private DoNothingNestedScrollConnection() {
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public /* synthetic */ Object mo309onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return wz2.a(this, j, j2, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public /* synthetic */ long mo310onPostScrollDzOQY0M(long j, long j2, int i) {
        return wz2.b(this, j, j2, i);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public /* synthetic */ Object mo311onPreFlingQWom1Mo(long j, Continuation continuation) {
        return wz2.c(this, j, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public /* synthetic */ long mo312onPreScrollOzD1aCk(long j, int i) {
        return wz2.d(this, j, i);
    }
}
