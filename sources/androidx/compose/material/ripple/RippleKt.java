package androidx.compose.material.ripple;

import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RippleKt {

    @NotNull
    private static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec<>(15, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        if (interaction instanceof HoverInteraction.Enter) {
            return DefaultTweenSpec;
        }
        if (!(interaction instanceof FocusInteraction$Focus) && !(interaction instanceof DragInteraction.Start)) {
            return DefaultTweenSpec;
        }
        return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        if (!(interaction instanceof HoverInteraction.Enter) && !(interaction instanceof FocusInteraction$Focus)) {
            return interaction instanceof DragInteraction.Start ? new TweenSpec(ZipAppConstants.LOW_LIMITED_MAX_APP_NUM, 0, EasingKt.getLinearEasing(), 2, null) : DefaultTweenSpec;
        }
        return DefaultTweenSpec;
    }

    @Composable
    @NotNull
    /* renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final Indication m897rememberRipple9IZ8Weo(boolean z, float f, long j, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1635163520);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i2 & 4) != 0) {
            j = Color.Companion.m1084getUnspecified0d7_KjU();
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, (i >> 6) & 14);
        Boolean valueOf = Boolean.valueOf(z);
        Dp dp = Dp.box-impl(f);
        composer.startReplaceableGroup(-3686552);
        boolean changed = composer.changed(valueOf) | composer.changed(dp);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PlatformRipple(z, f, rememberUpdatedState, (DefaultConstructorMarker) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PlatformRipple platformRipple = (PlatformRipple) rememberedValue;
        composer.endReplaceableGroup();
        return platformRipple;
    }
}
