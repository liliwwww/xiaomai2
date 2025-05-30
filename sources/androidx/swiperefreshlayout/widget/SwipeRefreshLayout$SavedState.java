package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SwipeRefreshLayout$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SwipeRefreshLayout$SavedState> CREATOR = new 1();
    final boolean mRefreshing;

    SwipeRefreshLayout$SavedState(Parcelable parcelable, boolean z) {
        super(parcelable);
        this.mRefreshing = z;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.mRefreshing ? (byte) 1 : (byte) 0);
    }

    SwipeRefreshLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.mRefreshing = parcel.readByte() != 0;
    }
}
