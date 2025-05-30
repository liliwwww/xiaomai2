package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMutableCollection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PersistentCollection$Builder<E> extends Collection<E>, KMutableCollection {
    @NotNull
    PersistentCollection<E> build();
}
