package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt$updateTransition$2$1$invoke$;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Dp> animateDp(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Dp> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(184732935);
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Dp>>() { // from class: androidx.compose.animation.core.TransitionKt$animateDp$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<Dp> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(segment, "$this$null");
                    composer2.startReplaceableGroup(-575880366);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-575880366, i3, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:963)");
                    }
                    SpringSpec<Dp> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return spring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Dp> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Float> animateFloat(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Float> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-1338768149);
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>>() { // from class: androidx.compose.animation.core.TransitionKt$animateFloat$1
                @Composable
                @NotNull
                public final SpringSpec<Float> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(segment, "$this$null");
                    composer2.startReplaceableGroup(-522164544);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-522164544, i3, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:934)");
                    }
                    SpringSpec<Float> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return spring$default;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Float> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Integer> animateInt(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Integer> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(1318902782);
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Integer>>() { // from class: androidx.compose.animation.core.TransitionKt$animateInt$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<Integer> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(segment, "$this$null");
                    composer2.startReplaceableGroup(-785273069);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-785273069, i3, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:1087)");
                    }
                    SpringSpec<Integer> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return spring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Integer> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntOffset> animateIntOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntOffset> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(776131825);
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>>() { // from class: androidx.compose.animation.core.TransitionKt$animateIntOffset$1
                @Composable
                @NotNull
                public final SpringSpec<IntOffset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(segment, "$this$null");
                    composer2.startReplaceableGroup(-1953479610);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953479610, i3, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:1058)");
                    }
                    SpringSpec<IntOffset> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m2634boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return spring$default;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<IntOffset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntSize> animateIntSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntSize> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-2104123233);
        if ((i2 & 1) != 0) {
            function3 = animateIntSize.1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<IntSize> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Offset> animateOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Offset> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(2078477582);
        if ((i2 & 1) != 0) {
            function3 = animateOffset.1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Offset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Rect> animateRect(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Rect> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(1496278239);
        if ((i2 & 1) != 0) {
            function3 = animateRect.1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Rect> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Size> animateSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Size> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-802210820);
        if ((i2 & 1) != 0) {
            function3 = animateSize.1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Size> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 9) & 57344) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> animateValue(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function32, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-142660079);
        if ((i2 & 2) != 0) {
            function3 = animateValue.1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i3 = (i >> 9) & 112;
        State<T> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i3)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i3)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter, str, composer, (i & 14) | (57344 & (i << 9)) | (458752 & (i << 6)));
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    @ExperimentalTransitionApi
    @Composable
    public static final <S, T> Transition<T> createChildTransition(@NotNull Transition<S> transition, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function3, "transformToChildState");
        composer.startReplaceableGroup(1215497572);
        if ((i2 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i3 = i & 14;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        if (transition.isSeeking()) {
            rememberedValue = transition.getCurrentState();
        }
        int i4 = (i >> 3) & 112;
        Transition<T> createChildTransitionInternal = createChildTransitionInternal(transition, function3.invoke(rememberedValue, composer, Integer.valueOf(i4)), function3.invoke(transition.getTargetState(), composer, Integer.valueOf(i4)), str2, composer, i3 | ((i << 6) & 7168));
        composer.endReplaceableGroup();
        return createChildTransitionInternal;
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final <S, T> Transition<T> createChildTransitionInternal(@NotNull final Transition<S> transition, T t, T t2, @NotNull String str, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(str, "childLabel");
        composer.startReplaceableGroup(-198307638);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:793)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(new MutableTransitionState(t), transition.getLabel() + " > " + str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition<T> transition2 = (Transition) rememberedValue;
        composer.startReplaceableGroup(511388516);
        boolean changed2 = composer.changed(transition) | composer.changed(transition2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        public void dispose() {
                            Transition.this.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t2, composer, ((i >> 3) & 8) | ((i >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition2;
    }

    @Composable
    @InternalAnimationApi
    @NotNull
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        composer.startReplaceableGroup(-1714122528);
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:748)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition.DeferredAnimation(transition, twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        EffectsKt.DisposableEffect(deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new createDeferredAnimation.1(transition, deferredAnimation), composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(@NotNull Transition<S> transition, T t, T t2, @NotNull FiniteAnimationSpec<T> finiteAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, @NotNull String str, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(str, "label");
        composer.startReplaceableGroup(-304821198);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:865)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition.TransitionAnimationState(transition, t, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t2), twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) rememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core_release(t, t2, finiteAnimationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core_release(t2, finiteAnimationSpec);
        }
        composer.startReplaceableGroup(511388516);
        boolean changed2 = composer.changed(transition) | composer.changed(transitionAnimationState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new createTransitionAnimation.1.1(transition, transitionAnimationState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transitionAnimationState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(T t, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2029166765);
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:66)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Transition(t, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        public void dispose() {
                            Transition.this.onTransitionEnd$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(@NotNull MutableTransitionState<T> mutableTransitionState, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(mutableTransitionState, "transitionState");
        composer.startReplaceableGroup(882913843);
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:149)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(mutableTransitionState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition((MutableTransitionState) mutableTransitionState, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition<T> transition = (Transition<T>) ((Transition) rememberedValue);
        transition.animateTo$animation_core_release(mutableTransitionState.getTargetState(), composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean changed2 = composer.changed(transition);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new TransitionKt$updateTransition$2$1$invoke$.inlined.onDispose.1(transition);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }
}
