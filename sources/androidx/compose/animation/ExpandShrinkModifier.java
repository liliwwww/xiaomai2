package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final State<Alignment> alignment;

    @Nullable
    private Alignment currentAlignment;

    @NotNull
    private final State<ChangeSize> expand;

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;

    @NotNull
    private final State<ChangeSize> shrink;

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

    @NotNull
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec;

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandShrinkModifier(@NotNull Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, @NotNull Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, @NotNull State<ChangeSize> state, @NotNull State<ChangeSize> state2, @NotNull State<? extends Alignment> state3) {
        Intrinsics.checkNotNullParameter(deferredAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(deferredAnimation2, "offsetAnimation");
        Intrinsics.checkNotNullParameter(state, "expand");
        Intrinsics.checkNotNullParameter(state2, "shrink");
        Intrinsics.checkNotNullParameter(state3, "alignment");
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.expand = state;
        this.shrink = state2;
        this.alignment = state3;
        this.sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$sizeTransitionSpec$1
            {
                super(1);
            }

            @NotNull
            public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                FiniteAnimationSpec<IntSize> finiteAnimationSpec = null;
                if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                    ChangeSize value = ExpandShrinkModifier.this.getExpand().getValue();
                    if (value != null) {
                        finiteAnimationSpec = value.getAnimationSpec();
                    }
                } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    ChangeSize value2 = ExpandShrinkModifier.this.getShrink().getValue();
                    if (value2 != null) {
                        finiteAnimationSpec = value2.getAnimationSpec();
                    }
                } else {
                    finiteAnimationSpec = EnterExitTransitionKt.access$getDefaultSizeAnimationSpec$p();
                }
                return finiteAnimationSpec == null ? EnterExitTransitionKt.access$getDefaultSizeAnimationSpec$p() : finiteAnimationSpec;
            }
        };
    }

    @NotNull
    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    @NotNull
    public final State<ChangeSize> getExpand() {
        return this.expand;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    @NotNull
    public final State<ChangeSize> getShrink() {
        return this.shrink;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    @NotNull
    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.measure-BRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight());
        long m2689unboximpl = this.sizeAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$currentSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m2677boximpl(m52invokeYEO4UFw((EnterExitState) obj));
            }

            /* renamed from: invoke-YEO4UFw, reason: not valid java name */
            public final long m52invokeYEO4UFw(@NotNull EnterExitState enterExitState) {
                Intrinsics.checkNotNullParameter(enterExitState, "it");
                return ExpandShrinkModifier.this.m50sizeByStateUzc_VyU(enterExitState, IntSize);
            }
        }).getValue().m2689unboximpl();
        final long m2652unboximpl = this.offsetAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$1
            @NotNull
            public final FiniteAnimationSpec<IntOffset> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
                Intrinsics.checkNotNullParameter(segment, "$this$animate");
                return EnterExitTransitionKt.access$getDefaultOffsetAnimationSpec$p();
            }
        }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m2634boximpl(m53invokeBjo55l4((EnterExitState) obj));
            }

            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
            public final long m53invokeBjo55l4(@NotNull EnterExitState enterExitState) {
                Intrinsics.checkNotNullParameter(enterExitState, "it");
                return ExpandShrinkModifier.this.m51targetOffsetByStateoFUgxo0(enterExitState, IntSize);
            }
        }).getValue().m2652unboximpl();
        Alignment alignment = this.currentAlignment;
        final long mo935alignKFBX0sM = alignment != null ? alignment.mo935alignKFBX0sM(IntSize, m2689unboximpl, LayoutDirection.Ltr) : IntOffset.Companion.m2653getZeronOccac();
        return MeasureScope$CC.p(measureScope, IntSize.m2685getWidthimpl(m2689unboximpl), IntSize.m2684getHeightimpl(m2689unboximpl), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable$PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                Placeable$PlacementScope.place$default(placeable$PlacementScope, placeable, IntOffset.m2643getXimpl(mo935alignKFBX0sM) + IntOffset.m2643getXimpl(m2652unboximpl), IntOffset.m2644getYimpl(mo935alignKFBX0sM) + IntOffset.m2644getYimpl(m2652unboximpl), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void setCurrentAlignment(@Nullable Alignment alignment) {
        this.currentAlignment = alignment;
    }

    /* renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m50sizeByStateUzc_VyU(@NotNull EnterExitState enterExitState, long j) {
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        ChangeSize value = this.expand.getValue();
        long m2689unboximpl = value != null ? ((IntSize) value.getSize().invoke(IntSize.m2677boximpl(j))).m2689unboximpl() : j;
        ChangeSize value2 = this.shrink.getValue();
        long m2689unboximpl2 = value2 != null ? ((IntSize) value2.getSize().invoke(IntSize.m2677boximpl(j))).m2689unboximpl() : j;
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return j;
        }
        if (i == 2) {
            return m2689unboximpl;
        }
        if (i == 3) {
            return m2689unboximpl2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m51targetOffsetByStateoFUgxo0(@NotNull EnterExitState enterExitState, long j) {
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        if (this.currentAlignment != null && this.alignment.getValue() != null && !Intrinsics.areEqual(this.currentAlignment, this.alignment.getValue())) {
            int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
            if (i == 1) {
                return IntOffset.Companion.m2653getZeronOccac();
            }
            if (i == 2) {
                return IntOffset.Companion.m2653getZeronOccac();
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ChangeSize value = this.shrink.getValue();
            if (value == null) {
                return IntOffset.Companion.m2653getZeronOccac();
            }
            long m2689unboximpl = ((IntSize) value.getSize().invoke(IntSize.m2677boximpl(j))).m2689unboximpl();
            Alignment value2 = this.alignment.getValue();
            Intrinsics.checkNotNull(value2);
            Alignment alignment = value2;
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            long mo935alignKFBX0sM = alignment.mo935alignKFBX0sM(j, m2689unboximpl, layoutDirection);
            Alignment alignment2 = this.currentAlignment;
            Intrinsics.checkNotNull(alignment2);
            long mo935alignKFBX0sM2 = alignment2.mo935alignKFBX0sM(j, m2689unboximpl, layoutDirection);
            return IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(mo935alignKFBX0sM) - IntOffset.m2643getXimpl(mo935alignKFBX0sM2), IntOffset.m2644getYimpl(mo935alignKFBX0sM) - IntOffset.m2644getYimpl(mo935alignKFBX0sM2));
        }
        return IntOffset.Companion.m2653getZeronOccac();
    }
}
