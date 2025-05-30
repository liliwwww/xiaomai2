package androidx.appcompat.widget;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class DropDownListView$ResolveHoverRunnable implements Runnable {
    final /* synthetic */ DropDownListView this$0;

    DropDownListView$ResolveHoverRunnable(DropDownListView dropDownListView) {
        this.this$0 = dropDownListView;
    }

    public void cancel() {
        DropDownListView dropDownListView = this.this$0;
        dropDownListView.mResolveHoverRunnable = null;
        dropDownListView.removeCallbacks(this);
    }

    public void post() {
        this.this$0.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        DropDownListView dropDownListView = this.this$0;
        dropDownListView.mResolveHoverRunnable = null;
        dropDownListView.drawableStateChanged();
    }
}
