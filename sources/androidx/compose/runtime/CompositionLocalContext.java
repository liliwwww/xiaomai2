package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public final class CompositionLocalContext {

    @NotNull
    private final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocals;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionLocalContext(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, "compositionLocals");
        this.compositionLocals = persistentMap;
    }

    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocals$runtime_release() {
        return this.compositionLocals;
    }
}
