package android.support.v4.media.session;

import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionCompat$MediaSessionImplApi18$1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {
    final /* synthetic */ MediaSessionCompat.MediaSessionImplApi18 this$0;

    MediaSessionCompat$MediaSessionImplApi18$1(MediaSessionCompat.MediaSessionImplApi18 mediaSessionImplApi18) {
        this.this$0 = mediaSessionImplApi18;
    }

    @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
    public void onPlaybackPositionUpdate(long j) {
        this.this$0.postToHandler(18, -1, -1, Long.valueOf(j), (Bundle) null);
    }
}
