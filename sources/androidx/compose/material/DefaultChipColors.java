package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DefaultChipColors implements ChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;

    private DefaultChipColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.leadingIconContentColor = j3;
        this.disabledBackgroundColor = j4;
        this.disabledContentColor = j5;
        this.disabledLeadingIconContentColor = j6;
    }

    public /* synthetic */ DefaultChipColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1593588247);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1593588247, i, -1, "androidx.compose.material.DefaultChipColors.backgroundColor (Chip.kt:591)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1040boximpl(z ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Composable
    @NotNull
    public State<Color> contentColor(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(483145880);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(483145880, i, -1, "androidx.compose.material.DefaultChipColors.contentColor (Chip.kt:596)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1040boximpl(z ? this.contentColor : this.disabledContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(DefaultChipColors.class), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultChipColors defaultChipColors = (DefaultChipColors) obj;
        return Color.m1051equalsimpl0(this.backgroundColor, defaultChipColors.backgroundColor) && Color.m1051equalsimpl0(this.contentColor, defaultChipColors.contentColor) && Color.m1051equalsimpl0(this.leadingIconContentColor, defaultChipColors.leadingIconContentColor) && Color.m1051equalsimpl0(this.disabledBackgroundColor, defaultChipColors.disabledBackgroundColor) && Color.m1051equalsimpl0(this.disabledContentColor, defaultChipColors.disabledContentColor) && Color.m1051equalsimpl0(this.disabledLeadingIconContentColor, defaultChipColors.disabledLeadingIconContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m1057hashCodeimpl(this.backgroundColor) * 31) + Color.m1057hashCodeimpl(this.contentColor)) * 31) + Color.m1057hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m1057hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m1057hashCodeimpl(this.disabledContentColor)) * 31) + Color.m1057hashCodeimpl(this.disabledLeadingIconContentColor);
    }

    @Composable
    @NotNull
    public State<Color> leadingIconContentColor(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1955749013);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1955749013, i, -1, "androidx.compose.material.DefaultChipColors.leadingIconContentColor (Chip.kt:601)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1040boximpl(z ? this.leadingIconContentColor : this.disabledLeadingIconContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
