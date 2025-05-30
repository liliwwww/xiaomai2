package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class MediaSessionCompat$Callback {
    private CallbackHandler mCallbackHandler = null;
    final Object mCallbackObj;
    private boolean mMediaPlayPauseKeyPending;
    WeakReference<MediaSessionCompat.MediaSessionImpl> mSessionImpl;

    public MediaSessionCompat$Callback() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
            return;
        }
        if (i >= 23) {
            this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
        } else if (i >= 21) {
            this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(this));
        } else {
            this.mCallbackObj = null;
        }
    }

    void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        if (this.mMediaPlayPauseKeyPending) {
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mSessionImpl.get();
            if (mediaSessionImpl == null) {
                return;
            }
            PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
            long actions = playbackState == null ? 0L : playbackState.getActions();
            boolean z = playbackState != null && playbackState.getState() == 3;
            boolean z2 = (516 & actions) != 0;
            boolean z3 = (actions & 514) != 0;
            mediaSessionImpl.setCurrentControllerInfo(mediaSessionManager$RemoteUserInfo);
            if (z && z3) {
                onPause();
            } else if (!z && z2) {
                onPlay();
            }
            mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) null);
        }
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
    }

    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public void onCustomAction(String str, Bundle bundle) {
    }

    public void onFastForward() {
    }

    public boolean onMediaButtonEvent(Intent intent) {
        MediaSessionCompat.MediaSessionImpl mediaSessionImpl;
        KeyEvent keyEvent;
        if (Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = this.mSessionImpl.get()) == null || this.mCallbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
            return false;
        }
        MediaSessionManager$RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 79 && keyCode != 85) {
            handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
            return false;
        }
        if (keyEvent.getRepeatCount() > 0) {
            handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
        } else if (this.mMediaPlayPauseKeyPending) {
            this.mCallbackHandler.removeMessages(1);
            this.mMediaPlayPauseKeyPending = false;
            PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
            if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                onSkipToNext();
            }
        } else {
            this.mMediaPlayPauseKeyPending = true;
            CallbackHandler callbackHandler = this.mCallbackHandler;
            callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), ViewConfiguration.getDoubleTapTimeout());
        }
        return true;
    }

    public void onPause() {
    }

    public void onPlay() {
    }

    public void onPlayFromMediaId(String str, Bundle bundle) {
    }

    public void onPlayFromSearch(String str, Bundle bundle) {
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
    }

    public void onPrepare() {
    }

    public void onPrepareFromMediaId(String str, Bundle bundle) {
    }

    public void onPrepareFromSearch(String str, Bundle bundle) {
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
    }

    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    @Deprecated
    public void onRemoveQueueItemAt(int i) {
    }

    public void onRewind() {
    }

    public void onSeekTo(long j) {
    }

    public void onSetCaptioningEnabled(boolean z) {
    }

    public void onSetRating(RatingCompat ratingCompat) {
    }

    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
    }

    public void onSetRepeatMode(int i) {
    }

    public void onSetShuffleMode(int i) {
    }

    public void onSkipToNext() {
    }

    public void onSkipToPrevious() {
    }

    public void onSkipToQueueItem(long j) {
    }

    public void onStop() {
    }

    void setSessionImpl(MediaSessionCompat.MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
        CallbackHandler callbackHandler = this.mCallbackHandler;
        if (callbackHandler != null) {
            callbackHandler.removeCallbacksAndMessages(null);
        }
        this.mCallbackHandler = new CallbackHandler(this, handler.getLooper());
    }
}
