package androidx.compose.ui.text.intl;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(api = 24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    @NotNull
    public List<PlatformLocale> getCurrent() {
        LocaleList localeList = LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeList, "getDefault()");
        ArrayList arrayList = new ArrayList();
        int size = localeList.size();
        for (int i = 0; i < size; i++) {
            java.util.Locale locale = localeList.get(i);
            Intrinsics.checkNotNullExpressionValue(locale, "localeList[i]");
            arrayList.add(new AndroidLocale(locale));
        }
        return arrayList;
    }

    @NotNull
    public PlatformLocale parseLanguageTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "languageTag");
        java.util.Locale forLanguageTag = java.util.Locale.forLanguageTag(str);
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(forLanguageTag);
    }
}
