package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ContextThemeWrapper$Api17Impl {
    private ContextThemeWrapper$Api17Impl() {
    }

    @DoNotInline
    static Context createConfigurationContext(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
        return contextThemeWrapper.createConfigurationContext(configuration);
    }
}
