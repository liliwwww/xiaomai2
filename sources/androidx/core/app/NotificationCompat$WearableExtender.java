package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NotificationCompat$WearableExtender implements NotificationCompat$Extender {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";

    @Deprecated
    public static final int SCREEN_TIMEOUT_LONG = -1;

    @Deprecated
    public static final int SCREEN_TIMEOUT_SHORT = 0;

    @Deprecated
    public static final int SIZE_DEFAULT = 0;

    @Deprecated
    public static final int SIZE_FULL_SCREEN = 5;

    @Deprecated
    public static final int SIZE_LARGE = 4;

    @Deprecated
    public static final int SIZE_MEDIUM = 3;

    @Deprecated
    public static final int SIZE_SMALL = 2;

    @Deprecated
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<NotificationCompat$Action> mActions;
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex;
    private int mContentIcon;
    private int mContentIconGravity;
    private int mCustomContentHeight;
    private int mCustomSizePreset;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags;
    private int mGravity;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages;

    public NotificationCompat$WearableExtender() {
        this.mActions = new ArrayList<>();
        this.mFlags = 1;
        this.mPages = new ArrayList<>();
        this.mContentIconGravity = DEFAULT_CONTENT_ICON_GRAVITY;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
    }

    @RequiresApi(20)
    private static Notification.Action getActionFromActionCompat(NotificationCompat$Action notificationCompat$Action) {
        Notification.Action.Builder builder;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            IconCompat iconCompat = notificationCompat$Action.getIconCompat();
            builder = new Notification.Action.Builder(iconCompat == null ? null : iconCompat.toIcon(), notificationCompat$Action.getTitle(), notificationCompat$Action.getActionIntent());
        } else {
            IconCompat iconCompat2 = notificationCompat$Action.getIconCompat();
            builder = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), notificationCompat$Action.getTitle(), notificationCompat$Action.getActionIntent());
        }
        Bundle bundle = notificationCompat$Action.getExtras() != null ? new Bundle(notificationCompat$Action.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action.getAllowGeneratedReplies());
        if (i >= 24) {
            builder.setAllowGeneratedReplies(notificationCompat$Action.getAllowGeneratedReplies());
        }
        if (i >= 31) {
            builder.setAuthenticationRequired(notificationCompat$Action.isAuthenticationRequired());
        }
        builder.addExtras(bundle);
        RemoteInput[] remoteInputs = notificationCompat$Action.getRemoteInputs();
        if (remoteInputs != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(remoteInputs)) {
                builder.addRemoteInput(remoteInput);
            }
        }
        return builder.build();
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags = i | this.mFlags;
        } else {
            this.mFlags = (~i) & this.mFlags;
        }
    }

    @NonNull
    public NotificationCompat$WearableExtender addAction(@NonNull NotificationCompat$Action notificationCompat$Action) {
        this.mActions.add(notificationCompat$Action);
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender addActions(@NonNull List<NotificationCompat$Action> list) {
        this.mActions.addAll(list);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender addPage(@NonNull Notification notification) {
        this.mPages.add(notification);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender addPages(@NonNull List<Notification> list) {
        this.mPages.addAll(list);
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender clearActions() {
        this.mActions.clear();
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender clearPages() {
        this.mPages.clear();
        return this;
    }

    @Override // androidx.core.app.NotificationCompat$Extender
    @NonNull
    public NotificationCompat.Builder extend(@NonNull NotificationCompat.Builder builder) {
        Bundle bundle = new Bundle();
        if (!this.mActions.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 16) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.mActions.size());
                Iterator<NotificationCompat$Action> it = this.mActions.iterator();
                while (it.hasNext()) {
                    NotificationCompat$Action next = it.next();
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 20) {
                        arrayList.add(getActionFromActionCompat(next));
                    } else if (i >= 16) {
                        arrayList.add(NotificationCompatJellybean.getBundleForAction(next));
                    }
                }
                bundle.putParcelableArrayList(KEY_ACTIONS, arrayList);
            } else {
                bundle.putParcelableArrayList(KEY_ACTIONS, null);
            }
        }
        int i2 = this.mFlags;
        if (i2 != 1) {
            bundle.putInt(KEY_FLAGS, i2);
        }
        PendingIntent pendingIntent = this.mDisplayIntent;
        if (pendingIntent != null) {
            bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
        }
        if (!this.mPages.isEmpty()) {
            ArrayList<Notification> arrayList2 = this.mPages;
            bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
        }
        Bitmap bitmap = this.mBackground;
        if (bitmap != null) {
            bundle.putParcelable(KEY_BACKGROUND, bitmap);
        }
        int i3 = this.mContentIcon;
        if (i3 != 0) {
            bundle.putInt(KEY_CONTENT_ICON, i3);
        }
        int i4 = this.mContentIconGravity;
        if (i4 != DEFAULT_CONTENT_ICON_GRAVITY) {
            bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i4);
        }
        int i5 = this.mContentActionIndex;
        if (i5 != -1) {
            bundle.putInt(KEY_CONTENT_ACTION_INDEX, i5);
        }
        int i6 = this.mCustomSizePreset;
        if (i6 != 0) {
            bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i6);
        }
        int i7 = this.mCustomContentHeight;
        if (i7 != 0) {
            bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i7);
        }
        int i8 = this.mGravity;
        if (i8 != 80) {
            bundle.putInt(KEY_GRAVITY, i8);
        }
        int i9 = this.mHintScreenTimeout;
        if (i9 != 0) {
            bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i9);
        }
        String str = this.mDismissalId;
        if (str != null) {
            bundle.putString(KEY_DISMISSAL_ID, str);
        }
        String str2 = this.mBridgeTag;
        if (str2 != null) {
            bundle.putString(KEY_BRIDGE_TAG, str2);
        }
        builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
        return builder;
    }

    @NonNull
    public List<NotificationCompat$Action> getActions() {
        return this.mActions;
    }

    @Nullable
    @Deprecated
    public Bitmap getBackground() {
        return this.mBackground;
    }

    @Nullable
    public String getBridgeTag() {
        return this.mBridgeTag;
    }

    public int getContentAction() {
        return this.mContentActionIndex;
    }

    @Deprecated
    public int getContentIcon() {
        return this.mContentIcon;
    }

    @Deprecated
    public int getContentIconGravity() {
        return this.mContentIconGravity;
    }

    public boolean getContentIntentAvailableOffline() {
        return (this.mFlags & 1) != 0;
    }

    @Deprecated
    public int getCustomContentHeight() {
        return this.mCustomContentHeight;
    }

    @Deprecated
    public int getCustomSizePreset() {
        return this.mCustomSizePreset;
    }

    @Nullable
    public String getDismissalId() {
        return this.mDismissalId;
    }

    @Nullable
    @Deprecated
    public PendingIntent getDisplayIntent() {
        return this.mDisplayIntent;
    }

    @Deprecated
    public int getGravity() {
        return this.mGravity;
    }

    @Deprecated
    public boolean getHintAmbientBigPicture() {
        return (this.mFlags & 32) != 0;
    }

    @Deprecated
    public boolean getHintAvoidBackgroundClipping() {
        return (this.mFlags & 16) != 0;
    }

    public boolean getHintContentIntentLaunchesActivity() {
        return (this.mFlags & 64) != 0;
    }

    @Deprecated
    public boolean getHintHideIcon() {
        return (this.mFlags & 2) != 0;
    }

    @Deprecated
    public int getHintScreenTimeout() {
        return this.mHintScreenTimeout;
    }

    @Deprecated
    public boolean getHintShowBackgroundOnly() {
        return (this.mFlags & 4) != 0;
    }

    @NonNull
    @Deprecated
    public List<Notification> getPages() {
        return this.mPages;
    }

    public boolean getStartScrollBottom() {
        return (this.mFlags & 8) != 0;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setBackground(@Nullable Bitmap bitmap) {
        this.mBackground = bitmap;
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setBridgeTag(@Nullable String str) {
        this.mBridgeTag = str;
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setContentAction(int i) {
        this.mContentActionIndex = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setContentIcon(int i) {
        this.mContentIcon = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setContentIconGravity(int i) {
        this.mContentIconGravity = i;
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean z) {
        setFlag(1, z);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setCustomContentHeight(int i) {
        this.mCustomContentHeight = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setCustomSizePreset(int i) {
        this.mCustomSizePreset = i;
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setDismissalId(@Nullable String str) {
        this.mDismissalId = str;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setDisplayIntent(@Nullable PendingIntent pendingIntent) {
        this.mDisplayIntent = pendingIntent;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setGravity(int i) {
        this.mGravity = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setHintAmbientBigPicture(boolean z) {
        setFlag(32, z);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(boolean z) {
        setFlag(16, z);
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
        setFlag(64, z);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setHintHideIcon(boolean z) {
        setFlag(2, z);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setHintScreenTimeout(int i) {
        this.mHintScreenTimeout = i;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean z) {
        setFlag(4, z);
        return this;
    }

    @NonNull
    public NotificationCompat$WearableExtender setStartScrollBottom(boolean z) {
        setFlag(8, z);
        return this;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NotificationCompat$WearableExtender m2784clone() {
        NotificationCompat$WearableExtender notificationCompat$WearableExtender = new NotificationCompat$WearableExtender();
        notificationCompat$WearableExtender.mActions = new ArrayList<>(this.mActions);
        notificationCompat$WearableExtender.mFlags = this.mFlags;
        notificationCompat$WearableExtender.mDisplayIntent = this.mDisplayIntent;
        notificationCompat$WearableExtender.mPages = new ArrayList<>(this.mPages);
        notificationCompat$WearableExtender.mBackground = this.mBackground;
        notificationCompat$WearableExtender.mContentIcon = this.mContentIcon;
        notificationCompat$WearableExtender.mContentIconGravity = this.mContentIconGravity;
        notificationCompat$WearableExtender.mContentActionIndex = this.mContentActionIndex;
        notificationCompat$WearableExtender.mCustomSizePreset = this.mCustomSizePreset;
        notificationCompat$WearableExtender.mCustomContentHeight = this.mCustomContentHeight;
        notificationCompat$WearableExtender.mGravity = this.mGravity;
        notificationCompat$WearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
        notificationCompat$WearableExtender.mDismissalId = this.mDismissalId;
        notificationCompat$WearableExtender.mBridgeTag = this.mBridgeTag;
        return notificationCompat$WearableExtender;
    }

    public NotificationCompat$WearableExtender(@NonNull Notification notification) {
        this.mActions = new ArrayList<>();
        this.mFlags = 1;
        this.mPages = new ArrayList<>();
        this.mContentIconGravity = DEFAULT_CONTENT_ICON_GRAVITY;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
        Bundle extras = NotificationCompat.getExtras(notification);
        Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_ACTIONS);
            if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                int size = parcelableArrayList.size();
                NotificationCompat$Action[] notificationCompat$ActionArr = new NotificationCompat$Action[size];
                for (int i = 0; i < size; i++) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 20) {
                        notificationCompat$ActionArr[i] = NotificationCompat.getActionCompatFromAction((Notification.Action) parcelableArrayList.get(i));
                    } else if (i2 >= 16) {
                        notificationCompat$ActionArr[i] = NotificationCompatJellybean.getActionFromBundle((Bundle) parcelableArrayList.get(i));
                    }
                }
                Collections.addAll(this.mActions, notificationCompat$ActionArr);
            }
            this.mFlags = bundle.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
            if (notificationArrayFromBundle != null) {
                Collections.addAll(this.mPages, notificationArrayFromBundle);
            }
            this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
            this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, DEFAULT_CONTENT_ICON_GRAVITY);
            this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
        }
    }
}
