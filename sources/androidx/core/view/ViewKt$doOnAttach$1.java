package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function1<View, Unit> $action;
    final /* synthetic */ View $this_doOnAttach;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewKt$doOnAttach$1(View view, Function1<? super View, Unit> function1) {
        this.$this_doOnAttach = view;
        this.$action = function1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
