package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ReportFragment;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ProcessLifecycleOwner implements LifecycleOwner {

    @VisibleForTesting
    static final long TIMEOUT_MS = 700;
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    private Handler mHandler;
    private int mStartedCounter = 0;
    private int mResumedCounter = 0;
    private boolean mPauseSent = true;
    private boolean mStopSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private Runnable mDelayedPauseRunnable = new 1(this);
    ReportFragment.ActivityInitializationListener mInitializationListener = new 2(this);

    private ProcessLifecycleOwner() {
    }

    @NonNull
    public static LifecycleOwner get() {
        return sInstance;
    }

    static void init(Context context) {
        sInstance.attach(context);
    }

    void activityPaused() {
        int i = this.mResumedCounter - 1;
        this.mResumedCounter = i;
        if (i == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, TIMEOUT_MS);
        }
    }

    void activityResumed() {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i == 1) {
            if (!this.mPauseSent) {
                this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
            } else {
                this.mRegistry.handleLifecycleEvent(Lifecycle$Event.ON_RESUME);
                this.mPauseSent = false;
            }
        }
    }

    void activityStarted() {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle$Event.ON_START);
            this.mStopSent = false;
        }
    }

    void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    void attach(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle$Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new 3(this));
    }

    void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle$Event.ON_PAUSE);
        }
    }

    void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle$Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
