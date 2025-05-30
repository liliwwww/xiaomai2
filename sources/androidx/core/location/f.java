package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport a;
    public final /* synthetic */ Executor b;

    public /* synthetic */ f(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.a = gpsStatusTransport;
        this.b = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.GpsStatusTransport.d(this.a, this.b);
    }
}
