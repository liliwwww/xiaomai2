package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.IResultReceiver;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ResultReceiver$MyResultReceiver extends IResultReceiver.Stub {
    final /* synthetic */ ResultReceiver this$0;

    ResultReceiver$MyResultReceiver(ResultReceiver resultReceiver) {
        this.this$0 = resultReceiver;
    }

    public void send(final int i, final Bundle bundle) {
        final ResultReceiver resultReceiver = this.this$0;
        Handler handler = resultReceiver.mHandler;
        if (handler != null) {
            handler.post(new Runnable(resultReceiver, i, bundle) { // from class: android.support.v4.os.ResultReceiver$MyRunnable
                final int mResultCode;
                final Bundle mResultData;
                final /* synthetic */ ResultReceiver this$0;

                {
                    this.mResultCode = i;
                    this.mResultData = bundle;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
                }
            });
        } else {
            resultReceiver.onReceiveResult(i, bundle);
        }
    }
}
