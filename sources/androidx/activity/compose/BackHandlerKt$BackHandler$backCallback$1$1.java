package androidx.activity.compose;

import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BackHandlerKt$BackHandler$backCallback$1$1 extends OnBackPressedCallback {
    final /* synthetic */ State<Function0<Unit>> $currentOnBack$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackHandlerKt$BackHandler$backCallback$1$1(boolean z, State<? extends Function0<Unit>> state) {
        super(z);
        this.$currentOnBack$delegate = state;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        BackHandlerKt.access$BackHandler$lambda-0(this.$currentOnBack$delegate).invoke();
    }
}
