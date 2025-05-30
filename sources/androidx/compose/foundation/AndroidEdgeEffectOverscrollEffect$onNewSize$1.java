package androidx.compose.foundation;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidEdgeEffectOverscrollEffect$onNewSize$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$onNewSize$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        super(1);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m108invokeozmzZPI(((IntSize) obj).unbox-impl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m108invokeozmzZPI(long j) {
        boolean z = !Size.m899equalsimpl0(IntSizeKt.m2202toSizeozmzZPI(j), AndroidEdgeEffectOverscrollEffect.access$getContainerSize$p(this.this$0));
        AndroidEdgeEffectOverscrollEffect.access$setContainerSize$p(this.this$0, IntSizeKt.m2202toSizeozmzZPI(j));
        if (z) {
            AndroidEdgeEffectOverscrollEffect.access$getTopEffect$p(this.this$0).setSize(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getBottomEffect$p(this.this$0).setSize(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getLeftEffect$p(this.this$0).setSize(IntSize.getHeight-impl(j), IntSize.getWidth-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getRightEffect$p(this.this$0).setSize(IntSize.getHeight-impl(j), IntSize.getWidth-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getTopEffectNegation$p(this.this$0).setSize(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getBottomEffectNegation$p(this.this$0).setSize(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getLeftEffectNegation$p(this.this$0).setSize(IntSize.getHeight-impl(j), IntSize.getWidth-impl(j));
            AndroidEdgeEffectOverscrollEffect.access$getRightEffectNegation$p(this.this$0).setSize(IntSize.getHeight-impl(j), IntSize.getWidth-impl(j));
        }
        if (z) {
            AndroidEdgeEffectOverscrollEffect.access$invalidateOverscroll(this.this$0);
            AndroidEdgeEffectOverscrollEffect.access$animateToRelease(this.this$0);
        }
    }
}
