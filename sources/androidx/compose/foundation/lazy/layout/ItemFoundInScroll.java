package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ItemFoundInScroll extends CancellationException {
    private final int itemOffset;

    @NotNull
    private final AnimationState<Float, AnimationVector1D> previousAnimation;

    public ItemFoundInScroll(int i, @NotNull AnimationState<Float, AnimationVector1D> animationState) {
        Intrinsics.checkNotNullParameter(animationState, "previousAnimation");
        this.itemOffset = i;
        this.previousAnimation = animationState;
    }

    public final int getItemOffset() {
        return this.itemOffset;
    }

    @NotNull
    public final AnimationState<Float, AnimationVector1D> getPreviousAnimation() {
        return this.previousAnimation;
    }
}
