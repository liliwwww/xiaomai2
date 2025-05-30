package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
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
public final class PlatformRipple extends Ripple {
    private PlatformRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, null);
    }

    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    @Composable
    private final ViewGroup findNearestViewGroup(Composer composer, int i) {
        composer.startReplaceableGroup(-1737891121);
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        while (!(consume instanceof ViewGroup)) {
            ViewParent parent = ((View) consume).getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            consume = parent;
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        composer.endReplaceableGroup();
        return viewGroup;
    }

    @Override // androidx.compose.material.ripple.Ripple
    @Composable
    @NotNull
    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public RippleIndicationInstance mo2367rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z, float f, @NotNull State<Color> state, @NotNull State<RippleAlpha> state2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(state, TypedValues.Custom.S_COLOR);
        Intrinsics.checkNotNullParameter(state2, "rippleAlpha");
        composer.startReplaceableGroup(331259447);
        ViewGroup findNearestViewGroup = findNearestViewGroup(composer, (i >> 15) & 14);
        composer.startReplaceableGroup(1643267286);
        if (findNearestViewGroup.isInEditMode()) {
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
            composer.endReplaceableGroup();
            return commonRippleIndicationInstance;
        }
        composer.endReplaceableGroup();
        View view = null;
        int i2 = 0;
        int childCount = findNearestViewGroup.getChildCount();
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = findNearestViewGroup.getChildAt(i2);
            if (childAt instanceof RippleContainer) {
                view = childAt;
                break;
            }
            i2++;
        }
        if (view == null) {
            Context context = findNearestViewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view = new RippleContainer(context);
            findNearestViewGroup.addView(view);
        }
        composer.startReplaceableGroup(-3686095);
        boolean changed2 = composer.changed(interactionSource) | composer.changed(this) | composer.changed(view);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidRippleIndicationInstance(z, f, state, state2, (RippleContainer) view, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) rememberedValue2;
        composer.endReplaceableGroup();
        return androidRippleIndicationInstance;
    }
}
