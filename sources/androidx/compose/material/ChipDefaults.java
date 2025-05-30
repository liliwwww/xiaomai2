package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;

    @NotNull
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m2142constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m2142constructorimpl(1);
    private static final float LeadingIconSize = Dp.m2142constructorimpl(20);
    private static final float SelectedIconSize = Dp.m2142constructorimpl(18);

    private ChipDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m549chipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        long j7;
        long j8;
        composer.startReplaceableGroup(1838505436);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j7 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(materialTheme.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j7 = j;
        }
        long m1049copywmQWz5c$default = (i2 & 2) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m1049copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            j8 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(materialTheme2.getColors(composer, 6).getOnSurface-0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j8 = j4;
        }
        long m1049copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m1049copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, i, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:383)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(j7, m1049copywmQWz5c$default, m1049copywmQWz5c$default2, j8, m1049copywmQWz5c$default3, m1049copywmQWz5c$default4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    @Composable
    @NotNull
    /* renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m550filterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, @Nullable Composer composer, int i, int i2) {
        long j10;
        long j11;
        composer.startReplaceableGroup(830140629);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j10 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(materialTheme.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j10 = j;
        }
        long m1049copywmQWz5c$default = (i2 & 2) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m1049copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            j11 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(materialTheme2.getColors(composer, 6).getOnSurface-0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j11 = j4;
        }
        long m1049copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m1049copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m1065compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), j10) : j7;
        long m1065compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m1049copywmQWz5c$default) : j8;
        long m1065compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m1049copywmQWz5c$default2) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, i, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:453)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(j10, m1049copywmQWz5c$default, m1049copywmQWz5c$default2, j11, m1049copywmQWz5c$default3, m1049copywmQWz5c$default4, m1065compositeOverOWjLjI, m1065compositeOverOWjLjI2, m1065compositeOverOWjLjI3, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m551getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m552getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    @Composable
    @JvmName(name = "getOutlinedBorder")
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1650225597);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, i, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:541)");
        }
        BorderStroke m124BorderStrokecXLIe8U = BorderStrokeKt.m124BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m124BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m553getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m554getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @Composable
    @NotNull
    /* renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m555outlinedChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1763922662);
        long j7 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU() : j;
        long m1049copywmQWz5c$default = (i2 & 2) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m1049copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j8 = (i2 & 8) != 0 ? j7 : j4;
        long m1049copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m1049copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:419)");
        }
        ChipColors m549chipColors5tl4gsc = m549chipColors5tl4gsc(j7, m1049copywmQWz5c$default, m1049copywmQWz5c$default2, j8, m1049copywmQWz5c$default3, m1049copywmQWz5c$default4, composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (i & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m549chipColors5tl4gsc;
    }

    @Composable
    @NotNull
    /* renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m556outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(346878099);
        long j10 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU() : j;
        long m1049copywmQWz5c$default = (i2 & 2) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m1049copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j11 = (i2 & 8) != 0 ? j10 : j4;
        long m1049copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m1049copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m1049copywmQWz5c$default(m1049copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m1065compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), j10) : j7;
        long m1065compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m1049copywmQWz5c$default) : j8;
        long m1065compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m1049copywmQWz5c$default2) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, i, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:504)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(j10, m1049copywmQWz5c$default, m1049copywmQWz5c$default2, j11, m1049copywmQWz5c$default3, m1049copywmQWz5c$default4, m1065compositeOverOWjLjI, m1065compositeOverOWjLjI2, m1065compositeOverOWjLjI3, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }
}
