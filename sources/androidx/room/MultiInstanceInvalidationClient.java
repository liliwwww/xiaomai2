package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MultiInstanceInvalidationClient {
    final Context mAppContext;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker$Observer mObserver;
    final Runnable mRemoveObserverRunnable;

    @Nullable
    IMultiInstanceInvalidationService mService;
    final ServiceConnection mServiceConnection;
    final Runnable mSetUpRunnable;
    final IMultiInstanceInvalidationCallback mCallback = new 1(this);
    final AtomicBoolean mStopped = new AtomicBoolean(false);

    MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        2 r0 = new 2(this);
        this.mServiceConnection = r0;
        this.mSetUpRunnable = new 3(this);
        this.mRemoveObserverRunnable = new 4(this);
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new 5(this, (String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]));
        applicationContext.bindService(intent, (ServiceConnection) r0, 1);
    }

    void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mInvalidationTracker.removeObserver(this.mObserver);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.mCallback, this.mClientId);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            this.mAppContext.unbindService(this.mServiceConnection);
        }
    }
}
