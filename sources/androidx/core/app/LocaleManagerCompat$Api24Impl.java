package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LocaleManagerCompat$Api24Impl {
    private LocaleManagerCompat$Api24Impl() {
    }

    @DoNotInline
    static LocaleListCompat getLocales(Configuration configuration) {
        return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
    }
}
