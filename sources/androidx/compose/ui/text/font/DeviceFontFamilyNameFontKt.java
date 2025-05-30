package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DeviceFontFamilyNameFontKt {
    @NotNull
    /* renamed from: Font-vxs03AY, reason: not valid java name */
    public static final Font m1916Fontvxs03AY(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation$Settings fontVariation$Settings) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(fontVariation$Settings, "variationSettings");
        return new DeviceFontFamilyNameFont(str, fontWeight, i, fontVariation$Settings, null);
    }

    /* renamed from: Font-vxs03AY$default, reason: not valid java name */
    public static /* synthetic */ Font m1917Fontvxs03AY$default(String str, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if ((i2 & 8) != 0) {
            fontVariation$Settings = new FontVariation$Settings(new FontVariation$Setting[0]);
        }
        return m1916Fontvxs03AY(str, fontWeight, i, fontVariation$Settings);
    }
}
