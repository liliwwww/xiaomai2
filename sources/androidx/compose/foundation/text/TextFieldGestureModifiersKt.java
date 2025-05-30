package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusChangedModifierKt;
import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.focus.FocusRequesterModifierKt;
import androidx.compose.p004ui.focus.FocusState;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextFieldGestureModifiersKt {
    @NotNull
    public static final Modifier longPressDragGestureFilter(@NotNull Modifier modifier, @NotNull TextDragObserver textDragObserver, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textDragObserver, "observer");
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, textDragObserver, new TextFieldGestureModifiersKt$longPressDragGestureFilter$1(textDragObserver, null)) : modifier;
    }

    @NotNull
    public static final Modifier mouseDragGestureDetector(@NotNull Modifier modifier, @NotNull MouseSelectionObserver mouseSelectionObserver, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(mouseSelectionObserver, "observer");
        return z ? SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, mouseSelectionObserver, new TextFieldGestureModifiersKt$mouseDragGestureDetector$1(mouseSelectionObserver, null)) : modifier;
    }

    @NotNull
    public static final Modifier textFieldFocusModifier(@NotNull Modifier modifier, boolean z, @NotNull FocusRequester focusRequester, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(function1, "onFocusChanged");
        return FocusableKt.focusable(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), function1), z, mutableInteractionSource);
    }
}
