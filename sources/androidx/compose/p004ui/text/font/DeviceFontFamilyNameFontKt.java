package androidx.compose.p004ui.text.font;

import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DeviceFontFamilyNameFontKt {
    @NotNull
    /* renamed from: Font-vxs03AY, reason: not valid java name */
    public static final Font m4807Fontvxs03AY(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new DeviceFontFamilyNameFont(str, fontWeight, i, settings, null);
    }

    /* renamed from: Font-vxs03AY$default, reason: not valid java name */
    public static /* synthetic */ Font m4808Fontvxs03AY$default(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        }
        return m4807Fontvxs03AY(str, fontWeight, i, settings);
    }
}
