package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
@SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Fragment$SavedState implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<Fragment$SavedState> CREATOR = new Parcelable.ClassLoaderCreator<Fragment$SavedState>() { // from class: androidx.fragment.app.Fragment$SavedState.1
        @Override // android.os.Parcelable.Creator
        public Fragment$SavedState[] newArray(int i) {
            return new Fragment$SavedState[i];
        }

        @Override // android.os.Parcelable.Creator
        public Fragment$SavedState createFromParcel(Parcel parcel) {
            return new Fragment$SavedState(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public Fragment$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new Fragment$SavedState(parcel, classLoader);
        }
    };
    final Bundle mState;

    Fragment$SavedState(Bundle bundle) {
        this.mState = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeBundle(this.mState);
    }

    Fragment$SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Bundle readBundle = parcel.readBundle();
        this.mState = readBundle;
        if (classLoader == null || readBundle == null) {
            return;
        }
        readBundle.setClassLoader(classLoader);
    }
}
