package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 8;
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    public LineHeightStyleSpan(float f, int i, int i2, boolean z, boolean z2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lineHeight = f;
        this.startIndex = i;
        this.endIndex = i2;
        this.trimFirstLineTop = z;
        this.trimLastLineBottom = z2;
        this.topRatio = f2;
        boolean z3 = true;
        if (!(0.0f <= f2 && f2 <= 1.0f)) {
            if (!(f2 == -1.0f)) {
                z3 = false;
            }
        }
        if (!z3) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        int ceil = (int) Math.ceil(this.lineHeight);
        int lineHeight = ceil - LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        float f = this.topRatio;
        if (f == -1.0f) {
            f = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        }
        int ceil2 = (int) (lineHeight <= 0 ? Math.ceil(lineHeight * f) : Math.ceil(lineHeight * (1.0f - f)));
        int i = fontMetricsInt.descent;
        int i2 = ceil2 + i;
        this.descent = i2;
        int i3 = i2 - ceil;
        this.ascent = i3;
        if (this.trimFirstLineTop) {
            i3 = fontMetricsInt.ascent;
        }
        this.firstAscent = i3;
        if (this.trimLastLineBottom) {
            i2 = i;
        }
        this.lastDescent = i2;
        this.firstAscentDiff = fontMetricsInt.ascent - i3;
        this.lastDescentDiff = i2 - i;
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text_release$default(LineHeightStyleSpan lineHeightStyleSpan, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text_release(i, i2, z);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@NotNull CharSequence charSequence, int i, int i2, int i3, int i4, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (LineHeightStyleSpanKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z = i == this.startIndex;
        boolean z2 = i2 == this.endIndex;
        if (z && z2 && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (z) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z2 ? this.lastDescent : this.descent;
    }

    @NotNull
    public final LineHeightStyleSpan copy$ui_text_release(int i, int i2, boolean z) {
        return new LineHeightStyleSpan(this.lineHeight, i, i2, z, this.trimLastLineBottom, this.topRatio);
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }
}
