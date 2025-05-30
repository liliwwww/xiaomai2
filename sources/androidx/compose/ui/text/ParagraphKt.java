package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ParagraphKt {
    public static final int DefaultMaxLines = Integer.MAX_VALUE;

    @Deprecated(message = "Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, spanStyles, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    @NotNull
    public static final Paragraph Paragraph(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z, float f, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return AndroidParagraph_androidKt.ActualParagraph(str, textStyle, list, list2, i, z, f, density, resourceLoader);
    }

    @NotNull
    /* renamed from: Paragraph-UdtVg6A, reason: not valid java name */
    public static final Paragraph m2263ParagraphUdtVg6A(@NotNull String str, @NotNull TextStyle textStyle, long j, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        return AndroidParagraph_androidKt.m2465ActualParagraphO3s9Psw(str, textStyle, list, list2, i, z, j, density, resolver);
    }

    @NotNull
    /* renamed from: Paragraph-_EkL_-Y, reason: not valid java name */
    public static final Paragraph m2265Paragraph_EkL_Y(@NotNull ParagraphIntrinsics paragraphIntrinsics, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m2464ActualParagraphhBUhpc(paragraphIntrinsics, i, z, j);
    }

    /* renamed from: Paragraph-_EkL_-Y$default, reason: not valid java name */
    public static /* synthetic */ Paragraph m2266Paragraph_EkL_Y$default(ParagraphIntrinsics paragraphIntrinsics, long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return m2265Paragraph_EkL_Y(paragraphIntrinsics, j, i, z);
    }

    public static final int ceilToInt(float f) {
        return (int) Math.ceil(f);
    }

    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, spanStyles, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    @NotNull
    public static final Paragraph Paragraph(@NotNull String str, @NotNull TextStyle textStyle, float f, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        return AndroidParagraph_androidKt.m2465ActualParagraphO3s9Psw(str, textStyle, list, list2, i, z, ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, (Object) null), density, resolver);
    }

    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(paragraphIntrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    @NotNull
    public static final Paragraph Paragraph(@NotNull ParagraphIntrinsics paragraphIntrinsics, int i, boolean z, float f) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m2464ActualParagraphhBUhpc(paragraphIntrinsics, i, z, ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, (Object) null));
    }

    public static /* synthetic */ Paragraph Paragraph$default(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Paragraph(paragraphIntrinsics, i, z, f);
    }
}
