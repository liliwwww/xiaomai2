package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaSessionCompat$Callback$StubApi23 extends MediaSessionCompat$Callback$StubApi21 implements MediaSessionCompatApi23$Callback {
    final /* synthetic */ MediaSessionCompat.Callback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaSessionCompat$Callback$StubApi23(final MediaSessionCompat.Callback callback) {
        new MediaSessionCompatApi21.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                try {
                    IBinder iBinder = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionCompat.MediaSessionImplApi21) callback.mSessionImpl.get();
                        if (mediaSessionImplApi21 != null) {
                            Bundle bundle2 = new Bundle();
                            MediaSessionCompat.Token sessionToken = mediaSessionImplApi21.getSessionToken();
                            IMediaSession extraBinder = sessionToken.getExtraBinder();
                            if (extraBinder != null) {
                                iBinder = extraBinder.asBinder();
                            }
                            BundleCompat.putBinder(bundle2, MediaSessionCompat.KEY_EXTRA_BINDER, iBinder);
                            bundle2.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, sessionToken.getSessionToken2Bundle());
                            resultReceiver.send(0, bundle2);
                            return;
                        }
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        callback.onAddQueueItem(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        callback.onAddQueueItem(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        callback.onRemoveQueueItem(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                        return;
                    }
                    if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        callback.onCommand(str, bundle, resultReceiver);
                        return;
                    }
                    MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi212 = (MediaSessionCompat.MediaSessionImplApi21) callback.mSessionImpl.get();
                    if (mediaSessionImplApi212 == null || mediaSessionImplApi212.mQueue == null) {
                        return;
                    }
                    int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    if (i >= 0 && i < mediaSessionImplApi212.mQueue.size()) {
                        iBinder = (MediaSessionCompat.QueueItem) mediaSessionImplApi212.mQueue.get(i);
                    }
                    if (iBinder != null) {
                        callback.onRemoveQueueItem(iBinder.getDescription());
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
            }

            public void onCustomAction(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    callback.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                    callback.onPrepare();
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    callback.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    callback.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    callback.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    callback.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    return;
                }
                if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    callback.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    callback.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (!str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                    callback.onCustomAction(str, bundle);
                } else {
                    callback.onSetRating(bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                }
            }

            public void onFastForward() {
                callback.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return callback.onMediaButtonEvent(intent);
            }

            public void onPause() {
                callback.onPause();
            }

            public void onPlay() {
                callback.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                callback.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                callback.onPlayFromSearch(str, bundle);
            }

            public void onRewind() {
                callback.onRewind();
            }

            public void onSeekTo(long j) {
                callback.onSeekTo(j);
            }

            public void onSetRating(Object obj) {
                callback.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSetRating(Object obj, Bundle bundle) {
            }

            public void onSkipToNext() {
                callback.onSkipToNext();
            }

            public void onSkipToPrevious() {
                callback.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j) {
                callback.onSkipToQueueItem(j);
            }

            public void onStop() {
                callback.onStop();
            }
        };
        this.this$0 = callback;
    }

    @Override // android.support.v4.media.session.MediaSessionCompatApi23$Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        this.this$0.onPlayFromUri(uri, bundle);
    }
}
