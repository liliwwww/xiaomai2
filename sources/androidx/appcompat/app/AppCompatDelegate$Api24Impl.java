package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AppCompatDelegate$Api24Impl {
    private AppCompatDelegate$Api24Impl() {
    }

    @DoNotInline
    static LocaleList localeListForLanguageTags(String str) {
        return LocaleList.forLanguageTags(str);
    }
}
