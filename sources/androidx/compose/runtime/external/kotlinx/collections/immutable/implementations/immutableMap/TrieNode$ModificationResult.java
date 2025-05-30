package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TrieNode$ModificationResult<K, V> {

    @NotNull
    private TrieNode<K, V> node;
    private final int sizeDelta;

    public TrieNode$ModificationResult(@NotNull TrieNode<K, V> trieNode, int i) {
        Intrinsics.checkNotNullParameter(trieNode, "node");
        this.node = trieNode;
        this.sizeDelta = i;
    }

    @NotNull
    public final TrieNode<K, V> getNode() {
        return this.node;
    }

    public final int getSizeDelta() {
        return this.sizeDelta;
    }

    @NotNull
    public final TrieNode$ModificationResult<K, V> replaceNode(@NotNull Function1<? super TrieNode<K, V>, TrieNode<K, V>> function1) {
        Intrinsics.checkNotNullParameter(function1, "operation");
        setNode((TrieNode) function1.invoke(getNode()));
        return this;
    }

    public final void setNode(@NotNull TrieNode<K, V> trieNode) {
        Intrinsics.checkNotNullParameter(trieNode, "<set-?>");
        this.node = trieNode;
    }
}
