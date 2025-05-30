package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LayoutNodeLayoutDelegate$performLookaheadMeasure$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $constraints;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$performLookaheadMeasure$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.$constraints = j;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1613invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1613invoke() {
        LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        lookaheadDelegate$ui_release.mo1521measureBRTryo0(this.$constraints);
    }
}
