package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class TextUtilsCompat$Api17Impl {
    private TextUtilsCompat$Api17Impl() {
    }

    @DoNotInline
    static int getLayoutDirectionFromLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
