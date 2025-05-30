package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ContentInViewModifier$Request {

    @NotNull
    private final CancellableContinuation<Unit> continuation;

    @NotNull
    private final Function0<Rect> currentBounds;

    public ContentInViewModifier$Request(@NotNull Function0<Rect> function0, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkNotNullParameter(function0, "currentBounds");
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        this.currentBounds = function0;
        this.continuation = cancellableContinuation;
    }

    @NotNull
    public final CancellableContinuation<Unit> getContinuation() {
        return this.continuation;
    }

    @NotNull
    public final Function0<Rect> getCurrentBounds() {
        return this.currentBounds;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004f, code lost:
    
        if (r0 == null) goto L10;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r4.continuation
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            tb.h80$a r1 = tb.h80.Key
            kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
            tb.h80 r0 = (tb.h80) r0
            if (r0 == 0) goto L15
            java.lang.String r0 = r0.a()
            goto L16
        L15:
            r0 = 0
        L16:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Request@"
            r1.append(r2)
            int r2 = r4.hashCode()
            r3 = 16
            int r3 = kotlin.text.CharsKt.checkRadix(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.append(r2)
            if (r0 == 0) goto L51
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 91
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "]("
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            if (r0 != 0) goto L53
        L51:
            java.lang.String r0 = "("
        L53:
            r1.append(r0)
            java.lang.String r0 = "currentBounds()="
            r1.append(r0)
            kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r0 = r4.currentBounds
            java.lang.Object r0 = r0.invoke()
            r1.append(r0)
            java.lang.String r0 = ", continuation="
            r1.append(r0)
            kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r4.continuation
            r1.append(r0)
            r0 = 41
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewModifier$Request.toString():java.lang.String");
    }
}
