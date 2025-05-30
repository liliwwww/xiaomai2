package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ComponentActivity$2$1 implements Runnable {
    final /* synthetic */ ComponentActivity.2 this$1;
    final /* synthetic */ int val$requestCode;
    final /* synthetic */ ActivityResultContract$SynchronousResult val$synchronousResult;

    ComponentActivity$2$1(ComponentActivity.2 r1, int i, ActivityResultContract$SynchronousResult activityResultContract$SynchronousResult) {
        this.this$1 = r1;
        this.val$requestCode = i;
        this.val$synchronousResult = activityResultContract$SynchronousResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
    }
}
