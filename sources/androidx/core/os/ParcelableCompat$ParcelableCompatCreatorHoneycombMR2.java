package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ParcelableCompat$ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

    ParcelableCompat$ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.mCallbacks.newArray(i);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }
}
