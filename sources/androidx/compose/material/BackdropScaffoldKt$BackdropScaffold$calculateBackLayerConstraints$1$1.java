package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends Lambda implements Function1<Constraints, Constraints> {
    final /* synthetic */ float $headerHeightPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f) {
        super(1);
        this.$headerHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Constraints.m2110boximpl(m502invokeZezNO4M(((Constraints) obj).m2128unboximpl()));
    }

    /* renamed from: invoke-ZezNO4M, reason: not valid java name */
    public final long m502invokeZezNO4M(long j) {
        return ConstraintsKt.m2139offsetNN6EwU$default(Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(this.$headerHeightPx), 1, null);
    }
}
