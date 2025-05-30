package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.ParentDataModifier;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;
import tb.pp5;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
/* loaded from: classes.dex */
public final class AnimatedContentScope<S> implements Transition.Segment<S> {
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

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
        public /* synthetic */ boolean all(Function1 function1) {
            return nt2.a(this, function1);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
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

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
            return nt2.c(this, obj, function2);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
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

        @Override // androidx.compose.p004ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return this;
        }

        public final void setTarget(boolean z) {
            this.isTarget = z;
        }

        @Override // androidx.compose.p004ui.Modifier
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

        /* JADX WARN: Multi-variable type inference failed */
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

        @Override // androidx.compose.p004ui.layout.LayoutModifier
        @NotNull
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            final AnimatedContentScope<S> animatedContentScope = this.this$0;
            Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> function1 = new Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentScope$SizeModifier$measure$size$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<S> segment) {
                    FiniteAnimationSpec<IntSize> mo1028createAnimationSpecTemP2vQ;
                    Intrinsics.checkNotNullParameter(segment, "$this$animate");
                    State<IntSize> state = animatedContentScope.getTargetSizeMap$animation_release().get(segment.getInitialState());
                    long m5380unboximpl = state != null ? state.getValue().m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                    State<IntSize> state2 = animatedContentScope.getTargetSizeMap$animation_release().get(segment.getTargetState());
                    long m5380unboximpl2 = state2 != null ? state2.getValue().m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                    SizeTransform value = this.getSizeTransform().getValue();
                    return (value == null || (mo1028createAnimationSpecTemP2vQ = value.mo1028createAnimationSpecTemP2vQ(m5380unboximpl, m5380unboximpl2)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : mo1028createAnimationSpecTemP2vQ;
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
                    return IntSize.m5368boximpl(m960invokeYEO4UFw(obj));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m960invokeYEO4UFw(S s) {
                    State<IntSize> state = animatedContentScope2.getTargetSizeMap$animation_release().get(s);
                    return state != null ? state.getValue().m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                }
            });
            this.this$0.setAnimatedSize$animation_release(animate);
            final long mo2450alignKFBX0sM = this.this$0.getContentAlignment$animation_release().mo2450alignKFBX0sM(IntSizeKt.IntSize(mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight()), animate.getValue().m5380unboximpl(), LayoutDirection.Ltr);
            return MeasureScope.CC.m140p(measureScope, IntSize.m5376getWidthimpl(animate.getValue().m5380unboximpl()), IntSize.m5375getHeightimpl(animate.getValue().m5380unboximpl()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentScope$SizeModifier$measure$1
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
                    Placeable.PlacementScope.m4223place70tqf50$default(placementScope, Placeable.this, mo2450alignKFBX0sM, 0.0f, 2, null);
                }
            }, 4, null);
        }
    }

    /* compiled from: Taobao */
    @Immutable
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class SlideDirection {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Left = m962constructorimpl(0);
        private static final int Right = m962constructorimpl(1);

        /* renamed from: Up */
        private static final int f61Up = m962constructorimpl(2);
        private static final int Down = m962constructorimpl(3);
        private static final int Start = m962constructorimpl(4);
        private static final int End = m962constructorimpl(5);

        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDown-aUPqQNE, reason: not valid java name */
            public final int m968getDownaUPqQNE() {
                return SlideDirection.Down;
            }

            /* renamed from: getEnd-aUPqQNE, reason: not valid java name */
            public final int m969getEndaUPqQNE() {
                return SlideDirection.End;
            }

            /* renamed from: getLeft-aUPqQNE, reason: not valid java name */
            public final int m970getLeftaUPqQNE() {
                return SlideDirection.Left;
            }

            /* renamed from: getRight-aUPqQNE, reason: not valid java name */
            public final int m971getRightaUPqQNE() {
                return SlideDirection.Right;
            }

            /* renamed from: getStart-aUPqQNE, reason: not valid java name */
            public final int m972getStartaUPqQNE() {
                return SlideDirection.Start;
            }

            /* renamed from: getUp-aUPqQNE, reason: not valid java name */
            public final int m973getUpaUPqQNE() {
                return SlideDirection.f61Up;
            }
        }

        private /* synthetic */ SlideDirection(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SlideDirection m961boximpl(int i) {
            return new SlideDirection(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m962constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m963equalsimpl(int i, Object obj) {
            return (obj instanceof SlideDirection) && i == ((SlideDirection) obj).m967unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m964equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m965hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m966toStringimpl(int i) {
            return m964equalsimpl0(i, Left) ? "Left" : m964equalsimpl0(i, Right) ? "Right" : m964equalsimpl0(i, f61Up) ? "Up" : m964equalsimpl0(i, Down) ? "Down" : m964equalsimpl0(i, Start) ? "Start" : m964equalsimpl0(i, End) ? "End" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m963equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m965hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m966toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m967unboximpl() {
            return this.value;
        }
    }

    public AnimatedContentScope(@NotNull Transition<S> transition, @NotNull Alignment alignment, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(alignment, "contentAlignment");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.transition = transition;
        this.contentAlignment = alignment;
        this.layoutDirection = layoutDirection;
        this.measuredSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m5368boximpl(IntSize.Companion.m5381getZeroYbymL2g()), null, 2, null);
        this.targetSizeMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateOffset-emnUabE, reason: not valid java name */
    public final long m947calculateOffsetemnUabE(long j, long j2) {
        return this.contentAlignment.mo2450alignKFBX0sM(j, j2, LayoutDirection.Ltr);
    }

    /* renamed from: createSizeAnimationModifier$lambda-2, reason: not valid java name */
    private static final boolean m948createSizeAnimationModifier$lambda2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* renamed from: createSizeAnimationModifier$lambda-3, reason: not valid java name */
    private static final void m949createSizeAnimationModifier$lambda3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCurrentSize-YbymL2g, reason: not valid java name */
    public final long m950getCurrentSizeYbymL2g() {
        State<IntSize> state = this.animatedSize;
        return state != null ? state.getValue().m5380unboximpl() : m955getMeasuredSizeYbymL2g$animation_release();
    }

    /* renamed from: isLeft-9jb1Dl8, reason: not valid java name */
    private final boolean m951isLeft9jb1Dl8(int i) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m964equalsimpl0(i, companion.m970getLeftaUPqQNE()) || (SlideDirection.m964equalsimpl0(i, companion.m972getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr) || (SlideDirection.m964equalsimpl0(i, companion.m969getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl);
    }

    /* renamed from: isRight-9jb1Dl8, reason: not valid java name */
    private final boolean m952isRight9jb1Dl8(int i) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m964equalsimpl0(i, companion.m971getRightaUPqQNE()) || (SlideDirection.m964equalsimpl0(i, companion.m972getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl) || (SlideDirection.m964equalsimpl0(i, companion.m969getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: slideIntoContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m953slideIntoContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5325boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
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
        return animatedContentScope.m957slideIntoContainerHTTW7Ok(i, finiteAnimationSpec, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: slideOutOfContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m954slideOutOfContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5325boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
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
        return animatedContentScope.m958slideOutOfContainerHTTW7Ok(i, finiteAnimationSpec, function1);
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
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        boolean z = false;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            m949createSizeAnimationModifier$lambda3(mutableState, false);
        } else if (rememberUpdatedState.getValue() != null) {
            m949createSizeAnimationModifier$lambda3(mutableState, true);
        }
        if (m948createSizeAnimationModifier$lambda2(mutableState)) {
            Transition.DeferredAnimation createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), null, composer, 64, 2);
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

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection$animation_release() {
        return this.layoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getMeasuredSize-YbymL2g$animation_release, reason: not valid java name */
    public final long m955getMeasuredSizeYbymL2g$animation_release() {
        return ((IntSize) this.measuredSize$delegate.getValue()).m5380unboximpl();
    }

    @NotNull
    public final Map<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    @NotNull
    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
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
    public final void m956setMeasuredSizeozmzZPI$animation_release(long j) {
        this.measuredSize$delegate.setValue(IntSize.m5368boximpl(j));
    }

    @NotNull
    /* renamed from: slideIntoContainer-HTTW7Ok, reason: not valid java name */
    public final EnterTransition m957slideIntoContainerHTTW7Ok(int i, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        if (m951isLeft9jb1Dl8(i)) {
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
                    long m950getCurrentSizeYbymL2g;
                    long m950getCurrentSizeYbymL2g2;
                    long m947calculateOffsetemnUabE;
                    Function1<Integer, Integer> function12 = function1;
                    m950getCurrentSizeYbymL2g = this.m950getCurrentSizeYbymL2g();
                    int m5376getWidthimpl = IntSize.m5376getWidthimpl(m950getCurrentSizeYbymL2g);
                    AnimatedContentScope<S> animatedContentScope = this;
                    long IntSize = IntSizeKt.IntSize(i2, i2);
                    m950getCurrentSizeYbymL2g2 = this.m950getCurrentSizeYbymL2g();
                    m947calculateOffsetemnUabE = animatedContentScope.m947calculateOffsetemnUabE(IntSize, m950getCurrentSizeYbymL2g2);
                    return (Integer) function12.invoke(Integer.valueOf(m5376getWidthimpl - IntOffset.m5334getXimpl(m947calculateOffsetemnUabE)));
                }
            });
        }
        if (m952isRight9jb1Dl8(i)) {
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
                    long m950getCurrentSizeYbymL2g;
                    long m947calculateOffsetemnUabE;
                    Function1<Integer, Integer> function12 = function1;
                    AnimatedContentScope<S> animatedContentScope = this;
                    long IntSize = IntSizeKt.IntSize(i2, i2);
                    m950getCurrentSizeYbymL2g = this.m950getCurrentSizeYbymL2g();
                    m947calculateOffsetemnUabE = animatedContentScope.m947calculateOffsetemnUabE(IntSize, m950getCurrentSizeYbymL2g);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5334getXimpl(m947calculateOffsetemnUabE)) - i2));
                }
            });
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m964equalsimpl0(i, companion.m973getUpaUPqQNE()) ? EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$4
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
                long m950getCurrentSizeYbymL2g;
                long m950getCurrentSizeYbymL2g2;
                long m947calculateOffsetemnUabE;
                Function1<Integer, Integer> function12 = function1;
                m950getCurrentSizeYbymL2g = this.m950getCurrentSizeYbymL2g();
                int m5375getHeightimpl = IntSize.m5375getHeightimpl(m950getCurrentSizeYbymL2g);
                AnimatedContentScope<S> animatedContentScope = this;
                long IntSize = IntSizeKt.IntSize(i2, i2);
                m950getCurrentSizeYbymL2g2 = this.m950getCurrentSizeYbymL2g();
                m947calculateOffsetemnUabE = animatedContentScope.m947calculateOffsetemnUabE(IntSize, m950getCurrentSizeYbymL2g2);
                return (Integer) function12.invoke(Integer.valueOf(m5375getHeightimpl - IntOffset.m5335getYimpl(m947calculateOffsetemnUabE)));
            }
        }) : SlideDirection.m964equalsimpl0(i, companion.m968getDownaUPqQNE()) ? EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentScope$slideIntoContainer$5
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
                long m950getCurrentSizeYbymL2g;
                long m947calculateOffsetemnUabE;
                Function1<Integer, Integer> function12 = function1;
                AnimatedContentScope<S> animatedContentScope = this;
                long IntSize = IntSizeKt.IntSize(i2, i2);
                m950getCurrentSizeYbymL2g = this.m950getCurrentSizeYbymL2g();
                m947calculateOffsetemnUabE = animatedContentScope.m947calculateOffsetemnUabE(IntSize, m950getCurrentSizeYbymL2g);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5335getYimpl(m947calculateOffsetemnUabE)) - i2));
            }
        }) : EnterTransition.Companion.getNone();
    }

    @NotNull
    /* renamed from: slideOutOfContainer-HTTW7Ok, reason: not valid java name */
    public final ExitTransition m958slideOutOfContainerHTTW7Ok(int i, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        if (m951isLeft9jb1Dl8(i)) {
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
                    long m947calculateOffsetemnUabE;
                    State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                    long m5380unboximpl = state != null ? ((IntSize) state.getValue()).m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                    Function1<Integer, Integer> function12 = function1;
                    m947calculateOffsetemnUabE = this.this$0.m947calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), m5380unboximpl);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5334getXimpl(m947calculateOffsetemnUabE)) - i2));
                }
            });
        }
        if (m952isRight9jb1Dl8(i)) {
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
                    long m947calculateOffsetemnUabE;
                    State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                    long m5380unboximpl = state != null ? ((IntSize) state.getValue()).m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                    Function1<Integer, Integer> function12 = function1;
                    m947calculateOffsetemnUabE = this.this$0.m947calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), m5380unboximpl);
                    return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5334getXimpl(m947calculateOffsetemnUabE)) + IntSize.m5376getWidthimpl(m5380unboximpl)));
                }
            });
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m964equalsimpl0(i, companion.m973getUpaUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$4
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
                long m947calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long m5380unboximpl = state != null ? ((IntSize) state.getValue()).m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                Function1<Integer, Integer> function12 = function1;
                m947calculateOffsetemnUabE = this.this$0.m947calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), m5380unboximpl);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5335getYimpl(m947calculateOffsetemnUabE)) - i2));
            }
        }) : SlideDirection.m964equalsimpl0(i, companion.m968getDownaUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentScope$slideOutOfContainer$5
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
                long m947calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long m5380unboximpl = state != null ? ((IntSize) state.getValue()).m5380unboximpl() : IntSize.Companion.m5381getZeroYbymL2g();
                Function1<Integer, Integer> function12 = function1;
                m947calculateOffsetemnUabE = this.this$0.m947calculateOffsetemnUabE(IntSizeKt.IntSize(i2, i2), m5380unboximpl);
                return (Integer) function12.invoke(Integer.valueOf((-IntOffset.m5335getYimpl(m947calculateOffsetemnUabE)) + IntSize.m5375getHeightimpl(m5380unboximpl)));
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
