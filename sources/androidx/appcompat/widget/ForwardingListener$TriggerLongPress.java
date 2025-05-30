package androidx.appcompat.widget;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ForwardingListener$TriggerLongPress implements Runnable {
    final /* synthetic */ ForwardingListener this$0;

    ForwardingListener$TriggerLongPress(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.onLongPress();
    }
}
