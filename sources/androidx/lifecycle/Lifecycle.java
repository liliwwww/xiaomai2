package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class Lifecycle {

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @NotNull
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    /* compiled from: Taobao */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NotNull LifecycleObserver lifecycleObserver);

    @MainThread
    @NotNull
    public abstract State getCurrentState();

    @NotNull
    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(@NotNull LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(@NotNull AtomicReference<Object> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
