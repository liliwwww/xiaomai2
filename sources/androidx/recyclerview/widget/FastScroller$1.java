package androidx.recyclerview.widget;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FastScroller$1 implements Runnable {
    final /* synthetic */ FastScroller this$0;

    FastScroller$1(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.hide(WVURLRuleConstants.ORDER_LIST);
    }
}
