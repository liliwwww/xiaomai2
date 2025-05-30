package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RecyclerView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<RecyclerView$SavedState> CREATOR = new 1();
    Parcelable mLayoutState;

    RecyclerView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.mLayoutState = parcel.readParcelable(classLoader == null ? RecyclerView$LayoutManager.class.getClassLoader() : classLoader);
    }

    void copyFrom(RecyclerView$SavedState recyclerView$SavedState) {
        this.mLayoutState = recyclerView$SavedState.mLayoutState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mLayoutState, 0);
    }

    RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
