package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionCompat$MediaSessionImplBase$MessageHandler extends Handler {
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    private static final int MSG_ADD_QUEUE_ITEM = 25;
    private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
    private static final int MSG_ADJUST_VOLUME = 2;
    private static final int MSG_COMMAND = 1;
    private static final int MSG_CUSTOM_ACTION = 20;
    private static final int MSG_FAST_FORWARD = 16;
    private static final int MSG_MEDIA_BUTTON = 21;
    private static final int MSG_NEXT = 14;
    private static final int MSG_PAUSE = 12;
    private static final int MSG_PLAY = 7;
    private static final int MSG_PLAY_MEDIA_ID = 8;
    private static final int MSG_PLAY_SEARCH = 9;
    private static final int MSG_PLAY_URI = 10;
    private static final int MSG_PREPARE = 3;
    private static final int MSG_PREPARE_MEDIA_ID = 4;
    private static final int MSG_PREPARE_SEARCH = 5;
    private static final int MSG_PREPARE_URI = 6;
    private static final int MSG_PREVIOUS = 15;
    private static final int MSG_RATE = 19;
    private static final int MSG_RATE_EXTRA = 31;
    private static final int MSG_REMOVE_QUEUE_ITEM = 27;
    private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
    private static final int MSG_REWIND = 17;
    private static final int MSG_SEEK_TO = 18;
    private static final int MSG_SET_CAPTIONING_ENABLED = 29;
    private static final int MSG_SET_REPEAT_MODE = 23;
    private static final int MSG_SET_SHUFFLE_MODE = 30;
    private static final int MSG_SET_VOLUME = 22;
    private static final int MSG_SKIP_TO_ITEM = 11;
    private static final int MSG_STOP = 13;
    final /* synthetic */ MediaSessionCompat.MediaSessionImplBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat$MediaSessionImplBase$MessageHandler(MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase, Looper looper) {
        super(looper);
        this.this$0 = mediaSessionImplBase;
    }

    private void onMediaButtonEvent(KeyEvent keyEvent, MediaSessionCompat$Callback mediaSessionCompat$Callback) {
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return;
        }
        PlaybackStateCompat playbackStateCompat = this.this$0.mState;
        long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 79) {
            if (keyCode == 126) {
                if ((actions & 4) != 0) {
                    mediaSessionCompat$Callback.onPlay();
                    return;
                }
                return;
            }
            if (keyCode == KEYCODE_MEDIA_PAUSE) {
                if ((actions & 2) != 0) {
                    mediaSessionCompat$Callback.onPause();
                    return;
                }
                return;
            }
            switch (keyCode) {
                case 86:
                    if ((actions & 1) != 0) {
                        mediaSessionCompat$Callback.onStop();
                        break;
                    }
                    break;
                case 87:
                    if ((actions & 32) != 0) {
                        mediaSessionCompat$Callback.onSkipToNext();
                        break;
                    }
                    break;
                case 88:
                    if ((actions & 16) != 0) {
                        mediaSessionCompat$Callback.onSkipToPrevious();
                        break;
                    }
                    break;
                case 89:
                    if ((actions & 8) != 0) {
                        mediaSessionCompat$Callback.onRewind();
                        break;
                    }
                    break;
                case 90:
                    if ((actions & 64) != 0) {
                        mediaSessionCompat$Callback.onFastForward();
                        break;
                    }
                    break;
            }
        }
        Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaSessionCompat$Callback mediaSessionCompat$Callback = this.this$0.mCallback;
        if (mediaSessionCompat$Callback == null) {
            return;
        }
        Bundle data = message.getData();
        MediaSessionCompat.ensureClassLoader(data);
        this.this$0.setCurrentControllerInfo(new MediaSessionManager$RemoteUserInfo(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
        Bundle bundle = data.getBundle("data_extras");
        MediaSessionCompat.ensureClassLoader(bundle);
        try {
            switch (message.what) {
                case 1:
                    MediaSessionCompat$MediaSessionImplBase$Command mediaSessionCompat$MediaSessionImplBase$Command = (MediaSessionCompat$MediaSessionImplBase$Command) message.obj;
                    mediaSessionCompat$Callback.onCommand(mediaSessionCompat$MediaSessionImplBase$Command.command, mediaSessionCompat$MediaSessionImplBase$Command.extras, mediaSessionCompat$MediaSessionImplBase$Command.stub);
                    break;
                case 2:
                    this.this$0.adjustVolume(message.arg1, 0);
                    break;
                case 3:
                    mediaSessionCompat$Callback.onPrepare();
                    break;
                case 4:
                    mediaSessionCompat$Callback.onPrepareFromMediaId((String) message.obj, bundle);
                    break;
                case 5:
                    mediaSessionCompat$Callback.onPrepareFromSearch((String) message.obj, bundle);
                    break;
                case 6:
                    mediaSessionCompat$Callback.onPrepareFromUri((Uri) message.obj, bundle);
                    break;
                case 7:
                    mediaSessionCompat$Callback.onPlay();
                    break;
                case 8:
                    mediaSessionCompat$Callback.onPlayFromMediaId((String) message.obj, bundle);
                    break;
                case 9:
                    mediaSessionCompat$Callback.onPlayFromSearch((String) message.obj, bundle);
                    break;
                case 10:
                    mediaSessionCompat$Callback.onPlayFromUri((Uri) message.obj, bundle);
                    break;
                case 11:
                    mediaSessionCompat$Callback.onSkipToQueueItem(((Long) message.obj).longValue());
                    break;
                case 12:
                    mediaSessionCompat$Callback.onPause();
                    break;
                case 13:
                    mediaSessionCompat$Callback.onStop();
                    break;
                case 14:
                    mediaSessionCompat$Callback.onSkipToNext();
                    break;
                case 15:
                    mediaSessionCompat$Callback.onSkipToPrevious();
                    break;
                case 16:
                    mediaSessionCompat$Callback.onFastForward();
                    break;
                case 17:
                    mediaSessionCompat$Callback.onRewind();
                    break;
                case 18:
                    mediaSessionCompat$Callback.onSeekTo(((Long) message.obj).longValue());
                    break;
                case 19:
                    mediaSessionCompat$Callback.onSetRating((RatingCompat) message.obj);
                    break;
                case 20:
                    mediaSessionCompat$Callback.onCustomAction((String) message.obj, bundle);
                    break;
                case 21:
                    KeyEvent keyEvent = (KeyEvent) message.obj;
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                    if (!mediaSessionCompat$Callback.onMediaButtonEvent(intent)) {
                        onMediaButtonEvent(keyEvent, mediaSessionCompat$Callback);
                        break;
                    }
                    break;
                case 22:
                    this.this$0.setVolumeTo(message.arg1, 0);
                    break;
                case 23:
                    mediaSessionCompat$Callback.onSetRepeatMode(message.arg1);
                    break;
                case 25:
                    mediaSessionCompat$Callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                    break;
                case 26:
                    mediaSessionCompat$Callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                    break;
                case 27:
                    mediaSessionCompat$Callback.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                    break;
                case 28:
                    List list = this.this$0.mQueue;
                    if (list != null) {
                        int i = message.arg1;
                        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (i < 0 || i >= list.size()) ? null : (MediaSessionCompat$QueueItem) this.this$0.mQueue.get(message.arg1);
                        if (mediaSessionCompat$QueueItem != null) {
                            mediaSessionCompat$Callback.onRemoveQueueItem(mediaSessionCompat$QueueItem.getDescription());
                            break;
                        }
                    }
                    break;
                case 29:
                    mediaSessionCompat$Callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                    break;
                case 30:
                    mediaSessionCompat$Callback.onSetShuffleMode(message.arg1);
                    break;
                case 31:
                    mediaSessionCompat$Callback.onSetRating((RatingCompat) message.obj, bundle);
                    break;
            }
        } finally {
            this.this$0.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) null);
        }
    }
}
