package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.IMediaSession;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new Parcelable.Creator<MediaSessionCompat$Token>() { // from class: android.support.v4.media.session.MediaSessionCompat$Token.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaSessionCompat$Token createFromParcel(Parcel parcel) {
            return new MediaSessionCompat$Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaSessionCompat$Token[] newArray(int i) {
            return new MediaSessionCompat$Token[i];
        }
    };
    private IMediaSession mExtraBinder;
    private final Object mInner;
    private Bundle mSessionToken2Bundle;

    MediaSessionCompat$Token(Object obj) {
        this(obj, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static MediaSessionCompat$Token fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) bundle.getParcelable("android.support.v4.media.session.TOKEN");
        if (mediaSessionCompat$Token == null) {
            return null;
        }
        return new MediaSessionCompat$Token(mediaSessionCompat$Token.mInner, asInterface, bundle2);
    }

    public static MediaSessionCompat$Token fromToken(Object obj) {
        return fromToken(obj, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
        Object obj2 = this.mInner;
        if (obj2 == null) {
            return mediaSessionCompat$Token.mInner == null;
        }
        Object obj3 = mediaSessionCompat$Token.mInner;
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IMediaSession getExtraBinder() {
        return this.mExtraBinder;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle getSessionToken2Bundle() {
        return this.mSessionToken2Bundle;
    }

    public Object getToken() {
        return this.mInner;
    }

    public int hashCode() {
        Object obj = this.mInner;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraBinder(IMediaSession iMediaSession) {
        this.mExtraBinder = iMediaSession;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSessionToken2Bundle(Bundle bundle) {
        this.mSessionToken2Bundle = bundle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.TOKEN", this);
        IMediaSession iMediaSession = this.mExtraBinder;
        if (iMediaSession != null) {
            BundleCompat.putBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER", iMediaSession.asBinder());
        }
        Bundle bundle2 = this.mSessionToken2Bundle;
        if (bundle2 != null) {
            bundle.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", bundle2);
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            parcel.writeParcelable((Parcelable) this.mInner, i);
        } else {
            parcel.writeStrongBinder((IBinder) this.mInner);
        }
    }

    MediaSessionCompat$Token(Object obj, IMediaSession iMediaSession) {
        this(obj, iMediaSession, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static MediaSessionCompat$Token fromToken(Object obj, IMediaSession iMediaSession) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat$Token(MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
    }

    MediaSessionCompat$Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
        this.mInner = obj;
        this.mExtraBinder = iMediaSession;
        this.mSessionToken2Bundle = bundle;
    }
}
