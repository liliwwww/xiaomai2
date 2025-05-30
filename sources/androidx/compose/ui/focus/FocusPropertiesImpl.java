package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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

    @NotNull
    private FocusRequester up;

    public FocusPropertiesImpl() {
        FocusRequester.Companion companion = FocusRequester.Companion;
        this.next = companion.getDefault();
        this.previous = companion.getDefault();
        this.up = companion.getDefault();
        this.down = companion.getDefault();
        this.left = companion.getDefault();
        this.right = companion.getDefault();
        this.start = companion.getDefault();
        this.end = companion.getDefault();
        this.enter = new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$enter$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m988invoke3ESFkO8(((FocusDirection) obj).m967unboximpl());
            }

            @NotNull
            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m988invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
        this.exit = exit.1.INSTANCE;
    }

    public static /* synthetic */ void getEnter$annotations() {
    }

    public static /* synthetic */ void getExit$annotations() {
    }

    public boolean getCanFocus() {
        return this.canFocus;
    }

    @NotNull
    public FocusRequester getDown() {
        return this.down;
    }

    @NotNull
    public FocusRequester getEnd() {
        return this.end;
    }

    @NotNull
    public Function1<FocusDirection, FocusRequester> getEnter() {
        return this.enter;
    }

    @NotNull
    public Function1<FocusDirection, FocusRequester> getExit() {
        return this.exit;
    }

    @NotNull
    public FocusRequester getLeft() {
        return this.left;
    }

    @NotNull
    public FocusRequester getNext() {
        return this.next;
    }

    @NotNull
    public FocusRequester getPrevious() {
        return this.previous;
    }

    @NotNull
    public FocusRequester getRight() {
        return this.right;
    }

    @NotNull
    public FocusRequester getStart() {
        return this.start;
    }

    @NotNull
    public FocusRequester getUp() {
        return this.up;
    }

    public void setCanFocus(boolean z) {
        this.canFocus = z;
    }

    public void setDown(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.down = focusRequester;
    }

    public void setEnd(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.end = focusRequester;
    }

    public void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.enter = function1;
    }

    public void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.exit = function1;
    }

    public void setLeft(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.left = focusRequester;
    }

    public void setNext(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.next = focusRequester;
    }

    public void setPrevious(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.previous = focusRequester;
    }

    public void setRight(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.right = focusRequester;
    }

    public void setStart(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.start = focusRequester;
    }

    public void setUp(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.up = focusRequester;
    }
}
