package androidx.compose.ui.text.input;

import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyboardCapitalization {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m2427constructorimpl(0);
    private static final int Characters = m2427constructorimpl(1);
    private static final int Words = m2427constructorimpl(2);
    private static final int Sentences = m2427constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getCharacters-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2433getCharactersIUNYP9k$annotations() {
        }

        @Stable
        /* renamed from: getNone-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2434getNoneIUNYP9k$annotations() {
        }

        @Stable
        /* renamed from: getSentences-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2435getSentencesIUNYP9k$annotations() {
        }

        @Stable
        /* renamed from: getWords-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m2436getWordsIUNYP9k$annotations() {
        }

        /* renamed from: getCharacters-IUNYP9k, reason: not valid java name */
        public final int m2437getCharactersIUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        /* renamed from: getNone-IUNYP9k, reason: not valid java name */
        public final int m2438getNoneIUNYP9k() {
            return KeyboardCapitalization.None;
        }

        /* renamed from: getSentences-IUNYP9k, reason: not valid java name */
        public final int m2439getSentencesIUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }

        /* renamed from: getWords-IUNYP9k, reason: not valid java name */
        public final int m2440getWordsIUNYP9k() {
            return KeyboardCapitalization.Words;
        }
    }

    private /* synthetic */ KeyboardCapitalization(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardCapitalization m2426boximpl(int i) {
        return new KeyboardCapitalization(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2427constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2428equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardCapitalization) && i == ((KeyboardCapitalization) obj).m2432unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2429equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2430hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2431toStringimpl(int i) {
        return m2429equalsimpl0(i, None) ? "None" : m2429equalsimpl0(i, Characters) ? "Characters" : m2429equalsimpl0(i, Words) ? "Words" : m2429equalsimpl0(i, Sentences) ? "Sentences" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2428equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2430hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2431toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2432unboximpl() {
        return this.value;
    }
}
