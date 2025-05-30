package androidx.compose.runtime;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComposerImpl$CompositionContextImpl extends CompositionContext {
    private final boolean collectingParameterInformation;

    @NotNull
    private final Set<ComposerImpl> composers = new LinkedHashSet();

    @NotNull
    private final MutableState compositionLocalScope$delegate;
    private final int compoundHashKey;

    @Nullable
    private Set<Set<CompositionData>> inspectionTables;
    final /* synthetic */ ComposerImpl this$0;

    public ComposerImpl$CompositionContextImpl(ComposerImpl composerImpl, int i, boolean z) {
        MutableState mutableStateOf$default;
        this.this$0 = composerImpl;
        this.compoundHashKey = i;
        this.collectingParameterInformation = z;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), null, 2, null);
        this.compositionLocalScope$delegate = mutableStateOf$default;
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
        return (PersistentMap) this.compositionLocalScope$delegate.getValue();
    }

    public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
    }

    private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        this.compositionLocalScope$delegate.setValue(persistentMap);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(@NotNull ControlledComposition controlledComposition, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        Intrinsics.checkNotNullParameter(function2, "content");
        ComposerImpl.access$getParentContext$p(this.this$0).composeInitial$runtime_release(controlledComposition, function2);
    }

    public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        ComposerImpl.access$getParentContext$p(this.this$0).deletedMovableContent$runtime_release(movableContentStateReference);
    }

    public final void dispose() {
        if (!this.composers.isEmpty()) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (ComposerImpl composerImpl : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(ComposerImpl.access$getSlotTable$p(composerImpl));
                    }
                }
            }
            this.composers.clear();
        }
    }

    public void doneComposing$runtime_release() {
        ComposerImpl.access$setChildrenComposing$p(this.this$0, ComposerImpl.access$getChildrenComposing$p(r0) - 1);
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return this.collectingParameterInformation;
    }

    @NotNull
    public final Set<ComposerImpl> getComposers() {
        return this.composers;
    }

    @NotNull
    public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
        return getCompositionLocalScope();
    }

    public int getCompoundHashKey$runtime_release() {
        return this.compoundHashKey;
    }

    @NotNull
    public CoroutineContext getEffectCoroutineContext$runtime_release() {
        return ComposerImpl.access$getParentContext$p(this.this$0).getEffectCoroutineContext$runtime_release();
    }

    @Nullable
    public final Set<Set<CompositionData>> getInspectionTables() {
        return this.inspectionTables;
    }

    @NotNull
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return CompositionKt.getRecomposeCoroutineContext(this.this$0.getComposition());
    }

    public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        ComposerImpl.access$getParentContext$p(this.this$0).insertMovableContent$runtime_release(movableContentStateReference);
    }

    public void invalidate$runtime_release(@NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(this.this$0.getComposition());
        ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(controlledComposition);
    }

    public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        ComposerImpl.access$getParentContext$p(this.this$0).invalidateScope$runtime_release(recomposeScopeImpl);
    }

    public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference movableContentStateReference, @NotNull MovableContentState movableContentState) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        Intrinsics.checkNotNullParameter(movableContentState, ApiConstants.DATA);
        ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
    }

    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        return ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateResolve$runtime_release(movableContentStateReference);
    }

    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> set) {
        Intrinsics.checkNotNullParameter(set, "table");
        Set set2 = this.inspectionTables;
        if (set2 == null) {
            set2 = new HashSet();
            this.inspectionTables = set2;
        }
        set2.add(set);
    }

    public void registerComposer$runtime_release(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        super.registerComposer$runtime_release((ComposerImpl) composer);
        this.composers.add(composer);
    }

    public void registerComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        ComposerImpl.access$getParentContext$p(this.this$0).registerComposition$runtime_release(controlledComposition);
    }

    public final void setInspectionTables(@Nullable Set<Set<CompositionData>> set) {
        this.inspectionTables = set;
    }

    public void startComposing$runtime_release() {
        ComposerImpl composerImpl = this.this$0;
        ComposerImpl.access$setChildrenComposing$p(composerImpl, ComposerImpl.access$getChildrenComposing$p(composerImpl) + 1);
    }

    public void unregisterComposer$runtime_release(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Set<Set<CompositionData>> set = this.inspectionTables;
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((Set) it.next()).remove(ComposerImpl.access$getSlotTable$p((ComposerImpl) composer));
            }
        }
        TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
    }

    public void unregisterComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        ComposerImpl.access$getParentContext$p(this.this$0).unregisterComposition$runtime_release(controlledComposition);
    }

    public final void updateCompositionLocalScope(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, "scope");
        setCompositionLocalScope(persistentMap);
    }
}
