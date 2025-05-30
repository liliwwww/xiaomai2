package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PlaybackStateCompat$CustomAction$1 implements Parcelable.Creator<PlaybackStateCompat.CustomAction> {
    PlaybackStateCompat$CustomAction$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PlaybackStateCompat.CustomAction createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat.CustomAction(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PlaybackStateCompat.CustomAction[] newArray(int i) {
        return new PlaybackStateCompat.CustomAction[i];
    }
}
