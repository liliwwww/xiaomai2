package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PlatformTypefaces {
    @NotNull
    /* renamed from: createDefault-FO1MlWM, reason: not valid java name */
    Typeface m1933createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i);

    @NotNull
    /* renamed from: createNamed-RetOiIg, reason: not valid java name */
    Typeface m1934createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i);

    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM, reason: not valid java name */
    Typeface m1935optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation$Settings fontVariation$Settings, @NotNull Context context);
}
