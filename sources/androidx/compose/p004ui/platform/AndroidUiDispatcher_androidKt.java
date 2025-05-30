package androidx.compose.p004ui.platform;

import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidUiDispatcher_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
