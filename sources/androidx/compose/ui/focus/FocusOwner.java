package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface FocusOwner extends FocusManager {
    void clearFocus(boolean z, boolean z2);

    /* renamed from: dispatchKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo984dispatchKeyEventZmokQxo(@NotNull KeyEvent keyEvent);

    boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);

    @Nullable
    Rect getFocusRect();

    @NotNull
    LayoutDirection getLayoutDirection();

    @NotNull
    Modifier getModifier();

    void releaseFocus();

    void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode);

    void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode);

    void scheduleInvalidation(@NotNull FocusTargetModifierNode focusTargetModifierNode);

    void setLayoutDirection(@NotNull LayoutDirection layoutDirection);

    void takeFocus();
}
