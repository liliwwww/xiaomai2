package androidx.lifecycle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ProcessLifecycleOwner$1 implements Runnable {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.dispatchPauseIfNeeded();
        this.this$0.dispatchStopIfNeeded();
    }
}
