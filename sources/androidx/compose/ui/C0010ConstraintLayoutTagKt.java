package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.constraintlayout.compose.ConstraintLayoutTagKt$layoutId$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u001e\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001\"\u0019\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0019\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "layoutId", "tag", "Landroidx/compose/ui/layout/Measurable;", "", "getConstraintLayoutTag", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/Object;", "constraintLayoutTag", "getConstraintLayoutId", "constraintLayoutId", "compose_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.constraintlayout.compose.ConstraintLayoutTagKt, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class C0010ConstraintLayoutTagKt {
    @Nullable
    public static final Object getConstraintLayoutId(@NotNull Measurable measurable) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Object parentData = measurable.getParentData();
        ConstraintLayoutTagParentData constraintLayoutTagParentData = parentData instanceof ConstraintLayoutTagParentData ? (ConstraintLayoutTagParentData) parentData : null;
        if (constraintLayoutTagParentData == null) {
            return null;
        }
        return constraintLayoutTagParentData.getConstraintLayoutId();
    }

    @Nullable
    public static final Object getConstraintLayoutTag(@NotNull Measurable measurable) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Object parentData = measurable.getParentData();
        ConstraintLayoutTagParentData constraintLayoutTagParentData = parentData instanceof ConstraintLayoutTagParentData ? (ConstraintLayoutTagParentData) parentData : null;
        if (constraintLayoutTagParentData == null) {
            return null;
        }
        return constraintLayoutTagParentData.getConstraintLayoutTag();
    }

    @NotNull
    public static final Modifier layoutId(@NotNull Modifier modifier, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "layoutId");
        if (str2 == null) {
            return LayoutIdKt.layoutId(modifier, str);
        }
        return modifier.then(new ConstraintLayoutTag(str2, str, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ConstraintLayoutTagKt$layoutId$.inlined.debugInspectorInfo.1(str) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static /* synthetic */ Modifier layoutId$default(Modifier modifier, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return layoutId(modifier, str, str2);
    }
}
