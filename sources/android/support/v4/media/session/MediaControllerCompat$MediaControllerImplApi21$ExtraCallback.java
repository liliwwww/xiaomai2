package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback extends MediaControllerCompat$Callback.StubCompat {
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        super(mediaControllerCompat$Callback);
    }

    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        throw new AssertionError();
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        throw new AssertionError();
    }

    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        throw new AssertionError();
    }

    public void onSessionDestroyed() throws RemoteException {
        throw new AssertionError();
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        throw new AssertionError();
    }
}
