package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaSessionCompat$ResultReceiverWrapper$1 implements Parcelable.Creator<MediaSessionCompat.ResultReceiverWrapper> {
    MediaSessionCompat$ResultReceiverWrapper$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel parcel) {
        return new MediaSessionCompat.ResultReceiverWrapper(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MediaSessionCompat.ResultReceiverWrapper[] newArray(int i) {
        return new MediaSessionCompat.ResultReceiverWrapper[i];
    }
}
