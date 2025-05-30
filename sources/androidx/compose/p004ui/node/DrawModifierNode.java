package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface DrawModifierNode extends DelegatableNode {
    void draw(@NotNull ContentDrawScope contentDrawScope);

    void onMeasureResultChanged();
}
