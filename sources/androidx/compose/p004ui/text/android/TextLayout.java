package androidx.compose.p004ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p004ui.text.android.style.BaselineShiftSpan;
import androidx.compose.p004ui.text.android.style.IndentationFixSpanKt;
import androidx.compose.p004ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: classes.dex */
public final class TextLayout {
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;

    @Nullable
    private final Paint.FontMetricsInt lastLineFontMetrics;

    @NotNull
    private final Layout layout;

    @NotNull
    private final Lazy layoutHelper$delegate;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;

    @NotNull
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final float rightPadding;

    @NotNull
    private final TextAndroidCanvas textCanvas;
    private final int topPadding;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        @NotNull
        public final StaticLayout constructStaticLayout(@NotNull CharSequence charSequence, int i, @NotNull TextPaint textPaint, int i2, int i3, int i4, int i5) {
            StaticLayout create;
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            create = StaticLayoutFactory.INSTANCE.create(charSequence, (r47 & 2) != 0 ? 0 : 0, (r47 & 4) != 0 ? charSequence.length() : 0, textPaint, i, (r47 & 32) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release() : null, (r47 & 64) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text_release() : null, (r47 & 128) != 0 ? Integer.MAX_VALUE : 0, (r47 & 256) != 0 ? null : null, (r47 & 512) != 0 ? i : 0, (r47 & 1024) != 0 ? 1.0f : 0.0f, (r47 & 2048) != 0 ? 0.0f : 0.0f, (r47 & 4096) != 0 ? 0 : 0, (r47 & 8192) != 0 ? false : false, (r47 & 16384) != 0, (32768 & r47) != 0 ? 0 : i4, (65536 & r47) != 0 ? 0 : i3, (131072 & r47) != 0 ? 0 : i5, (262144 & r47) != 0 ? 0 : i2, (524288 & r47) != 0 ? null : null, (r47 & 1048576) != 0 ? null : null);
            return create;
        }
    }

    public TextLayout(@NotNull CharSequence charSequence, float f, @NotNull TextPaint textPaint, int i, @Nullable TextUtils.TruncateAt truncateAt, int i2, float f2, @Px float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, @Nullable int[] iArr, @Nullable int[] iArr2, @NotNull LayoutIntrinsics layoutIntrinsics) {
        TextDirectionHeuristic textDirectionHeuristic;
        Layout create;
        Pair verticalPaddings;
        LineHeightStyleSpan[] lineHeightSpans;
        Pair lineHeightPaddings;
        Pair lastLineMetrics;
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(layoutIntrinsics, "layoutIntrinsics");
        this.includePadding = z;
        this.fallbackLineSpacing = z2;
        this.layoutIntrinsics = layoutIntrinsics;
        this.textCanvas = new TextAndroidCanvas();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayoutKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i);
        boolean z3 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
            double d = f;
            int ceil = (int) Math.ceil(d);
            if (boringMetrics == null || layoutIntrinsics.getMaxIntrinsicWidth() > f || z3) {
                this.isBoringLayout = false;
                textDirectionHeuristic = textDirectionHeuristic2;
                create = StaticLayoutFactory.INSTANCE.create(charSequence, 0, charSequence.length(), textPaint, ceil, textDirectionHeuristic2, alignment, i3, truncateAt, (int) Math.ceil(d), f2, f3, i8, z, z2, i4, i5, i6, i7, iArr, iArr2);
            } else {
                this.isBoringLayout = true;
                create = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, ceil, boringMetrics, alignment, z, z2, truncateAt, ceil);
                textDirectionHeuristic = textDirectionHeuristic2;
            }
            this.layout = create;
            Trace.endSection();
            int min = Math.min(create.getLineCount(), i3);
            this.lineCount = min;
            this.didExceedMaxLines = min >= i3 && (create.getEllipsisCount(min + (-1)) > 0 || create.getLineEnd(min + (-1)) != charSequence.length());
            verticalPaddings = TextLayoutKt.getVerticalPaddings(this);
            lineHeightSpans = TextLayoutKt.getLineHeightSpans(this);
            this.lineHeightSpans = lineHeightSpans;
            lineHeightPaddings = TextLayoutKt.getLineHeightPaddings(this, lineHeightSpans);
            this.topPadding = Math.max(((Number) verticalPaddings.getFirst()).intValue(), ((Number) lineHeightPaddings.getFirst()).intValue());
            this.bottomPadding = Math.max(((Number) verticalPaddings.getSecond()).intValue(), ((Number) lineHeightPaddings.getSecond()).intValue());
            lastLineMetrics = TextLayoutKt.getLastLineMetrics(this, textPaint, textDirectionHeuristic, lineHeightSpans);
            this.lastLineFontMetrics = (Paint.FontMetricsInt) lastLineMetrics.getFirst();
            this.lastLineExtra = ((Number) lastLineMetrics.getSecond()).intValue();
            this.leftPadding = IndentationFixSpanKt.getEllipsizedLeftPadding$default(create, min - 1, null, 2, null);
            this.rightPadding = IndentationFixSpanKt.getEllipsizedRightPadding$default(create, min - 1, null, 2, null);
            this.layoutHelper$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<LayoutHelper>() { // from class: androidx.compose.ui.text.android.TextLayout$layoutHelper$2
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final LayoutHelper m4779invoke() {
                    return new LayoutHelper(TextLayout.this.getLayout());
                }
            });
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    private final float getHorizontalPadding(int i) {
        if (i == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    @VisibleForTesting
    public static /* synthetic */ void getLayout$annotations() {
    }

    private final LayoutHelper getLayoutHelper() {
        return (LayoutHelper) this.layoutHelper$delegate.getValue();
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getPrimaryHorizontal(i, z);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getSecondaryHorizontal(i, z);
    }

    @VisibleForTesting
    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    public final void fillBoundingBoxes(int i, int i2, @NotNull float[] fArr, int i3) {
        float secondaryDownstream;
        float secondaryUpstream;
        Intrinsics.checkNotNullParameter(fArr, "array");
        int length = getText().length();
        int i4 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
        if (!(i < length)) {
            throw new IllegalArgumentException("startOffset must be less than text length".toString());
        }
        if (!(i2 > i)) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
        }
        if (!(i2 <= length)) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
        }
        if (!(fArr.length - i3 >= (i2 - i) * 4)) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
        }
        int lineForOffset = getLineForOffset(i);
        int lineForOffset2 = getLineForOffset(i2 - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        int i5 = lineForOffset;
        int i6 = i3;
        while (true) {
            int lineStart = getLineStart(i5);
            int lineEnd = getLineEnd(i5);
            int min = Math.min(i2, lineEnd);
            float lineTop = getLineTop(i5);
            float lineBottom = getLineBottom(i5);
            boolean z = getParagraphDirection(i5) == i4;
            boolean z2 = !z;
            for (int max = Math.max(i, lineStart); max < min; max++) {
                boolean isRtlCharAt = isRtlCharAt(max);
                if (z && !isRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(max);
                    secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(max + 1);
                } else if (z && isRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(max);
                    secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(max + 1);
                } else if (z2 && isRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(max);
                    secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(max + 1);
                } else {
                    secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(max);
                    secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(max + 1);
                }
                fArr[i6] = secondaryDownstream;
                fArr[i6 + 1] = lineTop;
                fArr[i6 + 2] = secondaryUpstream;
                fArr[i6 + 3] = lineBottom;
                i6 += 4;
            }
            if (i5 == lineForOffset2) {
                return;
            }
            i5++;
            i4 = 1;
        }
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    @NotNull
    public final RectF getBoundingBox(int i) {
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        int lineForOffset = getLineForOffset(i);
        float lineTop = getLineTop(lineForOffset);
        float lineBottom = getLineBottom(lineForOffset);
        boolean z = getParagraphDirection(lineForOffset) == 1;
        boolean isRtlCharAt = this.layout.isRtlCharAt(i);
        if (!z || isRtlCharAt) {
            if (z && isRtlCharAt) {
                primaryHorizontal = getSecondaryHorizontal(i, false);
                primaryHorizontal2 = getSecondaryHorizontal(i + 1, true);
            } else if (isRtlCharAt) {
                primaryHorizontal = getPrimaryHorizontal(i, false);
                primaryHorizontal2 = getPrimaryHorizontal(i + 1, true);
            } else {
                secondaryHorizontal = getSecondaryHorizontal(i, false);
                secondaryHorizontal2 = getSecondaryHorizontal(i + 1, true);
            }
            float f = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f;
        } else {
            secondaryHorizontal = getPrimaryHorizontal(i, false);
            secondaryHorizontal2 = getPrimaryHorizontal(i + 1, true);
        }
        return new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        return (this.didExceedMaxLines ? this.layout.getLineBottom(this.lineCount - 1) : this.layout.getHeight()) + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        return (i != this.lineCount + (-1) || (fontMetricsInt = this.lastLineFontMetrics) == null) ? this.layout.getLineAscent(i) : fontMetricsInt.ascent;
    }

    public final float getLineBaseline(int i) {
        return this.topPadding + ((i != this.lineCount + (-1) || this.lastLineFontMetrics == null) ? this.layout.getLineBaseline(i) : getLineTop(i) - this.lastLineFontMetrics.ascent);
    }

    public final float getLineBottom(int i) {
        if (i != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            return this.topPadding + this.layout.getLineBottom(i) + (i == this.lineCount + (-1) ? this.bottomPadding : 0);
        }
        return this.layout.getLineBottom(i - 1) + this.lastLineFontMetrics.bottom;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        return (i != this.lineCount + (-1) || (fontMetricsInt = this.lastLineFontMetrics) == null) ? this.layout.getLineDescent(i) : fontMetricsInt.descent;
    }

    public final int getLineEllipsisCount(int i) {
        return this.layout.getEllipsisCount(i);
    }

    public final int getLineEllipsisOffset(int i) {
        return this.layout.getEllipsisStart(i);
    }

    public final int getLineEnd(int i) {
        return this.layout.getEllipsisStart(i) == 0 ? this.layout.getLineEnd(i) : this.layout.getText().length();
    }

    public final int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    public final int getLineForVertical(int i) {
        return this.layout.getLineForVertical(this.topPadding + i);
    }

    public final float getLineHeight(int i) {
        return getLineBottom(i) - getLineTop(i);
    }

    @NotNull
    public final LineHeightStyleSpan[] getLineHeightSpans() {
        return this.lineHeightSpans;
    }

    public final float getLineLeft(int i) {
        return this.layout.getLineLeft(i) + (i == this.lineCount + (-1) ? this.leftPadding : 0.0f);
    }

    public final float getLineRight(int i) {
        return this.layout.getLineRight(i) + (i == this.lineCount + (-1) ? this.rightPadding : 0.0f);
    }

    public final int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    public final float getLineTop(int i) {
        return this.layout.getLineTop(i) + (i == 0 ? 0 : this.topPadding);
    }

    public final int getLineVisibleEnd(int i) {
        if (this.layout.getEllipsisStart(i) == 0) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getEllipsisStart(i) + this.layout.getLineStart(i);
    }

    public final float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int i, float f) {
        return this.layout.getOffsetForHorizontal(i, f + ((-1) * getHorizontalPadding(i)));
    }

    public final int getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(i);
    }

    public final float getPrimaryHorizontal(int i, boolean z) {
        return getLayoutHelper().getHorizontalPosition(i, true, z) + getHorizontalPadding(getLineForOffset(i));
    }

    public final float getSecondaryHorizontal(int i, boolean z) {
        return getLayoutHelper().getHorizontalPosition(i, false, z) + getHorizontalPadding(getLineForOffset(i));
    }

    public final void getSelectionPath(int i, int i2, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dest");
        this.layout.getSelectionPath(i, i2, path);
        if (this.topPadding == 0 || path.isEmpty()) {
            return;
        }
        path.offset(0.0f, this.topPadding);
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "layout.text");
        return text;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout = this.layout;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout2 = this.layout;
        Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout2, this.fallbackLineSpacing);
    }

    public final boolean isLineEllipsized(int i) {
        return TextLayoutKt.isLineEllipsized(this.layout, i);
    }

    public final boolean isRtlCharAt(int i) {
        return this.layout.isRtlCharAt(i);
    }

    public final void paint(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i = this.topPadding;
        if (i != 0) {
            canvas.translate(0.0f, i);
        }
        this.textCanvas.setCanvas(canvas);
        this.layout.draw(this.textCanvas);
        int i2 = this.topPadding;
        if (i2 != 0) {
            canvas.translate(0.0f, (-1) * i2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ TextLayout(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, float r30, float r31, boolean r32, boolean r33, int r34, int r35, int r36, int r37, int r38, int r39, int[] r40, int[] r41, androidx.compose.p004ui.text.android.LayoutIntrinsics r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], androidx.compose.ui.text.android.LayoutIntrinsics, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
