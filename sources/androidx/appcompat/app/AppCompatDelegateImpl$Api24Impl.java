package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$Api24Impl {
    private AppCompatDelegateImpl$Api24Impl() {
    }

    @DoNotInline
    static void generateConfigDelta_locale(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    @DoNotInline
    static LocaleListCompat getLocales(Configuration configuration) {
        return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
    }

    @DoNotInline
    public static void setDefaultLocales(LocaleListCompat localeListCompat) {
        LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
    }

    @DoNotInline
    static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
        configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
    }
}
