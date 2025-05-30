package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Set;
import kotlin.jvm.internal.markers.KMutableSet;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PersistentSet$Builder<E> extends Set<E>, PersistentCollection$Builder<E>, KMutableSet {
    @NotNull
    /* renamed from: build */
    PersistentSet<E> mo794build();
}
