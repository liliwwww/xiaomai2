package androidx.compose.p004ui.tooling;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ThreadSafeException {

    @Nullable
    private Throwable exception;

    @NotNull
    private final Object lock = new Object();

    public final void set(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        synchronized (this.lock) {
            this.exception = th;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void throwIfPresent() {
        synchronized (this.lock) {
            Throwable th = this.exception;
            if (th != null) {
                this.exception = null;
                throw th;
            }
        }
    }
}
