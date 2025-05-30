package androidx.compose.p004ui.text.platform;

import android.taobao.windvane.config.WVConfigManager;
import androidx.compose.p004ui.text.PlatformStringDelegate;
import androidx.compose.p004ui.text.intl.AndroidLocale;
import androidx.compose.p004ui.text.intl.PlatformLocale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    @Override // androidx.compose.p004ui.text.PlatformStringDelegate
    @NotNull
    public String capitalize(@NotNull String str, @NotNull PlatformLocale platformLocale) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(platformLocale, WVConfigManager.CONFIGNAME_LOCALE);
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(charAt) ? CharsKt.titlecase(charAt, ((AndroidLocale) platformLocale).getJavaLocale()) : String.valueOf(charAt)));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    @Override // androidx.compose.p004ui.text.PlatformStringDelegate
    @NotNull
    public String decapitalize(@NotNull String str, @NotNull PlatformLocale platformLocale) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(platformLocale, WVConfigManager.CONFIGNAME_LOCALE);
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) CharsKt.lowercase(str.charAt(0), ((AndroidLocale) platformLocale).getJavaLocale()));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    @Override // androidx.compose.p004ui.text.PlatformStringDelegate
    @NotNull
    public String toLowerCase(@NotNull String str, @NotNull PlatformLocale platformLocale) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(platformLocale, WVConfigManager.CONFIGNAME_LOCALE);
        String lowerCase = str.toLowerCase(((AndroidLocale) platformLocale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Override // androidx.compose.p004ui.text.PlatformStringDelegate
    @NotNull
    public String toUpperCase(@NotNull String str, @NotNull PlatformLocale platformLocale) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(platformLocale, WVConfigManager.CONFIGNAME_LOCALE);
        String upperCase = str.toUpperCase(((AndroidLocale) platformLocale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
