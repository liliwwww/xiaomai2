package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1 extends LayoutNode.NoIntrinsicsMeasurePolicy {
    final /* synthetic */ Function2<SubcomposeMeasureScope, Constraints, MeasureResult> $block;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeSubcompositionsState$createMeasurePolicy$1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, String str) {
        super(str);
        this.this$0 = layoutNodeSubcompositionsState;
        this.$block = function2;
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1540measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        LayoutNodeSubcompositionsState.access$getScope$p(this.this$0).setLayoutDirection(measureScope.getLayoutDirection());
        LayoutNodeSubcompositionsState.access$getScope$p(this.this$0).setDensity(measureScope.getDensity());
        LayoutNodeSubcompositionsState.access$getScope$p(this.this$0).setFontScale(measureScope.getFontScale());
        LayoutNodeSubcompositionsState.access$setCurrentIndex$p(this.this$0, 0);
        return new measure.1((MeasureResult) this.$block.invoke(LayoutNodeSubcompositionsState.access$getScope$p(this.this$0), Constraints.m2110boximpl(j)), this.this$0, LayoutNodeSubcompositionsState.access$getCurrentIndex$p(this.this$0));
    }
}
