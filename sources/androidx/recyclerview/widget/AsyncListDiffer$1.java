package androidx.recyclerview.widget;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AsyncListDiffer$1 implements Runnable {
    final /* synthetic */ AsyncListDiffer this$0;
    final /* synthetic */ Runnable val$commitCallback;
    final /* synthetic */ List val$newList;
    final /* synthetic */ List val$oldList;
    final /* synthetic */ int val$runGeneration;

    AsyncListDiffer$1(AsyncListDiffer asyncListDiffer, List list, List list2, int i, Runnable runnable) {
        this.this$0 = asyncListDiffer;
        this.val$oldList = list;
        this.val$newList = list2;
        this.val$runGeneration = i;
        this.val$commitCallback = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mMainThreadExecutor.execute(new 2(this, DiffUtil.calculateDiff(new 1(this))));
    }
}
