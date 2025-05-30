package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.versionedparcelable.VersionedParcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface AudioAttributesImpl extends VersionedParcelable {
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    @NonNull
    Bundle toBundle();
}
