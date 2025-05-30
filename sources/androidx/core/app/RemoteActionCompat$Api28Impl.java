package androidx.core.app;

import android.app.RemoteAction;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RemoteActionCompat$Api28Impl {
    private RemoteActionCompat$Api28Impl() {
    }

    @DoNotInline
    static void setShouldShowIcon(RemoteAction remoteAction, boolean z) {
        remoteAction.setShouldShowIcon(z);
    }

    @DoNotInline
    static boolean shouldShowIcon(RemoteAction remoteAction) {
        return remoteAction.shouldShowIcon();
    }
}
