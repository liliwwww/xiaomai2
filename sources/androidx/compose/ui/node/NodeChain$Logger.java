package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface NodeChain$Logger {
    void linearDiffAborted(int i, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node);

    void nodeInserted(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Node node, @NotNull Modifier.Node node2);

    void nodeRemoved(int i, @NotNull Modifier.Element element, @NotNull Modifier.Node node);

    void nodeReused(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node);

    void nodeUpdated(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node, @NotNull Modifier.Node node2);
}
