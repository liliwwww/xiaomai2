package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal$OnCancelListener;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener a;

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public final void onCancel() {
        this.a.cancel();
    }
}
