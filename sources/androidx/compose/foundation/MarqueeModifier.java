package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifier;
import androidx.compose.p004ui.focus.FocusEventModifier;
import androidx.compose.p004ui.focus.FocusState;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.ClipOp;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.layout.C0790a;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class MarqueeModifier implements Modifier.Element, DrawModifier, FocusEventModifier, LayoutModifier {

    @NotNull
    private final MutableState animationMode$delegate;

    @NotNull
    private final MutableState containerWidth$delegate;

    @NotNull
    private final MutableState contentWidth$delegate;
    private final int delayMillis;

    @NotNull
    private final Density density;
    private final float direction;

    @NotNull
    private final MutableState hasFocus$delegate;
    private final int initialDelayMillis;
    private final int iterations;

    @NotNull
    private final Animatable<Float, AnimationVector1D> offset;

    @NotNull
    private final MutableState spacing$delegate;

    @NotNull
    private final State spacingPx$delegate;
    private final float velocity;

    private MarqueeModifier(int i, int i2, int i3, float f, Density density) {
        this.iterations = i;
        this.delayMillis = i2;
        this.initialDelayMillis = i3;
        this.velocity = f;
        this.density = density;
        this.contentWidth$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.containerWidth$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.spacing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BasicMarqueeKt.getDefaultMarqueeSpacing(), null, 2, null);
        this.animationMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m1177boximpl(MarqueeAnimationMode.Companion.m1186getImmediatelyZbEOnfQ()), null, 2, null);
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.direction = Math.signum(f);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.MarqueeModifier$spacingPx$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1191invoke() {
                Density density2;
                int contentWidth;
                int containerWidth;
                MarqueeSpacing spacing = MarqueeModifier.this.getSpacing();
                MarqueeModifier marqueeModifier = MarqueeModifier.this;
                density2 = marqueeModifier.density;
                contentWidth = marqueeModifier.getContentWidth();
                containerWidth = marqueeModifier.getContainerWidth();
                return Integer.valueOf(spacing.calculateSpacing(density2, contentWidth, containerWidth));
            }
        });
    }

    public /* synthetic */ MarqueeModifier(int i, int i2, int i3, float f, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, f, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int getContainerWidth() {
        return ((Number) this.containerWidth$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int getContentWidth() {
        return ((Number) this.contentWidth$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    private final void setContainerWidth(int i) {
        this.containerWidth$delegate.setValue(Integer.valueOf(i));
    }

    private final void setContentWidth(int i) {
        this.contentWidth$delegate.setValue(Integer.valueOf(i));
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.p004ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float floatValue = this.offset.getValue().floatValue();
        float f = this.direction;
        float f2 = floatValue * f;
        boolean z = !((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0) ? this.offset.getValue().floatValue() >= ((float) getContainerWidth()) : this.offset.getValue().floatValue() >= ((float) getContentWidth());
        boolean z2 = !((this.direction > 1.0f ? 1 : (this.direction == 1.0f ? 0 : -1)) == 0) ? this.offset.getValue().floatValue() <= ((float) getSpacingPx()) : this.offset.getValue().floatValue() <= ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        float contentWidth = this.direction == 1.0f ? getContentWidth() + getSpacingPx() : (-getContentWidth()) - getSpacingPx();
        float m2622getHeightimpl = Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc());
        int m2776getIntersectrtfAjoo = ClipOp.Companion.m2776getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3214clipRectN_I0leg(f2, 0.0f, f2 + getContainerWidth(), m2622getHeightimpl, m2776getIntersectrtfAjoo);
        if (z) {
            contentDrawScope.drawContent();
        }
        if (z2) {
            contentDrawScope.getDrawContext().getTransform().translate(contentWidth, 0.0f);
            contentDrawScope.drawContent();
            contentDrawScope.getDrawContext().getTransform().translate(-contentWidth, -0.0f);
        }
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getAnimationMode-ZbEOnfQ, reason: not valid java name */
    public final int m1188getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m1183unboximpl();
    }

    @NotNull
    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m141a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m142b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(Constraints.m5175copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.m5198constrainWidthK40F9xA(j, mo4187measureBRTryo0.getWidth()));
        setContentWidth(mo4187measureBRTryo0.getWidth());
        return MeasureScope.CC.m140p(measureScope, getContainerWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.MarqueeModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Animatable animatable;
                float f;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable placeable = Placeable.this;
                animatable = this.offset;
                float f2 = -((Number) animatable.getValue()).floatValue();
                f = this.direction;
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, MathKt.roundToInt(f2 * f), 0, 0.0f, null, 12, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m143c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m144d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.focus.FocusEventModifier
    public void onFocusEvent(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        setHasFocus(focusState.getHasFocus());
    }

    @Nullable
    public final Object runAnimation(@NotNull Continuation<? super Unit> continuation) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object h = d.h(SnapshotStateKt.snapshotFlow(new Function0<Float>() { // from class: androidx.compose.foundation.MarqueeModifier$runAnimation$2
            {
                super(0);
            }

            @Nullable
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m1190invoke() {
                int contentWidth;
                int containerWidth;
                int contentWidth2;
                int spacingPx;
                boolean hasFocus;
                contentWidth = MarqueeModifier.this.getContentWidth();
                containerWidth = MarqueeModifier.this.getContainerWidth();
                if (contentWidth <= containerWidth) {
                    return null;
                }
                if (MarqueeAnimationMode.m1180equalsimpl0(MarqueeModifier.this.m1188getAnimationModeZbEOnfQ(), MarqueeAnimationMode.Companion.m1187getWhileFocusedZbEOnfQ())) {
                    hasFocus = MarqueeModifier.this.getHasFocus();
                    if (!hasFocus) {
                        return null;
                    }
                }
                contentWidth2 = MarqueeModifier.this.getContentWidth();
                spacingPx = MarqueeModifier.this.getSpacingPx();
                return Float.valueOf(contentWidth2 + spacingPx);
            }
        }), new MarqueeModifier$runAnimation$3(this, null), continuation);
        return h == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? h : Unit.INSTANCE;
    }

    /* renamed from: setAnimationMode-97h66l8, reason: not valid java name */
    public final void m1189setAnimationMode97h66l8(int i) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m1177boximpl(i));
    }

    public final void setSpacing(@NotNull MarqueeSpacing marqueeSpacing) {
        Intrinsics.checkNotNullParameter(marqueeSpacing, "<set-?>");
        this.spacing$delegate.setValue(marqueeSpacing);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
