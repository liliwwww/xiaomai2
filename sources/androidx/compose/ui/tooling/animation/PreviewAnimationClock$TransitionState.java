package androidx.compose.ui.tooling.animation;

import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PreviewAnimationClock$TransitionState {

    @NotNull
    private final Object current;

    @NotNull
    private final Object target;

    public PreviewAnimationClock$TransitionState(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "current");
        Intrinsics.checkNotNullParameter(obj2, "target");
        this.current = obj;
        this.target = obj2;
    }

    public static /* synthetic */ PreviewAnimationClock$TransitionState copy$default(PreviewAnimationClock$TransitionState previewAnimationClock$TransitionState, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = previewAnimationClock$TransitionState.current;
        }
        if ((i & 2) != 0) {
            obj2 = previewAnimationClock$TransitionState.target;
        }
        return previewAnimationClock$TransitionState.copy(obj, obj2);
    }

    @NotNull
    public final Object component1() {
        return this.current;
    }

    @NotNull
    public final Object component2() {
        return this.target;
    }

    @NotNull
    public final PreviewAnimationClock$TransitionState copy(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "current");
        Intrinsics.checkNotNullParameter(obj2, "target");
        return new PreviewAnimationClock$TransitionState(obj, obj2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviewAnimationClock$TransitionState)) {
            return false;
        }
        PreviewAnimationClock$TransitionState previewAnimationClock$TransitionState = (PreviewAnimationClock$TransitionState) obj;
        return Intrinsics.areEqual(this.current, previewAnimationClock$TransitionState.current) && Intrinsics.areEqual(this.target, previewAnimationClock$TransitionState.target);
    }

    @NotNull
    public final Object getCurrent() {
        return this.current;
    }

    @NotNull
    public final Object getTarget() {
        return this.target;
    }

    public int hashCode() {
        return (this.current.hashCode() * 31) + this.target.hashCode();
    }

    @NotNull
    public String toString() {
        return "TransitionState(current=" + this.current + ", target=" + this.target + ')';
    }
}
