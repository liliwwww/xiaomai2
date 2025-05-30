package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class RippleIndicationInstance implements IndicationInstance {

    @NotNull
    private final StateLayer stateLayer;

    public RippleIndicationInstance(boolean z, @NotNull State<RippleAlpha> state) {
        Intrinsics.checkNotNullParameter(state, "rippleAlpha");
        this.stateLayer = new StateLayer(z, state);
    }

    public abstract void addRipple(@NotNull PressInteraction.Press press, @NotNull CoroutineScope coroutineScope);

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m731drawStateLayerH2RKhps(@NotNull DrawScope drawScope, float f, long j) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawStateLayer");
        this.stateLayer.drawStateLayer-H2RKhps(drawScope, f, j);
    }

    public abstract void removeRipple(@NotNull PressInteraction.Press press);

    public final void updateStateLayer$material_ripple_release(@NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.stateLayer.handleInteraction(interaction, coroutineScope);
    }
}
