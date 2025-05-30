package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public abstract class CompositionContext {
    public static final int $stable = 0;

    public abstract void composeInitial$runtime_release(@NotNull ControlledComposition controlledComposition, @NotNull Function2<? super Composer, ? super Integer, Unit> function2);

    public abstract void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference);

    public void doneComposing$runtime_release() {
    }

    public abstract boolean getCollectingParameterInformation$runtime_release();

    @NotNull
    public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap;
        persistentMap = CompositionContextKt.EmptyCompositionLocalMap;
        return persistentMap;
    }

    public abstract int getCompoundHashKey$runtime_release();

    @NotNull
    public abstract CoroutineContext getEffectCoroutineContext$runtime_release();

    @NotNull
    public abstract CoroutineContext getRecomposeCoroutineContext$runtime_release();

    public abstract void insertMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference);

    public abstract void invalidate$runtime_release(@NotNull ControlledComposition controlledComposition);

    public abstract void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl);

    public abstract void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference movableContentStateReference, @NotNull MovableContentState movableContentState);

    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        return null;
    }

    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> set) {
        Intrinsics.checkNotNullParameter(set, "table");
    }

    public void registerComposer$runtime_release(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void registerComposition$runtime_release(@NotNull ControlledComposition controlledComposition);

    public void startComposing$runtime_release() {
    }

    public void unregisterComposer$runtime_release(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(@NotNull ControlledComposition controlledComposition);
}
