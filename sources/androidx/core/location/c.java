package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener a;

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.CancellableLocationListener.b(this.a);
    }
}
