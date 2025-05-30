package androidx.core.app;

import android.app.AppOpsManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppOpsManagerCompat$Api19Impl {
    private AppOpsManagerCompat$Api19Impl() {
    }

    @DoNotInline
    static int noteOp(AppOpsManager appOpsManager, String str, int i, String str2) {
        return appOpsManager.noteOp(str, i, str2);
    }

    @DoNotInline
    static int noteOpNoThrow(AppOpsManager appOpsManager, String str, int i, String str2) {
        return appOpsManager.noteOpNoThrow(str, i, str2);
    }
}
