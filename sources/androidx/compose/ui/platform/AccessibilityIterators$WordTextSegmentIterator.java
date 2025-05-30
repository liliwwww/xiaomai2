package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityIterators$WordTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {

    @Nullable
    private static AccessibilityIterators$WordTextSegmentIterator instance;
    private BreakIterator impl;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int $stable = 8;

    private AccessibilityIterators$WordTextSegmentIterator(Locale locale) {
        onLocaleChanged(locale);
    }

    public /* synthetic */ AccessibilityIterators$WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final boolean isEndBoundary(int i) {
        return i > 0 && isLetterOrDigit(i + (-1)) && (i == getText().length() || !isLetterOrDigit(i));
    }

    private final boolean isLetterOrDigit(int i) {
        if (i < 0 || i >= getText().length()) {
            return false;
        }
        return Character.isLetterOrDigit(getText().codePointAt(i));
    }

    private final boolean isStartBoundary(int i) {
        return isLetterOrDigit(i) && (i == 0 || !isLetterOrDigit(i - 1));
    }

    private final void onLocaleChanged(Locale locale) {
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
        this.impl = wordInstance;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    @Nullable
    public int[] following(int i) {
        if (getText().length() <= 0 || i >= getText().length()) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        while (!isLetterOrDigit(i) && !isStartBoundary(i)) {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            i = breakIterator.following(i);
            if (i == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator2 = null;
        }
        int following = breakIterator2.following(i);
        if (following == -1 || !isEndBoundary(following)) {
            return null;
        }
        return getRange(i, following);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
    public void initialize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        super.initialize(str);
        BreakIterator breakIterator = this.impl;
        if (breakIterator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    @Nullable
    public int[] preceding(int i) {
        int length = getText().length();
        if (length <= 0 || i <= 0) {
            return null;
        }
        if (i > length) {
            i = length;
        }
        while (i > 0 && !isLetterOrDigit(i - 1) && !isEndBoundary(i)) {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            i = breakIterator.preceding(i);
            if (i == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator2 = null;
        }
        int preceding = breakIterator2.preceding(i);
        if (preceding == -1 || !isStartBoundary(preceding)) {
            return null;
        }
        return getRange(preceding, i);
    }
}
