package androidx.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ Function1<OnBackPressedCallback, Unit> $onBackPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OnBackPressedDispatcherKt$addCallback$callback$1(boolean z, Function1<? super OnBackPressedCallback, Unit> function1) {
        super(z);
        this.$onBackPressed = function1;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
