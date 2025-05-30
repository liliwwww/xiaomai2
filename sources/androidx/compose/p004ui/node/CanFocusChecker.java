package androidx.compose.p004ui.node;

import androidx.compose.p004ui.focus.FocusProperties;
import androidx.compose.p004ui.focus.FocusRequester;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class CanFocusChecker implements FocusProperties {

    @NotNull
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();

    @Nullable
    private static Boolean canFocusValue;

    private CanFocusChecker() {
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getDown() {
        return FocusProperties.CC.m89a(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getEnd() {
        return FocusProperties.CC.m90b(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ Function1 getEnter() {
        return FocusProperties.CC.m91c(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ Function1 getExit() {
        return FocusProperties.CC.m92d(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getLeft() {
        return FocusProperties.CC.m93e(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getNext() {
        return FocusProperties.CC.m94f(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getPrevious() {
        return FocusProperties.CC.m95g(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getRight() {
        return FocusProperties.CC.m96h(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getStart() {
        return FocusProperties.CC.m97i(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getUp() {
        return FocusProperties.CC.m98j(this);
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setDown(FocusRequester focusRequester) {
        FocusProperties.CC.m99k(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setEnd(FocusRequester focusRequester) {
        FocusProperties.CC.m100l(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setEnter(Function1 function1) {
        FocusProperties.CC.m101m(this, function1);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setExit(Function1 function1) {
        FocusProperties.CC.m102n(this, function1);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setLeft(FocusRequester focusRequester) {
        FocusProperties.CC.m103o(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setNext(FocusRequester focusRequester) {
        FocusProperties.CC.m104p(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setPrevious(FocusRequester focusRequester) {
        FocusProperties.CC.m105q(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setRight(FocusRequester focusRequester) {
        FocusProperties.CC.m106r(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setStart(FocusRequester focusRequester) {
        FocusProperties.CC.m107s(this, focusRequester);
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public /* synthetic */ void setUp(FocusRequester focusRequester) {
        FocusProperties.CC.m108t(this, focusRequester);
    }
}
