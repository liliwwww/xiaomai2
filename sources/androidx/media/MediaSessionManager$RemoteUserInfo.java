package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MediaSessionManager$RemoteUserInfo {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    MediaSessionManager$RemoteUserInfoImpl mImpl;

    public MediaSessionManager$RemoteUserInfo(@NonNull String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
        } else {
            this.mImpl = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaSessionManager$RemoteUserInfo) {
            return this.mImpl.equals(((MediaSessionManager$RemoteUserInfo) obj).mImpl);
        }
        return false;
    }

    @NonNull
    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public int getPid() {
        return this.mImpl.getPid();
    }

    public int getUid() {
        return this.mImpl.getUid();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MediaSessionManager$RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
    }
}
