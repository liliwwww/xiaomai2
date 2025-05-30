package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LocaleListCompat$Api21Impl {
    private static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale("ar", "XB")};

    private LocaleListCompat$Api21Impl() {
    }

    @DoNotInline
    static Locale forLanguageTag(String str) {
        return Locale.forLanguageTag(str);
    }

    private static boolean isPseudoLocale(Locale locale) {
        for (Locale locale2 : PSEUDO_LOCALE) {
            if (locale2.equals(locale)) {
                return true;
            }
        }
        return false;
    }

    @DoNotInline
    static boolean matchesLanguageAndScript(@NonNull Locale locale, @NonNull Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return false;
        }
        String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
        if (!maximizeAndGetScript.isEmpty()) {
            return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
        }
        String country = locale.getCountry();
        return country.isEmpty() || country.equals(locale2.getCountry());
    }
}
