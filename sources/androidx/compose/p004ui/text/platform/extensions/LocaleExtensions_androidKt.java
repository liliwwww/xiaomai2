package androidx.compose.p004ui.text.platform.extensions;

import androidx.compose.p004ui.text.intl.AndroidLocale;
import androidx.compose.p004ui.text.intl.PlatformLocale;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LocaleExtensions_androidKt {
    @NotNull
    public static final Locale toJavaLocale(@NotNull androidx.compose.p004ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        PlatformLocale platformLocale$ui_text_release = locale.getPlatformLocale$ui_text_release();
        Intrinsics.checkNotNull(platformLocale$ui_text_release, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
        return ((AndroidLocale) platformLocale$ui_text_release).getJavaLocale();
    }
}
