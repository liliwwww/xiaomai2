package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BitmapPainter extends Painter {
    private float alpha;

    @Nullable
    private ColorFilter colorFilter;
    private int filterQuality;

    @NotNull
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i & 2) != 0 ? IntOffset.Companion.m2653getZeronOccac() : j, (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2, null);
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j, j2);
    }

    /* renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m1316validateSizeN5eqBDc(long j, long j2) {
        if (IntOffset.m2643getXimpl(j) >= 0 && IntOffset.m2644getYimpl(j) >= 0 && IntSize.m2685getWidthimpl(j2) >= 0 && IntSize.m2684getHeightimpl(j2) >= 0 && IntSize.m2685getWidthimpl(j2) <= this.image.getWidth() && IntSize.m2684getHeightimpl(j2) <= this.image.getHeight()) {
            return j2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m2642equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m2683equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.equals-impl0(this.filterQuality, bitmapPainter.filterQuality);
    }

    /* renamed from: getFilterQuality-f-v9h1I$ui_graphics_release, reason: not valid java name */
    public final int m1317getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1318getIntrinsicSizeNHjbRc() {
        return IntSizeKt.toSize-ozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m2645hashCodeimpl(this.srcOffset)) * 31) + IntSize.m2686hashCodeimpl(this.srcSize)) * 31) + FilterQuality.hashCode-impl(this.filterQuality);
    }

    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        w51.z(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(MathKt.roundToInt(Size.getWidth-impl(drawScope.getSize-NH-jbRc())), MathKt.roundToInt(Size.getHeight-impl(drawScope.getSize-NH-jbRc()))), this.alpha, (DrawStyle) null, this.colorFilter, 0, this.filterQuality, 328, (Object) null);
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m1319setFilterQualityvDHp3xo$ui_graphics_release(int i) {
        this.filterQuality = i;
    }

    @NotNull
    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m2650toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m2688toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.toString-impl(this.filterQuality)) + ')';
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j, long j2) {
        this.image = imageBitmap;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = FilterQuality.Companion.getLow-f-v9h1I();
        this.size = m1316validateSizeN5eqBDc(j, j2);
        this.alpha = 1.0f;
    }
}
