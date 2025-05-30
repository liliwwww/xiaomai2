package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class IntentSenderRequest$1 implements Parcelable.Creator<IntentSenderRequest> {
    IntentSenderRequest$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public IntentSenderRequest createFromParcel(Parcel parcel) {
        return new IntentSenderRequest(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public IntentSenderRequest[] newArray(int i) {
        return new IntentSenderRequest[i];
    }
}
