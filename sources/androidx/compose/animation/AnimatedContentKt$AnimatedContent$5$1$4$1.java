package androidx.compose.animation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AnimatedContentKt$AnimatedContent$5$1$4$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentScope<S> $rootScope;
    final /* synthetic */ S $stateForContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$5$1$4$1(SnapshotStateList<S> snapshotStateList, S s, AnimatedContentScope<S> animatedContentScope) {
        super(1);
        this.$currentlyVisible = snapshotStateList;
        this.$stateForContent = s;
        this.$rootScope = animatedContentScope;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final SnapshotStateList<S> snapshotStateList = this.$currentlyVisible;
        final S s = this.$stateForContent;
        final AnimatedContentScope<S> animatedContentScope = this.$rootScope;
        return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                snapshotStateList.remove(s);
                animatedContentScope.getTargetSizeMap$animation_release().remove(s);
            }
        };
    }
}
