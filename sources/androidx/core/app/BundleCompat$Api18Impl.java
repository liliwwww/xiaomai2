package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class BundleCompat$Api18Impl {
    private BundleCompat$Api18Impl() {
    }

    @DoNotInline
    static IBinder getBinder(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    @DoNotInline
    static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
