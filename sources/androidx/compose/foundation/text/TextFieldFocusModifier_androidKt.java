package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextFieldFocusModifier_androidKt {
    @NotNull
    public static final Modifier interceptDPadAndMoveFocus(@NotNull Modifier modifier, @NotNull final TextFieldState textFieldState, @NotNull final FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldState, "state");
        Intrinsics.checkNotNullParameter(focusManager, "focusManager");
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m577invokeZmokQxo(((KeyEvent) obj).m1942unboximpl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m577invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                boolean mo983moveFocus3ESFkO8;
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                InputDevice device = keyEvent.getDevice();
                if (device == null) {
                    return Boolean.FALSE;
                }
                if (device.getKeyboardType() == 2 && device.isVirtual()) {
                    return Boolean.FALSE;
                }
                if (!KeyEventType.m1946equalsimpl0(KeyEvent_androidKt.m1951getTypeZmokQxo(keyEvent), KeyEventType.Companion.getKeyDown-CS__XNY())) {
                    return Boolean.FALSE;
                }
                switch (Key_androidKt.getNativeKeyCode-YVgTNJs(KeyEvent_androidKt.m1950getKeyZmokQxo(keyEvent))) {
                    case 19:
                        mo983moveFocus3ESFkO8 = FocusManager.this.mo983moveFocus3ESFkO8(FocusDirection.Companion.m981getUpdhqQ8s());
                        break;
                    case 20:
                        mo983moveFocus3ESFkO8 = FocusManager.this.mo983moveFocus3ESFkO8(FocusDirection.Companion.m972getDowndhqQ8s());
                        break;
                    case 21:
                        mo983moveFocus3ESFkO8 = FocusManager.this.mo983moveFocus3ESFkO8(FocusDirection.Companion.m976getLeftdhqQ8s());
                        break;
                    case 22:
                        mo983moveFocus3ESFkO8 = FocusManager.this.mo983moveFocus3ESFkO8(FocusDirection.Companion.m980getRightdhqQ8s());
                        break;
                    case 23:
                        TextInputSession inputSession = textFieldState.getInputSession();
                        if (inputSession != null) {
                            inputSession.showSoftwareKeyboard();
                        }
                        mo983moveFocus3ESFkO8 = true;
                        break;
                    default:
                        mo983moveFocus3ESFkO8 = false;
                        break;
                }
                return Boolean.valueOf(mo983moveFocus3ESFkO8);
            }
        });
    }
}
