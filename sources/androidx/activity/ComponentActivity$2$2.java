package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ComponentActivity$2$2 implements Runnable {
    final /* synthetic */ ComponentActivity.2 this$1;
    final /* synthetic */ IntentSender.SendIntentException val$e;
    final /* synthetic */ int val$requestCode;

    ComponentActivity$2$2(ComponentActivity.2 r1, int i, IntentSender.SendIntentException sendIntentException) {
        this.this$1 = r1;
        this.val$requestCode = i;
        this.val$e = sendIntentException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, this.val$e));
    }
}
