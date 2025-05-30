package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.media.R;
import androidx.media.R$id;
import androidx.media.R$layout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$MediaStyle extends NotificationCompat.Style {
    private static final int MAX_MEDIA_BUTTONS = 5;
    private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    int[] mActionsToShowInCompact = null;
    PendingIntent mCancelButtonIntent;
    boolean mShowCancelButton;
    MediaSessionCompat$Token mToken;

    public NotificationCompat$MediaStyle() {
    }

    private RemoteViews generateMediaActionButton(NotificationCompat$Action notificationCompat$Action) {
        boolean z = notificationCompat$Action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(((NotificationCompat.Style) this).mBuilder.mContext.getPackageName(), R$layout.notification_media_action);
        int i = R$id.action0;
        remoteViews.setImageViewResource(i, notificationCompat$Action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(i, notificationCompat$Action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(i, notificationCompat$Action.getTitle());
        }
        return remoteViews;
    }

    public static MediaSessionCompat$Token getMediaSession(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Parcelable parcelable = extras.getParcelable("android.mediaSession");
            if (parcelable != null) {
                return MediaSessionCompat$Token.fromToken(parcelable);
            }
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, "android.mediaSession");
        if (binder == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeStrongBinder(binder);
        obtain.setDataPosition(0);
        MediaSessionCompat$Token createFromParcel = MediaSessionCompat$Token.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        } else if (this.mShowCancelButton) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }

    @RequiresApi(21)
    Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.mActionsToShowInCompact;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = this.mToken;
        if (mediaSessionCompat$Token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) mediaSessionCompat$Token.getToken());
        }
        return mediaStyle;
    }

    RemoteViews generateBigContentView() {
        int min = Math.min(((NotificationCompat.Style) this).mBuilder.mActions.size(), 5);
        RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i = 0; i < min; i++) {
                applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton((NotificationCompat$Action) ((NotificationCompat.Style) this).mBuilder.mActions.get(i)));
            }
        }
        if (this.mShowCancelButton) {
            int i2 = R$id.cancel_action;
            applyStandardTemplate.setViewVisibility(i2, 0);
            applyStandardTemplate.setInt(i2, "setAlpha", ((NotificationCompat.Style) this).mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
        } else {
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    RemoteViews generateContentView() {
        RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
        int size = ((NotificationCompat.Style) this).mBuilder.mActions.size();
        int[] iArr = this.mActionsToShowInCompact;
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i = 0; i < min; i++) {
                if (i >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                }
                applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton((NotificationCompat$Action) ((NotificationCompat.Style) this).mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
            }
        }
        if (this.mShowCancelButton) {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, 8);
            int i2 = R$id.cancel_action;
            applyStandardTemplate.setViewVisibility(i2, 0);
            applyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
            applyStandardTemplate.setInt(i2, "setAlpha", ((NotificationCompat.Style) this).mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    int getBigContentViewLayoutResource(int i) {
        return i <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
    }

    int getContentViewLayoutResource() {
        return R$layout.notification_template_media;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return generateBigContentView();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return generateContentView();
    }

    public NotificationCompat$MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
        this.mCancelButtonIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.mToken = mediaSessionCompat$Token;
        return this;
    }

    public NotificationCompat$MediaStyle setShowActionsInCompactView(int... iArr) {
        this.mActionsToShowInCompact = iArr;
        return this;
    }

    public NotificationCompat$MediaStyle setShowCancelButton(boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            this.mShowCancelButton = z;
        }
        return this;
    }

    public NotificationCompat$MediaStyle(NotificationCompat.Builder builder) {
        setBuilder(builder);
    }
}
