package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DefaultDebugIndication$DefaultDebugIndicationInstance implements IndicationInstance {

    @NotNull
    private final State<Boolean> isFocused;

    @NotNull
    private final State<Boolean> isHovered;

    @NotNull
    private final State<Boolean> isPressed;

    public DefaultDebugIndication$DefaultDebugIndicationInstance(@NotNull State<Boolean> state, @NotNull State<Boolean> state2, @NotNull State<Boolean> state3) {
        Intrinsics.checkNotNullParameter(state, "isPressed");
        Intrinsics.checkNotNullParameter(state2, "isHovered");
        Intrinsics.checkNotNullParameter(state3, "isFocused");
        this.isPressed = state;
        this.isHovered = state2;
        this.isFocused = state3;
    }

    public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        contentDrawScope.drawContent();
        if (this.isPressed.getValue().booleanValue()) {
            w51.K(contentDrawScope, Color.copy-wmQWz5c$default(Color.Companion.m1074getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, contentDrawScope.getSize-NH-jbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 122, (Object) null);
        } else if (this.isHovered.getValue().booleanValue() || this.isFocused.getValue().booleanValue()) {
            w51.K(contentDrawScope, Color.copy-wmQWz5c$default(Color.Companion.m1074getBlack0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, contentDrawScope.getSize-NH-jbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 122, (Object) null);
        }
    }
}
