package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AudioAttributesCompat$Builder {
    private int mContentType;
    private int mFlags;
    private int mLegacyStream;
    private int mUsage;

    public AudioAttributesCompat$Builder() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    public AudioAttributesCompat build() {
        AudioAttributesImplApi21 audioAttributesImplBase;
        if (AudioAttributesCompat.sForceLegacyBehavior || Build.VERSION.SDK_INT < 21) {
            audioAttributesImplBase = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
        } else {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
            int i = this.mLegacyStream;
            if (i != -1) {
                usage.setLegacyStreamType(i);
            }
            audioAttributesImplBase = new AudioAttributesImplApi21(usage.build(), this.mLegacyStream);
        }
        return new AudioAttributesCompat(audioAttributesImplBase);
    }

    public AudioAttributesCompat$Builder setContentType(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            this.mContentType = i;
        } else {
            this.mUsage = 0;
        }
        return this;
    }

    public AudioAttributesCompat$Builder setFlags(int i) {
        this.mFlags = (i & 1023) | this.mFlags;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    AudioAttributesCompat$Builder setInternalLegacyStreamType(int i) {
        switch (i) {
            case 0:
                this.mContentType = 1;
                break;
            case 1:
                this.mContentType = 4;
                break;
            case 2:
                this.mContentType = 4;
                break;
            case 3:
                this.mContentType = 2;
                break;
            case 4:
                this.mContentType = 4;
                break;
            case 5:
                this.mContentType = 4;
                break;
            case 6:
                this.mContentType = 1;
                this.mFlags |= 4;
                break;
            case 7:
                this.mFlags = 1 | this.mFlags;
                this.mContentType = 4;
                break;
            case 8:
                this.mContentType = 4;
                break;
            case 9:
                this.mContentType = 4;
                break;
            case 10:
                this.mContentType = 1;
                break;
            default:
                Log.e("AudioAttributesCompat", "Invalid stream type " + i + " for AudioAttributesCompat");
                break;
        }
        this.mUsage = AudioAttributesCompat.usageForStreamType(i);
        return this;
    }

    public AudioAttributesCompat$Builder setLegacyStreamType(int i) {
        if (i == 10) {
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }
        this.mLegacyStream = i;
        return Build.VERSION.SDK_INT >= 21 ? setInternalLegacyStreamType(i) : this;
    }

    public AudioAttributesCompat$Builder setUsage(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                this.mUsage = i;
                return this;
            case 16:
                if (AudioAttributesCompat.sForceLegacyBehavior || Build.VERSION.SDK_INT <= 25) {
                    this.mUsage = 12;
                } else {
                    this.mUsage = i;
                }
                return this;
            default:
                this.mUsage = 0;
                return this;
        }
    }

    public AudioAttributesCompat$Builder(AudioAttributesCompat audioAttributesCompat) {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
        this.mUsage = audioAttributesCompat.getUsage();
        this.mContentType = audioAttributesCompat.getContentType();
        this.mFlags = audioAttributesCompat.getFlags();
        this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
    }
}
