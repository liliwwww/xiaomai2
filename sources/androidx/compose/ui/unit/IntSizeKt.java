package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.SizeKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i, int i2) {
        return IntSize.constructor-impl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m2198getCenterozmzZPI(long j) {
        return IntOffsetKt.IntOffset(IntSize.getWidth-impl(j) / 2, IntSize.getHeight-impl(j) / 2);
    }

    @Stable
    /* renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m2199getCenterozmzZPI$annotations(long j) {
    }

    @Stable
    /* renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m2200timesO0kMr_c(int i, long j) {
        return IntSize.times-YEO4UFw(j, i);
    }

    @Stable
    @NotNull
    /* renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m2201toIntRectozmzZPI(long j) {
        return IntRectKt.IntRect-VbeCjmY(IntOffset.Companion.getZero-nOcc-ac(), j);
    }

    @Stable
    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m2202toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j));
    }
}
