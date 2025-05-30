package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;

    public /* synthetic */ g(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i) {
        this.a = gpsStatusTransport;
        this.b = executor;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.GpsStatusTransport.a(this.a, this.b, this.c);
    }
}
