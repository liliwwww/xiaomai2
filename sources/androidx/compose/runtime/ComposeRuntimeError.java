package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComposeRuntimeError extends IllegalStateException {

    @NotNull
    private final String message;

    public ComposeRuntimeError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.message = str;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }
}
