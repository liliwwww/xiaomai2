package androidx.window.embedding;

import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/window/embedding/EmptyEmbeddingComponent;", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "splitRules", "", "setEmbeddingRules", "Ljava/util/function/Consumer;", "", "Landroidx/window/extensions/embedding/SplitInfo;", "consumer", "setSplitInfoCallback", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class EmptyEmbeddingComponent implements ActivityEmbeddingComponent {
    public void setEmbeddingRules(@NotNull Set<androidx.window.extensions.embedding.EmbeddingRule> splitRules) {
        Intrinsics.checkNotNullParameter(splitRules, "splitRules");
    }

    public void setSplitInfoCallback(@NotNull Consumer<List<androidx.window.extensions.embedding.SplitInfo>> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
    }
}
