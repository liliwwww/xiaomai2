package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;

    @Nullable
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo397defaultKeyboardActionKlQnJC8(int i) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m1947equalsimpl0(i, companion.m1962getNexteUduSuo())) {
            getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
            return;
        }
        if (ImeAction.m1947equalsimpl0(i, companion.m1964getPreviouseUduSuo())) {
            getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
            return;
        }
        if (!ImeAction.m1947equalsimpl0(i, companion.m1960getDoneeUduSuo())) {
            if (ImeAction.m1947equalsimpl0(i, companion.m1961getGoeUduSuo()) ? true : ImeAction.m1947equalsimpl0(i, companion.m1965getSearcheUduSuo()) ? true : ImeAction.m1947equalsimpl0(i, companion.m1966getSendeUduSuo()) ? true : ImeAction.m1947equalsimpl0(i, companion.m1959getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m1947equalsimpl0(i, companion.m1963getNoneeUduSuo());
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
    public final void m398runActionKlQnJC8(int i) {
        Function1<KeyboardActionScope, Unit> function1;
        ImeAction.Companion companion = ImeAction.Companion;
        Unit unit = null;
        if (ImeAction.m1947equalsimpl0(i, companion.m1960getDoneeUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.m1947equalsimpl0(i, companion.m1961getGoeUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.m1947equalsimpl0(i, companion.m1962getNexteUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.m1947equalsimpl0(i, companion.m1964getPreviouseUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m1947equalsimpl0(i, companion.m1965getSearcheUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m1947equalsimpl0(i, companion.m1966getSendeUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m1947equalsimpl0(i, companion.m1959getDefaulteUduSuo()) ? true : ImeAction.m1947equalsimpl0(i, companion.m1963getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            mo397defaultKeyboardActionKlQnJC8(i);
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
