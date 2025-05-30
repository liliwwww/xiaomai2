package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
/* loaded from: classes2.dex */
public final class ContentTransform {
    public static final int $stable = 8;

    @NotNull
    private final ExitTransition initialContentExit;

    @Nullable
    private SizeTransform sizeTransform;

    @NotNull
    private final EnterTransition targetContentEnter;

    @NotNull
    private final MutableState targetContentZIndex$delegate;

    public ContentTransform(@NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, float f, @Nullable SizeTransform sizeTransform) {
        Intrinsics.checkNotNullParameter(enterTransition, "targetContentEnter");
        Intrinsics.checkNotNullParameter(exitTransition, "initialContentExit");
        this.targetContentEnter = enterTransition;
        this.initialContentExit = exitTransition;
        this.targetContentZIndex$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f), null, 2, null);
        this.sizeTransform = sizeTransform;
    }

    @NotNull
    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    @Nullable
    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    @NotNull
    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getTargetContentZIndex() {
        return ((Number) this.targetContentZIndex$delegate.getValue()).floatValue();
    }

    public final void setSizeTransform$animation_release(@Nullable SizeTransform sizeTransform) {
        this.sizeTransform = sizeTransform;
    }

    public final void setTargetContentZIndex(float f) {
        this.targetContentZIndex$delegate.setValue(Float.valueOf(f));
    }

    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f, SizeTransform sizeTransform, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterTransition, exitTransition, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? AnimatedContentKt.SizeTransform$default(false, null, 3, null) : sizeTransform);
    }
}
