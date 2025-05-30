package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$Api17Impl {
    private AppCompatDelegateImpl$Api17Impl() {
    }

    static Context createConfigurationContext(@NonNull Context context, @NonNull Configuration configuration) {
        return context.createConfigurationContext(configuration);
    }

    static void generateConfigDelta_densityDpi(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        int i = configuration.densityDpi;
        int i2 = configuration2.densityDpi;
        if (i != i2) {
            configuration3.densityDpi = i2;
        }
    }

    @DoNotInline
    static void setLayoutDirection(Configuration configuration, Locale locale) {
        configuration.setLayoutDirection(locale);
    }

    @DoNotInline
    static void setLocale(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }
}
