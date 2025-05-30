package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class IResultReceiver$_Parcel {
    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
        if (t == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            t.writeToParcel(parcel, i);
        }
    }
}
