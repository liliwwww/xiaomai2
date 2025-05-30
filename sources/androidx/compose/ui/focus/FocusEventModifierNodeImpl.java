package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusEventModifierNodeImpl extends Modifier.Node implements FocusEventModifierNode {

    @NotNull
    private Function1<? super FocusState, Unit> onFocusEvent;

    public FocusEventModifierNodeImpl(@NotNull Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFocusEvent");
        this.onFocusEvent = function1;
    }

    @NotNull
    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        this.onFocusEvent.invoke(focusState);
    }

    public final void setOnFocusEvent(@NotNull Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFocusEvent = function1;
    }
}
