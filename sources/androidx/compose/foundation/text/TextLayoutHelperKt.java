package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextLayoutHelperKt {
    /* renamed from: canReuse-7_7YC6M, reason: not valid java name */
    public static final boolean m452canReuse7_7YC6M(@NotNull TextLayoutResult textLayoutResult, @NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull FontFamily.Resolver resolver, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "$this$canReuse");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
        if (textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || !Intrinsics.areEqual(layoutInput.getText(), annotatedString) || !layoutInput.getStyle().hasSameLayoutAffectingAttributes(textStyle) || !Intrinsics.areEqual(layoutInput.getPlaceholders(), list) || layoutInput.getMaxLines() != i || layoutInput.getSoftWrap() != z || !TextOverflow.equals-impl0(layoutInput.getOverflow-gIe3tQ8(), i2) || !Intrinsics.areEqual(layoutInput.getDensity(), density) || layoutInput.getLayoutDirection() != layoutDirection || !Intrinsics.areEqual(layoutInput.getFontFamilyResolver(), resolver) || Constraints.m2124getMinWidthimpl(j) != Constraints.m2124getMinWidthimpl(layoutInput.getConstraints-msEJaDk())) {
            return false;
        }
        if (z || TextOverflow.equals-impl0(i2, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
            return Constraints.m2122getMaxWidthimpl(j) == Constraints.m2122getMaxWidthimpl(layoutInput.getConstraints-msEJaDk()) && Constraints.m2121getMaxHeightimpl(j) == Constraints.m2121getMaxHeightimpl(layoutInput.getConstraints-msEJaDk());
        }
        return true;
    }
}
