package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AsyncListDiffer$1$2 implements Runnable {
    final /* synthetic */ AsyncListDiffer.1 this$1;
    final /* synthetic */ DiffUtil.DiffResult val$result;

    AsyncListDiffer$1$2(AsyncListDiffer.1 r1, DiffUtil.DiffResult diffResult) {
        this.this$1 = r1;
        this.val$result = diffResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncListDiffer.1 r0 = this.this$1;
        AsyncListDiffer asyncListDiffer = r0.this$0;
        if (asyncListDiffer.mMaxScheduledGeneration == r0.val$runGeneration) {
            asyncListDiffer.latchList(r0.val$newList, this.val$result, r0.val$commitCallback);
        }
    }
}
