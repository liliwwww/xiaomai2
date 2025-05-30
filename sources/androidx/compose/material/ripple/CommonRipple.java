package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public final class CommonRipple extends Ripple {
    private CommonRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, null);
    }

    public /* synthetic */ CommonRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    @Override // androidx.compose.material.ripple.Ripple
    @Composable
    @NotNull
    /* renamed from: rememberUpdatedRippleInstance-942rkJo, reason: not valid java name */
    public RippleIndicationInstance mo2367rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z, float f, @NotNull State<Color> state, @NotNull State<RippleAlpha> state2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(state, TypedValues.Custom.S_COLOR);
        Intrinsics.checkNotNullParameter(state2, "rippleAlpha");
        composer.startReplaceableGroup(-1768051227);
        composer.startReplaceableGroup(-3686552);
        boolean changed = composer.changed(interactionSource) | composer.changed(this);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CommonRippleIndicationInstance(z, f, state, state2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) rememberedValue;
        composer.endReplaceableGroup();
        return commonRippleIndicationInstance;
    }
}
