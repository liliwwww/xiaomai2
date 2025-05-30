package androidx.print;

import android.os.CancellationSignal;
import androidx.print.PrintHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PrintHelper$PrintUriAdapter$1$1 implements CancellationSignal.OnCancelListener {
    final /* synthetic */ PrintHelper.PrintUriAdapter.1 this$2;

    PrintHelper$PrintUriAdapter$1$1(PrintHelper.PrintUriAdapter.1 r1) {
        this.this$2 = r1;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        this.this$2.this$1.cancelLoad();
        this.this$2.cancel(false);
    }
}
