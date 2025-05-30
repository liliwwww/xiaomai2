package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates);

    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);

    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    void m2120onRemeasuredozmzZPI(long j);
}
