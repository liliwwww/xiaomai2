package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@ExperimentalTextApi
/* loaded from: classes.dex */
public final class LineBreak {

    @NotNull
    public static final Companion Companion;

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
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LineBreak getHeading() {
            return LineBreak.Heading;
        }

        @NotNull
        public final LineBreak getParagraph() {
            return LineBreak.Paragraph;
        }

        @NotNull
        public final LineBreak getSimple() {
            return LineBreak.Simple;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    public static final class Strategy {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Simple = m5013constructorimpl(1);
        private static final int HighQuality = m5013constructorimpl(2);
        private static final int Balanced = m5013constructorimpl(3);

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m5019getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m5020getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m5021getSimplefcGXIks() {
                return Strategy.Simple;
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m5012boximpl(int i) {
            return new Strategy(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m5013constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5014equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m5018unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5015equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5016hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5017toStringimpl(int i) {
            return m5015equalsimpl0(i, Simple) ? "Strategy.Simple" : m5015equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m5015equalsimpl0(i, Balanced) ? "Strategy.Balanced" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5014equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5016hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5017toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5018unboximpl() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    public static final class Strictness {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Default = m5023constructorimpl(1);
        private static final int Loose = m5023constructorimpl(2);
        private static final int Normal = m5023constructorimpl(3);
        private static final int Strict = m5023constructorimpl(4);
        private final int value;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m5029getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m5030getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m5031getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m5032getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m5022boximpl(int i) {
            return new Strictness(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m5023constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5024equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m5028unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5025equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5026hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5027toStringimpl(int i) {
            return m5025equalsimpl0(i, Default) ? "Strictness.None" : m5025equalsimpl0(i, Loose) ? "Strictness.Loose" : m5025equalsimpl0(i, Normal) ? "Strictness.Normal" : m5025equalsimpl0(i, Strict) ? "Strictness.Strict" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5024equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5026hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5027toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5028unboximpl() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    public static final class WordBreak {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Default = m5034constructorimpl(1);
        private static final int Phrase = m5034constructorimpl(2);
        private final int value;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m5040getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m5041getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m5033boximpl(int i) {
            return new WordBreak(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m5034constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5035equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m5039unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5036equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5037hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5038toStringimpl(int i) {
            return m5036equalsimpl0(i, Default) ? "WordBreak.None" : m5036equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5035equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5037hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5038toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5039unboximpl() {
            return this.value;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Strategy.Companion companion = Strategy.Companion;
        int m5021getSimplefcGXIks = companion.m5021getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int m5031getNormalusljTpc = companion2.m5031getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = new LineBreak(m5021getSimplefcGXIks, m5031getNormalusljTpc, companion3.m5040getDefaultjp8hJ3c(), defaultConstructorMarker);
        Heading = new LineBreak(companion.m5019getBalancedfcGXIks(), companion2.m5030getLooseusljTpc(), companion3.m5041getPhrasejp8hJ3c(), defaultConstructorMarker);
        Paragraph = new LineBreak(companion.m5020getHighQualityfcGXIks(), companion2.m5032getStrictusljTpc(), companion3.m5040getDefaultjp8hJ3c(), defaultConstructorMarker);
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
    public static /* synthetic */ LineBreak m5007copyvyCVYYw$default(LineBreak lineBreak, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = lineBreak.strategy;
        }
        if ((i4 & 2) != 0) {
            i2 = lineBreak.strictness;
        }
        if ((i4 & 4) != 0) {
            i3 = lineBreak.wordBreak;
        }
        return lineBreak.m5008copyvyCVYYw(i, i2, i3);
    }

    @NotNull
    /* renamed from: copy-vyCVYYw, reason: not valid java name */
    public final LineBreak m5008copyvyCVYYw(int i, int i2, int i3) {
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
        return Strategy.m5015equalsimpl0(this.strategy, lineBreak.strategy) && Strictness.m5025equalsimpl0(this.strictness, lineBreak.strictness) && WordBreak.m5036equalsimpl0(this.wordBreak, lineBreak.wordBreak);
    }

    /* renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public final int m5009getStrategyfcGXIks() {
        return this.strategy;
    }

    /* renamed from: getStrictness-usljTpc, reason: not valid java name */
    public final int m5010getStrictnessusljTpc() {
        return this.strictness;
    }

    /* renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public final int m5011getWordBreakjp8hJ3c() {
        return this.wordBreak;
    }

    public int hashCode() {
        return (((Strategy.m5016hashCodeimpl(this.strategy) * 31) + Strictness.m5026hashCodeimpl(this.strictness)) * 31) + WordBreak.m5037hashCodeimpl(this.wordBreak);
    }

    @NotNull
    public String toString() {
        return "LineBreak(strategy=" + ((Object) Strategy.m5017toStringimpl(this.strategy)) + ", strictness=" + ((Object) Strictness.m5027toStringimpl(this.strictness)) + ", wordBreak=" + ((Object) WordBreak.m5038toStringimpl(this.wordBreak)) + ')';
    }
}
