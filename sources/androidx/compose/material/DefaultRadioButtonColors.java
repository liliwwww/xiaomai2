package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;

    private DefaultRadioButtonColors(long j, long j2, long j3) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledColor = j3;
    }

    public /* synthetic */ DefaultRadioButtonColors(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(DefaultRadioButtonColors.class), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) obj;
        return Color.equals-impl0(this.selectedColor, defaultRadioButtonColors.selectedColor) && Color.equals-impl0(this.unselectedColor, defaultRadioButtonColors.unselectedColor) && Color.equals-impl0(this.disabledColor, defaultRadioButtonColors.disabledColor);
    }

    public int hashCode() {
        return (((Color.hashCode-impl(this.selectedColor) * 31) + Color.hashCode-impl(this.unselectedColor)) * 31) + Color.hashCode-impl(this.disabledColor);
    }

    @Override // androidx.compose.material.RadioButtonColors
    @Composable
    @NotNull
    public State<Color> radioColor(boolean z, boolean z2, @Nullable Composer composer, int i) {
        State<Color> rememberUpdatedState;
        composer.startReplaceableGroup(1243421834);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1243421834, i, -1, "androidx.compose.material.DefaultRadioButtonColors.radioColor (RadioButton.kt:181)");
        }
        long j = !z ? this.disabledColor : !z2 ? this.unselectedColor : this.selectedColor;
        if (z) {
            composer.startReplaceableGroup(-1052799218);
            rememberUpdatedState = SingleValueAnimationKt.animateColorAsState-KTwxG1Y(j, AnimationSpecKt.tween$default(100, 0, null, 6, null), (Function1) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1052799113);
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
