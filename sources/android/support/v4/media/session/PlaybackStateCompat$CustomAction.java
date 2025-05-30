package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PlaybackStateCompat$CustomAction implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat$CustomAction> CREATOR = new 1();
    private final String mAction;
    private Object mCustomActionObj;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;

    PlaybackStateCompat$CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
        this.mAction = str;
        this.mName = charSequence;
        this.mIcon = i;
        this.mExtras = bundle;
    }

    public static PlaybackStateCompat$CustomAction fromCustomAction(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction = new PlaybackStateCompat$CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(obj), PlaybackStateCompatApi21.CustomAction.getName(obj), PlaybackStateCompatApi21.CustomAction.getIcon(obj), PlaybackStateCompatApi21.CustomAction.getExtras(obj));
        playbackStateCompat$CustomAction.mCustomActionObj = obj;
        return playbackStateCompat$CustomAction;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.mAction;
    }

    public Object getCustomAction() {
        Object obj = this.mCustomActionObj;
        if (obj != null || Build.VERSION.SDK_INT < 21) {
            return obj;
        }
        Object newInstance = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
        this.mCustomActionObj = newInstance;
        return newInstance;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String toString() {
        return "Action:mName='" + ((Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAction);
        TextUtils.writeToParcel(this.mName, parcel, i);
        parcel.writeInt(this.mIcon);
        parcel.writeBundle(this.mExtras);
    }

    PlaybackStateCompat$CustomAction(Parcel parcel) {
        this.mAction = parcel.readString();
        this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = parcel.readInt();
        this.mExtras = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
