package androidx.room;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class InvalidationTracker$WeakObserver extends InvalidationTracker$Observer {
    final WeakReference<InvalidationTracker$Observer> mDelegateRef;
    final InvalidationTracker mTracker;

    InvalidationTracker$WeakObserver(InvalidationTracker invalidationTracker, InvalidationTracker$Observer invalidationTracker$Observer) {
        super(invalidationTracker$Observer.mTables);
        this.mTracker = invalidationTracker;
        this.mDelegateRef = new WeakReference<>(invalidationTracker$Observer);
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        InvalidationTracker$Observer invalidationTracker$Observer = this.mDelegateRef.get();
        if (invalidationTracker$Observer == null) {
            this.mTracker.removeObserver(this);
        } else {
            invalidationTracker$Observer.onInvalidated(set);
        }
    }
}
