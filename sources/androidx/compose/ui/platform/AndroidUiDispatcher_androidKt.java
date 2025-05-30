package androidx.compose.ui.platform;

import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidUiDispatcher_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
