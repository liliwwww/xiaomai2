package androidx.concurrent.futures;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AbstractResolvableFuture$SynchronizedHelper extends AbstractResolvableFuture$AtomicHelper {
    AbstractResolvableFuture$SynchronizedHelper() {
        super();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.listeners != abstractResolvableFuture$Listener) {
                return false;
            }
            abstractResolvableFuture.listeners = abstractResolvableFuture$Listener2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.value != obj) {
                return false;
            }
            abstractResolvableFuture.value = obj2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        synchronized (abstractResolvableFuture) {
            if (abstractResolvableFuture.waiters != abstractResolvableFuture$Waiter) {
                return false;
            }
            abstractResolvableFuture.waiters = abstractResolvableFuture$Waiter2;
            return true;
        }
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        abstractResolvableFuture$Waiter.next = abstractResolvableFuture$Waiter2;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
    void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread) {
        abstractResolvableFuture$Waiter.thread = thread;
    }
}
