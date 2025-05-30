package androidx.compose.ui.layout;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a {
    public static int a(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int b(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int c(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public static int d(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
