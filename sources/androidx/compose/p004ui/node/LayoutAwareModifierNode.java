package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LookaheadLayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates);

    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);

    /* renamed from: onRemeasured-ozmzZPI */
    void mo4266onRemeasuredozmzZPI(long j);
}
