package androidx.core.os;

import android.os.Parcel;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
