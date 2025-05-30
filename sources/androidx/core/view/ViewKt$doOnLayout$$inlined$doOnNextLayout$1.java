package androidx.core.view;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ Function1 $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(Function1 function1) {
        this.$action$inlined = function1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action$inlined.invoke(view);
    }
}
