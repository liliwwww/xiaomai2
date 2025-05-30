package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation;

    @NotNull
    private final State<Slide> slideIn;

    @NotNull
    private final State<Slide> slideOut;

    @NotNull
    private final Function1<Transition$Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> transitionSpec;

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

    public SlideModifier(@NotNull Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation, @NotNull State<Slide> state, @NotNull State<Slide> state2) {
        Intrinsics.checkNotNullParameter(deferredAnimation, "lazyAnimation");
        Intrinsics.checkNotNullParameter(state, "slideIn");
        Intrinsics.checkNotNullParameter(state2, "slideOut");
        this.lazyAnimation = deferredAnimation;
        this.slideIn = state;
        this.slideOut = state2;
        this.transitionSpec = new transitionSpec.1(this);
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getLazyAnimation() {
        return this.lazyAnimation;
    }

    @NotNull
    public final State<Slide> getSlideIn() {
        return this.slideIn;
    }

    @NotNull
    public final State<Slide> getSlideOut() {
        return this.slideOut;
    }

    @NotNull
    public final Function1<Transition$Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getTransitionSpec() {
        return this.transitionSpec;
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m67measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight());
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SlideModifier$measure$1
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
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(placementScope, mo1521measureBRTryo0, ((IntOffset) SlideModifier.this.getLazyAnimation().animate(SlideModifier.this.getTransitionSpec(), new slideOffset.1(SlideModifier.this, IntSize)).getValue()).unbox-impl(), 0.0f, (Function1) null, 6, (Object) null);
            }
        }, 4, (Object) null);
    }

    /* renamed from: targetValueByState-oFUgxo0, reason: not valid java name */
    public final long m68targetValueByStateoFUgxo0(@NotNull EnterExitState enterExitState, long j) {
        Function1<IntSize, IntOffset> slideOffset;
        Function1<IntSize, IntOffset> slideOffset2;
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        Slide slide = (Slide) this.slideIn.getValue();
        long j2 = (slide == null || (slideOffset2 = slide.getSlideOffset()) == null) ? IntOffset.Companion.getZero-nOcc-ac() : ((IntOffset) slideOffset2.invoke(IntSize.box-impl(j))).unbox-impl();
        Slide slide2 = (Slide) this.slideOut.getValue();
        long j3 = (slide2 == null || (slideOffset = slide2.getSlideOffset()) == null) ? IntOffset.Companion.getZero-nOcc-ac() : ((IntOffset) slideOffset.invoke(IntSize.box-impl(j))).unbox-impl();
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.getZero-nOcc-ac();
        }
        if (i == 2) {
            return j2;
        }
        if (i == 3) {
            return j3;
        }
        throw new NoWhenBranchMatchedException();
    }
}
