package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.ClipOp;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class StateLayer {

    @NotNull
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final boolean bounded;

    @Nullable
    private Interaction currentInteraction;

    @NotNull
    private final List<Interaction> interactions;

    @NotNull
    private final State<RippleAlpha> rippleAlpha;

    public StateLayer(boolean z, @NotNull State<RippleAlpha> state) {
        Intrinsics.checkNotNullParameter(state, "rippleAlpha");
        this.bounded = z;
        this.rippleAlpha = state;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.interactions = new ArrayList();
    }

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m2380drawStateLayerH2RKhps(@NotNull DrawScope drawScope, float f, long j) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawStateLayer");
        float m2370getRippleEndRadiuscSwnlzA = Float.isNaN(f) ? RippleAnimationKt.m2370getRippleEndRadiuscSwnlzA(drawScope, this.bounded, drawScope.mo3205getSizeNHjbRc()) : drawScope.mo1283toPx0680j_4(f);
        float floatValue = this.animatedAlpha.getValue().floatValue();
        if (floatValue > 0.0f) {
            long m2786copywmQWz5c$default = Color.m2786copywmQWz5c$default(j, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (!this.bounded) {
                w51.x(drawScope, m2786copywmQWz5c$default, m2370getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float m2625getWidthimpl = Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc());
            float m2622getHeightimpl = Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc());
            int m2776getIntersectrtfAjoo = ClipOp.Companion.m2776getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo3214clipRectN_I0leg(0.0f, 0.0f, m2625getWidthimpl, m2622getHeightimpl, m2776getIntersectrtfAjoo);
            w51.x(drawScope, m2786copywmQWz5c$default, m2370getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, 124, null);
            drawContext.getCanvas().restore();
            drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
        }
    }

    public final void handleInteraction(@NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        AnimationSpec outgoingStateLayerAnimationSpecFor;
        AnimationSpec incomingStateLayerAnimationSpecFor;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        boolean z = interaction instanceof HoverInteraction.Enter;
        if (z) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction.Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull(this.interactions);
        if (Intrinsics.areEqual(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            float hoveredAlpha = z ? this.rippleAlpha.getValue().getHoveredAlpha() : interaction instanceof FocusInteraction.Focus ? this.rippleAlpha.getValue().getFocusedAlpha() : interaction instanceof DragInteraction.Start ? this.rippleAlpha.getValue().getDraggedAlpha() : 0.0f;
            incomingStateLayerAnimationSpecFor = RippleKt.incomingStateLayerAnimationSpecFor(interaction2);
            d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$1(this, hoveredAlpha, incomingStateLayerAnimationSpecFor, null), 3, (Object) null);
        } else {
            outgoingStateLayerAnimationSpecFor = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
            d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$2(this, outgoingStateLayerAnimationSpecFor, null), 3, (Object) null);
        }
        this.currentInteraction = interaction2;
    }
}
