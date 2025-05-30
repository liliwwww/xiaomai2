package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaControllerCompat;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MediaControllerCompat$Callback$StubCompat extends IMediaControllerCallback.Stub {
    private final WeakReference<MediaControllerCompat.Callback> mCallback;

    MediaControllerCompat$Callback$StubCompat(MediaControllerCompat.Callback callback) {
        this.mCallback = new WeakReference<>(callback);
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(11, Boolean.valueOf(z), (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onEvent(String str, Bundle bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(1, str, bundle);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(7, bundle, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(3, mediaMetadataCompat, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(2, playbackStateCompat, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onQueueChanged(List<MediaSessionCompat$QueueItem> list) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(5, list, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(6, charSequence, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onRepeatModeChanged(int i) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(9, Integer.valueOf(i), (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onSessionDestroyed() throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(8, (Object) null, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onSessionReady() throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(13, (Object) null, (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onShuffleModeChanged(int i) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(12, Integer.valueOf(i), (Bundle) null);
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        MediaControllerCompat.Callback callback = this.mCallback.get();
        if (callback != null) {
            callback.postToHandler(4, parcelableVolumeInfo != null ? new MediaControllerCompat.PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, (Bundle) null);
        }
    }
}
