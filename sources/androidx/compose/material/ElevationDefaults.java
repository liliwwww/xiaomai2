package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ElevationDefaults {

    @NotNull
    public static final ElevationDefaults INSTANCE = new ElevationDefaults();

    private ElevationDefaults() {
    }

    @Nullable
    public final AnimationSpec<Dp> incomingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        DurationBasedAnimationSpec durationBasedAnimationSpec;
        DurationBasedAnimationSpec durationBasedAnimationSpec2;
        DurationBasedAnimationSpec durationBasedAnimationSpec3;
        DurationBasedAnimationSpec durationBasedAnimationSpec4;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction$Press) {
            durationBasedAnimationSpec4 = ElevationKt.DefaultIncomingSpec;
            return durationBasedAnimationSpec4;
        }
        if (interaction instanceof DragInteraction.Start) {
            durationBasedAnimationSpec3 = ElevationKt.DefaultIncomingSpec;
            return durationBasedAnimationSpec3;
        }
        if (interaction instanceof HoverInteraction.Enter) {
            durationBasedAnimationSpec2 = ElevationKt.DefaultIncomingSpec;
            return durationBasedAnimationSpec2;
        }
        if (!(interaction instanceof FocusInteraction$Focus)) {
            return null;
        }
        durationBasedAnimationSpec = ElevationKt.DefaultIncomingSpec;
        return durationBasedAnimationSpec;
    }

    @Nullable
    public final AnimationSpec<Dp> outgoingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        DurationBasedAnimationSpec durationBasedAnimationSpec;
        DurationBasedAnimationSpec durationBasedAnimationSpec2;
        DurationBasedAnimationSpec durationBasedAnimationSpec3;
        DurationBasedAnimationSpec durationBasedAnimationSpec4;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction$Press) {
            durationBasedAnimationSpec4 = ElevationKt.DefaultOutgoingSpec;
            return durationBasedAnimationSpec4;
        }
        if (interaction instanceof DragInteraction.Start) {
            durationBasedAnimationSpec3 = ElevationKt.DefaultOutgoingSpec;
            return durationBasedAnimationSpec3;
        }
        if (interaction instanceof HoverInteraction.Enter) {
            durationBasedAnimationSpec2 = ElevationKt.HoveredOutgoingSpec;
            return durationBasedAnimationSpec2;
        }
        if (!(interaction instanceof FocusInteraction$Focus)) {
            return null;
        }
        durationBasedAnimationSpec = ElevationKt.DefaultOutgoingSpec;
        return durationBasedAnimationSpec;
    }
}
