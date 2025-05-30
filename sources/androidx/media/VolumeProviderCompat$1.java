package androidx.media;

import androidx.media.VolumeProviderCompatApi21;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class VolumeProviderCompat$1 implements VolumeProviderCompatApi21.Delegate {
    final /* synthetic */ VolumeProviderCompat this$0;

    VolumeProviderCompat$1(VolumeProviderCompat volumeProviderCompat) {
        this.this$0 = volumeProviderCompat;
    }

    public void onAdjustVolume(int i) {
        this.this$0.onAdjustVolume(i);
    }

    public void onSetVolumeTo(int i) {
        this.this$0.onSetVolumeTo(i);
    }
}
