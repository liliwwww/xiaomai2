package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Transformations;

/* JADX INFO: Add missing generic type declarations: [Y] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Transformations$2$1<Y> implements Observer<Y> {
    final /* synthetic */ Transformations.2 this$0;

    Transformations$2$1(Transformations.2 r1) {
        this.this$0 = r1;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@Nullable Y y) {
        this.this$0.val$result.setValue(y);
    }
}
