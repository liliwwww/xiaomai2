package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusPropertiesModifierNodeImpl extends Modifier$Node implements FocusPropertiesModifierNode {

    @NotNull
    private Function1<? super FocusProperties, Unit> focusPropertiesScope;

    public FocusPropertiesModifierNodeImpl(@NotNull Function1<? super FocusProperties, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "focusPropertiesScope");
        this.focusPropertiesScope = function1;
    }

    @NotNull
    public final Function1<FocusProperties, Unit> getFocusPropertiesScope$ui_release() {
        return this.focusPropertiesScope;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void modifyFocusProperties(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        this.focusPropertiesScope.invoke(focusProperties);
    }

    public final void setFocusPropertiesScope$ui_release(@NotNull Function1<? super FocusProperties, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.focusPropertiesScope = function1;
    }
}
