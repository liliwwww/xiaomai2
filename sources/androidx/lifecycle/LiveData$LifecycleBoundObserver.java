package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LiveData$LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

    @NonNull
    final LifecycleOwner mOwner;
    final /* synthetic */ LiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveData$LifecycleBoundObserver(@NonNull LiveData liveData, LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        super(liveData, observer);
        this.this$0 = liveData;
        this.mOwner = lifecycleOwner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void detachObserver() {
        this.mOwner.getLifecycle().removeObserver(this);
    }

    boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        return this.mOwner == lifecycleOwner;
    }

    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        Lifecycle.State currentState = this.mOwner.getLifecycle().getCurrentState();
        if (currentState == Lifecycle.State.DESTROYED) {
            this.this$0.removeObserver(((LiveData.ObserverWrapper) this).mObserver);
            return;
        }
        Lifecycle.State state = null;
        while (state != currentState) {
            activeStateChanged(shouldBeActive());
            state = currentState;
            currentState = this.mOwner.getLifecycle().getCurrentState();
        }
    }

    boolean shouldBeActive() {
        return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
}
