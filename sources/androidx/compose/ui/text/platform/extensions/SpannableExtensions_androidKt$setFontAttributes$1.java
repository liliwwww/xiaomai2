package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SpannableExtensions_androidKt$setFontAttributes$1 extends Lambda implements Function3<SpanStyle, Integer, Integer, Unit> {
    final /* synthetic */ Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> $resolveTypeface;
    final /* synthetic */ Spannable $this_setFontAttributes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SpannableExtensions_androidKt$setFontAttributes$1(Spannable spannable, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        super(3);
        this.$this_setFontAttributes = spannable;
        this.$resolveTypeface = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SpanStyle spanStyle, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Spannable spannable = this.$this_setFontAttributes;
        Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function4 = this.$resolveTypeface;
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontStyle fontStyle = spanStyle.getFontStyle-4Lr2A7w();
        FontStyle m1924boximpl = FontStyle.m1924boximpl(fontStyle != null ? fontStyle.m1930unboximpl() : FontStyle.Companion.getNormal-_-LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis-ZQGJjVo();
        spannable.setSpan(new TypefaceSpan((Typeface) function4.invoke(fontFamily, fontWeight, m1924boximpl, FontSynthesis.box-impl(fontSynthesis != null ? fontSynthesis.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU()))), i, i2, 33);
    }
}
