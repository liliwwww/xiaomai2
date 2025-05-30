package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class MediaControllerCompat$Callback implements IBinder.DeathRecipient {
    final Object mCallbackObj;
    MessageHandler mHandler;
    IMediaControllerCallback mIControllerCallback;

    /* compiled from: Taobao */
    private class MessageHandler extends Handler {
        private static final int MSG_DESTROYED = 8;
        private static final int MSG_EVENT = 1;
        private static final int MSG_SESSION_READY = 13;
        private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
        private static final int MSG_UPDATE_EXTRAS = 7;
        private static final int MSG_UPDATE_METADATA = 3;
        private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
        private static final int MSG_UPDATE_QUEUE = 5;
        private static final int MSG_UPDATE_QUEUE_TITLE = 6;
        private static final int MSG_UPDATE_REPEAT_MODE = 9;
        private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
        private static final int MSG_UPDATE_VOLUME = 4;
        boolean mRegistered;

        MessageHandler(Looper looper) {
            super(looper);
            this.mRegistered = false;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mRegistered) {
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        MediaSessionCompat.ensureClassLoader(data);
                        MediaControllerCompat$Callback.this.onSessionEvent((String) message.obj, data);
                        break;
                    case 2:
                        MediaControllerCompat$Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                        break;
                    case 3:
                        MediaControllerCompat$Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                        break;
                    case 4:
                        MediaControllerCompat$Callback.this.onAudioInfoChanged((MediaControllerCompat$PlaybackInfo) message.obj);
                        break;
                    case 5:
                        MediaControllerCompat$Callback.this.onQueueChanged((List) message.obj);
                        break;
                    case 6:
                        MediaControllerCompat$Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                        break;
                    case 7:
                        Bundle bundle = (Bundle) message.obj;
                        MediaSessionCompat.ensureClassLoader(bundle);
                        MediaControllerCompat$Callback.this.onExtrasChanged(bundle);
                        break;
                    case 8:
                        MediaControllerCompat$Callback.this.onSessionDestroyed();
                        break;
                    case 9:
                        MediaControllerCompat$Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                        break;
                    case 11:
                        MediaControllerCompat$Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                        break;
                    case 12:
                        MediaControllerCompat$Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                        break;
                    case 13:
                        MediaControllerCompat$Callback.this.onSessionReady();
                        break;
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static class StubApi21 implements MediaControllerCompatApi21.Callback {
        private final WeakReference<MediaControllerCompat$Callback> mCallback;

        StubApi21(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            this.mCallback = new WeakReference<>(mediaControllerCompat$Callback);
        }

        public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onAudioInfoChanged(new MediaControllerCompat$PlaybackInfo(i, i2, i3, i4, i5));
            }
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onExtrasChanged(bundle);
            }
        }

        public void onMetadataChanged(Object obj) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }
        }

        public void onPlaybackStateChanged(Object obj) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback == null || mediaControllerCompat$Callback.mIControllerCallback != null) {
                return;
            }
            mediaControllerCompat$Callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
        }

        public void onQueueChanged(List<?> list) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onQueueTitleChanged(charSequence);
            }
        }

        public void onSessionDestroyed() {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.onSessionDestroyed();
            }
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
            if (mediaControllerCompat$Callback != null) {
                if (mediaControllerCompat$Callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                    mediaControllerCompat$Callback.onSessionEvent(str, bundle);
                }
            }
        }
    }

    public MediaControllerCompat$Callback() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
            return;
        }
        StubCompat stubCompat = new StubCompat(this);
        this.mIControllerCallback = stubCompat;
        this.mCallbackObj = stubCompat;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        postToHandler(8, null, null);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public IMediaControllerCallback getIControllerCallback() {
        return this.mIControllerCallback;
    }

    public void onAudioInfoChanged(MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo) {
    }

    public void onCaptioningEnabledChanged(boolean z) {
    }

    public void onExtrasChanged(Bundle bundle) {
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSessionDestroyed() {
    }

    public void onSessionEvent(String str, Bundle bundle) {
    }

    public void onSessionReady() {
    }

    public void onShuffleModeChanged(int i) {
    }

    void postToHandler(int i, Object obj, Bundle bundle) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            Message obtainMessage = messageHandler.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    void setHandler(Handler handler) {
        if (handler != null) {
            MessageHandler messageHandler = new MessageHandler(handler.getLooper());
            this.mHandler = messageHandler;
            messageHandler.mRegistered = true;
        } else {
            MessageHandler messageHandler2 = this.mHandler;
            if (messageHandler2 != null) {
                messageHandler2.mRegistered = false;
                messageHandler2.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        }
    }
}
