package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.versionedparcelable.VersionedParcel;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl) versionedParcel.readVersionedParcelable(audioAttributesCompat.mImpl, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(audioAttributesCompat.mImpl, 1);
    }
}
