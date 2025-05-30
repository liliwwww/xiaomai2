package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final SpanStyle m1878invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Color.Companion companion = Color.Companion;
        Saver saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        Color color = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (Color) saver.restore(obj2);
        Intrinsics.checkNotNull(color);
        long m1060unboximpl = color.m1060unboximpl();
        Object obj3 = list.get(1);
        TextUnit.Companion companion2 = TextUnit.Companion;
        TextUnit textUnit = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (TextUnit) SaversKt.getSaver(companion2).restore(obj3);
        Intrinsics.checkNotNull(textUnit);
        long m2222unboximpl = textUnit.m2222unboximpl();
        Object obj4 = list.get(2);
        FontWeight fontWeight = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (FontWeight) SaversKt.getSaver(FontWeight.Companion).restore(obj4);
        Object obj5 = list.get(3);
        FontStyle fontStyle = obj5 != null ? (FontStyle) obj5 : null;
        Object obj6 = list.get(4);
        FontSynthesis fontSynthesis = obj6 != null ? (FontSynthesis) obj6 : null;
        Object obj7 = list.get(6);
        String str = obj7 != null ? (String) obj7 : null;
        Object obj8 = list.get(7);
        TextUnit textUnit2 = (Intrinsics.areEqual(obj8, bool) || obj8 == null) ? null : (TextUnit) SaversKt.getSaver(companion2).restore(obj8);
        Intrinsics.checkNotNull(textUnit2);
        long m2222unboximpl2 = textUnit2.m2222unboximpl();
        Object obj9 = list.get(8);
        BaselineShift baselineShift = (Intrinsics.areEqual(obj9, bool) || obj9 == null) ? null : (BaselineShift) SaversKt.getSaver(BaselineShift.Companion).restore(obj9);
        Object obj10 = list.get(9);
        TextGeometricTransform textGeometricTransform = (Intrinsics.areEqual(obj10, bool) || obj10 == null) ? null : (TextGeometricTransform) SaversKt.getSaver(TextGeometricTransform.Companion).restore(obj10);
        Object obj11 = list.get(10);
        LocaleList localeList = (Intrinsics.areEqual(obj11, bool) || obj11 == null) ? null : (LocaleList) SaversKt.getSaver(LocaleList.Companion).restore(obj11);
        Object obj12 = list.get(11);
        Color color2 = (Intrinsics.areEqual(obj12, bool) || obj12 == null) ? null : (Color) SaversKt.getSaver(companion).restore(obj12);
        Intrinsics.checkNotNull(color2);
        long m1060unboximpl2 = color2.m1060unboximpl();
        Object obj13 = list.get(12);
        TextDecoration textDecoration = (Intrinsics.areEqual(obj13, bool) || obj13 == null) ? null : (TextDecoration) SaversKt.getSaver(TextDecoration.Companion).restore(obj13);
        Object obj14 = list.get(13);
        return new SpanStyle(m1060unboximpl, m2222unboximpl, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, str, m2222unboximpl2, baselineShift, textGeometricTransform, localeList, m1060unboximpl2, textDecoration, (Intrinsics.areEqual(obj14, bool) || obj14 == null) ? null : (Shadow) SaversKt.getSaver(Shadow.Companion).restore(obj14), 32, (DefaultConstructorMarker) null);
    }
}
