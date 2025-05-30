package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnnotatedStringKt {

    @NotNull
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String str, @NotNull SpanStyle spanStyle, @Nullable ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        return new AnnotatedString(str, CollectionsKt.listOf(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    @NotNull
    public static final AnnotatedString buildAnnotatedString(@NotNull Function1<? super AnnotatedString.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        function1.invoke(builder);
        return builder.toAnnotatedString();
    }

    @NotNull
    public static final AnnotatedString capitalize(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new capitalize.1(localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i <= i3 && i4 <= i2) {
            if (i2 != i4) {
                return true;
            }
            if ((i3 == i4) == (i == i2)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final AnnotatedString decapitalize(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new decapitalize.1(localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        if (!(i <= i2)) {
            throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + ')').toString());
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends T> range = list.get(i3);
            AnnotatedString.Range<? extends T> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), Math.max(i, range3.getStart()) - i, Math.min(i2, range3.getEnd()) - i, range3.getTag()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends Object>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i2) {
        if (i == i2) {
            return CollectionsKt.emptyList();
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotatedString.getAnnotations$ui_text_release();
        }
        List annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
        ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
        int size = annotations$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = annotations$ui_text_release.get(i3);
            AnnotatedString.Range range = (AnnotatedString.Range) obj;
            if (intersect(i, i2, range.getStart(), range.getEnd())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range2.getItem(), RangesKt.coerceIn(range2.getStart(), i, i2) - i, RangesKt.coerceIn(range2.getEnd(), i, i2) - i, range2.getTag()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        if (i == i2) {
            return CollectionsKt.emptyList();
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotatedString.getParagraphStyles();
        }
        List paragraphStyles = annotatedString.getParagraphStyles();
        ArrayList arrayList = new ArrayList(paragraphStyles.size());
        int size = paragraphStyles.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = paragraphStyles.get(i3);
            AnnotatedString.Range range = (AnnotatedString.Range) obj;
            if (intersect(i, i2, range.getStart(), range.getEnd())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range2.getItem(), RangesKt.coerceIn(range2.getStart(), i, i2) - i, RangesKt.coerceIn(range2.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString annotatedString, int i, int i2) {
        if (i == i2) {
            return CollectionsKt.emptyList();
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotatedString.getSpanStyles();
        }
        List spanStyles = annotatedString.getSpanStyles();
        ArrayList arrayList = new ArrayList(spanStyles.size());
        int size = spanStyles.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = spanStyles.get(i3);
            AnnotatedString.Range range = (AnnotatedString.Range) obj;
            if (intersect(i, i2, range.getStart(), range.getEnd())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range2.getItem(), RangesKt.coerceIn(range2.getStart(), i, i2) - i, RangesKt.coerceIn(range2.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return Math.max(i, i3) < Math.min(i2, i4) || contains(i, i2, i3, i4) || contains(i3, i4, i, i2);
    }

    @NotNull
    public static final <T> List<T> mapEachParagraphStyle(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle paragraphStyle, @NotNull Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "defaultParagraphStyle");
        Intrinsics.checkNotNullParameter(function2, "block");
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<ParagraphStyle> range = normalizedParagraphStyles.get(i);
            arrayList.add(function2.invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    @NotNull
    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "defaultParagraphStyle");
        int length = annotatedString.getText().length();
        List paragraphStyles = annotatedString.getParagraphStyles();
        ArrayList arrayList = new ArrayList();
        int size = paragraphStyles.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) paragraphStyles.get(i);
            ParagraphStyle paragraphStyle2 = (ParagraphStyle) range.component1();
            int component2 = range.component2();
            int component3 = range.component3();
            if (component2 != i2) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, component2));
            }
            arrayList.add(new AnnotatedString.Range(paragraphStyle.merge(paragraphStyle2), component2, component3));
            i++;
            i2 = component3;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String str;
        if (i != i2) {
            str = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "";
        }
        return new AnnotatedString(str, getLocalSpanStyles(annotatedString, i, i2), (List) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final AnnotatedString toLowerCase(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new toLowerCase.1(localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString toUpperCase(@NotNull AnnotatedString annotatedString, @NotNull final LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$toUpperCase$1
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final String invoke(@NotNull String str, int i, int i2) {
                Intrinsics.checkNotNullParameter(str, "str");
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.toUpperCase(substring, LocaleList.this);
            }
        });
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull String str, @NotNull String str2, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "annotation");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return (R) function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStringAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull SpanStyle spanStyle, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(spanStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStyle = builder.pushStyle(spanStyle);
        try {
            return (R) function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull TtsAnnotation ttsAnnotation, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return (R) function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushTtsAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull ParagraphStyle paragraphStyle, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStyle = builder.pushStyle(paragraphStyle);
        try {
            return (R) function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String str, @NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
        return new AnnotatedString(str, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull UrlAnnotation urlAnnotation, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushUrlAnnotation = builder.pushUrlAnnotation(urlAnnotation);
        try {
            return (R) function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushUrlAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }
}
