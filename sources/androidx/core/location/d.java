package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ Location b;

    public /* synthetic */ d(Consumer consumer, Location location) {
        this.a = consumer;
        this.b = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationManagerCompat.CancellableLocationListener.a(this.a, this.b);
    }
}
