package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DrawModifierNode extends DelegatableNode {
    void draw(@NotNull ContentDrawScope contentDrawScope);

    void onMeasureResultChanged();
}
