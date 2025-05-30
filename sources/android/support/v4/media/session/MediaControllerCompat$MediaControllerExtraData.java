package android.support.v4.media.session;

import androidx.core.app.ComponentActivity;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaControllerCompat$MediaControllerExtraData extends ComponentActivity.ExtraData {
    private final MediaControllerCompat mMediaController;

    MediaControllerCompat$MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
        this.mMediaController = mediaControllerCompat;
    }

    MediaControllerCompat getMediaController() {
        return this.mMediaController;
    }
}
