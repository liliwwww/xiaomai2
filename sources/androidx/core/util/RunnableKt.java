package androidx.core.util;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RunnableKt {
    @NotNull
    public static final Runnable asRunnable(@NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        return new ContinuationRunnable(continuation);
    }
}
