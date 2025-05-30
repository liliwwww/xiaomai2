package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;

    @NotNull
    private final State<Color> color;
    private final float radius;

    @NotNull
    private final State<RippleAlpha> rippleAlpha;

    @NotNull
    private final SnapshotStateMap<PressInteraction.Press, RippleAnimation> ripples;

    private CommonRippleIndicationInstance(boolean z, float f, State<Color> state, State<RippleAlpha> state2) {
        super(z, state2);
        this.bounded = z;
        this.radius = f;
        this.color = state;
        this.rippleAlpha = state2;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
    }

    public /* synthetic */ CommonRippleIndicationInstance(boolean z, float f, State state, State state2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2);
    }

    /* renamed from: drawRipples-4WTKRHQ, reason: not valid java name */
    private final void m728drawRipples4WTKRHQ(DrawScope drawScope, long j) {
        Iterator<Map.Entry<PressInteraction.Press, RippleAnimation>> it = this.ripples.entrySet().iterator();
        while (it.hasNext()) {
            RippleAnimation value = it.next().getValue();
            float pressedAlpha = ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha();
            if (!(pressedAlpha == 0.0f)) {
                value.m730draw4WTKRHQ(drawScope, Color.m1049copywmQWz5c$default(j, pressedAlpha, 0.0f, 0.0f, 0.0f, 14, null));
            }
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(@NotNull PressInteraction.Press press, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(press, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Iterator<Map.Entry<PressInteraction.Press, RippleAnimation>> it = this.ripples.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().finish();
        }
        RippleAnimation rippleAnimation = new RippleAnimation(this.bounded ? Offset.m837boximpl(press.getPressPosition-F1C5BW0()) : null, this.radius, this.bounded, null);
        this.ripples.put(press, rippleAnimation);
        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new addRipple.2(rippleAnimation, this, press, (Continuation) null), 3, (Object) null);
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long m1060unboximpl = ((Color) this.color.getValue()).m1060unboximpl();
        contentDrawScope.drawContent();
        m731drawStateLayerH2RKhps(contentDrawScope, this.radius, m1060unboximpl);
        m728drawRipples4WTKRHQ(contentDrawScope, m1060unboximpl);
    }

    public void onAbandoned() {
        this.ripples.clear();
    }

    public void onForgotten() {
        this.ripples.clear();
    }

    public void onRemembered() {
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(@NotNull PressInteraction.Press press) {
        Intrinsics.checkNotNullParameter(press, "interaction");
        RippleAnimation rippleAnimation = this.ripples.get(press);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }
}
