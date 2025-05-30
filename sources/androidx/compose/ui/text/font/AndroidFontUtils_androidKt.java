package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidFontUtils_androidKt {
    @NotNull
    public static final FontWeight getAndroidBold(@NotNull FontWeight.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getW600();
    }

    public static final int getAndroidTypefaceStyle(boolean z, boolean z2) {
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    /* renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
    public static final int m1906getAndroidTypefaceStyleFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return getAndroidTypefaceStyle(fontWeight.compareTo(getAndroidBold(FontWeight.Companion)) >= 0, FontStyle.m1927equalsimpl0(i, FontStyle.Companion.getItalic-_-LCdwA()));
    }
}
