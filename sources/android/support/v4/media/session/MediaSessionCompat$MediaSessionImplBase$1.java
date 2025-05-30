package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.VolumeProviderCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionCompat$MediaSessionImplBase$1 extends VolumeProviderCompat.Callback {
    final /* synthetic */ MediaSessionCompat.MediaSessionImplBase this$0;

    MediaSessionCompat$MediaSessionImplBase$1(MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase) {
        this.this$0 = mediaSessionImplBase;
    }

    @Override // androidx.media.VolumeProviderCompat.Callback
    public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
        if (this.this$0.mVolumeProvider != volumeProviderCompat) {
            return;
        }
        MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase = this.this$0;
        this.this$0.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
    }
}
