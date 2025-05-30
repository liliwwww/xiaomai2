package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ LocationManager a;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport b;

    public /* synthetic */ b(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.a = locationManager;
        this.b = gpsStatusTransport;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LocationManagerCompat.b(this.a, this.b);
    }
}
