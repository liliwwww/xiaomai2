package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NestedScrollModifierLocal$1 extends Lambda implements Function0<CoroutineScope> {
    final /* synthetic */ NestedScrollModifierLocal this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedScrollModifierLocal$1(NestedScrollModifierLocal nestedScrollModifierLocal) {
        super(0);
        this.this$0 = nestedScrollModifierLocal;
    }

    @NotNull
    public final CoroutineScope invoke() {
        return NestedScrollModifierLocal.access$getNestedCoroutineScope(this.this$0);
    }
}
