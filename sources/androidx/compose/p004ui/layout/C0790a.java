package androidx.compose.p004ui.layout;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.ui.layout.a */
/* loaded from: classes.dex */
public final /* synthetic */ class C0790a {
    /* renamed from: a */
    public static int m141a(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: b */
    public static int m142b(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: c */
    public static int m143c(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: d */
    public static int m144d(@NotNull LayoutModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
