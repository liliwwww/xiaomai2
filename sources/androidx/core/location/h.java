package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ GnssStatusCompat c;

    public /* synthetic */ h(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.a = gpsStatusTransport;
        this.b = executor;
        this.c = gnssStatusCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.GpsStatusTransport.b(this.a, this.b, this.c);
    }
}
