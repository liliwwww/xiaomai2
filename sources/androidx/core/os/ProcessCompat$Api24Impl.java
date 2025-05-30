package androidx.core.os;

import android.os.Process;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ProcessCompat$Api24Impl {
    private ProcessCompat$Api24Impl() {
    }

    static boolean isApplicationUid(int i) {
        return Process.isApplicationUid(i);
    }
}
