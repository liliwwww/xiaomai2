package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollDraggableState implements DragScope, DraggableState {

    @NotNull
    private ScrollScope latestScrollScope;

    @NotNull
    private final State<ScrollingLogic> scrollLogic;

    public ScrollDraggableState(@NotNull State<ScrollingLogic> state) {
        Intrinsics.checkNotNullParameter(state, "scrollLogic");
        this.scrollLogic = state;
        this.latestScrollScope = ScrollableKt.access$getNoOpScrollScope$p();
    }

    public void dispatchRawDelta(float f) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m246performRawScrollMKHz9U(value.m252toOffsettuRUvjQ(f));
    }

    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = this.scrollLogic.getValue().getScrollableState().scroll(mutatePriority, new drag.2(this, function2, (Continuation) null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public void dragBy(float f) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m242dispatchScroll3eAAhYA(this.latestScrollScope, value.m252toOffsettuRUvjQ(f), NestedScrollSource.Companion.getDrag-WNlRxjI());
    }

    @NotNull
    public final ScrollScope getLatestScrollScope() {
        return this.latestScrollScope;
    }

    @NotNull
    public final State<ScrollingLogic> getScrollLogic() {
        return this.scrollLogic;
    }

    public final void setLatestScrollScope(@NotNull ScrollScope scrollScope) {
        Intrinsics.checkNotNullParameter(scrollScope, "<set-?>");
        this.latestScrollScope = scrollScope;
    }
}
