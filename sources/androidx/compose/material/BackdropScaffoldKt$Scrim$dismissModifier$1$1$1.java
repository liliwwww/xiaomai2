package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BackdropScaffoldKt$Scrim$dismissModifier$1$1$1 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ Function0<Unit> $onDismiss;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$Scrim$dismissModifier$1$1$1(Function0<Unit> function0) {
        super(1);
        this.$onDismiss = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m672invokek4lQ0M(((Offset) obj).unbox-impl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final void m672invokek4lQ0M(long j) {
        this.$onDismiss.invoke();
    }
}
