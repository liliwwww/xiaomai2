package androidx.compose.material;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerKt$ModalDrawer$1$2$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$2$2(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        super(0);
        this.$gesturesEnabled = z;
        this.$drawerState = drawerState;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m582invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m582invoke() {
        if (this.$gesturesEnabled && ((Boolean) this.$drawerState.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed)).booleanValue()) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new 1(this.$drawerState, (Continuation) null), 3, (Object) null);
        }
    }
}
