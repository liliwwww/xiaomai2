package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class CallbackToFutureAdapter$SafeFuture$1 extends AbstractResolvableFuture<Object> {
    final /* synthetic */ CallbackToFutureAdapter.SafeFuture this$0;

    CallbackToFutureAdapter$SafeFuture$1(CallbackToFutureAdapter.SafeFuture safeFuture) {
        this.this$0 = safeFuture;
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected String pendingToString() {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.this$0.completerWeakReference.get();
        if (completer == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + completer.tag + "]";
    }
}
