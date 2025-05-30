package androidx.compose.p004ui.text.font;

import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.p004ui.text.font.FontVariation;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FontKt {
    @ExperimentalTextApi
    @NotNull
    /* renamed from: Font-F3nL8kk, reason: not valid java name */
    public static final Font m4812FontF3nL8kk(int i, @NotNull FontWeight fontWeight, int i2, int i3, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new ResourceFont(i, fontWeight, i2, settings, i3, null);
    }

    /* renamed from: Font-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ Font m4813FontF3nL8kk$default(int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.Companion.m4826getBlockingPKNRLFQ();
        }
        if ((i4 & 16) != 0) {
            settings = FontVariation.INSTANCE.m4854Settings6EWAqTQ(fontWeight, i2, new FontVariation.Setting[0]);
        }
        return m4812FontF3nL8kk(i, fontWeight, i2, i3, settings);
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility until Compose 1.3.", replaceWith = @ReplaceWith(expression = "Font(resId, weight, style)", imports = {}))
    /* renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m4814FontRetOiIg(int i, FontWeight fontWeight, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new ResourceFont(i, fontWeight, i2, null, FontLoadingStrategy.Companion.m4826getBlockingPKNRLFQ(), 8, null);
    }

    /* renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m4815FontRetOiIg$default(int i, FontWeight fontWeight, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i3 & 4) != 0) {
            i2 = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        return m4814FontRetOiIg(i, fontWeight, i2);
    }

    @Stable
    @NotNull
    /* renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m4816FontYpTlLL0(int i, @NotNull FontWeight fontWeight, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new ResourceFont(i, fontWeight, i2, new FontVariation.Settings(new FontVariation.Setting[0]), i3, null);
    }

    /* renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m4817FontYpTlLL0$default(int i, FontWeight fontWeight, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.Companion.m4826getBlockingPKNRLFQ();
        }
        return m4816FontYpTlLL0(i, fontWeight, i2, i3);
    }

    @Stable
    @NotNull
    public static final FontFamily toFontFamily(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
