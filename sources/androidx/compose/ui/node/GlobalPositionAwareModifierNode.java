package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface GlobalPositionAwareModifierNode extends DelegatableNode {
    void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates);
}
