package androidx.compose.p004ui.graphics.painter;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.FilterQuality;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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
        this(imageBitmap, (i & 2) != 0 ? IntOffset.Companion.m5344getZeronOccac() : j, (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2, null);
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j, j2);
    }

    /* renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m3296validateSizeN5eqBDc(long j, long j2) {
        if (IntOffset.m5334getXimpl(j) >= 0 && IntOffset.m5335getYimpl(j) >= 0 && IntSize.m5376getWidthimpl(j2) >= 0 && IntSize.m5375getHeightimpl(j2) >= 0 && IntSize.m5376getWidthimpl(j2) <= this.image.getWidth() && IntSize.m5375getHeightimpl(j2) <= this.image.getHeight()) {
            return j2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
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
        return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m5333equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m5374equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m2877equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
    }

    /* renamed from: getFilterQuality-f-v9h1I$ui_graphics_release, reason: not valid java name */
    public final int m3297getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo3298getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m5386toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m5336hashCodeimpl(this.srcOffset)) * 31) + IntSize.m5377hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m2878hashCodeimpl(this.filterQuality);
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        w51.z(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(MathKt.roundToInt(Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc())), MathKt.roundToInt(Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc()))), this.alpha, (DrawStyle) null, this.colorFilter, 0, this.filterQuality, 328, (Object) null);
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m3299setFilterQualityvDHp3xo$ui_graphics_release(int i) {
        this.filterQuality = i;
    }

    @NotNull
    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m5341toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m5379toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m2879toStringimpl(this.filterQuality)) + ')';
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j, long j2) {
        this.image = imageBitmap;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = FilterQuality.Companion.m2882getLowfv9h1I();
        this.size = m3296validateSizeN5eqBDc(j, j2);
        this.alpha = 1.0f;
    }
}
