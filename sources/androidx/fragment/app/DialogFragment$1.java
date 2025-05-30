package androidx.fragment.app;

import android.annotation.SuppressLint;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DialogFragment$1 implements Runnable {
    final /* synthetic */ DialogFragment this$0;

    DialogFragment$1(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        DialogFragment.access$100(this.this$0).onDismiss(DialogFragment.access$000(this.this$0));
    }
}
