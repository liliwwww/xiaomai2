package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.widget.R$styleable;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.interactions = new ArrayList();
    }

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m898drawStateLayerH2RKhps(@NotNull DrawScope drawScope, float f, long j) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawStateLayer");
        float m892getRippleEndRadiuscSwnlzA = Float.isNaN(f) ? RippleAnimationKt.m892getRippleEndRadiuscSwnlzA(drawScope, this.bounded, drawScope.getSize-NH-jbRc()) : drawScope.toPx-0680j_4(f);
        float floatValue = ((Number) this.animatedAlpha.getValue()).floatValue();
        if (floatValue > 0.0f) {
            long j2 = Color.copy-wmQWz5c$default(j, floatValue, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (!this.bounded) {
                w51.x(drawScope, j2, m892getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, R$styleable.AppCompatTheme_windowMinWidthMajor, null);
                return;
            }
            float f2 = Size.getWidth-impl(drawScope.getSize-NH-jbRc());
            float f3 = Size.getHeight-impl(drawScope.getSize-NH-jbRc());
            int m1058getIntersectrtfAjoo = ClipOp.Companion.m1058getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().clipRect-N_I0leg(0.0f, 0.0f, f2, f3, m1058getIntersectrtfAjoo);
            w51.x(drawScope, j2, m892getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, R$styleable.AppCompatTheme_windowMinWidthMajor, null);
            drawContext.getCanvas().restore();
            drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleInteraction(@NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        AnimationSpec outgoingStateLayerAnimationSpecFor;
        AnimationSpec incomingStateLayerAnimationSpecFor;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        boolean z = interaction instanceof HoverInteraction.Enter;
        if (z) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction$Exit) {
            this.interactions.remove(((HoverInteraction$Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction$Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction$Unfocus) {
            this.interactions.remove(((FocusInteraction$Unfocus) interaction).getFocus());
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
            float hoveredAlpha = z ? this.rippleAlpha.getValue().getHoveredAlpha() : interaction instanceof FocusInteraction$Focus ? this.rippleAlpha.getValue().getFocusedAlpha() : interaction instanceof DragInteraction.Start ? this.rippleAlpha.getValue().getDraggedAlpha() : 0.0f;
            incomingStateLayerAnimationSpecFor = RippleKt.incomingStateLayerAnimationSpecFor(interaction2);
            d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$1(this, hoveredAlpha, incomingStateLayerAnimationSpecFor, null), 3, (Object) null);
        } else {
            outgoingStateLayerAnimationSpecFor = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
            d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$2(this, outgoingStateLayerAnimationSpecFor, null), 3, (Object) null);
        }
        this.currentInteraction = interaction2;
    }
}
