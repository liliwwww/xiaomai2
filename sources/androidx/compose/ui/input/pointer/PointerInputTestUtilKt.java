package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerInputTestUtilKt {
    @NotNull
    public static final PointerInputChange down(long j, long j2, float f, float f2) {
        return new PointerInputChange(PointerId.constructor-impl(j), j2, OffsetKt.Offset(f, f2), true, 1.0f, j2, OffsetKt.Offset(f, f2), false, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange down$default(long j, long j2, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        return down(j, j2, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? 0.0f : f2);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY, reason: not valid java name */
    public static final void m2022invokeOverAllPassesH0pRuoY(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, long j) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverAllPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        m2026invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt.listOf(new PointerEventPass[]{PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final}), j);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY$default, reason: not valid java name */
    public static /* synthetic */ void m2023invokeOverAllPassesH0pRuoY$default(Function3 function3, PointerEvent pointerEvent, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2022invokeOverAllPassesH0pRuoY(function3, pointerEvent, j);
    }

    /* renamed from: invokeOverPass-hUlJWOE, reason: not valid java name */
    public static final void m2024invokeOverPasshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPass");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pointerEventPass");
        m2026invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt.listOf(pointerEventPass), j);
    }

    /* renamed from: invokeOverPass-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2025invokeOverPasshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2024invokeOverPasshUlJWOE(function3, pointerEvent, pointerEventPass, j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m2027invokeOverPasseshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass[] pointerEventPassArr, long j) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPassArr, "pointerEventPasses");
        m2026invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) ArraysKt.toList(pointerEventPassArr), j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2029invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2027invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, pointerEventPassArr, j);
    }

    @NotNull
    public static final PointerInputChange moveBy(@NotNull PointerInputChange pointerInputChange, long j, float f, float f2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long j2 = pointerInputChange.getId-J3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(j2, pointerInputChange.getUptimeMillis() + j, OffsetKt.Offset(Offset.getX-impl(pointerInputChange.getPosition-F1C5BW0()) + f, Offset.getY-impl(pointerInputChange.getPosition-F1C5BW0()) + f2), true, 1.0f, uptimeMillis, pointerInputChange.getPosition-F1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveBy(pointerInputChange, j, f, f2);
    }

    @NotNull
    public static final PointerInputChange moveTo(@NotNull PointerInputChange pointerInputChange, long j, float f, float f2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long j2 = pointerInputChange.getId-J3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(j2, j, OffsetKt.Offset(f, f2), true, 1.0f, uptimeMillis, pointerInputChange.getPosition-F1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveTo(pointerInputChange, j, f, f2);
    }

    @NotNull
    public static final PointerInputChange up(@NotNull PointerInputChange pointerInputChange, long j) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long j2 = pointerInputChange.getId-J3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(j2, j, pointerInputChange.getPosition-F1C5BW0(), false, 1.0f, uptimeMillis, pointerInputChange.getPosition-F1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    /* renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m2026invokeOverPasseshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull List<? extends PointerEventPass> list, long j) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(list, "pointerEventPasses");
        if (!(!pointerEvent.getChanges().isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function3.invoke(pointerEvent, list.get(i), IntSize.m2677boximpl(j));
        }
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2028invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, List list, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2026invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, (List<? extends PointerEventPass>) list, j);
    }
}
