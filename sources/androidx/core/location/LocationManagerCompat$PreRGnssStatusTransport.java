package androidx.core.location;

import android.location.GnssStatus;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LocationManagerCompat$PreRGnssStatusTransport extends GnssStatus.Callback {
    final GnssStatusCompat$Callback mCallback;

    @Nullable
    volatile Executor mExecutor;

    LocationManagerCompat$PreRGnssStatusTransport(GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        Preconditions.checkArgument(gnssStatusCompat$Callback != null, "invalid null callback");
        this.mCallback = gnssStatusCompat$Callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFirstFix$2(Executor executor, int i) {
        if (this.mExecutor != executor) {
            return;
        }
        this.mCallback.onFirstFix(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSatelliteStatusChanged$3(Executor executor, GnssStatus gnssStatus) {
        if (this.mExecutor != executor) {
            return;
        }
        this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStarted$0(Executor executor) {
        if (this.mExecutor != executor) {
            return;
        }
        this.mCallback.onStarted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStopped$1(Executor executor) {
        if (this.mExecutor != executor) {
            return;
        }
        this.mCallback.onStopped();
    }

    @Override // android.location.GnssStatus.Callback
    public void onFirstFix(final int i) {
        final Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.core.location.q
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$PreRGnssStatusTransport.this.lambda$onFirstFix$2(executor, i);
            }
        });
    }

    @Override // android.location.GnssStatus.Callback
    public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
        final Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.core.location.r
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$PreRGnssStatusTransport.this.lambda$onSatelliteStatusChanged$3(executor, gnssStatus);
            }
        });
    }

    @Override // android.location.GnssStatus.Callback
    public void onStarted() {
        final Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.core.location.p
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$PreRGnssStatusTransport.this.lambda$onStarted$0(executor);
            }
        });
    }

    @Override // android.location.GnssStatus.Callback
    public void onStopped() {
        final Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.core.location.o
            @Override // java.lang.Runnable
            public final void run() {
                LocationManagerCompat$PreRGnssStatusTransport.this.lambda$onStopped$1(executor);
            }
        });
    }

    public void register(Executor executor) {
        Preconditions.checkArgument(executor != null, "invalid null executor");
        Preconditions.checkState(this.mExecutor == null);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}
