package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2", f = "TextSelectionMouseDetector.kt", i = {0, 0, 1, 1, 2, 2}, l = {89, 96, 111}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "clicksCounter", "$this$awaitEachGesture", "clicksCounter", "$this$awaitEachGesture", "clicksCounter"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextSelectionMouseDetectorKt$mouseSelectionDetector$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MouseSelectionObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextSelectionMouseDetectorKt$mouseSelectionDetector$2(MouseSelectionObserver mouseSelectionObserver, Continuation<? super TextSelectionMouseDetectorKt$mouseSelectionDetector$2> continuation) {
        super(2, continuation);
        this.$observer = mouseSelectionObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextSelectionMouseDetectorKt$mouseSelectionDetector$2 textSelectionMouseDetectorKt$mouseSelectionDetector$2 = new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(this.$observer, continuation);
        textSelectionMouseDetectorKt$mouseSelectionDetector$2.L$0 = obj;
        return textSelectionMouseDetectorKt$mouseSelectionDetector$2;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d6 -> B:11:0x0045). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 == r4) goto L27
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1a:
            java.lang.Object r1 = r12.L$1
            androidx.compose.foundation.text.selection.ClicksCounter r1 = (androidx.compose.foundation.text.selection.ClicksCounter) r1
            java.lang.Object r5 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r5
            goto L44
        L27:
            java.lang.Object r1 = r12.L$1
            androidx.compose.foundation.text.selection.ClicksCounter r1 = (androidx.compose.foundation.text.selection.ClicksCounter) r1
            java.lang.Object r5 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r12
            goto L56
        L34:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            androidx.compose.foundation.text.selection.ClicksCounter r1 = new androidx.compose.foundation.text.selection.ClicksCounter
            androidx.compose.ui.platform.ViewConfiguration r5 = r13.getViewConfiguration()
            r1.<init>(r5)
        L44:
            r5 = r12
        L45:
            r5.L$0 = r13
            r5.L$1 = r1
            r5.label = r4
            java.lang.Object r6 = androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.access$awaitMouseEventDown(r13, r5)
            if (r6 != r0) goto L52
            return r0
        L52:
            r11 = r5
            r5 = r13
            r13 = r6
            r6 = r11
        L56:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            r1.update(r13)
            java.util.List r7 = r13.getChanges()
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r13 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r13)
            if (r13 == 0) goto L93
            androidx.compose.foundation.text.selection.MouseSelectionObserver r13 = r6.$observer
            long r8 = r7.getPosition-F1C5BW0()
            boolean r13 = r13.mo566onExtendk4lQ0M(r8)
            if (r13 == 0) goto Ld6
            r7.consume()
            long r7 = r7.getId-J3iCeTQ()
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1 r13 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1
            androidx.compose.foundation.text.selection.MouseSelectionObserver r9 = r6.$observer
            r13.<init>(r9)
            r6.L$0 = r5
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m187dragjO51t88(r5, r7, r13, r6)
            if (r13 != r0) goto Ld6
            return r0
        L93:
            int r13 = r1.getClicks()
            if (r13 == r4) goto La9
            if (r13 == r3) goto La2
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getParagraph()
            goto Laf
        La2:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getWord()
            goto Laf
        La9:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getNone()
        Laf:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = r6.$observer
            long r9 = r7.getPosition-F1C5BW0()
            boolean r8 = r8.mo568onStart3MmeM6k(r9, r13)
            if (r8 == 0) goto Ld6
            r7.consume()
            long r7 = r7.getId-J3iCeTQ()
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$2 r9 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$2
            androidx.compose.foundation.text.selection.MouseSelectionObserver r10 = r6.$observer
            r9.<init>()
            r6.L$0 = r5
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m187dragjO51t88(r5, r7, r9, r6)
            if (r13 != r0) goto Ld6
            return r0
        Ld6:
            r13 = r5
            r5 = r6
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
