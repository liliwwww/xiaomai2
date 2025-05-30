package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class AndroidBringIntoViewParent implements BringIntoViewParent {

    @NotNull
    private final View view;

    public AndroidBringIntoViewParent(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    @Nullable
    public Object bringChildIntoView(@NotNull LayoutCoordinates layoutCoordinates, @NotNull Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation) {
        Rect m2593translatek4lQ0M;
        android.graphics.Rect rect;
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
        Rect rect2 = (Rect) function0.invoke();
        if (rect2 == null || (m2593translatek4lQ0M = rect2.m2593translatek4lQ0M(positionInRoot)) == null) {
            return Unit.INSTANCE;
        }
        View view = this.view;
        rect = BringIntoViewResponder_androidKt.toRect(m2593translatek4lQ0M);
        view.requestRectangleOnScreen(rect, false);
        return Unit.INSTANCE;
    }
}
