package androidx.media.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class NotificationCompat {

    /* compiled from: Taobao */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        /* JADX WARN: Multi-variable type inference failed */
        private void setBackgroundColor(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", ((NotificationCompat.Style) this).mBuilder.getColor() != 0 ? ((NotificationCompat.Style) this).mBuilder.getColor() : ((NotificationCompat.Style) this).mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        /* JADX WARN: Multi-variable type inference failed */
        int getContentViewLayoutResource() {
            return ((NotificationCompat.Style) this).mBuilder.getContentView() != null ? R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            RemoteViews bigContentView = ((NotificationCompat.Style) this).mBuilder.getBigContentView() != null ? ((NotificationCompat.Style) this).mBuilder.getBigContentView() : ((NotificationCompat.Style) this).mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, bigContentView);
            if (i >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = ((NotificationCompat.Style) this).mBuilder.getContentView() != null;
            if (i >= 21) {
                if (!z2 && ((NotificationCompat.Style) this).mBuilder.getBigContentView() == null) {
                    z = false;
                }
                if (z) {
                    RemoteViews generateContentView = generateContentView();
                    if (z2) {
                        buildIntoRemoteViews(generateContentView, ((NotificationCompat.Style) this).mBuilder.getContentView());
                    }
                    setBackgroundColor(generateContentView);
                    return generateContentView;
                }
            } else {
                RemoteViews generateContentView2 = generateContentView();
                if (z2) {
                    buildIntoRemoteViews(generateContentView2, ((NotificationCompat.Style) this).mBuilder.getContentView());
                    return generateContentView2;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = ((NotificationCompat.Style) this).mBuilder.getHeadsUpContentView() != null ? ((NotificationCompat.Style) this).mBuilder.getHeadsUpContentView() : ((NotificationCompat.Style) this).mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, headsUpContentView);
            if (i >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }
    }

    private NotificationCompat() {
    }
}
