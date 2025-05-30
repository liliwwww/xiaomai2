package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ExcludeFromSystemGesture_androidKt {
    @Deprecated(message = "Use systemGestureExclusion", replaceWith = @ReplaceWith(expression = "systemGestureExclusion", imports = {}))
    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier);
    }

    @Deprecated(message = "Use systemGestureExclusion", replaceWith = @ReplaceWith(expression = "systemGestureExclusion", imports = {}))
    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier, @NotNull Function1<? super LayoutCoordinates, Rect> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "exclusion");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier, function1);
    }
}
