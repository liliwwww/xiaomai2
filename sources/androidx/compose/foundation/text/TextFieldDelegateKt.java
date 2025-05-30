package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;

    @NotNull
    private static final String EmptyTextReplacement = StringsKt.repeat("H", 10);

    public static final long computeSizeForDefaultText(@NotNull TextStyle textStyle, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull String str, int i) {
        Paragraph m2263ParagraphUdtVg6A;
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(str, "text");
        m2263ParagraphUdtVg6A = ParagraphKt.m2263ParagraphUdtVg6A(str, textStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), density, resolver, (r22 & 32) != 0 ? CollectionsKt.emptyList() : CollectionsKt.emptyList(), (r22 & 64) != 0 ? CollectionsKt.emptyList() : null, (r22 & 128) != 0 ? Integer.MAX_VALUE : i, (r22 & 256) != 0 ? false : false);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m2263ParagraphUdtVg6A.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(m2263ParagraphUdtVg6A.getHeight()));
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i);
    }

    @NotNull
    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }
}
