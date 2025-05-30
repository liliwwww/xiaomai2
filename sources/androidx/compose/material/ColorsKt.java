package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ColorsKt {

    @NotNull
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Colors m566invoke() {
            Colors m564lightColors2qZNXz8;
            m564lightColors2qZNXz8 = ColorsKt.m564lightColors2qZNXz8((r43 & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (r43 & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (r43 & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (r43 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (r43 & 16) != 0 ? Color.Companion.getWhite-0d7_KjU() : 0L, (r43 & 32) != 0 ? Color.Companion.getWhite-0d7_KjU() : 0L, (r43 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (r43 & 128) != 0 ? Color.Companion.getWhite-0d7_KjU() : 0L, (r43 & 256) != 0 ? Color.Companion.getBlack-0d7_KjU() : 0L, (r43 & 512) != 0 ? Color.Companion.getBlack-0d7_KjU() : 0L, (r43 & 1024) != 0 ? Color.Companion.getBlack-0d7_KjU() : 0L, (r43 & 2048) != 0 ? Color.Companion.getWhite-0d7_KjU() : 0L);
            return m564lightColors2qZNXz8;
        }
    });

    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m560contentColorFor4WTKRHQ(@NotNull Colors colors, long j) {
        Intrinsics.checkNotNullParameter(colors, "$this$contentColorFor");
        if (!Color.m1051equalsimpl0(j, colors.getPrimary-0d7_KjU()) && !Color.m1051equalsimpl0(j, colors.getPrimaryVariant-0d7_KjU())) {
            if (!Color.m1051equalsimpl0(j, colors.getSecondary-0d7_KjU()) && !Color.m1051equalsimpl0(j, colors.getSecondaryVariant-0d7_KjU())) {
                return Color.m1051equalsimpl0(j, colors.getBackground-0d7_KjU()) ? colors.getOnBackground-0d7_KjU() : Color.m1051equalsimpl0(j, colors.getSurface-0d7_KjU()) ? colors.getOnSurface-0d7_KjU() : Color.m1051equalsimpl0(j, colors.getError-0d7_KjU()) ? colors.getOnError-0d7_KjU() : Color.Companion.getUnspecified-0d7_KjU();
            }
            return colors.getOnSecondary-0d7_KjU();
        }
        return colors.getOnPrimary-0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m561contentColorForek8zF_U(long j, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long m560contentColorFor4WTKRHQ = m560contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (!(m560contentColorFor4WTKRHQ != Color.Companion.getUnspecified-0d7_KjU())) {
            m560contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1060unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m560contentColorFor4WTKRHQ;
    }

    @NotNull
    /* renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m562darkColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m563darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long Color = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long Color2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long Color3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        return m562darkColors2qZNXz8(Color, Color2, Color3, (i & 8) != 0 ? Color3 : j4, (i & 16) != 0 ? ColorKt.Color(4279374354L) : j5, (i & 32) != 0 ? ColorKt.Color(4279374354L) : j6, (i & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i & 128) != 0 ? Color.Companion.getBlack-0d7_KjU() : j8, (i & 256) != 0 ? Color.Companion.getBlack-0d7_KjU() : j9, (i & 512) != 0 ? Color.Companion.getWhite-0d7_KjU() : j10, (i & 1024) != 0 ? Color.Companion.getWhite-0d7_KjU() : j11, (i & 2048) != 0 ? Color.Companion.getBlack-0d7_KjU() : j12);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(@NotNull Colors colors) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        return colors.isLight() ? colors.getPrimary-0d7_KjU() : colors.getSurface-0d7_KjU();
    }

    @NotNull
    /* renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m564lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, (DefaultConstructorMarker) null);
    }

    public static final void updateColorsFrom(@NotNull Colors colors, @NotNull Colors colors2) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        Intrinsics.checkNotNullParameter(colors2, "other");
        colors.setPrimary-8_81llA$material_release(colors2.getPrimary-0d7_KjU());
        colors.setPrimaryVariant-8_81llA$material_release(colors2.getPrimaryVariant-0d7_KjU());
        colors.setSecondary-8_81llA$material_release(colors2.getSecondary-0d7_KjU());
        colors.setSecondaryVariant-8_81llA$material_release(colors2.getSecondaryVariant-0d7_KjU());
        colors.setBackground-8_81llA$material_release(colors2.getBackground-0d7_KjU());
        colors.setSurface-8_81llA$material_release(colors2.getSurface-0d7_KjU());
        colors.setError-8_81llA$material_release(colors2.getError-0d7_KjU());
        colors.setOnPrimary-8_81llA$material_release(colors2.getOnPrimary-0d7_KjU());
        colors.setOnSecondary-8_81llA$material_release(colors2.getOnSecondary-0d7_KjU());
        colors.setOnBackground-8_81llA$material_release(colors2.getOnBackground-0d7_KjU());
        colors.setOnSurface-8_81llA$material_release(colors2.getOnSurface-0d7_KjU());
        colors.setOnError-8_81llA$material_release(colors2.getOnError-0d7_KjU());
        colors.setLight$material_release(colors2.isLight());
    }
}
