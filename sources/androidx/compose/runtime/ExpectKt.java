package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ExpectKt {
    @NotNull
    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(new Function0<T>() { // from class: androidx.compose.runtime.ExpectKt$ThreadLocal$1
            @Nullable
            public final T invoke() {
                return null;
            }
        });
    }

    public static final int postIncrement(@NotNull AtomicInt atomicInt) {
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        return atomicInt.add(1) - 1;
    }
}
