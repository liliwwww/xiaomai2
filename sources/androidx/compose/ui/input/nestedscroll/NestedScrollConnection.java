package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface NestedScrollConnection {
    @Nullable
    /* renamed from: onPostFling-RZ2iAVY */
    Object mo309onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M */
    long mo310onPostScrollDzOQY0M(long j, long j2, int i);

    @Nullable
    /* renamed from: onPreFling-QWom1Mo */
    Object mo311onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk */
    long mo312onPreScrollOzD1aCk(long j, int i);
}
