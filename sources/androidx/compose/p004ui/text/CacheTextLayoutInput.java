package androidx.compose.p004ui.text;

import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public final class CacheTextLayoutInput {

    @NotNull
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(@NotNull TextLayoutInput textLayoutInput) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "textLayoutInput");
        this.textLayoutInput = textLayoutInput;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) obj;
        return Intrinsics.areEqual(textLayoutInput.getText(), cacheTextLayoutInput.textLayoutInput.getText()) && textLayoutInput.getStyle().hasSameLayoutAffectingAttributes(cacheTextLayoutInput.textLayoutInput.getStyle()) && Intrinsics.areEqual(textLayoutInput.getPlaceholders(), cacheTextLayoutInput.textLayoutInput.getPlaceholders()) && textLayoutInput.getMaxLines() == cacheTextLayoutInput.textLayoutInput.getMaxLines() && textLayoutInput.getSoftWrap() == cacheTextLayoutInput.textLayoutInput.getSoftWrap() && TextOverflow.m5121equalsimpl0(textLayoutInput.m4720getOverflowgIe3tQ8(), cacheTextLayoutInput.textLayoutInput.m4720getOverflowgIe3tQ8()) && Intrinsics.areEqual(textLayoutInput.getDensity(), cacheTextLayoutInput.textLayoutInput.getDensity()) && textLayoutInput.getLayoutDirection() == cacheTextLayoutInput.textLayoutInput.getLayoutDirection() && textLayoutInput.getFontFamilyResolver() == cacheTextLayoutInput.textLayoutInput.getFontFamilyResolver() && Constraints.m5184getMaxWidthimpl(textLayoutInput.m4719getConstraintsmsEJaDk()) == Constraints.m5184getMaxWidthimpl(cacheTextLayoutInput.textLayoutInput.m4719getConstraintsmsEJaDk()) && Constraints.m5183getMaxHeightimpl(textLayoutInput.m4719getConstraintsmsEJaDk()) == Constraints.m5183getMaxHeightimpl(cacheTextLayoutInput.textLayoutInput.m4719getConstraintsmsEJaDk());
    }

    @NotNull
    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        return (((((((((((((((((((textLayoutInput.getText().hashCode() * 31) + textLayoutInput.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + textLayoutInput.getPlaceholders().hashCode()) * 31) + textLayoutInput.getMaxLines()) * 31) + l3.a(textLayoutInput.getSoftWrap())) * 31) + TextOverflow.m5122hashCodeimpl(textLayoutInput.m4720getOverflowgIe3tQ8())) * 31) + textLayoutInput.getDensity().hashCode()) * 31) + textLayoutInput.getLayoutDirection().hashCode()) * 31) + textLayoutInput.getFontFamilyResolver().hashCode()) * 31) + Constraints.m5184getMaxWidthimpl(textLayoutInput.m4719getConstraintsmsEJaDk())) * 31) + Constraints.m5183getMaxHeightimpl(textLayoutInput.m4719getConstraintsmsEJaDk());
    }
}
