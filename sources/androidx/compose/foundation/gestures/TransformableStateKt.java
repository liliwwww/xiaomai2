package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ep5;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TransformableStateKt {
    @NotNull
    public static final TransformableState TransformableState(@NotNull Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "onTransformation");
        return new DefaultTransformableState(function3);
    }

    @Nullable
    /* renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m1311animatePanByubNVwUQ(@NotNull TransformableState transformableState, long j, @NotNull AnimationSpec<Offset> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.Companion.m2572getZeroF1C5BW0();
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$animatePanBy$2(longRef, j, animationSpec, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m1312animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m1311animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    @Nullable
    public static final Object animateRotateBy(@NotNull TransformableState transformableState, float f, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$animateRotateBy$2(new Ref.FloatRef(), f, animationSpec, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f, animationSpec, continuation);
    }

    @Nullable
    public static final Object animateZoomBy(@NotNull TransformableState transformableState, float f, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        if (!(f > 0.0f)) {
            throw new IllegalArgumentException("zoom value should be greater than 0".toString());
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 1.0f;
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$animateZoomBy$3(floatRef, f, animationSpec, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f, animationSpec, continuation);
    }

    @Nullable
    /* renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m1313panByd4ec7I(@NotNull TransformableState transformableState, long j, @NotNull Continuation<? super Unit> continuation) {
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$panBy$2(j, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    @Composable
    @NotNull
    public static final TransformableState rememberTransformableState(@NotNull Function3<? super Float, ? super Offset, ? super Float, Unit> function3, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function3, "onTransformation");
        composer.startReplaceableGroup(1681419281);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:114)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TransformableState(new Function3<Float, Offset, Float, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$rememberTransformableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m1314invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m2566unboximpl(), ((Number) obj3).floatValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final void m1314invoked4ec7I(float f, long j, float f2) {
                    rememberUpdatedState.getValue().invoke(Float.valueOf(f), Offset.m2545boximpl(j), Float.valueOf(f2));
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transformableState;
    }

    @Nullable
    public static final Object rotateBy(@NotNull TransformableState transformableState, float f, @NotNull Continuation<? super Unit> continuation) {
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$rotateBy$2(f, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    @Nullable
    public static final Object stopTransformation(@NotNull TransformableState transformableState, @NotNull MutatePriority mutatePriority, @NotNull Continuation<? super Unit> continuation) {
        Object transform = transformableState.transform(mutatePriority, new TransformableStateKt$stopTransformation$2(null), continuation);
        return transform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    @Nullable
    public static final Object zoomBy(@NotNull TransformableState transformableState, float f, @NotNull Continuation<? super Unit> continuation) {
        Object a = ep5.a(transformableState, (MutatePriority) null, new TransformableStateKt$zoomBy$2(f, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }
}
