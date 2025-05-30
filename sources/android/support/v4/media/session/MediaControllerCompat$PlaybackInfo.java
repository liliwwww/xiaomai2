package android.support.v4.media.session;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MediaControllerCompat$PlaybackInfo {
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final int mAudioStream;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;

    MediaControllerCompat$PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
        this.mPlaybackType = i;
        this.mAudioStream = i2;
        this.mVolumeControl = i3;
        this.mMaxVolume = i4;
        this.mCurrentVolume = i5;
    }

    public int getAudioStream() {
        return this.mAudioStream;
    }

    public int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public int getMaxVolume() {
        return this.mMaxVolume;
    }

    public int getPlaybackType() {
        return this.mPlaybackType;
    }

    public int getVolumeControl() {
        return this.mVolumeControl;
    }
}
