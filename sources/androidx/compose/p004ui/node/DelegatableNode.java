package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface DelegatableNode {
    @NotNull
    Modifier.Node getNode();
}
