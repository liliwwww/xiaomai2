package androidx.transition;

import android.os.IBinder;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
