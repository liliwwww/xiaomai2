package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class TextViewCompat$Api24Impl {
    private TextViewCompat$Api24Impl() {
    }

    @DoNotInline
    static DecimalFormatSymbols getInstance(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
