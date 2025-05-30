package androidx.core.app;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LocaleManagerCompat$Api21Impl {
    private LocaleManagerCompat$Api21Impl() {
    }

    @DoNotInline
    static String toLanguageTag(Locale locale) {
        return locale.toLanguageTag();
    }
}
