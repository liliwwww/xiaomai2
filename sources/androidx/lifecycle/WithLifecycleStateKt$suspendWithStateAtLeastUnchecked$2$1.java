package androidx.lifecycle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1 implements Runnable {
    final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$this_suspendWithStateAtLeastUnchecked.addObserver(this.$observer);
    }
}
