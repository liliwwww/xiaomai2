package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RemoteActionCompat$Api26Impl {
    private RemoteActionCompat$Api26Impl() {
    }

    @DoNotInline
    static RemoteAction createRemoteAction(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
    }

    @DoNotInline
    static PendingIntent getActionIntent(RemoteAction remoteAction) {
        return remoteAction.getActionIntent();
    }

    @DoNotInline
    static CharSequence getContentDescription(RemoteAction remoteAction) {
        return remoteAction.getContentDescription();
    }

    @DoNotInline
    static Icon getIcon(RemoteAction remoteAction) {
        return remoteAction.getIcon();
    }

    @DoNotInline
    static CharSequence getTitle(RemoteAction remoteAction) {
        return remoteAction.getTitle();
    }

    @DoNotInline
    static boolean isEnabled(RemoteAction remoteAction) {
        return remoteAction.isEnabled();
    }

    @DoNotInline
    static void setEnabled(RemoteAction remoteAction, boolean z) {
        remoteAction.setEnabled(z);
    }
}
