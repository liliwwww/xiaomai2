package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextMeasurer$Companion {
    private TextMeasurer$Companion() {
    }

    public /* synthetic */ TextMeasurer$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
        int i = Constraints.getMinWidth-impl(textLayoutInput.m2307getConstraintsmsEJaDk());
        boolean z = false;
        int i2 = ((textLayoutInput.getSoftWrap() || TextOverflow.m2531equalsimpl0(textLayoutInput.m2308getOverflowgIe3tQ8(), TextOverflow.Companion.m2539getEllipsisgIe3tQ8())) && Constraints.getHasBoundedWidth-impl(textLayoutInput.m2307getConstraintsmsEJaDk())) ? Constraints.getMaxWidth-impl(textLayoutInput.m2307getConstraintsmsEJaDk()) : Integer.MAX_VALUE;
        if (!textLayoutInput.getSoftWrap() && TextOverflow.m2531equalsimpl0(textLayoutInput.m2308getOverflowgIe3tQ8(), TextOverflow.Companion.m2539getEllipsisgIe3tQ8())) {
            z = true;
        }
        int maxLines = z ? 1 : textLayoutInput.getMaxLines();
        if (i != i2) {
            i2 = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), i, i2);
        }
        return new TextLayoutResult(textLayoutInput, new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, i2, 0, Constraints.getMaxHeight-impl(textLayoutInput.m2307getConstraintsmsEJaDk()), 5, (Object) null), maxLines, TextOverflow.m2531equalsimpl0(textLayoutInput.m2308getOverflowgIe3tQ8(), TextOverflow.Companion.m2539getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null), ConstraintsKt.constrain-4WqzIAM(textLayoutInput.m2307getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) Math.ceil(r2.getWidth()), (int) Math.ceil(r2.getHeight()))), (DefaultConstructorMarker) null);
    }
}
