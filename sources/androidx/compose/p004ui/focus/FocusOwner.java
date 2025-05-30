package androidx.compose.p004ui.focus;

import android.view.KeyEvent;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p004ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface FocusOwner extends FocusManager {
    void clearFocus(boolean z, boolean z2);

    /* renamed from: dispatchKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo2500dispatchKeyEventZmokQxo(@NotNull KeyEvent keyEvent);

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
