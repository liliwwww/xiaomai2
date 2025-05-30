package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PointerInputModifierNode extends DelegatableNode {
    boolean interceptOutOfBoundsChildEvents();

    void onCancelPointerInput();

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    void m2179onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j);

    boolean sharePointerInputWithSiblings();
}
