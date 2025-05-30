package androidx.compose.p004ui.node;

import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.ui.node.a */
/* loaded from: classes.dex */
public final /* synthetic */ class C0800a {
    /* renamed from: a */
    public static void m155a(LayoutModifierNode _this) {
        DelegatableNodeKt.requireLayoutNode(_this).forceRemeasure();
    }

    /* renamed from: b */
    public static int m156b(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: c */
    public static int m157c(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: d */
    public static int m158d(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: e */
    public static int m159e(@NotNull LayoutModifierNode _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(_this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
