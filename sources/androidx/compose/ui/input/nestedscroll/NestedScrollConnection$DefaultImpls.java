package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NestedScrollConnection$DefaultImpls {
    @Deprecated
    @Nullable
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public static Object m1393onPostFlingRZ2iAVY(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        return wz2.e(nestedScrollConnection, j, j2, continuation);
    }

    @Deprecated
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public static long m1394onPostScrollDzOQY0M(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
        return wz2.f(nestedScrollConnection, j, j2, i);
    }

    @Deprecated
    @Nullable
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public static Object m1395onPreFlingQWom1Mo(@NotNull NestedScrollConnection nestedScrollConnection, long j, @NotNull Continuation<? super Velocity> continuation) {
        return wz2.g(nestedScrollConnection, j, continuation);
    }

    @Deprecated
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public static long m1396onPreScrollOzD1aCk(@NotNull NestedScrollConnection nestedScrollConnection, long j, int i) {
        return wz2.h(nestedScrollConnection, j, i);
    }
}
