package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalWindowApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J,\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH&J\u001c\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH&J\b\u0010\u0017\u001a\u00020\u0016H&¨\u0006\u0018"}, d2 = {"Landroidx/window/embedding/EmbeddingBackend;", "", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "", "setSplitRules", "getSplitRules", "rule", "registerRule", "unregisterRule", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "callback", "registerSplitListenerForActivity", "consumer", "unregisterSplitListenerForActivity", "", "isSplitSupported", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface EmbeddingBackend {
    @NotNull
    Set<EmbeddingRule> getSplitRules();

    boolean isSplitSupported();

    void registerRule(@NotNull EmbeddingRule rule);

    void registerSplitListenerForActivity(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<List<SplitInfo>> callback);

    void setSplitRules(@NotNull Set<? extends EmbeddingRule> rules);

    void unregisterRule(@NotNull EmbeddingRule rule);

    void unregisterSplitListenerForActivity(@NotNull Consumer<List<SplitInfo>> consumer);
}
