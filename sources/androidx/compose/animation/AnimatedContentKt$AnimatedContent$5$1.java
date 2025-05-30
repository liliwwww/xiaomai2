package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimatedContentKt$AnimatedContent$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentScope<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimatedContentKt$AnimatedContent$5$1(Transition<S> transition, S s, int i, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, AnimatedContentScope<S> animatedContentScope, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, SnapshotStateList<S> snapshotStateList) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$$dirty = i;
        this.$transitionSpec = function1;
        this.$rootScope = animatedContentScope;
        this.$content = function4;
        this.$currentlyVisible = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
    
        if (r8 == r5.getEmpty()) goto L18;
     */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r17, int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
