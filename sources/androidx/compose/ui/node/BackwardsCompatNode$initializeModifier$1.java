package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BackwardsCompatNode$initializeModifier$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BackwardsCompatNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackwardsCompatNode$initializeModifier$1(BackwardsCompatNode backwardsCompatNode) {
        super(0);
        this.this$0 = backwardsCompatNode;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2092invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2092invoke() {
        this.this$0.updateModifierLocalConsumer();
    }
}
