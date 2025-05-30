package androidx.lifecycle;

import androidx.lifecycle.WithLifecycleStateKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2$1 implements Runnable {
    final /* synthetic */ WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.observer.1 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2$1(Lifecycle lifecycle, WithLifecycleStateKt.suspendWithStateAtLeastUnchecked.2.observer.1 r2) {
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
    }
}
