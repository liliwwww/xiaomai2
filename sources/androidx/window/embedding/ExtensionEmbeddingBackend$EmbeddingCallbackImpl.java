package androidx.window.embedding;

import androidx.window.embedding.EmbeddingInterfaceCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "", "onSplitInfoChanged", "lastInfo", "Ljava/util/List;", "getLastInfo", "()Ljava/util/List;", "setLastInfo", "(Ljava/util/List;)V", "<init>", "(Landroidx/window/embedding/ExtensionEmbeddingBackend;)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ExtensionEmbeddingBackend$EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {

    @Nullable
    private List<SplitInfo> lastInfo;
    final /* synthetic */ ExtensionEmbeddingBackend this$0;

    public ExtensionEmbeddingBackend$EmbeddingCallbackImpl(ExtensionEmbeddingBackend extensionEmbeddingBackend) {
        Intrinsics.checkNotNullParameter(extensionEmbeddingBackend, "this$0");
        this.this$0 = extensionEmbeddingBackend;
    }

    @Nullable
    public final List<SplitInfo> getLastInfo() {
        return this.lastInfo;
    }

    public void onSplitInfoChanged(@NotNull List<SplitInfo> splitInfo) {
        Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
        this.lastInfo = splitInfo;
        Iterator it = this.this$0.getSplitChangeCallbacks().iterator();
        while (it.hasNext()) {
            ((ExtensionEmbeddingBackend$SplitListenerWrapper) it.next()).accept(splitInfo);
        }
    }

    public final void setLastInfo(@Nullable List<SplitInfo> list) {
        this.lastInfo = list;
    }
}
