package androidx.compose.ui.input.pointer;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SuspendingPointerInputFilterKt {

    @NotNull
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(CollectionsKt.emptyList());

    @NotNull
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";

    @Deprecated(level = DeprecationLevel.ERROR, message = PointerInputModifierNoParamError)
    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        throw new IllegalStateException(PointerInputModifierNoParamError.toString());
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$.inlined.debugInspectorInfo.1(obj, function2) : InspectableValueKt.getNoInspectorInfo(), new pointerInput.2(obj, function2));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @Nullable Object obj2, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$.inlined.debugInspectorInfo.2(obj, obj2, function2) : InspectableValueKt.getNoInspectorInfo(), new pointerInput.4(obj, obj2, function2));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull Object[] objArr, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "keys");
        Intrinsics.checkNotNullParameter(function2, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$.inlined.debugInspectorInfo.3(objArr, function2) : InspectableValueKt.getNoInspectorInfo(), new pointerInput.6(objArr, function2));
    }
}
