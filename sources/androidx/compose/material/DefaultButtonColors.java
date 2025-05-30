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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultButtonColors implements ButtonColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;

    private DefaultButtonColors(long j, long j2, long j3, long j4) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.disabledBackgroundColor = j3;
        this.disabledContentColor = j4;
    }

    public /* synthetic */ DefaultButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-655254499);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-655254499, i, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:583)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Composable
    @NotNull
    public State<Color> contentColor(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2133647540);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2133647540, i, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:588)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.contentColor : this.disabledContentColor), composer, 0);
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
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(DefaultButtonColors.class), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultButtonColors defaultButtonColors = (DefaultButtonColors) obj;
        return Color.equals-impl0(this.backgroundColor, defaultButtonColors.backgroundColor) && Color.equals-impl0(this.contentColor, defaultButtonColors.contentColor) && Color.equals-impl0(this.disabledBackgroundColor, defaultButtonColors.disabledBackgroundColor) && Color.equals-impl0(this.disabledContentColor, defaultButtonColors.disabledContentColor);
    }

    public int hashCode() {
        return (((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledContentColor);
    }
}
