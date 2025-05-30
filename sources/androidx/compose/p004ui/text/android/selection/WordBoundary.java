package androidx.compose.p004ui.text.android.selection;

import android.taobao.windvane.config.WVConfigManager;
import androidx.compose.p004ui.text.android.InternalPlatformTextApi;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: classes2.dex */
public final class WordBoundary {
    public static final int $stable = 8;

    @NotNull
    private final WordIterator wordIterator;

    public WordBoundary(@NotNull Locale locale, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(locale, WVConfigManager.CONFIGNAME_LOCALE);
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.wordIterator = new WordIterator(charSequence, 0, charSequence.length(), locale);
    }

    public final int getWordEnd(int i) {
        int punctuationEnd = this.wordIterator.isAfterPunctuation(this.wordIterator.nextBoundary(i)) ? this.wordIterator.getPunctuationEnd(i) : this.wordIterator.getNextWordEndOnTwoWordBoundary(i);
        return punctuationEnd == -1 ? i : punctuationEnd;
    }

    public final int getWordStart(int i) {
        int punctuationBeginning = this.wordIterator.isOnPunctuation(this.wordIterator.prevBoundary(i)) ? this.wordIterator.getPunctuationBeginning(i) : this.wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i);
        return punctuationBeginning == -1 ? i : punctuationBeginning;
    }
}
