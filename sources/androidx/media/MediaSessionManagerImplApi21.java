package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean hasMediaControlPermission(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", mediaSessionManager$RemoteUserInfoImpl.getPid(), mediaSessionManager$RemoteUserInfoImpl.getUid()) == 0;
    }

    @Override // androidx.media.MediaSessionManagerImplBase
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        return hasMediaControlPermission(mediaSessionManager$RemoteUserInfoImpl) || super.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfoImpl);
    }
}
