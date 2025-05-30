package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FocusChangedModifierNode extends Modifier.Node implements FocusEventModifierNode {

    @Nullable
    private FocusState focusState;

    @NotNull
    private Function1<? super FocusState, Unit> onFocusChanged;

    public FocusChangedModifierNode(@NotNull Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFocusChanged");
        this.onFocusChanged = function1;
    }

    @Nullable
    public final FocusState getFocusState() {
        return this.focusState;
    }

    @NotNull
    public final Function1<FocusState, Unit> getOnFocusChanged() {
        return this.onFocusChanged;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (Intrinsics.areEqual(this.focusState, focusState)) {
            return;
        }
        this.focusState = focusState;
        this.onFocusChanged.invoke(focusState);
    }

    public final void setFocusState(@Nullable FocusState focusState) {
        this.focusState = focusState;
    }

    public final void setOnFocusChanged(@NotNull Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFocusChanged = function1;
    }
}
