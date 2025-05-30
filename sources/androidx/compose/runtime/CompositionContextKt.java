package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class CompositionContextKt {

    @NotNull
    private static final PersistentMap<CompositionLocal<Object>, State<Object>> EmptyCompositionLocalMap = ExtensionsKt.persistentHashMapOf();
}
