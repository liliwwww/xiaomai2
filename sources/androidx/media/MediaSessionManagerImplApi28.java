package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    MediaSessionManager mObject;

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.mObject = (MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase
    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        if (mediaSessionManager$RemoteUserInfoImpl instanceof RemoteUserInfoImplApi28) {
            return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) mediaSessionManager$RemoteUserInfoImpl).mObject);
        }
        return false;
    }

    /* compiled from: Taobao */
    static final class RemoteUserInfoImplApi28 implements MediaSessionManager$RemoteUserInfoImpl {
        final MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(String str, int i, int i2) {
            this.mObject = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplApi28) {
                return this.mObject.equals(((RemoteUserInfoImplApi28) obj).mObject);
            }
            return false;
        }

        @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mObject);
        }

        RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mObject = remoteUserInfo;
        }
    }
}
