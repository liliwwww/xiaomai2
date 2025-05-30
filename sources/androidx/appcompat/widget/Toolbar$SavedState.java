package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Toolbar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<Toolbar$SavedState> CREATOR = new 1();
    int expandedMenuItemId;
    boolean isOverflowOpen;

    public Toolbar$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.expandedMenuItemId);
        parcel.writeInt(this.isOverflowOpen ? 1 : 0);
    }

    public Toolbar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.expandedMenuItemId = parcel.readInt();
        this.isOverflowOpen = parcel.readInt() != 0;
    }

    public Toolbar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
