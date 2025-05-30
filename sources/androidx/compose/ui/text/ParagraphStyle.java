package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ParagraphStyle {

    @Nullable
    private final Hyphens hyphens;

    @Nullable
    private final LineBreak lineBreak;
    private final long lineHeight;

    @Nullable
    private final LineHeightStyle lineHeightStyle;

    @Nullable
    private final PlatformParagraphStyle platformStyle;

    @Nullable
    private final TextAlign textAlign;

    @Nullable
    private final TextDirection textDirection;

    @Nullable
    private final TextIndent textIndent;

    @Nullable
    private final TextMotion textMotion;

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this.textAlign = textAlign;
        this.textDirection = textDirection;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = lineBreak;
        this.hyphens = hyphens;
        this.textMotion = textMotion;
        if (TextUnit.equals-impl0(j, TextUnit.Companion.getUnspecified-XSAIIZE())) {
            return;
        }
        if (TextUnit.getValue-impl(j) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.getValue-impl(j) + ')').toString());
    }

    @ExperimentalTextApi
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign, textDirection, j, textIndent);
    }

    /* renamed from: copy-Elsmlbk$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m2267copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection = paragraphStyle.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        return paragraphStyle.m2270copyElsmlbk(textAlign, textDirection2, j2, textIndent);
    }

    /* renamed from: copy-xPh5V4g$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m2269copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection = paragraphStyle.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        TextIndent textIndent2 = textIndent;
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        PlatformParagraphStyle platformParagraphStyle2 = platformParagraphStyle;
        if ((i & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        return paragraphStyle.m2272copyxPh5V4g(textAlign, textDirection2, j2, textIndent2, platformParagraphStyle2, lineHeightStyle);
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getHyphens$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getLineBreak$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getTextMotion$annotations() {
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    private final PlatformParagraphStyle mergePlatformStyle(PlatformParagraphStyle platformParagraphStyle) {
        PlatformParagraphStyle platformParagraphStyle2 = this.platformStyle;
        return platformParagraphStyle2 == null ? platformParagraphStyle : platformParagraphStyle == null ? platformParagraphStyle2 : platformParagraphStyle2.merge(platformParagraphStyle);
    }

    @NotNull
    /* renamed from: copy-Elsmlbk, reason: not valid java name */
    public final ParagraphStyle m2270copyElsmlbk(@Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j, @Nullable TextIndent textIndent) {
        return new ParagraphStyle(textAlign, textDirection, j, textIndent, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, null);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-Y2FIdtc, reason: not valid java name */
    public final ParagraphStyle m2271copyY2FIdtc(@Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j, @Nullable TextIndent textIndent, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle, @Nullable LineBreak lineBreak, @Nullable Hyphens hyphens, @Nullable TextMotion textMotion) {
        return new ParagraphStyle(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, textMotion, null);
    }

    @NotNull
    /* renamed from: copy-xPh5V4g, reason: not valid java name */
    public final ParagraphStyle m2272copyxPh5V4g(@Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j, @Nullable TextIndent textIndent, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle) {
        return new ParagraphStyle(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return Intrinsics.areEqual(this.textAlign, paragraphStyle.textAlign) && Intrinsics.areEqual(this.textDirection, paragraphStyle.textDirection) && TextUnit.equals-impl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && Intrinsics.areEqual(this.lineBreak, paragraphStyle.lineBreak) && Intrinsics.areEqual(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion);
    }

    @ExperimentalTextApi
    @Nullable
    public final Hyphens getHyphens() {
        return this.hyphens;
    }

    @ExperimentalTextApi
    @Nullable
    public final LineBreak getLineBreak() {
        return this.lineBreak;
    }

    /* renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m2273getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    @Nullable
    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    /* renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m2274getTextAlignbuA522U() {
        return this.textAlign;
    }

    @Nullable
    /* renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m2275getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    @ExperimentalTextApi
    @Nullable
    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    public int hashCode() {
        TextAlign textAlign = this.textAlign;
        int m2503hashCodeimpl = (textAlign != null ? TextAlign.m2503hashCodeimpl(textAlign.m2505unboximpl()) : 0) * 31;
        TextDirection textDirection = this.textDirection;
        int i = (((m2503hashCodeimpl + (textDirection != null ? TextDirection.hashCode-impl(textDirection.unbox-impl()) : 0)) * 31) + TextUnit.hashCode-impl(this.lineHeight)) * 31;
        TextIndent textIndent = this.textIndent;
        int hashCode = (i + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int hashCode2 = (hashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        int hashCode3 = (hashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31;
        LineBreak lineBreak = this.lineBreak;
        int hashCode4 = (hashCode3 + (lineBreak != null ? lineBreak.hashCode() : 0)) * 31;
        Hyphens hyphens = this.hyphens;
        int hashCode5 = (hashCode4 + (hyphens != null ? hyphens.hashCode() : 0)) * 31;
        TextMotion textMotion = this.textMotion;
        return hashCode5 + (textMotion != null ? textMotion.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final ParagraphStyle merge(@Nullable ParagraphStyle paragraphStyle) {
        if (paragraphStyle == null) {
            return this;
        }
        long j = TextUnitKt.isUnspecified--R2X_6o(paragraphStyle.lineHeight) ? this.lineHeight : paragraphStyle.lineHeight;
        TextIndent textIndent = paragraphStyle.textIndent;
        if (textIndent == null) {
            textIndent = this.textIndent;
        }
        TextIndent textIndent2 = textIndent;
        TextAlign textAlign = paragraphStyle.textAlign;
        if (textAlign == null) {
            textAlign = this.textAlign;
        }
        TextAlign textAlign2 = textAlign;
        TextDirection textDirection = paragraphStyle.textDirection;
        if (textDirection == null) {
            textDirection = this.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        PlatformParagraphStyle mergePlatformStyle = mergePlatformStyle(paragraphStyle.platformStyle);
        LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
        if (lineHeightStyle == null) {
            lineHeightStyle = this.lineHeightStyle;
        }
        LineHeightStyle lineHeightStyle2 = lineHeightStyle;
        LineBreak lineBreak = paragraphStyle.lineBreak;
        if (lineBreak == null) {
            lineBreak = this.lineBreak;
        }
        LineBreak lineBreak2 = lineBreak;
        Hyphens hyphens = paragraphStyle.hyphens;
        if (hyphens == null) {
            hyphens = this.hyphens;
        }
        Hyphens hyphens2 = hyphens;
        TextMotion textMotion = paragraphStyle.textMotion;
        if (textMotion == null) {
            textMotion = this.textMotion;
        }
        return new ParagraphStyle(textAlign2, textDirection2, j, textIndent2, mergePlatformStyle, lineHeightStyle2, lineBreak2, hyphens2, textMotion, null);
    }

    @Stable
    @NotNull
    public final ParagraphStyle plus(@NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    @NotNull
    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + ((Object) TextUnit.toString-impl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ", hyphens=" + this.hyphens + ", textMotion=" + this.textMotion + ')';
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) != 0 ? null : lineHeightStyle, (i & 64) != 0 ? null : lineBreak, (i & 128) != 0 ? null : hyphens, (i & 256) == 0 ? textMotion : null, null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 8) != 0 ? null : textIndent, null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent) {
        this(textAlign, textDirection, j, textIndent, null, null, null, null, null, null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign, (i & 2) != 0 ? null : textDirection, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 8) != 0 ? null : textIndent, (i & 16) != 0 ? null : platformParagraphStyle, (i & 32) == 0 ? lineHeightStyle : null, null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle) {
        this(textAlign, textDirection, j, textIndent, platformParagraphStyle, lineHeightStyle, null, null, null, 256, null);
    }
}
