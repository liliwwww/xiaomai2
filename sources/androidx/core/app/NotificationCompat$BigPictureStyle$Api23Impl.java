package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$BigPictureStyle$Api23Impl {
    private NotificationCompat$BigPictureStyle$Api23Impl() {
    }

    @RequiresApi(23)
    static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigLargeIcon(icon);
    }
}
