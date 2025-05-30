package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class SwipeRefreshLayout$SavedState$1 implements Parcelable.Creator<SwipeRefreshLayout.SavedState> {
    SwipeRefreshLayout$SavedState$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public SwipeRefreshLayout.SavedState createFromParcel(Parcel parcel) {
        return new SwipeRefreshLayout.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public SwipeRefreshLayout.SavedState[] newArray(int i) {
        return new SwipeRefreshLayout.SavedState[i];
    }
}
