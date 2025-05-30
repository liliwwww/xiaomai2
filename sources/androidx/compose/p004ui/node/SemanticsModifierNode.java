package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.semantics.SemanticsConfiguration;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public interface SemanticsModifierNode extends DelegatableNode {
    @NotNull
    SemanticsConfiguration getSemanticsConfiguration();
}
