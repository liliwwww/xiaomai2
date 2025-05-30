package androidx.compose.p004ui.text;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextDirection;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.text.style.TextIndent;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.p004ui.unit.TextUnitType;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SaversKt {

    @NotNull
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull AnnotatedString annotatedString) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(annotatedString, "it");
            List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
            saver = SaversKt.AnnotationRangeListSaver;
            List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
            saver2 = SaversKt.AnnotationRangeListSaver;
            List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
            saver3 = SaversKt.AnnotationRangeListSaver;
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(annotatedString.getText()), SaversKt.save(spanStyles, saver, saverScope), SaversKt.save(paragraphStyles, saver2, saverScope), SaversKt.save(annotations$ui_text_release, saver3, saverScope)});
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnnotatedString m4676invoke(@NotNull Object obj) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            List list2 = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            saver = SaversKt.AnnotationRangeListSaver;
            Boolean bool = Boolean.FALSE;
            List list3 = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (List) saver.restore(obj3);
            Intrinsics.checkNotNull(list3);
            Object obj4 = list.get(2);
            saver2 = SaversKt.AnnotationRangeListSaver;
            List list4 = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (List) saver2.restore(obj4);
            Intrinsics.checkNotNull(list4);
            Object obj5 = list.get(3);
            saver3 = SaversKt.AnnotationRangeListSaver;
            if (!Intrinsics.areEqual(obj5, bool) && obj5 != null) {
                list2 = (List) saver3.restore(obj5);
            }
            Intrinsics.checkNotNull(list2);
            return new AnnotatedString(str, list3, list4, list2);
        }
    });

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

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
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
        public final AnnotatedString.Range<? extends Object> m4678invoke(@NotNull Object obj) {
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
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull VerbatimTtsAnnotation verbatimTtsAnnotation) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(verbatimTtsAnnotation, "it");
            return SaversKt.save(verbatimTtsAnnotation.getVerbatim());
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final VerbatimTtsAnnotation m4699invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new VerbatimTtsAnnotation((String) obj);
        }
    });

    @NotNull
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull UrlAnnotation urlAnnotation) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(urlAnnotation, "it");
            return SaversKt.save(urlAnnotation.getUrl());
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UrlAnnotation m4698invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new UrlAnnotation((String) obj);
        }
    });

    @NotNull
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull ParagraphStyle paragraphStyle) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(paragraphStyle, "it");
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(paragraphStyle.m4653getTextAlignbuA522U()), SaversKt.save(paragraphStyle.m4654getTextDirectionmmuk1to()), SaversKt.save(TextUnit.m5387boximpl(paragraphStyle.m4652getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), saverScope)});
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ParagraphStyle m4688invoke(@NotNull Object obj) {
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
            long m5406unboximpl = restore.m5406unboximpl();
            Object obj5 = list.get(3);
            return new ParagraphStyle(textAlign, textDirection, m5406unboximpl, (Intrinsics.areEqual(obj5, bool) || obj5 == null) ? null : SaversKt.getSaver(TextIndent.Companion).restore(obj5), null);
        }
    });

    @NotNull
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull SpanStyle spanStyle) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(spanStyle, "it");
            Color m2777boximpl = Color.m2777boximpl(spanStyle.m4710getColor0d7_KjU());
            Color.Companion companion = Color.Companion;
            TextUnit m5387boximpl = TextUnit.m5387boximpl(spanStyle.m4711getFontSizeXSAIIZE());
            TextUnit.Companion companion2 = TextUnit.Companion;
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(m2777boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(m5387boximpl, SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), saverScope), SaversKt.save(spanStyle.m4712getFontStyle4Lr2A7w()), SaversKt.save(spanStyle.m4713getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m5387boximpl(spanStyle.m4714getLetterSpacingXSAIIZE()), SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.m4709getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), saverScope), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), saverScope), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), saverScope), SaversKt.save(Color.m2777boximpl(spanStyle.m4708getBackground0d7_KjU()), SaversKt.getSaver(companion), saverScope), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), saverScope), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.Companion), saverScope)});
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SpanStyle m4690invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Color.Companion companion = Color.Companion;
            Saver<Color, Object> saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            Color restore = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
            Intrinsics.checkNotNull(restore);
            long m2797unboximpl = restore.m2797unboximpl();
            Object obj3 = list.get(1);
            TextUnit.Companion companion2 = TextUnit.Companion;
            TextUnit restore2 = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : SaversKt.getSaver(companion2).restore(obj3);
            Intrinsics.checkNotNull(restore2);
            long m5406unboximpl = restore2.m5406unboximpl();
            Object obj4 = list.get(2);
            FontWeight restore3 = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : SaversKt.getSaver(FontWeight.Companion).restore(obj4);
            Object obj5 = list.get(3);
            FontStyle fontStyle = obj5 != null ? (FontStyle) obj5 : null;
            Object obj6 = list.get(4);
            FontSynthesis fontSynthesis = obj6 != null ? (FontSynthesis) obj6 : null;
            Object obj7 = list.get(6);
            String str = obj7 != null ? (String) obj7 : null;
            Object obj8 = list.get(7);
            TextUnit restore4 = (Intrinsics.areEqual(obj8, bool) || obj8 == null) ? null : SaversKt.getSaver(companion2).restore(obj8);
            Intrinsics.checkNotNull(restore4);
            long m5406unboximpl2 = restore4.m5406unboximpl();
            Object obj9 = list.get(8);
            BaselineShift restore5 = (Intrinsics.areEqual(obj9, bool) || obj9 == null) ? null : SaversKt.getSaver(BaselineShift.Companion).restore(obj9);
            Object obj10 = list.get(9);
            TextGeometricTransform restore6 = (Intrinsics.areEqual(obj10, bool) || obj10 == null) ? null : SaversKt.getSaver(TextGeometricTransform.Companion).restore(obj10);
            Object obj11 = list.get(10);
            LocaleList restore7 = (Intrinsics.areEqual(obj11, bool) || obj11 == null) ? null : SaversKt.getSaver(LocaleList.Companion).restore(obj11);
            Object obj12 = list.get(11);
            Color restore8 = (Intrinsics.areEqual(obj12, bool) || obj12 == null) ? null : SaversKt.getSaver(companion).restore(obj12);
            Intrinsics.checkNotNull(restore8);
            long m2797unboximpl2 = restore8.m2797unboximpl();
            Object obj13 = list.get(12);
            TextDecoration restore9 = (Intrinsics.areEqual(obj13, bool) || obj13 == null) ? null : SaversKt.getSaver(TextDecoration.Companion).restore(obj13);
            Object obj14 = list.get(13);
            return new SpanStyle(m2797unboximpl, m5406unboximpl, restore3, fontStyle, fontSynthesis, (FontFamily) null, str, m5406unboximpl2, restore5, restore6, restore7, m2797unboximpl2, restore9, (Intrinsics.areEqual(obj14, bool) || obj14 == null) ? null : SaversKt.getSaver(Shadow.Companion).restore(obj14), 32, (DefaultConstructorMarker) null);
        }
    });

    @NotNull
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull TextDecoration textDecoration) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(textDecoration, "it");
            return Integer.valueOf(textDecoration.getMask());
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextDecoration m4691invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new TextDecoration(((Integer) obj).intValue());
        }
    });

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
        public final TextGeometricTransform m4692invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });

    @NotNull
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull TextIndent textIndent) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(textIndent, "it");
            TextUnit m5387boximpl = TextUnit.m5387boximpl(textIndent.m5103getFirstLineXSAIIZE());
            TextUnit.Companion companion = TextUnit.Companion;
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(m5387boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(TextUnit.m5387boximpl(textIndent.m5104getRestLineXSAIIZE()), SaversKt.getSaver(companion), saverScope)});
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextIndent m4693invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextUnit.Companion companion = TextUnit.Companion;
            Saver<TextUnit, Object> saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = null;
            TextUnit restore = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
            Intrinsics.checkNotNull(restore);
            long m5406unboximpl = restore.m5406unboximpl();
            Object obj3 = list.get(1);
            Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion);
            if (!Intrinsics.areEqual(obj3, bool) && obj3 != null) {
                textUnit = saver2.restore(obj3);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(m5406unboximpl, textUnit.m5406unboximpl(), null);
        }
    });

    @NotNull
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull FontWeight fontWeight) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(fontWeight, "it");
            return Integer.valueOf(fontWeight.getWeight());
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FontWeight m4683invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return new FontWeight(((Integer) obj).intValue());
        }
    });

    @NotNull
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m4679invoke8a2Sb4w((SaverScope) obj, ((BaselineShift) obj2).m4994unboximpl());
        }

        @Nullable
        /* renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m4679invoke8a2Sb4w(@NotNull SaverScope saverScope, float f) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return Float.valueOf(f);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Nullable
        /* renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return BaselineShift.m4988boximpl(BaselineShift.m4989constructorimpl(((Float) obj).floatValue()));
        }
    });

    @NotNull
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m4694invokeFDrldGo((SaverScope) obj, ((TextRange) obj2).m4753unboximpl());
        }

        @Nullable
        /* renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m4694invokeFDrldGo(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return CollectionsKt.arrayListOf(new Integer[]{(Integer) SaversKt.save(Integer.valueOf(TextRange.m4749getStartimpl(j))), (Integer) SaversKt.save(Integer.valueOf(TextRange.m4744getEndimpl(j)))});
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
            return TextRange.m4737boximpl(TextRangeKt.TextRange(intValue, num2.intValue()));
        }
    });

    @NotNull
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull Shadow shadow) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(shadow, "it");
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Color.m2777boximpl(shadow.m3072getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope), SaversKt.save(Offset.m2545boximpl(shadow.m3073getOffsetF1C5BW0()), SaversKt.getSaver(Offset.Companion), saverScope), SaversKt.save(Float.valueOf(shadow.getBlurRadius()))});
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Shadow m4689invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
            Boolean bool = Boolean.FALSE;
            Color restore = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
            Intrinsics.checkNotNull(restore);
            long m2797unboximpl = restore.m2797unboximpl();
            Object obj3 = list.get(1);
            Offset restore2 = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : SaversKt.getSaver(Offset.Companion).restore(obj3);
            Intrinsics.checkNotNull(restore2);
            long m2566unboximpl = restore2.m2566unboximpl();
            Object obj4 = list.get(2);
            Float f = obj4 != null ? (Float) obj4 : null;
            Intrinsics.checkNotNull(f);
            return new Shadow(m2797unboximpl, m2566unboximpl, f.floatValue(), null);
        }
    });

    @NotNull
    private static final Saver<Color, Object> ColorSaver = SaverKt.Saver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m4681invoke4WTKRHQ((SaverScope) obj, ((Color) obj2).m2797unboximpl());
        }

        @Nullable
        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m4681invoke4WTKRHQ(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return ULong.box-impl(j);
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Nullable
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return Color.m2777boximpl(Color.m2783constructorimpl(((ULong) obj).unbox-impl()));
        }
    });

    @NotNull
    private static final Saver<TextUnit, Object> TextUnitSaver = SaverKt.Saver(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m4696invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m5406unboximpl());
        }

        @Nullable
        /* renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m4696invokempE4wyQ(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Float.valueOf(TextUnit.m5397getValueimpl(j))), SaversKt.save(TextUnitType.m5422boximpl(TextUnit.m5396getTypeUIouoOA(j)))});
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Nullable
        /* renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextUnit invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj3 = list.get(1);
            TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m5387boximpl(TextUnitKt.m5409TextUnitanM5pPY(floatValue, textUnitType.m5428unboximpl()));
        }
    });

    @NotNull
    private static final Saver<Offset, Object> OffsetSaver = SaverKt.Saver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m4686invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).m2566unboximpl());
        }

        @Nullable
        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m4686invokeUv8p0NA(@NotNull SaverScope saverScope, long j) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            return Offset.m2553equalsimpl0(j, Offset.Companion.m2571getUnspecifiedF1C5BW0()) ? Boolean.FALSE : CollectionsKt.arrayListOf(new Float[]{(Float) SaversKt.save(Float.valueOf(Offset.m2556getXimpl(j))), (Float) SaversKt.save(Float.valueOf(Offset.m2557getYimpl(j)))});
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Nullable
        /* renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Offset.m2545boximpl(Offset.Companion.m2571getUnspecifiedF1C5BW0());
            }
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj3 = list.get(1);
            Float f2 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f2);
            return Offset.m2545boximpl(OffsetKt.Offset(floatValue, f2.floatValue()));
        }
    });

    @NotNull
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Nullable
        public final Object invoke(@NotNull SaverScope saverScope, @NotNull LocaleList localeList) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
            Intrinsics.checkNotNullParameter(localeList, "it");
            List<Locale> localeList2 = localeList.getLocaleList();
            ArrayList arrayList = new ArrayList(localeList2.size());
            int size = localeList2.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(SaversKt.save(localeList2.get(i), SaversKt.getSaver(Locale.Companion), saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LocaleList m4684invoke(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                Saver<Locale, Object> saver = SaversKt.getSaver(Locale.Companion);
                Locale locale = null;
                if (!Intrinsics.areEqual(obj2, Boolean.FALSE) && obj2 != null) {
                    locale = saver.restore(obj2);
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });

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
        public final Locale m4685invoke(@NotNull Object obj) {
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
    public static final Saver<FontWeight, Object> getSaver(@NotNull FontWeight.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return FontWeightSaver;
    }

    @NotNull
    public static final Saver<BaselineShift, Object> getSaver(@NotNull BaselineShift.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
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
    public static final Saver<Color, Object> getSaver(@NotNull Color.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ColorSaver;
    }

    @NotNull
    public static final Saver<TextUnit, Object> getSaver(@NotNull TextUnit.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextUnitSaver;
    }

    @NotNull
    public static final Saver<Offset, Object> getSaver(@NotNull Offset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
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
