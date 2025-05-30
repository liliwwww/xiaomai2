package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset$Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color$Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight$Companion;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShift$Companion;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SaversKt {

    @NotNull
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(AnnotatedStringSaver.1.INSTANCE, AnnotatedStringSaver.2.INSTANCE);

    @NotNull
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull List<? extends AnnotatedString.Range<? extends Object>> list) {
            Saver saver;
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(list, "it");
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<? extends Object> range = list.get(i);
                saver = SaversKt.AnnotationRangeSaver;
                arrayList.add(SaversKt.save(range, saver, saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Nullable
        public final List<AnnotatedString.Range<? extends Object>> invoke(@NotNull Object obj) {
            Saver saver;
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                saver = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if (!Intrinsics.areEqual(obj2, Boolean.FALSE) && obj2 != null) {
                    range = (AnnotatedString.Range) saver.restore(obj2);
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });

    @NotNull
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull AnnotatedString.Range<? extends Object> range) {
            Object save;
            Saver saver;
            Saver saver2;
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(range, "it");
            Object item = range.getItem();
            AnnotationType annotationType = item instanceof ParagraphStyle ? AnnotationType.Paragraph : item instanceof SpanStyle ? AnnotationType.Span : item instanceof VerbatimTtsAnnotation ? AnnotationType.VerbatimTts : item instanceof UrlAnnotation ? AnnotationType.Url : AnnotationType.String;
            int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (i == 1) {
                Object item2 = range.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                save = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), saverScope);
            } else if (i == 2) {
                Object item3 = range.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                save = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), saverScope);
            } else if (i == 3) {
                Object item4 = range.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                saver = SaversKt.VerbatimTtsAnnotationSaver;
                save = SaversKt.save((VerbatimTtsAnnotation) item4, saver, saverScope);
            } else if (i == 4) {
                Object item5 = range.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                saver2 = SaversKt.UrlAnnotationSaver;
                save = SaversKt.save((UrlAnnotation) item5, saver2, saverScope);
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                save = SaversKt.save(range.getItem());
            }
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(annotationType), save, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag())});
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* compiled from: Taobao */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnnotatedString.Range<? extends Object> m2279invoke(@NotNull Object obj) {
            Saver saver;
            Saver saver2;
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.checkNotNull(annotationType);
            Object obj3 = list.get(2);
            Integer num = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj4 = list.get(3);
            Integer num2 = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            Object obj5 = list.get(4);
            String str = obj5 != null ? (String) obj5 : null;
            Intrinsics.checkNotNull(str);
            int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (i == 1) {
                Object obj6 = list.get(1);
                Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
                if (!Intrinsics.areEqual(obj6, Boolean.FALSE) && obj6 != null) {
                    r1 = paragraphStyleSaver.restore(obj6);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
            }
            if (i == 2) {
                Object obj7 = list.get(1);
                Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
                if (!Intrinsics.areEqual(obj7, Boolean.FALSE) && obj7 != null) {
                    r1 = spanStyleSaver.restore(obj7);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
            }
            if (i == 3) {
                Object obj8 = list.get(1);
                saver = SaversKt.VerbatimTtsAnnotationSaver;
                if (!Intrinsics.areEqual(obj8, Boolean.FALSE) && obj8 != null) {
                    r1 = (VerbatimTtsAnnotation) saver.restore(obj8);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
            }
            if (i != 4) {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                Object obj9 = list.get(1);
                r1 = obj9 != null ? (String) obj9 : null;
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
            }
            Object obj10 = list.get(1);
            saver2 = SaversKt.UrlAnnotationSaver;
            if (!Intrinsics.areEqual(obj10, Boolean.FALSE) && obj10 != null) {
                r1 = (UrlAnnotation) saver2.restore(obj10);
            }
            Intrinsics.checkNotNull(r1);
            return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
        }
    });

    @NotNull
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(VerbatimTtsAnnotationSaver.1.INSTANCE, VerbatimTtsAnnotationSaver.2.INSTANCE);

    @NotNull
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(UrlAnnotationSaver.1.INSTANCE, UrlAnnotationSaver.2.INSTANCE);

    @NotNull
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull ParagraphStyle paragraphStyle) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(paragraphStyle, "it");
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(paragraphStyle.m2274getTextAlignbuA522U()), SaversKt.save(paragraphStyle.m2275getTextDirectionmmuk1to()), SaversKt.save(TextUnit.box-impl(paragraphStyle.m2273getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), saverScope)});
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ParagraphStyle m2285invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
            Object obj3 = list.get(1);
            TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
            Object obj4 = list.get(2);
            Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
            Boolean bool = Boolean.FALSE;
            TextUnit restore = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : saver.restore(obj4);
            Intrinsics.checkNotNull(restore);
            long j = restore.unbox-impl();
            Object obj5 = list.get(3);
            return new ParagraphStyle(textAlign, textDirection, j, (Intrinsics.areEqual(obj5, bool) || obj5 == null) ? null : SaversKt.getSaver(TextIndent.Companion).restore(obj5), null);
        }
    });

    @NotNull
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(SpanStyleSaver.1.INSTANCE, SpanStyleSaver.2.INSTANCE);

    @NotNull
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(TextDecorationSaver.1.INSTANCE, TextDecorationSaver.2.INSTANCE);

    @NotNull
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull TextGeometricTransform textGeometricTransform) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(textGeometricTransform, "it");
            return CollectionsKt.arrayListOf(new Float[]{Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX())});
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextGeometricTransform m2286invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });

    @NotNull
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(TextIndentSaver.1.INSTANCE, TextIndentSaver.2.INSTANCE);

    @NotNull
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(FontWeightSaver.1.INSTANCE, FontWeightSaver.2.INSTANCE);

    @NotNull
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2280invoke8a2Sb4w((SaverScope) obj, ((BaselineShift) obj2).unbox-impl());
        }

        @Nullable
        /* renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m2280invoke8a2Sb4w(@NotNull SaverScope saverScope, float f) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return Float.valueOf(f);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Nullable
        /* renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return BaselineShift.box-impl(BaselineShift.constructor-impl(((Float) obj).floatValue()));
        }
    });

    @NotNull
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2287invokeFDrldGo((SaverScope) obj, ((TextRange) obj2).m2334unboximpl());
        }

        @Nullable
        /* renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m2287invokeFDrldGo(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return CollectionsKt.arrayListOf(new Integer[]{(Integer) SaversKt.save(Integer.valueOf(TextRange.m2330getStartimpl(j))), (Integer) SaversKt.save(Integer.valueOf(TextRange.m2325getEndimpl(j)))});
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Nullable
        /* renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextRange invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num2);
            return TextRange.m2318boximpl(TextRangeKt.TextRange(intValue, num2.intValue()));
        }
    });

    @NotNull
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(ShadowSaver.1.INSTANCE, ShadowSaver.2.INSTANCE);

    @NotNull
    private static final Saver<Color, Object> ColorSaver = SaverKt.Saver(ColorSaver.1.INSTANCE, ColorSaver.2.INSTANCE);

    @NotNull
    private static final Saver<TextUnit, Object> TextUnitSaver = SaverKt.Saver(TextUnitSaver.1.INSTANCE, TextUnitSaver.2.INSTANCE);

    @NotNull
    private static final Saver<Offset, Object> OffsetSaver = SaverKt.Saver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m2283invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).unbox-impl());
        }

        @Nullable
        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m2283invokeUv8p0NA(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return Offset.equals-impl0(j, Offset.Companion.m1023getUnspecifiedF1C5BW0()) ? Boolean.FALSE : CollectionsKt.arrayListOf(new Float[]{(Float) SaversKt.save(Float.valueOf(Offset.getX-impl(j))), (Float) SaversKt.save(Float.valueOf(Offset.getY-impl(j)))});
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Nullable
        /* renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Offset.box-impl(Offset.Companion.m1023getUnspecifiedF1C5BW0());
            }
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj3 = list.get(1);
            Float f2 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f2);
            return Offset.box-impl(OffsetKt.Offset(floatValue, f2.floatValue()));
        }
    });

    @NotNull
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(LocaleListSaver.1.INSTANCE, LocaleListSaver.2.INSTANCE);

    @NotNull
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull Locale locale) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(locale, "it");
            return locale.toLanguageTag();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Locale m2282invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new Locale((String) obj);
        }
    });

    @NotNull
    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    @NotNull
    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    @NotNull
    public static final Saver<TextDecoration, Object> getSaver(@NotNull TextDecoration.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextDecorationSaver;
    }

    @NotNull
    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    private static /* synthetic */ void getTextUnitSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        Intrinsics.checkNotNullParameter(t, "saver");
        if (Intrinsics.areEqual(saveable, Boolean.FALSE) || saveable == null) {
            return null;
        }
        Result result = (Result) t.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        return result;
    }

    @Nullable
    public static final <T> T save(@Nullable T t) {
        return t;
    }

    @NotNull
    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(@Nullable Original original, @NotNull T t, @NotNull SaverScope saverScope) {
        Object save;
        Intrinsics.checkNotNullParameter(t, "saver");
        Intrinsics.checkNotNullParameter(saverScope, "scope");
        return (original == null || (save = t.save(saverScope, original)) == null) ? Boolean.FALSE : save;
    }

    @NotNull
    public static final Saver<TextGeometricTransform, Object> getSaver(@NotNull TextGeometricTransform.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextGeometricTransformSaver;
    }

    @NotNull
    public static final Saver<TextIndent, Object> getSaver(@NotNull TextIndent.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextIndentSaver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        return obj;
    }

    @NotNull
    public static final Saver<FontWeight, Object> getSaver(@NotNull FontWeight$Companion fontWeight$Companion) {
        Intrinsics.checkNotNullParameter(fontWeight$Companion, "<this>");
        return FontWeightSaver;
    }

    @NotNull
    public static final Saver<BaselineShift, Object> getSaver(@NotNull BaselineShift$Companion baselineShift$Companion) {
        Intrinsics.checkNotNullParameter(baselineShift$Companion, "<this>");
        return BaselineShiftSaver;
    }

    @NotNull
    public static final Saver<TextRange, Object> getSaver(@NotNull TextRange.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextRangeSaver;
    }

    @NotNull
    public static final Saver<Shadow, Object> getSaver(@NotNull Shadow.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ShadowSaver;
    }

    @NotNull
    public static final Saver<Color, Object> getSaver(@NotNull Color$Companion color$Companion) {
        Intrinsics.checkNotNullParameter(color$Companion, "<this>");
        return ColorSaver;
    }

    @NotNull
    public static final Saver<TextUnit, Object> getSaver(@NotNull TextUnit.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextUnitSaver;
    }

    @NotNull
    public static final Saver<Offset, Object> getSaver(@NotNull Offset$Companion offset$Companion) {
        Intrinsics.checkNotNullParameter(offset$Companion, "<this>");
        return OffsetSaver;
    }

    @NotNull
    public static final Saver<LocaleList, Object> getSaver(@NotNull LocaleList.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return LocaleListSaver;
    }

    @NotNull
    public static final Saver<Locale, Object> getSaver(@NotNull Locale.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return LocaleSaver;
    }
}
