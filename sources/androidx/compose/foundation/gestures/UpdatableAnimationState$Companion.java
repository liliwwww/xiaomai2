package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorizedSpringSpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class UpdatableAnimationState$Companion {
    private UpdatableAnimationState$Companion() {
    }

    public /* synthetic */ UpdatableAnimationState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final VectorizedSpringSpec<AnimationVector1D> getRebasableAnimationSpec() {
        return UpdatableAnimationState.access$getRebasableAnimationSpec$cp();
    }

    @NotNull
    public final AnimationVector1D getZeroVector() {
        return UpdatableAnimationState.access$getZeroVector$cp();
    }

    public final boolean isZeroish(float f) {
        return Math.abs(f) < 0.01f;
    }
}
