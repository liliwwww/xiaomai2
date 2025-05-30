package androidx.core.location;

import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Consumer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Executor;
import tb.ug2;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LocationManagerCompat$Api30Impl {
    private static Class<?> sLocationRequestClass;
    private static Method sRequestLocationUpdatesExecutorMethod;

    private LocationManagerCompat$Api30Impl() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        android.os.CancellationSignal cancellationSignal2 = cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null;
        Objects.requireNonNull(consumer);
        com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.getCurrentLocation(locationManager, str, cancellationSignal2, executor, new ug2(consumer));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        SimpleArrayMap simpleArrayMap = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners;
        synchronized (simpleArrayMap) {
            LocationManagerCompat.GnssStatusTransport gnssStatusTransport = (LocationManagerCompat.GnssStatusTransport) simpleArrayMap.get(gnssStatusCompat$Callback);
            if (gnssStatusTransport == null) {
                gnssStatusTransport = new LocationManagerCompat.GnssStatusTransport(gnssStatusCompat$Callback);
            }
            if (!locationManager.registerGnssStatusCallback(executor, (GnssStatus.Callback) gnssStatusTransport)) {
                return false;
            }
            simpleArrayMap.put(gnssStatusCompat$Callback, gnssStatusTransport);
            return true;
        }
    }

    @DoNotInline
    public static boolean tryRequestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesExecutorMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", sLocationRequestClass, Executor.class, LocationListener.class);
                    sRequestLocationUpdatesExecutorMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesExecutorMethod.invoke(locationManager, locationRequest, executor, locationListenerCompat);
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
        return false;
    }
}
