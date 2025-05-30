package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
    public static final LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1 INSTANCE = new LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1();

    LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AlignmentLinesOwner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "it");
        alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
    }
}
