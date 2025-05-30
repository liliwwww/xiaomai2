package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public abstract class Ripple implements Indication {
    private final boolean bounded;

    @NotNull
    private final State<Color> color;
    private final float radius;

    private Ripple(boolean z, float f, State<Color> state) {
        this.bounded = z;
        this.radius = f;
        this.color = state;
    }

    public /* synthetic */ Ripple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        return this.bounded == ripple.bounded && C0856Dp.m5221equalsimpl0(this.radius, ripple.radius) && Intrinsics.areEqual(this.color, ripple.color);
    }

    public int hashCode() {
        return (((l3.a(this.bounded) * 31) + C0856Dp.m5222hashCodeimpl(this.radius)) * 31) + this.color.hashCode();
    }

    @Override // androidx.compose.foundation.Indication
    @Composable
    @NotNull
    public final IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(988743187);
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.getLocalRippleTheme());
        composer.startReplaceableGroup(-1524341038);
        long m2797unboximpl = (this.color.getValue().m2797unboximpl() > Color.Companion.m2823getUnspecified0d7_KjU() ? 1 : (this.color.getValue().m2797unboximpl() == Color.Companion.m2823getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? this.color.getValue().m2797unboximpl() : rippleTheme.mo2135defaultColorWaAFU9c(composer, 0);
        composer.endReplaceableGroup();
        RippleIndicationInstance mo2367rememberUpdatedRippleInstance942rkJo = mo2367rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, SnapshotStateKt.rememberUpdatedState(Color.m2777boximpl(m2797unboximpl), composer, 0), SnapshotStateKt.rememberUpdatedState(rippleTheme.rippleAlpha(composer, 0), composer, 0), composer, (i & 14) | (458752 & (i << 12)));
        EffectsKt.LaunchedEffect(mo2367rememberUpdatedRippleInstance942rkJo, interactionSource, new Ripple$rememberUpdatedInstance$1(interactionSource, mo2367rememberUpdatedRippleInstance942rkJo, null), composer, ((i << 3) & 112) | 520);
        composer.endReplaceableGroup();
        return mo2367rememberUpdatedRippleInstance942rkJo;
    }

    @Composable
    @NotNull
    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo2367rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z, float f, @NotNull State<Color> state, @NotNull State<RippleAlpha> state2, @Nullable Composer composer, int i);
}
