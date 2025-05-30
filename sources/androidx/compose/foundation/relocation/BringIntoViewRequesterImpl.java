package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.collection.MutableVector;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {

    @NotNull
    private final MutableVector<BringIntoViewRequesterModifier> modifiers = new MutableVector<>(new BringIntoViewRequesterModifier[16], 0);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (r7 < r2) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0063 -> B:10:0x0066). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object bringIntoView(@org.jetbrains.annotations.Nullable androidx.compose.ui.geometry.Rect r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r7 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.geometry.Rect r5 = (androidx.compose.ui.geometry.Rect) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r5
            goto L66
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterModifier> r8 = r6.modifiers
            int r2 = r8.getSize()
            if (r2 <= 0) goto L69
            r4 = 0
            java.lang.Object[] r8 = r8.getContent()
            r4 = r8
            r8 = r7
            r7 = 0
        L51:
            r5 = r4[r7]
            androidx.compose.foundation.relocation.BringIntoViewRequesterModifier r5 = (androidx.compose.foundation.relocation.BringIntoViewRequesterModifier) r5
            r0.L$0 = r8
            r0.L$1 = r4
            r0.I$0 = r2
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r5 = r5.bringIntoView(r8, r0)
            if (r5 != r1) goto L66
            return r1
        L66:
            int r7 = r7 + r3
            if (r7 < r2) goto L51
        L69:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final MutableVector<BringIntoViewRequesterModifier> getModifiers() {
        return this.modifiers;
    }
}
