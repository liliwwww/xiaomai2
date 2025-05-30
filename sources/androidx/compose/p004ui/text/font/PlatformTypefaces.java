package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.FontVariation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PlatformTypefaces {
    @NotNull
    /* renamed from: createDefault-FO1MlWM, reason: not valid java name */
    Typeface mo4857createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i);

    @NotNull
    /* renamed from: createNamed-RetOiIg, reason: not valid java name */
    Typeface mo4858createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i);

    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM, reason: not valid java name */
    Typeface mo4859optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings, @NotNull Context context);
}
