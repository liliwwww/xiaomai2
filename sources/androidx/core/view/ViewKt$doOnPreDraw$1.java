package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ Function1<View, Unit> $action;
    final /* synthetic */ View $this_doOnPreDraw;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewKt$doOnPreDraw$1(Function1<? super View, Unit> function1, View view) {
        this.$action = function1;
        this.$this_doOnPreDraw = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
