package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class NotificationManagerCompat$NotifyTask implements NotificationManagerCompat.Task {
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;

    NotificationManagerCompat$NotifyTask(String str, int i, String str2, Notification notification) {
        this.packageName = str;
        this.id = i;
        this.tag = str2;
        this.notif = notification;
    }

    public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
        iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
    }

    @NonNull
    public String toString() {
        return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
    }
}
