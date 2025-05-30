package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1", f = "Scrollable.kt", i = {0}, l = {301}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ScrollableKt$mouseWheelScroll$1$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
    final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$mouseWheelScroll$1$1(ScrollConfig scrollConfig, State<ScrollingLogic> state, Continuation<? super ScrollableKt$mouseWheelScroll$1$1> continuation) {
        super(2, continuation);
        this.$mouseWheelScrollConfig = scrollConfig;
        this.$scrollingLogicState = state;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollableKt$mouseWheelScroll$1$1 scrollableKt$mouseWheelScroll$1$1 = new ScrollableKt$mouseWheelScroll$1$1(this.$mouseWheelScrollConfig, this.$scrollingLogicState, continuation);
        scrollableKt$mouseWheelScroll$1$1.L$0 = obj;
        return scrollableKt$mouseWheelScroll$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0032 -> B:5:0x0037). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r10.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r3 = r1
            r1 = r0
            r0 = r10
            goto L37
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            r1 = r11
            r11 = r10
        L27:
            r11.L$0 = r1
            r11.label = r2
            java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r1, r11)
            if (r3 != r0) goto L32
            return r0
        L32:
            r9 = r0
            r0 = r11
            r11 = r3
            r3 = r1
            r1 = r9
        L37:
            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
            java.util.List r4 = r11.getChanges()
            int r5 = r4.size()
            r6 = 0
            r7 = 0
        L43:
            if (r7 >= r5) goto L57
            java.lang.Object r8 = r4.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.isConsumed()
            r8 = r8 ^ r2
            if (r8 != 0) goto L54
            r4 = 0
            goto L58
        L54:
            int r7 = r7 + 1
            goto L43
        L57:
            r4 = 1
        L58:
            if (r4 == 0) goto L9c
            androidx.compose.foundation.gestures.ScrollConfig r4 = r0.$mouseWheelScrollConfig
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r5 = r0.$scrollingLogicState
            long r7 = r3.mo1410getSizeYbymL2g()
            long r7 = r4.m174calculateMouseWheelScroll8xgXZGE(r3, r11, r7)
            java.lang.Object r4 = r5.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
            float r5 = r4.toFloat-k-4lQ0M(r7)
            float r5 = r4.reverseIfNeeded(r5)
            androidx.compose.foundation.gestures.ScrollableState r4 = r4.getScrollableState()
            float r4 = r4.dispatchRawDelta(r5)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L83
            r4 = 1
            goto L84
        L83:
            r4 = 0
        L84:
            if (r4 != 0) goto L9c
            java.util.List r11 = r11.getChanges()
            int r4 = r11.size()
        L8e:
            if (r6 >= r4) goto L9c
            java.lang.Object r5 = r11.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            r5.consume()
            int r6 = r6 + 1
            goto L8e
        L9c:
            r11 = r0
            r0 = r1
            r1 = r3
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
