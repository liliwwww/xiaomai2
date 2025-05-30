package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$DecoratedCustomViewStyle extends NotificationCompat.Style {
    private static final int MAX_ACTION_BUTTONS = 3;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

    private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z) {
        int min;
        boolean z2 = true;
        RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
        applyStandardTemplate.removeAllViews(R.id.actions);
        List<NotificationCompat$Action> nonContextualActions = getNonContextualActions(((NotificationCompat.Style) this).mBuilder.mActions);
        if (!z || nonContextualActions == null || (min = Math.min(nonContextualActions.size(), 3)) <= 0) {
            z2 = false;
        } else {
            for (int i = 0; i < min; i++) {
                applyStandardTemplate.addView(R.id.actions, generateActionButton(nonContextualActions.get(i)));
            }
        }
        int i2 = z2 ? 0 : 8;
        applyStandardTemplate.setViewVisibility(R.id.actions, i2);
        applyStandardTemplate.setViewVisibility(R.id.action_divider, i2);
        buildIntoRemoteViews(applyStandardTemplate, remoteViews);
        return applyStandardTemplate;
    }

    private RemoteViews generateActionButton(NotificationCompat$Action notificationCompat$Action) {
        boolean z = notificationCompat$Action.actionIntent == null;
        RemoteViews remoteViews = new RemoteViews(((NotificationCompat.Style) this).mBuilder.mContext.getPackageName(), z ? R.layout.notification_action_tombstone : R.layout.notification_action);
        IconCompat iconCompat = notificationCompat$Action.getIconCompat();
        if (iconCompat != null) {
            remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(iconCompat, ((NotificationCompat.Style) this).mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
        }
        remoteViews.setTextViewText(R.id.action_text, notificationCompat$Action.title);
        if (!z) {
            remoteViews.setOnClickPendingIntent(R.id.action_container, notificationCompat$Action.actionIntent);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action_container, notificationCompat$Action.title);
        }
        return remoteViews;
    }

    private static List<NotificationCompat$Action> getNonContextualActions(List<NotificationCompat$Action> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationCompat$Action notificationCompat$Action : list) {
            if (!notificationCompat$Action.isContextual()) {
                arrayList.add(notificationCompat$Action);
            }
        }
        return arrayList;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean displayCustomViewInline() {
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        RemoteViews bigContentView = ((NotificationCompat.Style) this).mBuilder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = ((NotificationCompat.Style) this).mBuilder.getContentView();
        }
        if (bigContentView == null) {
            return null;
        }
        return createRemoteViews(bigContentView, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 24 && ((NotificationCompat.Style) this).mBuilder.getContentView() != null) {
            return createRemoteViews(((NotificationCompat.Style) this).mBuilder.getContentView(), false);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        RemoteViews headsUpContentView = ((NotificationCompat.Style) this).mBuilder.getHeadsUpContentView();
        RemoteViews contentView = headsUpContentView != null ? headsUpContentView : ((NotificationCompat.Style) this).mBuilder.getContentView();
        if (headsUpContentView == null) {
            return null;
        }
        return createRemoteViews(contentView, true);
    }
}
