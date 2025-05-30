package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.media.MediaSessionManager;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = MediaSessionManager.DEBUG;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    ContentResolver mContentResolver;
    Context mContext;

    MediaSessionManagerImplBase(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl, String str) {
        return mediaSessionManager$RemoteUserInfoImpl.getPid() < 0 ? this.mContext.getPackageManager().checkPermission(str, mediaSessionManager$RemoteUserInfoImpl.getPackageName()) == 0 : this.mContext.checkPermission(str, mediaSessionManager$RemoteUserInfoImpl.getPid(), mediaSessionManager$RemoteUserInfoImpl.getUid()) == 0;
    }

    public Context getContext() {
        return this.mContext;
    }

    boolean isEnabledNotificationListener(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (string != null) {
            for (String str : string.split(":")) {
                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                if (unflattenFromString != null && unflattenFromString.getPackageName().equals(mediaSessionManager$RemoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        try {
            if (this.mContext.getPackageManager().getApplicationInfo(mediaSessionManager$RemoteUserInfoImpl.getPackageName(), 0).uid == mediaSessionManager$RemoteUserInfoImpl.getUid()) {
                return isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) || isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) || mediaSessionManager$RemoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(mediaSessionManager$RemoteUserInfoImpl);
            }
            if (DEBUG) {
                Log.d(TAG, "Package name " + mediaSessionManager$RemoteUserInfoImpl.getPackageName() + " doesn't match with the uid " + mediaSessionManager$RemoteUserInfoImpl.getUid());
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            if (DEBUG) {
                Log.d(TAG, "Package " + mediaSessionManager$RemoteUserInfoImpl.getPackageName() + " doesn't exist");
            }
            return false;
        }
    }
}
