package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MediaSessionManager {
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;
    static final String TAG = "MediaSessionManager";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final Object sLock = new Object();

    /* compiled from: Taobao */
    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    private MediaSessionManager(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28(context);
        } else if (i >= 21) {
            this.mImpl = new MediaSessionManagerImplApi21(context);
        } else {
            this.mImpl = new MediaSessionManagerImplBase(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                mediaSessionManager = sSessionManager;
                if (mediaSessionManager == null) {
                    sSessionManager = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = sSessionManager;
                }
            }
        }
        return mediaSessionManager;
    }

    Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.mImpl.isTrustedForMediaControl(remoteUserInfo.mImpl);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
