package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PersistentHashSet$Companion {
    private PersistentHashSet$Companion() {
    }

    public /* synthetic */ PersistentHashSet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final <E> PersistentSet<E> emptyOf$runtime_release() {
        return PersistentHashSet.access$getEMPTY$cp();
    }
}
