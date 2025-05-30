package androidx.compose.p004ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.p004ui.geometry.Offset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long j, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MotionEvent obtain = MotionEvent.obtain(j, j, 3, 0.0f, 0.0f, 0);
        obtain.setSource(0);
        Intrinsics.checkNotNullExpressionValue(obtain, "motionEvent");
        function1.invoke(obtain);
        obtain.recycle();
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j, function1);
    }

    /* renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m4126toCancelMotionEventScoped4ec7I(@NotNull PointerEvent pointerEvent, long j, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(pointerEvent, "$this$toCancelMotionEventScope");
        Intrinsics.checkNotNullParameter(function1, "block");
        m4128toMotionEventScopeubNVwUQ(pointerEvent, j, function1, true);
    }

    /* renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m4127toMotionEventScoped4ec7I(@NotNull PointerEvent pointerEvent, long j, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(pointerEvent, "$this$toMotionEventScope");
        Intrinsics.checkNotNullParameter(function1, "block");
        m4128toMotionEventScopeubNVwUQ(pointerEvent, j, function1, false);
    }

    /* renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m4128toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j, Function1<? super MotionEvent, Unit> function1, boolean z) {
        MotionEvent motionEvent$ui_release = pointerEvent.getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
        }
        int action = motionEvent$ui_release.getAction();
        if (z) {
            motionEvent$ui_release.setAction(3);
        }
        motionEvent$ui_release.offsetLocation(-Offset.m2556getXimpl(j), -Offset.m2557getYimpl(j));
        function1.invoke(motionEvent$ui_release);
        motionEvent$ui_release.offsetLocation(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        motionEvent$ui_release.setAction(action);
    }
}
