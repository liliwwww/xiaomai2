package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RestrictsSuspension
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface AwaitPointerEventScope extends Density {
    @Nullable
    Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull Continuation<? super PointerEvent> continuation);

    @NotNull
    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo1409getExtendedTouchPaddingNHjbRc();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo1410getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    @Nullable
    <T> Object withTimeout(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);

    @Nullable
    <T> Object withTimeoutOrNull(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);
}
