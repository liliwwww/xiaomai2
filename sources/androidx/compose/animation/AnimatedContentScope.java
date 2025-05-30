package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;
import tb.pp5;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimatedContentScope<S> implements Transition$Segment<S> {
    public static final int $stable = 8;

    @Nullable
    private State<IntSize> animatedSize;

    @NotNull
    private Alignment contentAlignment;

    @NotNull
    private LayoutDirection layoutDirection;

    @NotNull
    private final MutableState measuredSize$delegate;

    @NotNull
    private final Map<S, State<IntSize>> targetSizeMap;

    @NotNull
    private final Transition<S> transition;

    /* compiled from: Taobao */
    public static final class ChildData implements ParentDataModifier {
        private boolean isTarget;

        public ChildData(boolean z) {
            this.isTarget = z;
        }

        public static /* synthetic */ ChildData copy$default(ChildData childData, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = childData.isTarget;
            }
            return childData.copy(z);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ boolean all(Function1 function1) {
            return nt2.a(this, function1);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ boolean any(Function1 function1) {
            return nt2.b(this, function1);
        }

        public final boolean component1() {
            return this.isTarget;
        }

        @NotNull
        public final ChildData copy(boolean z) {
            return new ChildData(z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChildData) && this.isTarget == ((ChildData) obj).isTarget;
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
            return nt2.c(this, obj, function2);
        }

        @Override // androidx.compose.ui.Modifier$Element
        public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
            return nt2.d(this, obj, function2);
        }

        public int hashCode() {
            boolean z = this.isTarget;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isTarget() {
            return this.isTarget;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return this;
        }

        public final void setTarget(boolean z) {
            this.isTarget = z;
        }

        public /* synthetic */ Modifier then(Modifier modifier) {
            return mt2.a(this, modifier);
        }

        @NotNull
        public String toString() {
            return "ChildData(isTarget=" + this.isTarget + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @ExperimentalAnimationApi
    final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {

        @NotNull
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

        @NotNull
        private final State<SizeTransform> sizeTransform;
        final /* synthetic */ AnimatedContentScope<S> this$0;

        public SizeModifier(@NotNull AnimatedContentScope animatedContentScope, @NotNull Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, State<? extends SizeTransform> state) {
            Intrinsics.checkNotNullParameter(deferredAnimation, "sizeAnimation");
            Intrinsics.checkNotNullParameter(state, "sizeTransform");
            this.this$0 = animatedContentScope;
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = state;
        }

        @NotNull
        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        @NotNull
        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @NotNull
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult m31measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            final Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            final AnimatedContentScope<S> animatedContentScope = this.this$0;
            Function1<Transition$Segment<S>, FiniteAnimationSpec<IntSize>> function1 = new Function1<Transition$Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentScope$SizeModifier$measure$size$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition$Segment<S> transition$Segment) {
                    FiniteAnimationSpec<IntSize> finiteAnimationSpec;
                    Intrinsics.checkNotNullParameter(transition$Segment, "$this$animate");
                    State<IntSize> state = animatedContentScope.getTargetSizeMap$animation_release().get(transition$Segment.getInitialState());
                    long j2 = state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                    State<IntSize> state2 = animatedContentScope.getTargetSizeMap$animation_release().get(transition$Segment.getTargetState());
                    long j3 = state2 != null ? ((IntSize) state2.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                    SizeTransform sizeTransform = (SizeTransform) this.getSizeTransform().getValue();
                    return (sizeTransform == null || (finiteAnimationSpec = sizeTransform.createAnimationSpec-TemP2vQ(j2, j3)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null) : finiteAnimationSpec;
                }
            };
            final AnimatedContentScope<S> animatedContentScope2 = this.this$0;
            State<IntSize> animate = deferredAnimation.animate(function1, new Function1<S, IntSize>() { // from class: androidx.compose.animation.AnimatedContentScope$SizeModifier$measure$size$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntSize.box-impl(m32invokeYEO4UFw(obj));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m32invokeYEO4UFw(S s) {
                    State<IntSize> state = animatedContentScope2.getTargetSizeMap$animation_release().get(s);
                    return state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                }
            });
            this.this$0.setAnimatedSize$animation_release(animate);
            final long j2 = this.this$0.getContentAlignment$animation_release().align-KFBX0sM(IntSizeKt.IntSize(mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight()), ((IntSize) animate.getValue()).unbox-impl(), LayoutDirection.Ltr);
            return MeasureScope.-CC.p(measureScope, IntSize.getWidth-impl(((IntSize) animate.getValue()).unbox-impl()), IntSize.getHeight-impl(((IntSize) animate.getValue()).unbox-impl()), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentScope$SizeModifier$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                    Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                    Placeable.PlacementScope.place-70tqf50$default(placementScope, Placeable.this, j2, 0.0f, 2, (Object) null);
                }
            }, 4, (Object) null);
        }
    }

    public AnimatedContentScope(@NotNull Transition<S> transition, @NotNull Alignment alignment, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(alignment, "contentAlignment");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.transition = transition;
        this.contentAlignment = alignment;
        this.layoutDirection = layoutDirection;
        this.measuredSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetSizeMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateOffset-emnUabE, reason: not valid java name */
    public final long m19calculateOffsetemnUabE(long j, long j2) {
        return this.contentAlignment.align-KFBX0sM(j, j2, LayoutDirection.Ltr);
    }

    /* renamed from: createSizeAnimationModifier$lambda-2, reason: not valid java name */
    private static final boolean m20createSizeAnimationModifier$lambda2(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* renamed from: createSizeAnimationModifier$lambda-3, reason: not valid java name */
    private static final void m21createSizeAnimationModifier$lambda3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCurrentSize-YbymL2g, reason: not valid java name */
    public final long m22getCurrentSizeYbymL2g() {
        State<IntSize> state = this.animatedSize;
        return state != null ? ((IntSize) state.getValue()).unbox-impl() : m27getMeasuredSizeYbymL2g$animation_release();
    }

    /* renamed from: isLeft-9jb1Dl8, reason: not valid java name */
    private final boolean m23isLeft9jb1Dl8(int i) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.equals-impl0(i, companion.getLeft-aUPqQNE()) || (SlideDirection.equals-impl0(i, companion.getStart-aUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr) || (SlideDirection.equals-impl0(i, companion.getEnd-aUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl);
    }

    /* renamed from: isRight-9jb1Dl8, reason: not valid java name */
    private final boolean m24isRight9jb1Dl8(int i) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.equals-impl0(i, companion.getRight-aUPqQNE()) || (SlideDirection.equals-impl0(i, companion.getStart-aUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl) || (SlideDirection.equals-impl0(i, companion.getEnd-aUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: slideIntoContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m25slideIntoContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$1
                @NotNull
                public final Integer invoke(int i3) {
                    return Integer.valueOf(i3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return animatedContentScope.m29slideIntoContainerHTTW7Ok(i, finiteAnimationSpec, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: slideOutOfContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m26slideOutOfContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$1
                @NotNull
                public final Integer invoke(int i3) {
                    return Integer.valueOf(i3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return animatedContentScope.m30slideOutOfContainerHTTW7Ok(i, finiteAnimationSpec, function1);
    }

    @Composable
    @NotNull
    public final Modifier createSizeAnimationModifier$animation_release(@NotNull ContentTransform contentTransform, @Nullable Composer composer, int i) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(contentTransform, "contentTransform");
        composer.startReplaceableGroup(-1349251863);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1349251863, i, -1, "androidx.compose.animation.AnimatedContentScope.createSizeAnimationModifier (AnimatedContent.kt:458)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(this);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        boolean z = false;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            m21createSizeAnimationModifier$lambda3(mutableState, false);
        } else if (rememberUpdatedState.getValue() != null) {
            m21createSizeAnimationModifier$lambda3(mutableState, true);
        }
        if (m20createSizeAnimationModifier$lambda2(mutableState)) {
            Transition.DeferredAnimation createDeferredAnimation = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), (String) null, composer, 64, 2);
            composer.startReplaceableGroup(1157296644);
            boolean changed2 = composer.changed(createDeferredAnimation);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                SizeTransform sizeTransform = (SizeTransform) rememberUpdatedState.getValue();
                if (sizeTransform != null && !sizeTransform.getClip()) {
                    z = true;
                }
                Modifier modifier2 = Modifier.Companion;
                if (!z) {
                    modifier2 = ClipKt.clipToBounds(modifier2);
                }
                rememberedValue2 = modifier2.then(new SizeModifier(this, createDeferredAnimation, rememberUpdatedState));
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            modifier = (Modifier) rememberedValue2;
        } else {
            this.animatedSize = null;
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier;
    }

    @Nullable
    public final State<IntSize> getAnimatedSize$animation_release() {
        return this.animatedSize;
    }

    @NotNull
    public final Alignment getContentAlignment$animation_release() {
        return this.contentAlignment;
    }

    @Override // androidx.compose.animation.core.Transition$Segment
    public S getInitialState() {
        return (S) this.transition.getSegment().getInitialState();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection$animation_release() {
        return this.layoutDirection;
    }

    /* renamed from: getMeasuredSize-YbymL2g$animation_release, reason: not valid java name */
    public final long m27getMeasuredSizeYbymL2g$animation_release() {
        return ((IntSize) this.measuredSize$delegate.getValue()).unbox-impl();
    }

    @NotNull
    public final Map<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    @Override // androidx.compose.animation.core.Transition$Segment
    public S getTargetState() {
        return (S) this.transition.getSegment().getTargetState();
    }

    @NotNull
    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    @Override // androidx.compose.animation.core.Transition$Segment
    public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
        return pp5.a(this, obj, obj2);
    }

    public final void setAnimatedSize$animation_release(@Nullable State<IntSize> state) {
        this.animatedSize = state;
    }

    public final void setContentAlignment$animation_release(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.contentAlignment = alignment;
    }

    public final void setLayoutDirection$animation_release(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    /* renamed from: setMeasuredSize-ozmzZPI$animation_release, reason: not valid java name */
    public final void m28setMeasuredSizeozmzZPI$animation_release(long j) {
        this.measuredSize$delegate.setValue(IntSize.box-impl(j));
    }

    @NotNull
    /* renamed from: slideIntoContainer-HTTW7Ok, reason: not valid java name */
    public final EnterTransition m29slideIntoContainerHTTW7Ok(int i, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        if (m23isLeft9jb1Dl8(i)) {
            return EnterExitTransitionKt.slideInHorizontally(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @NotNull
                public final Integer invoke(int i2) {
                    long m22getCurrentSizeYbymL2g;
                    long m22getCurrentSizeYbymL2g2;
                    long m19calculateOffsetemnUabE;
                    Function1<Integer, Integer> function12 = function1;
                    m22getCurrentSizeYbymL2g = this.m22getCurrentSizeYbymL2g();
                    int i3 = IntSize.getWidth-impl(m22getCurrentSizeYbymL2g);
                    AnimatedContentScope<S> animatedContentScope = this;
                    long IntSize = IntSizeKt.IntSize(i2, i2);
                    m22getCurrentSizeYbymL2g2 = this.m22getCurrentSizeYbymL2g();
                    m19calculateOffsetemnUabE = animatedContentScope.m19calculateOffsetemnUabE(IntSize, m22getCurrentSizeYbymL2g2);
                    return (Integer) function12.invoke(Integer.valueOf(i3 - IntOffset.getX-impl(m19calculateOffsetemnUabE)));
                }
            });
        }
        if (m24isRight9jb1Dl8(i)) {
            return EnterExitTransitionKt.slideInHorizontally(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @NotNull
                public final Integer invoke(int i2) {
                    long m22getCurrentSizeYbymL2g;
                    long m19calculateOffsetemnUabE;
                    Function1<Integer, Integer> function12 = function1;
                    AnimatedContentScope<S> animatedContentScope = this;
                    long IntSize = IntSizeKt.IntSize(i2, i2);
                    m22getCurrentSizeYbymL2g = this.m22getCurrentSizeYbymL2g();
                    m19calculateOffsetemnUabE = animatedContentScope.m19calculateOffsetemnUabE(IntSize, m22getCurrentSizeYbymL2g);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getX-impl(m19calculateOffsetemnUabE)) - i2));
                }
            });
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.equals-impl0(i, companion.getUp-aUPqQNE()) ? EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @NotNull
            public final Integer invoke(int i2) {
                long m22getCurrentSizeYbymL2g;
                long m22getCurrentSizeYbymL2g2;
                long m19calculateOffsetemnUabE;
                Function1<Integer, Integer> function12 = function1;
                m22getCurrentSizeYbymL2g = this.m22getCurrentSizeYbymL2g();
                int i3 = IntSize.getHeight-impl(m22getCurrentSizeYbymL2g);
                AnimatedContentScope<S> animatedContentScope = this;
                long IntSize = IntSizeKt.IntSize(i2, i2);
                m22getCurrentSizeYbymL2g2 = this.m22getCurrentSizeYbymL2g();
                m19calculateOffsetemnUabE = animatedContentScope.m19calculateOffsetemnUabE(IntSize, m22getCurrentSizeYbymL2g2);
                return (Integer) function12.invoke(Integer.valueOf(i3 - IntOffset.getY-impl(m19calculateOffsetemnUabE)));
            }
        }) : SlideDirection.equals-impl0(i, companion.getDown-aUPqQNE()) ? EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @NotNull
            public final Integer invoke(int i2) {
                long m22getCurrentSizeYbymL2g;
                long m19calculateOffsetemnUabE;
                Function1<Integer, Integer> function12 = function1;
                AnimatedContentScope<S> animatedContentScope = this;
                long IntSize = IntSizeKt.IntSize(i2, i2);
                m22getCurrentSizeYbymL2g = this.m22getCurrentSizeYbymL2g();
                m19calculateOffsetemnUabE = animatedContentScope.m19calculateOffsetemnUabE(IntSize, m22getCurrentSizeYbymL2g);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getY-impl(m19calculateOffsetemnUabE)) - i2));
            }
        }) : EnterTransition.Companion.getNone();
    }

    @NotNull
    /* renamed from: slideOutOfContainer-HTTW7Ok, reason: not valid java name */
    public final ExitTransition m30slideOutOfContainerHTTW7Ok(int i, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        if (m23isLeft9jb1Dl8(i)) {
            return EnterExitTransitionKt.slideOutHorizontally(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$2
                final /* synthetic */ AnimatedContentScope<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @NotNull
                public final Integer invoke(int i2) {
                    long m19calculateOffsetemnUabE;
                    State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                    long j = state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                    Function1<Integer, Integer> function12 = function1;
                    m19calculateOffsetemnUabE = this.this$0.m19calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), j);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getX-impl(m19calculateOffsetemnUabE)) - i2));
                }
            });
        }
        if (m24isRight9jb1Dl8(i)) {
            return EnterExitTransitionKt.slideOutHorizontally(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$3
                final /* synthetic */ AnimatedContentScope<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @NotNull
                public final Integer invoke(int i2) {
                    long m19calculateOffsetemnUabE;
                    State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                    long j = state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                    Function1<Integer, Integer> function12 = function1;
                    m19calculateOffsetemnUabE = this.this$0.m19calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), j);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getX-impl(m19calculateOffsetemnUabE)) + IntSize.getWidth-impl(j)));
                }
            });
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.equals-impl0(i, companion.getUp-aUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$4
            final /* synthetic */ AnimatedContentScope<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @NotNull
            public final Integer invoke(int i2) {
                long m19calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long j = state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                Function1<Integer, Integer> function12 = function1;
                m19calculateOffsetemnUabE = this.this$0.m19calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), j);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getY-impl(m19calculateOffsetemnUabE)) - i2));
            }
        }) : SlideDirection.equals-impl0(i, companion.getDown-aUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$5
            final /* synthetic */ AnimatedContentScope<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @NotNull
            public final Integer invoke(int i2) {
                long m19calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long j = state != null ? ((IntSize) state.getValue()).unbox-impl() : IntSize.Companion.getZero-YbymL2g();
                Function1<Integer, Integer> function12 = function1;
                m19calculateOffsetemnUabE = this.this$0.m19calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), j);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.getY-impl(m19calculateOffsetemnUabE)) + IntSize.getHeight-impl(j)));
            }
        }) : ExitTransition.Companion.getNone();
    }

    @ExperimentalAnimationApi
    @NotNull
    public final ContentTransform using(@NotNull ContentTransform contentTransform, @Nullable SizeTransform sizeTransform) {
        Intrinsics.checkNotNullParameter(contentTransform, "<this>");
        contentTransform.setSizeTransform$animation_release(sizeTransform);
        return contentTransform;
    }
}
