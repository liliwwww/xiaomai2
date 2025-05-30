package androidx.core.app;

import android.app.Notification;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$BubbleMetadata$Api29Impl {
    private NotificationCompat$BubbleMetadata$Api29Impl() {
    }

    @Nullable
    @RequiresApi(29)
    static NotificationCompat.BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
            return null;
        }
        NotificationCompat$BubbleMetadata$Builder suppressNotification = new NotificationCompat$BubbleMetadata$Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon())).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() != 0) {
            suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        }
        return suppressNotification.build();
    }

    @Nullable
    @RequiresApi(29)
    static Notification.BubbleMetadata toPlatform(@Nullable NotificationCompat.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
            return null;
        }
        Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() != 0) {
            suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        }
        return suppressNotification.build();
    }
}
