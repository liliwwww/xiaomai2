package androidx.compose.ui.graphics.vector;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorPainter$vector$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VectorPainter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VectorPainter$vector$1$1(VectorPainter vectorPainter) {
        super(0);
        this.this$0 = vectorPainter;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1360invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1360invoke() {
        VectorPainter.access$setDirty(this.this$0, true);
    }
}
