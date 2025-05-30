package androidx.compose.material;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float f = Dp.constructor-impl((float) 0.125d);
        mouseSlop = f;
        float f2 = Dp.constructor-impl(18);
        defaultTouchSlop = f2;
        mouseToTouchSlopRatio = f / f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x011a -> B:17:0x0166). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0159 -> B:11:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0181 -> B:17:0x0166). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m720awaitHorizontalPointerSlopOrCancellationgDDlDlE(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m720awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cd, code lost:
    
        r21.invoke(r15, java.lang.Float.valueOf(r8 - (java.lang.Math.signum(r8) * r3)));
     */
    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.Object m721awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, int r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r21, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Float> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r17
            r1 = r22
            r2 = r23
            androidx.compose.ui.input.pointer.PointerEvent r3 = r17.getCurrentEvent()
            r4 = r18
            boolean r3 = m722isPointerUpDmW0f2w(r3, r4)
            r6 = 0
            if (r3 == 0) goto L14
            return r6
        L14:
            androidx.compose.ui.platform.ViewConfiguration r3 = r17.getViewConfiguration()
            r7 = r20
            float r3 = m723pointerSlopE8SPZFQ(r3, r7)
            r7 = 0
        L1f:
            r8 = 0
        L20:
            r9 = 0
            kotlin.jvm.internal.InlineMarker.mark(r9)
            r10 = 1
            java.lang.Object r11 = tb.je.t(r0, r6, r2, r10, r6)
            kotlin.jvm.internal.InlineMarker.mark(r10)
            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
            java.util.List r12 = r11.getChanges()
            int r13 = r12.size()
            r14 = 0
        L37:
            if (r14 >= r13) goto L51
            java.lang.Object r15 = r12.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            long r9 = r16.getId-J3iCeTQ()
            boolean r9 = androidx.compose.ui.input.pointer.PointerId.equals-impl0(r9, r4)
            if (r9 == 0) goto L4c
            goto L52
        L4c:
            int r14 = r14 + 1
            r9 = 0
            r10 = 1
            goto L37
        L51:
            r15 = r6
        L52:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            boolean r9 = r15.isConsumed()
            if (r9 == 0) goto L5e
            return r6
        L5e:
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r9 == 0) goto L8b
            java.util.List r4 = r11.getChanges()
            int r5 = r4.size()
            r9 = 0
        L6d:
            if (r9 >= r5) goto L80
            java.lang.Object r10 = r4.get(r9)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L7d
            goto L81
        L7d:
            int r9 = r9 + 1
            goto L6d
        L80:
            r10 = r6
        L81:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L86
            return r6
        L86:
            long r4 = r10.getId-J3iCeTQ()
            goto L20
        L8b:
            long r9 = r15.getPosition-F1C5BW0()
            long r11 = r15.getPreviousPosition-F1C5BW0()
            androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.box-impl(r9)
            java.lang.Object r9 = r1.invoke(r9)
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.box-impl(r11)
            java.lang.Object r10 = r1.invoke(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            float r9 = r9 - r10
            float r8 = r8 + r9
            float r9 = java.lang.Math.abs(r8)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto Lcd
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r10 = 0
            kotlin.jvm.internal.InlineMarker.mark(r10)
            r0.awaitPointerEvent(r9, r2)
            r9 = 1
            kotlin.jvm.internal.InlineMarker.mark(r9)
            boolean r9 = r15.isConsumed()
            if (r9 == 0) goto L20
            return r6
        Lcd:
            float r9 = java.lang.Math.signum(r8)
            float r9 = r9 * r3
            float r8 = r8 - r9
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r9 = r21
            r9.invoke(r15, r8)
            boolean r8 = r15.isConsumed()
            if (r8 == 0) goto L1f
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m721awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m722isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.equals-impl0(pointerInputChange.getId-J3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m723pointerSlopE8SPZFQ(@NotNull ViewConfiguration viewConfiguration, int i) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "$this$pointerSlop");
        return PointerType.m2036equalsimpl0(i, PointerType.Companion.getMouse-T8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }
}
