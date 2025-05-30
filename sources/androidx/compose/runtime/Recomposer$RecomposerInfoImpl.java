package androidx.compose.runtime;

import androidx.compose.runtime.ComposableSingletons;
import androidx.compose.runtime.Recomposer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Recomposer$RecomposerInfoImpl implements RecomposerInfo {
    final /* synthetic */ Recomposer this$0;

    public Recomposer$RecomposerInfoImpl(Recomposer recomposer) {
        this.this$0 = recomposer;
    }

    @Override // androidx.compose.runtime.RecomposerInfo
    public long getChangeCount() {
        return this.this$0.getChangeCount();
    }

    @Nullable
    public final RecomposerErrorInfo getCurrentError() {
        Recomposer.RecomposerErrorState access$getErrorState$p;
        Object access$getStateLock$p = Recomposer.access$getStateLock$p(this.this$0);
        Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            access$getErrorState$p = Recomposer.access$getErrorState$p(recomposer);
        }
        return access$getErrorState$p;
    }

    @Override // androidx.compose.runtime.RecomposerInfo
    public boolean getHasPendingWork() {
        return this.this$0.getHasPendingWork();
    }

    @Override // androidx.compose.runtime.RecomposerInfo
    @NotNull
    public Flow<Recomposer$State> getState() {
        return this.this$0.getCurrentState();
    }

    public final void invalidateGroupsWithKey(int i) {
        List mutableList;
        Object access$getStateLock$p = Recomposer.access$getStateLock$p(this.this$0);
        Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            mutableList = CollectionsKt.toMutableList(Recomposer.access$getKnownCompositions$p(recomposer));
        }
        ArrayList arrayList = new ArrayList(mutableList.size());
        int size = mutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i2);
            CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
            if (compositionImpl != null) {
                arrayList.add(compositionImpl);
            }
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((CompositionImpl) arrayList.get(i3)).invalidateGroupsWithKey(i);
        }
    }

    @Nullable
    public final Recomposer.RecomposerErrorState resetErrorState() {
        return Recomposer.access$resetErrorState(this.this$0);
    }

    public final void retryFailedCompositions() {
        Recomposer.access$retryFailedCompositions(this.this$0);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.runtime.Recomposer$HotReloadable, java.lang.Object] */
    @NotNull
    public final List<Recomposer$HotReloadable> saveStateAndDisposeForHotReload() {
        List mutableList;
        Object access$getStateLock$p = Recomposer.access$getStateLock$p(this.this$0);
        Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            mutableList = CollectionsKt.toMutableList(Recomposer.access$getKnownCompositions$p(recomposer));
        }
        ArrayList arrayList = new ArrayList(mutableList.size());
        int size = mutableList.size();
        for (int i = 0; i < size; i++) {
            ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i);
            CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
            if (compositionImpl != null) {
                arrayList.add(compositionImpl);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            final CompositionImpl compositionImpl2 = (CompositionImpl) arrayList.get(i2);
            ?? r5 = new Object(compositionImpl2) { // from class: androidx.compose.runtime.Recomposer$HotReloadable

                @NotNull
                private Function2<? super Composer, ? super Integer, Unit> composable;

                @NotNull
                private final CompositionImpl composition;

                {
                    Intrinsics.checkNotNullParameter(compositionImpl2, "composition");
                    this.composition = compositionImpl2;
                    this.composable = compositionImpl2.getComposable();
                }

                public final void clearContent() {
                    if (this.composition.isRoot()) {
                        this.composition.setContent(ComposableSingletons.RecomposerKt.INSTANCE.getLambda-1$runtime_release());
                    }
                }

                public final void recompose() {
                    if (this.composition.isRoot()) {
                        this.composition.setContent(this.composable);
                    }
                }

                public final void resetContent() {
                    this.composition.setComposable(this.composable);
                }
            };
            r5.clearContent();
            arrayList2.add(r5);
        }
        return arrayList2;
    }
}
