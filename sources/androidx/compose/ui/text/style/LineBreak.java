package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@ExperimentalTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LineBreak {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final LineBreak Heading;

    @NotNull
    private static final LineBreak Paragraph;

    @NotNull
    private static final LineBreak Simple;
    private final int strategy;
    private final int strictness;
    private final int wordBreak;

    /* compiled from: Taobao */
    @JvmInline
    public static final class Strategy {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int Simple = m2019constructorimpl(1);
        private static final int HighQuality = m2019constructorimpl(2);
        private static final int Balanced = m2019constructorimpl(3);

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m2018boximpl(int i) {
            return new Strategy(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m2019constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m2020equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m2024unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2021equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2022hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2023toStringimpl(int i) {
            return m2021equalsimpl0(i, Simple) ? "Strategy.Simple" : m2021equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m2021equalsimpl0(i, Balanced) ? "Strategy.Balanced" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m2020equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2022hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m2023toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2024unboximpl() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    public static final class Strictness {

        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int Default = m2026constructorimpl(1);
        private static final int Loose = m2026constructorimpl(2);
        private static final int Normal = m2026constructorimpl(3);
        private static final int Strict = m2026constructorimpl(4);
        private final int value;

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m2025boximpl(int i) {
            return new Strictness(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m2026constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m2027equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m2031unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2028equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2029hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2030toStringimpl(int i) {
            return m2028equalsimpl0(i, Default) ? "Strictness.None" : m2028equalsimpl0(i, Loose) ? "Strictness.Loose" : m2028equalsimpl0(i, Normal) ? "Strictness.Normal" : m2028equalsimpl0(i, Strict) ? "Strictness.Strict" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m2027equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2029hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m2030toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2031unboximpl() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    public static final class WordBreak {

        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int Default = m2033constructorimpl(1);
        private static final int Phrase = m2033constructorimpl(2);
        private final int value;

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m2032boximpl(int i) {
            return new WordBreak(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m2033constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m2034equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m2038unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2035equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2036hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2037toStringimpl(int i) {
            return m2035equalsimpl0(i, Default) ? "WordBreak.None" : m2035equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m2034equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2036hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m2037toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2038unboximpl() {
            return this.value;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Strategy.Companion companion = Strategy.Companion;
        int i = companion.getSimple-fcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int i2 = companion2.getNormal-usljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = new LineBreak(i, i2, companion3.getDefault-jp8hJ3c(), defaultConstructorMarker);
        Heading = new LineBreak(companion.getBalanced-fcGXIks(), companion2.getLoose-usljTpc(), companion3.getPhrase-jp8hJ3c(), defaultConstructorMarker);
        Paragraph = new LineBreak(companion.getHighQuality-fcGXIks(), companion2.getStrict-usljTpc(), companion3.getDefault-jp8hJ3c(), defaultConstructorMarker);
    }

    private LineBreak(int i, int i2, int i3) {
        this.strategy = i;
        this.strictness = i2;
        this.wordBreak = i3;
    }

    public /* synthetic */ LineBreak(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    /* renamed from: copy-vyCVYYw$default, reason: not valid java name */
    public static /* synthetic */ LineBreak m2013copyvyCVYYw$default(LineBreak lineBreak, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = lineBreak.strategy;
        }
        if ((i4 & 2) != 0) {
            i2 = lineBreak.strictness;
        }
        if ((i4 & 4) != 0) {
            i3 = lineBreak.wordBreak;
        }
        return lineBreak.m2014copyvyCVYYw(i, i2, i3);
    }

    @NotNull
    /* renamed from: copy-vyCVYYw, reason: not valid java name */
    public final LineBreak m2014copyvyCVYYw(int i, int i2, int i3) {
        return new LineBreak(i, i2, i3, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineBreak)) {
            return false;
        }
        LineBreak lineBreak = (LineBreak) obj;
        return Strategy.m2021equalsimpl0(this.strategy, lineBreak.strategy) && Strictness.m2028equalsimpl0(this.strictness, lineBreak.strictness) && WordBreak.m2035equalsimpl0(this.wordBreak, lineBreak.wordBreak);
    }

    /* renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public final int m2015getStrategyfcGXIks() {
        return this.strategy;
    }

    /* renamed from: getStrictness-usljTpc, reason: not valid java name */
    public final int m2016getStrictnessusljTpc() {
        return this.strictness;
    }

    /* renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public final int m2017getWordBreakjp8hJ3c() {
        return this.wordBreak;
    }

    public int hashCode() {
        return (((Strategy.m2022hashCodeimpl(this.strategy) * 31) + Strictness.m2029hashCodeimpl(this.strictness)) * 31) + WordBreak.m2036hashCodeimpl(this.wordBreak);
    }

    @NotNull
    public String toString() {
        return "LineBreak(strategy=" + ((Object) Strategy.m2023toStringimpl(this.strategy)) + ", strictness=" + ((Object) Strictness.m2030toStringimpl(this.strictness)) + ", wordBreak=" + ((Object) WordBreak.m2037toStringimpl(this.wordBreak)) + ')';
    }
}
