package androidx.core.telephony.mbms;

import android.content.Context;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MbmsHelper$Api28Impl {
    private MbmsHelper$Api28Impl() {
    }

    static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
        if (namedContentLocales.isEmpty()) {
            return null;
        }
        String[] strArr = new String[namedContentLocales.size()];
        int i = 0;
        Iterator<Locale> it = serviceInfo.getNamedContentLocales().iterator();
        while (it.hasNext()) {
            strArr[i] = it.next().toLanguageTag();
            i++;
        }
        Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
        if (firstMatch == null) {
            return null;
        }
        return serviceInfo.getNameForLocale(firstMatch);
    }
}
