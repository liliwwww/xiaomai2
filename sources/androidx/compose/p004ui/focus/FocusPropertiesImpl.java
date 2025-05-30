package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.focus.FocusRequester;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FocusPropertiesImpl implements FocusProperties {
    private boolean canFocus = true;

    @NotNull
    private FocusRequester down;

    @NotNull
    private FocusRequester end;

    @NotNull
    private Function1<? super FocusDirection, FocusRequester> enter;

    @NotNull
    private Function1<? super FocusDirection, FocusRequester> exit;

    @NotNull
    private FocusRequester left;

    @NotNull
    private FocusRequester next;

    @NotNull
    private FocusRequester previous;

    @NotNull
    private FocusRequester right;

    @NotNull
    private FocusRequester start;

    /* renamed from: up */
    @NotNull
    private FocusRequester f110up;

    public FocusPropertiesImpl() {
        FocusRequester.Companion companion = FocusRequester.Companion;
        this.next = companion.getDefault();
        this.previous = companion.getDefault();
        this.f110up = companion.getDefault();
        this.down = companion.getDefault();
        this.left = companion.getDefault();
        this.right = companion.getDefault();
        this.start = companion.getDefault();
        this.end = companion.getDefault();
        this.enter = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$enter$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2505invoke3ESFkO8(((FocusDirection) obj).m2482unboximpl());
            }

            @NotNull
            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m2505invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
        this.exit = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$exit$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2506invoke3ESFkO8(((FocusDirection) obj).m2482unboximpl());
            }

            @NotNull
            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m2506invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }

    public static /* synthetic */ void getEnter$annotations() {
    }

    public static /* synthetic */ void getExit$annotations() {
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getDown() {
        return this.down;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getEnd() {
        return this.end;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public Function1<FocusDirection, FocusRequester> getEnter() {
        return this.enter;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public Function1<FocusDirection, FocusRequester> getExit() {
        return this.exit;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getLeft() {
        return this.left;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getNext() {
        return this.next;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getPrevious() {
        return this.previous;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getRight() {
        return this.right;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getStart() {
        return this.start;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    @NotNull
    public FocusRequester getUp() {
        return this.f110up;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setCanFocus(boolean z) {
        this.canFocus = z;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setDown(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.down = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setEnd(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.end = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.enter = function1;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.exit = function1;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setLeft(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.left = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setNext(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.next = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setPrevious(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.previous = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setRight(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.right = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setStart(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.start = focusRequester;
    }

    @Override // androidx.compose.p004ui.focus.FocusProperties
    public void setUp(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.f110up = focusRequester;
    }
}
