package android.taobao.windvane.webview;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ParamsParcelable implements Parcelable {
    public static final Parcelable.Creator<ParamsParcelable> CREATOR = new 1();
    private boolean jsbridgeEnabled;
    private boolean navBarEnabled;
    private boolean showLoading;
    private boolean supportPullRefresh;

    public ParamsParcelable() {
        this.showLoading = true;
        this.supportPullRefresh = false;
        this.navBarEnabled = true;
        this.jsbridgeEnabled = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isJsbridgeEnabled() {
        return this.jsbridgeEnabled;
    }

    public boolean isNavBarEnabled() {
        return this.navBarEnabled;
    }

    public boolean isShowLoading() {
        return this.showLoading;
    }

    public boolean isSupportPullRefresh() {
        return this.supportPullRefresh;
    }

    public void setJsbridgeEnabled(boolean z) {
        this.jsbridgeEnabled = z;
    }

    public void setNavBarEnabled(boolean z) {
        this.navBarEnabled = z;
    }

    public void setShowLoading(boolean z) {
        this.showLoading = z;
    }

    public void setSupportPullRefresh(boolean z) {
        this.supportPullRefresh = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.showLoading ? 1 : 0);
        parcel.writeInt(this.supportPullRefresh ? 1 : 0);
        parcel.writeInt(this.navBarEnabled ? 1 : 0);
        parcel.writeInt(this.jsbridgeEnabled ? 1 : 0);
    }

    public ParamsParcelable(Parcel parcel) {
        this.showLoading = true;
        this.supportPullRefresh = false;
        this.navBarEnabled = true;
        this.jsbridgeEnabled = true;
        this.showLoading = parcel.readInt() == 1;
        this.supportPullRefresh = parcel.readInt() == 1;
        this.navBarEnabled = parcel.readInt() == 1;
        this.jsbridgeEnabled = parcel.readInt() == 1;
    }
}
