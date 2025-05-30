package androidx.compose.material;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DrawerKt$BottomDrawer$1$1$4$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$1$1$4$1(BottomDrawerState bottomDrawerState, CoroutineScope coroutineScope) {
        super(0);
        this.$drawerState = bottomDrawerState;
        this.$scope = coroutineScope;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m735invoke() {
        if (((Boolean) this.$drawerState.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed)).booleanValue()) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new 1(this.$drawerState, (Continuation) null), 3, (Object) null);
        }
        return Boolean.TRUE;
    }
}
