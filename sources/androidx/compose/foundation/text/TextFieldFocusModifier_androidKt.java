package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.focus.FocusManager;
import androidx.compose.p004ui.input.key.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEventType;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.compose.p004ui.input.key.KeyInputModifierKt;
import androidx.compose.p004ui.input.key.Key_androidKt;
import androidx.compose.p004ui.text.input.TextInputSession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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
                return m1788invokeZmokQxo(((KeyEvent) obj).m3953unboximpl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1788invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                boolean mo2498moveFocus3ESFkO8;
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                InputDevice device = keyEvent.getDevice();
                if (device == null) {
                    return Boolean.FALSE;
                }
                if (device.getKeyboardType() == 2 && device.isVirtual()) {
                    return Boolean.FALSE;
                }
                if (!KeyEventType.m3957equalsimpl0(KeyEvent_androidKt.m3965getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3961getKeyDownCS__XNY())) {
                    return Boolean.FALSE;
                }
                switch (Key_androidKt.m3973getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent))) {
                    case 19:
                        mo2498moveFocus3ESFkO8 = FocusManager.this.mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2496getUpdhqQ8s());
                        break;
                    case 20:
                        mo2498moveFocus3ESFkO8 = FocusManager.this.mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2487getDowndhqQ8s());
                        break;
                    case 21:
                        mo2498moveFocus3ESFkO8 = FocusManager.this.mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2491getLeftdhqQ8s());
                        break;
                    case 22:
                        mo2498moveFocus3ESFkO8 = FocusManager.this.mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2495getRightdhqQ8s());
                        break;
                    case 23:
                        TextInputSession inputSession = textFieldState.getInputSession();
                        if (inputSession != null) {
                            inputSession.showSoftwareKeyboard();
                        }
                        mo2498moveFocus3ESFkO8 = true;
                        break;
                    default:
                        mo2498moveFocus3ESFkO8 = false;
                        break;
                }
                return Boolean.valueOf(mo2498moveFocus3ESFkO8);
            }
        });
    }
}
