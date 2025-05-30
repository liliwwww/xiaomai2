package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1 extends Lambda implements Function1<LayoutNode, Measurable> {
    public static final LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1 INSTANCE = new LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1();

    LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1() {
        super(1);
    }

    @NotNull
    public final Measurable invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        return layoutNode.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release();
    }
}
