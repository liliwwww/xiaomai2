package androidx.compose.foundation.text;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.p004ui.text.TextLayoutInput;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextLayoutHelperKt {
    /* renamed from: canReuse-7_7YC6M, reason: not valid java name */
    public static final boolean m1807canReuse7_7YC6M(@NotNull TextLayoutResult textLayoutResult, @NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull FontFamily.Resolver resolver, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "$this$canReuse");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
        if (textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || !Intrinsics.areEqual(layoutInput.getText(), annotatedString) || !layoutInput.getStyle().hasSameLayoutAffectingAttributes(textStyle) || !Intrinsics.areEqual(layoutInput.getPlaceholders(), list) || layoutInput.getMaxLines() != i || layoutInput.getSoftWrap() != z || !TextOverflow.m5121equalsimpl0(layoutInput.m4720getOverflowgIe3tQ8(), i2) || !Intrinsics.areEqual(layoutInput.getDensity(), density) || layoutInput.getLayoutDirection() != layoutDirection || !Intrinsics.areEqual(layoutInput.getFontFamilyResolver(), resolver) || Constraints.m5186getMinWidthimpl(j) != Constraints.m5186getMinWidthimpl(layoutInput.m4719getConstraintsmsEJaDk())) {
            return false;
        }
        if (z || TextOverflow.m5121equalsimpl0(i2, TextOverflow.Companion.m5129getEllipsisgIe3tQ8())) {
            return Constraints.m5184getMaxWidthimpl(j) == Constraints.m5184getMaxWidthimpl(layoutInput.m4719getConstraintsmsEJaDk()) && Constraints.m5183getMaxHeightimpl(j) == Constraints.m5183getMaxHeightimpl(layoutInput.m4719getConstraintsmsEJaDk());
        }
        return true;
    }
}
