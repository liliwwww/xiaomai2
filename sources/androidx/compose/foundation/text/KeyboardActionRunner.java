package androidx.compose.foundation.text;

import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.focus.FocusManager;
import androidx.compose.p004ui.text.input.ImeAction;
import androidx.compose.p004ui.text.input.TextInputSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;

    @Nullable
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo1729defaultKeyboardActionKlQnJC8(int i) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m4883equalsimpl0(i, companion.m4898getNexteUduSuo())) {
            getFocusManager().mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2492getNextdhqQ8s());
            return;
        }
        if (ImeAction.m4883equalsimpl0(i, companion.m4900getPreviouseUduSuo())) {
            getFocusManager().mo2498moveFocus3ESFkO8(FocusDirection.Companion.m2494getPreviousdhqQ8s());
            return;
        }
        if (!ImeAction.m4883equalsimpl0(i, companion.m4896getDoneeUduSuo())) {
            if (ImeAction.m4883equalsimpl0(i, companion.m4897getGoeUduSuo()) ? true : ImeAction.m4883equalsimpl0(i, companion.m4901getSearcheUduSuo()) ? true : ImeAction.m4883equalsimpl0(i, companion.m4902getSendeUduSuo()) ? true : ImeAction.m4883equalsimpl0(i, companion.m4895getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m4883equalsimpl0(i, companion.m4899getNoneeUduSuo());
        } else {
            TextInputSession textInputSession = this.inputSession;
            if (textInputSession != null) {
                textInputSession.hideSoftwareKeyboard();
            }
        }
    }

    @NotNull
    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    @Nullable
    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    @NotNull
    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    /* renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final void m1730runActionKlQnJC8(int i) {
        Function1<KeyboardActionScope, Unit> function1;
        ImeAction.Companion companion = ImeAction.Companion;
        Unit unit = null;
        if (ImeAction.m4883equalsimpl0(i, companion.m4896getDoneeUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.m4883equalsimpl0(i, companion.m4897getGoeUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.m4883equalsimpl0(i, companion.m4898getNexteUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.m4883equalsimpl0(i, companion.m4900getPreviouseUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m4883equalsimpl0(i, companion.m4901getSearcheUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m4883equalsimpl0(i, companion.m4902getSendeUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m4883equalsimpl0(i, companion.m4895getDefaulteUduSuo()) ? true : ImeAction.m4883equalsimpl0(i, companion.m4899getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            mo1729defaultKeyboardActionKlQnJC8(i);
        }
    }

    public final void setFocusManager(@NotNull FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(focusManager, "<set-?>");
        this.focusManager = focusManager;
    }

    public final void setInputSession(@Nullable TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final void setKeyboardActions(@NotNull KeyboardActions keyboardActions) {
        Intrinsics.checkNotNullParameter(keyboardActions, "<set-?>");
        this.keyboardActions = keyboardActions;
    }
}
