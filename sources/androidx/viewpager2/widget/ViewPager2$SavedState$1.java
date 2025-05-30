package androidx.viewpager2.widget;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$SavedState$1 implements Parcelable.ClassLoaderCreator<ViewPager2.SavedState> {
    ViewPager2$SavedState$1() {
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager2.SavedState[] newArray(int i) {
        return new ViewPager2.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ViewPager2.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 ? new ViewPager2.SavedState(parcel, classLoader) : new ViewPager2.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager2.SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
