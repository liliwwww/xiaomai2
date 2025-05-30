package androidx.compose.material;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnackbarKt$Snackbar$actionComposable$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$actionComposable$1$1(SnackbarData snackbarData) {
        super(0);
        this.$snackbarData = snackbarData;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m809invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m809invoke() {
        this.$snackbarData.performAction();
    }
}
