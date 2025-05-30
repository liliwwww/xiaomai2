package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
interface MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    Bundle getBrowserRootHints();

    MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo();

    void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle);

    void notifyChildrenChanged(String str, Bundle bundle);

    IBinder onBind(Intent intent);

    void onCreate();

    void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token);
}
