package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentManager$LaunchedFragmentInfo$1 implements Parcelable.Creator<FragmentManager.LaunchedFragmentInfo> {
    FragmentManager$LaunchedFragmentInfo$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentManager.LaunchedFragmentInfo createFromParcel(Parcel parcel) {
        return new FragmentManager.LaunchedFragmentInfo(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentManager.LaunchedFragmentInfo[] newArray(int i) {
        return new FragmentManager.LaunchedFragmentInfo[i];
    }
}
