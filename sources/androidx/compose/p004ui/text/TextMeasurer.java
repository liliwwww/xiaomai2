package androidx.compose.p004ui.text;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@ExperimentalTextApi
/* loaded from: classes.dex */
public final class TextMeasurer {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int cacheSize;

    @NotNull
    private final Density fallbackDensity;

    @NotNull
    private final FontFamily.Resolver fallbackFontFamilyResolver;

    @NotNull
    private final LayoutDirection fallbackLayoutDirection;

    @Nullable
    private final TextLayoutCache textLayoutCache;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int m5186getMinWidthimpl = Constraints.m5186getMinWidthimpl(textLayoutInput.m4719getConstraintsmsEJaDk());
            boolean z = false;
            int m5184getMaxWidthimpl = ((textLayoutInput.getSoftWrap() || TextOverflow.m5121equalsimpl0(textLayoutInput.m4720getOverflowgIe3tQ8(), TextOverflow.Companion.m5129getEllipsisgIe3tQ8())) && Constraints.m5180getHasBoundedWidthimpl(textLayoutInput.m4719getConstraintsmsEJaDk())) ? Constraints.m5184getMaxWidthimpl(textLayoutInput.m4719getConstraintsmsEJaDk()) : Integer.MAX_VALUE;
            if (!textLayoutInput.getSoftWrap() && TextOverflow.m5121equalsimpl0(textLayoutInput.m4720getOverflowgIe3tQ8(), TextOverflow.Companion.m5129getEllipsisgIe3tQ8())) {
                z = true;
            }
            int maxLines = z ? 1 : textLayoutInput.getMaxLines();
            if (m5186getMinWidthimpl != m5184getMaxWidthimpl) {
                m5184getMaxWidthimpl = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), m5186getMinWidthimpl, m5184getMaxWidthimpl);
            }
            return new TextLayoutResult(textLayoutInput, new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, m5184getMaxWidthimpl, 0, Constraints.m5183getMaxHeightimpl(textLayoutInput.m4719getConstraintsmsEJaDk()), 5, null), maxLines, TextOverflow.m5121equalsimpl0(textLayoutInput.m4720getOverflowgIe3tQ8(), TextOverflow.Companion.m5129getEllipsisgIe3tQ8()), null), ConstraintsKt.m5195constrain4WqzIAM(textLayoutInput.m4719getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) Math.ceil(r2.getWidth()), (int) Math.ceil(r2.getHeight()))), null);
        }
    }

    public TextMeasurer(@NotNull FontFamily.Resolver resolver, @NotNull Density density, @NotNull LayoutDirection layoutDirection, int i) {
        Intrinsics.checkNotNullParameter(resolver, "fallbackFontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "fallbackDensity");
        Intrinsics.checkNotNullParameter(layoutDirection, "fallbackLayoutDirection");
        this.fallbackFontFamilyResolver = resolver;
        this.fallbackDensity = density;
        this.fallbackLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    @Stable
    @NotNull
    /* renamed from: measure-xDpz5zY, reason: not valid java name */
    public final TextLayoutResult m4727measurexDpz5zY(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, int i, boolean z, int i2, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver resolver, boolean z2) {
        TextLayoutCache textLayoutCache;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, list, i2, z, i, density, layoutDirection, resolver, j, (DefaultConstructorMarker) null);
        TextLayoutResult textLayoutResult = (z2 || (textLayoutCache = this.textLayoutCache) == null) ? null : textLayoutCache.get(textLayoutInput);
        if (textLayoutResult != null) {
            return textLayoutResult.m4722copyO0kMr_c(textLayoutInput, ConstraintsKt.m5195constrain4WqzIAM(j, IntSizeKt.IntSize(ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getWidth()), ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getHeight()))));
        }
        TextLayoutResult layout = Companion.layout(textLayoutInput);
        TextLayoutCache textLayoutCache2 = this.textLayoutCache;
        if (textLayoutCache2 != null) {
            textLayoutCache2.put(textLayoutInput, layout);
        }
        return layout;
    }

    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }
}
