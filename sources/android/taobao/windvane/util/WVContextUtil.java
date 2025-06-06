package android.taobao.windvane.util;

import android.content.Context;
import android.content.MutableContextWrapper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVContextUtil {
    public static Context getRealContext(Context context) {
        if (context == null) {
            return null;
        }
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }
}
