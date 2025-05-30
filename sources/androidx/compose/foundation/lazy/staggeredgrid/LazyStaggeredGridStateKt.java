package androidx.compose.foundation.lazy.staggeredgrid;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyStaggeredGridStateKt {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L15;
     */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.ExperimentalFoundationApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState rememberLazyStaggeredGridState(int r10, int r11, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 161145796(0x99ae3c4, float:3.728834E-33)
            r12.startReplaceableGroup(r0)
            r1 = r14 & 1
            r2 = 0
            if (r1 == 0) goto Lc
            r10 = 0
        Lc:
            r14 = r14 & 2
            if (r14 == 0) goto L11
            r11 = 0
        L11:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L1d
            r14 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState (LazyStaggeredGridState.kt:58)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r1)
        L1d:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion r13 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r13.getSaver()
            r5 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r0)
            boolean r13 = r12.changed(r13)
            boolean r14 = r12.changed(r14)
            r13 = r13 | r14
            java.lang.Object r14 = r12.rememberedValue()
            if (r13 != 0) goto L4b
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L53
        L4b:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1 r14 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1
            r14.<init>(r10, r11)
            r12.updateRememberedValue(r14)
        L53:
            r12.endReplaceableGroup()
            r6 = r14
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r8 = 72
            r9 = 4
            r7 = r12
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r10 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L6c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L6c:
            r12.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(int, int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState");
    }
}
