package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AnnotatedString implements CharSequence {

    @NotNull
    private final List<Range<? extends Object>> annotations;

    @NotNull
    private final List<Range<ParagraphStyle>> paragraphStyles;

    @NotNull
    private final List<Range<SpanStyle>> spanStyles;

    @NotNull
    private final String text;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Builder implements Appendable {
        public static final int $stable = 8;

        @NotNull
        private final List<MutableRange<? extends Object>> annotations;

        @NotNull
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;

        @NotNull
        private final List<MutableRange<SpanStyle>> spanStyles;

        @NotNull
        private final List<MutableRange<? extends Object>> styleStack;

        @NotNull
        private final StringBuilder text;

        public Builder() {
            this(0, 1, null);
        }

        public Builder(int i) {
            this.text = new StringBuilder(i);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addStringAnnotation(@NotNull String str, @NotNull String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "annotation");
            this.annotations.add(new MutableRange<>(str2, i, i2, str));
        }

        public final void addStyle(@NotNull SpanStyle spanStyle, int i, int i2) {
            Intrinsics.checkNotNullParameter(spanStyle, "style");
            this.spanStyles.add(new MutableRange<>(spanStyle, i, i2, null, 8, null));
        }

        @ExperimentalTextApi
        public final void addTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation, int i, int i2) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            this.annotations.add(new MutableRange<>(ttsAnnotation, i, i2, null, 8, null));
        }

        @ExperimentalTextApi
        public final void addUrlAnnotation(@NotNull UrlAnnotation urlAnnotation, int i, int i2) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            this.annotations.add(new MutableRange<>(urlAnnotation, i, i2, null, 8, null));
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void pop() {
            if (!(!this.styleStack.isEmpty())) {
                throw new IllegalStateException("Nothing to pop.".toString());
            }
            this.styleStack.remove(r0.size() - 1).setEnd(this.text.length());
        }

        public final int pushStringAnnotation(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "annotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(str2, this.text.length(), 0, str, 4, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(@NotNull SpanStyle spanStyle) {
            Intrinsics.checkNotNullParameter(spanStyle, "style");
            MutableRange<SpanStyle> mutableRange = new MutableRange<>(spanStyle, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(ttsAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @ExperimentalTextApi
        public final int pushUrlAnnotation(@NotNull UrlAnnotation urlAnnotation) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(urlAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @NotNull
        public final AnnotatedString toAnnotatedString() {
            String sb = this.text.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "text.toString()");
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i).toRange(this.text.length()));
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(list2.get(i2).toRange(this.text.length()));
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                arrayList3.add(list3.get(i3).toRange(this.text.length()));
            }
            return new AnnotatedString(sb, arrayList, arrayList2, arrayList3);
        }

        public final void addStyle(@NotNull ParagraphStyle paragraphStyle, int i, int i2) {
            Intrinsics.checkNotNullParameter(paragraphStyle, "style");
            this.paragraphStyles.add(new MutableRange<>(paragraphStyle, i, i2, null, 8, null));
        }

        public final void append(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text.append(str);
        }

        /* compiled from: Taobao */
        private static final class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;

            @NotNull
            private final String tag;

            public MutableRange(T t, int i, int i2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "tag");
                this.item = t;
                this.start = i;
                this.end = i2;
                this.tag = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, Object obj, int i, int i2, String str, int i3, Object obj2) {
                if ((i3 & 1) != 0) {
                    obj = mutableRange.item;
                }
                if ((i3 & 2) != 0) {
                    i = mutableRange.start;
                }
                if ((i3 & 4) != 0) {
                    i2 = mutableRange.end;
                }
                if ((i3 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(obj, i, i2, str);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i);
            }

            public final T component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            @NotNull
            public final String component4() {
                return this.tag;
            }

            @NotNull
            public final MutableRange<T> copy(T t, int i, int i2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "tag");
                return new MutableRange<>(t, i, i2, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public final int getEnd() {
                return this.end;
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            @NotNull
            public final String getTag() {
                return this.tag;
            }

            public int hashCode() {
                T t = this.item;
                return ((((((t == null ? 0 : t.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            }

            public final void setEnd(int i) {
                this.end = i;
            }

            @NotNull
            public final Range<T> toRange(int i) {
                int i2 = this.end;
                if (i2 != Integer.MIN_VALUE) {
                    i = i2;
                }
                if (i != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, i, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }

            @NotNull
            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public /* synthetic */ MutableRange(Object obj, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i, (i3 & 4) != 0 ? Integer.MIN_VALUE : i2, (i3 & 8) != 0 ? "" : str);
            }
        }

        public final void pop(int i) {
            if (i < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= i) {
                    pop();
                }
            } else {
                throw new IllegalStateException((i + " should be less than " + this.styleStack.size()).toString());
            }
        }

        public final int pushStyle(@NotNull ParagraphStyle paragraphStyle) {
            Intrinsics.checkNotNullParameter(paragraphStyle, "style");
            MutableRange<ParagraphStyle> mutableRange = new MutableRange<>(paragraphStyle, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(@Nullable CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence);
            } else {
                this.text.append(charSequence);
            }
            return this;
        }

        public /* synthetic */ Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull String str) {
            this(0, 1, null);
            Intrinsics.checkNotNullParameter(str, "text");
            append(str);
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(@Nullable CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence, i, i2);
            } else {
                this.text.append(charSequence, i, i2);
            }
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull AnnotatedString annotatedString) {
            this(0, 1, null);
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(@NotNull AnnotatedString annotatedString) {
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            int length = this.text.length();
            this.text.append(annotatedString.getText());
            List<Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
            int size = spanStyles.size();
            for (int i = 0; i < size; i++) {
                Range<SpanStyle> range = spanStyles.get(i);
                addStyle(range.getItem(), range.getStart() + length, range.getEnd() + length);
            }
            List<Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
            int size2 = paragraphStyles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Range<ParagraphStyle> range2 = paragraphStyles.get(i2);
                addStyle(range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
            }
            List<Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
            int size3 = annotations$ui_text_release.size();
            for (int i3 = 0; i3 < size3; i3++) {
                Range<? extends Object> range3 = annotations$ui_text_release.get(i3);
                this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
            }
        }

        public final void append(@NotNull AnnotatedString annotatedString, int i, int i2) {
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            int length = this.text.length();
            this.text.append((CharSequence) annotatedString.getText(), i, i2);
            List access$getLocalSpanStyles = AnnotatedStringKt.access$getLocalSpanStyles(annotatedString, i, i2);
            int size = access$getLocalSpanStyles.size();
            for (int i3 = 0; i3 < size; i3++) {
                Range range = (Range) access$getLocalSpanStyles.get(i3);
                addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
            }
            List access$getLocalParagraphStyles = AnnotatedStringKt.access$getLocalParagraphStyles(annotatedString, i, i2);
            int size2 = access$getLocalParagraphStyles.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Range range2 = (Range) access$getLocalParagraphStyles.get(i4);
                addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
            }
            List access$getLocalAnnotations = AnnotatedStringKt.access$getLocalAnnotations(annotatedString, i, i2);
            int size3 = access$getLocalAnnotations.size();
            for (int i5 = 0; i5 < size3; i5++) {
                Range range3 = (Range) access$getLocalAnnotations.get(i5);
                this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(@NotNull String str, @NotNull List<Range<SpanStyle>> list, @NotNull List<Range<ParagraphStyle>> list2, @NotNull List<? extends Range<? extends Object>> list3) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "paragraphStyles");
        Intrinsics.checkNotNullParameter(list3, "annotations");
        this.text = str;
        this.spanStyles = list;
        this.paragraphStyles = list2;
        this.annotations = list3;
        List sortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t).getStart()), Integer.valueOf(((AnnotatedString.Range) t2).getStart()));
            }
        });
        int size = sortedWith.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            Range range = (Range) sortedWith.get(i2);
            if (!(range.getStart() >= i)) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
            }
            if (!(range.getEnd() <= this.text.length())) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + ", " + range.getEnd() + ") is out of boundary").toString());
            }
            i = range.getEnd();
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStyles, annotatedString.spanStyles) && Intrinsics.areEqual(this.paragraphStyles, annotatedString.paragraphStyles) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public char get(int i) {
        return this.text.charAt(i);
    }

    @NotNull
    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    @NotNull
    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        return this.paragraphStyles;
    }

    @NotNull
    public final List<Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Range<? extends Object> range = list.get(i3);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof String) && Intrinsics.areEqual(str, range2.getTag()) && AnnotatedStringKt.intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<Range<TtsAnnotation>> getTtsAnnotations(int i, int i2) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Range<? extends Object> range = list.get(i3);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @ExperimentalTextApi
    @NotNull
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int i, int i2) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Range<? extends Object> range = list.get(i3);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.spanStyles.hashCode()) * 31) + this.paragraphStyles.hashCode()) * 31) + this.annotations.hashCode();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    @Stable
    @NotNull
    public final AnnotatedString plus(@NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "other");
        Builder builder = new Builder(this);
        builder.append(annotatedString);
        return builder.toAnnotatedString();
    }

    @NotNull
    /* renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m2254subSequence5zctL8(long j) {
        return subSequence(TextRange.m2328getMinimpl(j), TextRange.m2327getMaximpl(j));
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    @NotNull
    public AnnotatedString subSequence(int i, int i2) {
        if (i <= i2) {
            if (i == 0 && i2 == this.text.length()) {
                return this;
            }
            String substring = this.text.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, AnnotatedStringKt.access$filterRanges(this.spanStyles, i, i2), AnnotatedStringKt.access$filterRanges(this.paragraphStyles, i, i2), AnnotatedStringKt.access$filterRanges(this.annotations, i, i2));
        }
        throw new IllegalArgumentException(("start (" + i + ") should be less or equal to end (" + i2 + ')').toString());
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class Range<T> {
        private final int end;
        private final T item;
        private final int start;

        @NotNull
        private final String tag;

        public Range(T t, int i, int i2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            this.item = t;
            this.start = i;
            this.end = i2;
            this.tag = str;
            if (!(i <= i2)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Object obj, int i, int i2, String str, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                obj = range.item;
            }
            if ((i3 & 2) != 0) {
                i = range.start;
            }
            if ((i3 & 4) != 0) {
                i2 = range.end;
            }
            if ((i3 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(obj, i, i2, str);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        @NotNull
        public final String component4() {
            return this.tag;
        }

        @NotNull
        public final Range<T> copy(T t, int i, int i2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Range<>(t, i, i2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t = this.item;
            return ((((((t == null ? 0 : t.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        }

        @NotNull
        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T t, int i, int i2) {
            this(t, i, i2, "");
        }
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(int i, int i2) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Range<? extends Object> range = list.get(i3);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof String) && AnnotatedStringKt.intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnotatedString(@NotNull String str, @NotNull List<Range<SpanStyle>> list, @NotNull List<Range<ParagraphStyle>> list2) {
        this(str, list, list2, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "paragraphStyles");
    }
}
