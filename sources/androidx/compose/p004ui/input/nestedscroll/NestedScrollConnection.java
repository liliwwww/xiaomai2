package androidx.compose.p004ui.input.nestedscroll;

import androidx.compose.p004ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface NestedScrollConnection {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m3974onPostFlingRZ2iAVY(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
            return wz2.e(nestedScrollConnection, j, j2, continuation);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m3975onPostScrollDzOQY0M(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return wz2.f(nestedScrollConnection, j, j2, i);
        }

        @Deprecated
        @Nullable
        /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m3976onPreFlingQWom1Mo(@NotNull NestedScrollConnection nestedScrollConnection, long j, @NotNull Continuation<? super Velocity> continuation) {
            return wz2.g(nestedScrollConnection, j, continuation);
        }

        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m3977onPreScrollOzD1aCk(@NotNull NestedScrollConnection nestedScrollConnection, long j, int i) {
            return wz2.h(nestedScrollConnection, j, i);
        }
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY */
    Object mo1290onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M */
    long mo1291onPostScrollDzOQY0M(long j, long j2, int i);

    @Nullable
    /* renamed from: onPreFling-QWom1Mo */
    Object mo1292onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk */
    long mo1293onPreScrollOzD1aCk(long j, int i);
}
