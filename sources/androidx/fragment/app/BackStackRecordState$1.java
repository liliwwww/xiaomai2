package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class BackStackRecordState$1 implements Parcelable.Creator<BackStackRecordState> {
    BackStackRecordState$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BackStackRecordState createFromParcel(Parcel parcel) {
        return new BackStackRecordState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BackStackRecordState[] newArray(int i) {
        return new BackStackRecordState[i];
    }
}
