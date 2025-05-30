package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i, int i2) {
        return IntSize.m5371constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m5382getCenterozmzZPI(long j) {
        return IntOffsetKt.IntOffset(IntSize.m5376getWidthimpl(j) / 2, IntSize.m5375getHeightimpl(j) / 2);
    }

    @Stable
    /* renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m5383getCenterozmzZPI$annotations(long j) {
    }

    @Stable
    /* renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m5384timesO0kMr_c(int i, long j) {
        return IntSize.m5378timesYEO4UFw(j, i);
    }

    @Stable
    @NotNull
    /* renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m5385toIntRectozmzZPI(long j) {
        return IntRectKt.m5366IntRectVbeCjmY(IntOffset.Companion.m5344getZeronOccac(), j);
    }

    @Stable
    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m5386toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m5376getWidthimpl(j), IntSize.m5375getHeightimpl(j));
    }
}
