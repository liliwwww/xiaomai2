package androidx.compose.material;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {521}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ExposedDropdownMenuKt$expandable$1$1$1$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onExpandedChange;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$expandable$1$1$1$1(Function0<Unit> function0, Continuation<? super ExposedDropdownMenuKt$expandable$1$1$1$1> continuation) {
        super(2, continuation);
        this.$onExpandedChange = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ExposedDropdownMenuKt$expandable$1$1$1$1 exposedDropdownMenuKt$expandable$1$1$1$1 = new ExposedDropdownMenuKt$expandable$1$1$1$1(this.$onExpandedChange, continuation);
        exposedDropdownMenuKt$expandable$1$1$1$1.L$0 = obj;
        return exposedDropdownMenuKt$expandable$1$1$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0034 -> B:5:0x0039). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r9.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r3 = r1
            r1 = r0
            r0 = r9
            goto L39
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            r1 = r10
            r10 = r9
        L27:
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r10.L$0 = r1
            r10.label = r2
            java.lang.Object r3 = r1.awaitPointerEvent(r3, r10)
            if (r3 != r0) goto L34
            return r0
        L34:
            r8 = r0
            r0 = r10
            r10 = r3
            r3 = r1
            r1 = r8
        L39:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            java.util.List r10 = r10.getChanges()
            int r4 = r10.size()
            r5 = 0
            r6 = 0
        L45:
            if (r6 >= r4) goto L57
            java.lang.Object r7 = r10.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r7)
            if (r7 != 0) goto L54
            goto L58
        L54:
            int r6 = r6 + 1
            goto L45
        L57:
            r5 = 1
        L58:
            if (r5 == 0) goto L62
            kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r0.$onExpandedChange
            r10.invoke()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L62:
            r10 = r0
            r0 = r1
            r1 = r3
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
