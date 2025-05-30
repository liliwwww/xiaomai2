package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LocationManagerCompat$LocationListenerTransport implements LocationListener {
    final Executor mExecutor;

    @Nullable
    volatile LocationManagerCompat.LocationListenerKey mKey;

    LocationManagerCompat$LocationListenerTransport(@Nullable LocationManagerCompat.LocationListenerKey locationListenerKey, Executor executor) {
        this.mKey = locationListenerKey;
        this.mExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFlushComplete$2(int i) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onFlushComplete(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLocationChanged$0(Location location) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onLocationChanged(location);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLocationChanged$1(List list) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onLocationChanged((List<Location>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProviderDisabled$5(String str) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onProviderDisabled(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProviderEnabled$4(String str) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onProviderEnabled(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStatusChanged$3(String str, int i, Bundle bundle) {
        LocationManagerCompat.LocationListenerKey locationListenerKey = this.mKey;
        if (locationListenerKey == null) {
            return;
        }
        locationListenerKey.mListener.onStatusChanged(str, i, bundle);
    }

    public LocationManagerCompat.LocationListenerKey getKey() {
        return (LocationManagerCompat.LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
    }

    @Override // android.location.LocationListener
    public void onFlushComplete(final int i) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.i
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onFlushComplete$2(i);
            }
        });
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@NonNull final Location location) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.j
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onLocationChanged$0(location);
            }
        });
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(@NonNull final String str) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.l
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onProviderDisabled$5(str);
            }
        });
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(@NonNull final String str) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.k
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onProviderEnabled$4(str);
            }
        });
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(final String str, final int i, final Bundle bundle) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.m
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onStatusChanged$3(str, i, bundle);
            }
        });
    }

    public void unregister() {
        this.mKey = null;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@NonNull final List<Location> list) {
        if (this.mKey == null) {
            return;
        }
        this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.n
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$LocationListenerTransport.this.lambda$onLocationChanged$1(list);
            }
        });
    }
}
