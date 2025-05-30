package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a {
    public static void a(LayoutModifierNode _this) {
        DelegatableNodeKt.requireLayoutNode(_this).forceRemeasure();
    }

    public static int b(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int c(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int d(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int e(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
