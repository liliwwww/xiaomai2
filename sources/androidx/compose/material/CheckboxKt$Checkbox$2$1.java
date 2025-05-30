package androidx.compose.material;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CheckboxKt$Checkbox$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CheckboxKt$Checkbox$2$1(Function1<? super Boolean, Unit> function1, boolean z) {
        super(0);
        this.$onCheckedChange = function1;
        this.$checked = z;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m685invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m685invoke() {
        this.$onCheckedChange.invoke(Boolean.valueOf(!this.$checked));
    }
}
