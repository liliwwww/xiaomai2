package android.taobao.windvane.webview;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ParamsParcelable$1 implements Parcelable.Creator<ParamsParcelable> {
    ParamsParcelable$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ParamsParcelable createFromParcel(Parcel parcel) {
        return new ParamsParcelable(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ParamsParcelable[] newArray(int i) {
        return new ParamsParcelable[i];
    }
}
