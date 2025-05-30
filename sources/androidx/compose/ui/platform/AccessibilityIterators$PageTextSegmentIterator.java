package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityIterators$PageTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {

    @Nullable
    private static AccessibilityIterators$PageTextSegmentIterator pageInstance;
    private TextLayoutResult layoutResult;
    private SemanticsNode node;

    @NotNull
    private Rect tempRect;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;

    @NotNull
    private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AccessibilityIterators$PageTextSegmentIterator getInstance() {
            if (AccessibilityIterators$PageTextSegmentIterator.pageInstance == null) {
                AccessibilityIterators$PageTextSegmentIterator.pageInstance = new AccessibilityIterators$PageTextSegmentIterator(null);
            }
            AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator = AccessibilityIterators$PageTextSegmentIterator.pageInstance;
            Intrinsics.checkNotNull(accessibilityIterators$PageTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return accessibilityIterators$PageTextSegmentIterator;
        }
    }

    private AccessibilityIterators$PageTextSegmentIterator() {
        this.tempRect = new Rect();
    }

    public /* synthetic */ AccessibilityIterators$PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int getLineEdgeIndex(int i, ResolvedTextDirection resolvedTextDirection) {
        TextLayoutResult textLayoutResult = this.layoutResult;
        TextLayoutResult textLayoutResult2 = null;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult = null;
        }
        int lineStart = textLayoutResult.getLineStart(i);
        TextLayoutResult textLayoutResult3 = this.layoutResult;
        if (textLayoutResult3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult3 = null;
        }
        if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
            TextLayoutResult textLayoutResult4 = this.layoutResult;
            if (textLayoutResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            } else {
                textLayoutResult2 = textLayoutResult4;
            }
            return textLayoutResult2.getLineStart(i);
        }
        TextLayoutResult textLayoutResult5 = this.layoutResult;
        if (textLayoutResult5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult5 = null;
        }
        return TextLayoutResult.getLineEnd$default(textLayoutResult5, i, false, 2, null) - 1;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    @Nullable
    public int[] following(int i) {
        int lineCount;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() <= 0 || i >= getText().length()) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                semanticsNode = null;
            }
            int roundToInt = MathKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
            int coerceAtLeast = RangesKt.coerceAtLeast(0, i);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult2 = null;
            }
            int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtLeast);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            float lineTop = textLayoutResult3.getLineTop(lineForOffset) + roundToInt;
            TextLayoutResult textLayoutResult4 = this.layoutResult;
            if (textLayoutResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult4 = null;
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                TextLayoutResult textLayoutResult6 = this.layoutResult;
                if (textLayoutResult6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult6;
                }
                lineCount = textLayoutResult.getLineForVerticalPosition(lineTop);
            } else {
                TextLayoutResult textLayoutResult7 = this.layoutResult;
                if (textLayoutResult7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult7;
                }
                lineCount = textLayoutResult.getLineCount();
            }
            return getRange(coerceAtLeast, getLineEdgeIndex(lineCount - 1, DirectionEnd) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final void initialize(@NotNull String str, @NotNull TextLayoutResult textLayoutResult, @NotNull SemanticsNode semanticsNode) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textLayoutResult, "layoutResult");
        Intrinsics.checkNotNullParameter(semanticsNode, "node");
        setText(str);
        this.layoutResult = textLayoutResult;
        this.node = semanticsNode;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    @Nullable
    public int[] preceding(int i) {
        int i2;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() <= 0 || i <= 0) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                semanticsNode = null;
            }
            int roundToInt = MathKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
            int coerceAtMost = RangesKt.coerceAtMost(getText().length(), i);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult2 = null;
            }
            int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtMost);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            float lineTop = textLayoutResult3.getLineTop(lineForOffset) - roundToInt;
            if (lineTop > 0.0f) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult4;
                }
                i2 = textLayoutResult.getLineForVerticalPosition(lineTop);
            } else {
                i2 = 0;
            }
            if (coerceAtMost == getText().length() && i2 < lineForOffset) {
                i2++;
            }
            return getRange(getLineEdgeIndex(i2, DirectionStart), coerceAtMost);
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
