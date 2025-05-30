package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements RecomposeScope, ScopeUpdateScope {

    @Nullable
    private Anchor anchor;

    @Nullable
    private Function2<? super Composer, ? super Integer, Unit> block;

    @Nullable
    private CompositionImpl composition;
    private int currentToken;
    private int flags;

    @Nullable
    private IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;

    @Nullable
    private IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(@Nullable CompositionImpl compositionImpl) {
        this.composition = compositionImpl;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z) {
        if (z) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z) {
        if (z) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void adoptedBy(@NotNull CompositionImpl compositionImpl) {
        Intrinsics.checkNotNullParameter(compositionImpl, "composition");
        this.composition = compositionImpl;
    }

    public final void compose(@NotNull Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    @Nullable
    public final Function1<Composition, Unit> end(final int i) {
        final IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        int size = identityArrayIntMap.getSize();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            Intrinsics.checkNotNull(identityArrayIntMap.getKeys()[i2], "null cannot be cast to non-null type kotlin.Any");
            if (identityArrayIntMap.getValues()[i2] != i) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return new Function1<Composition, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Composition) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Composition composition) {
                    int i3;
                    IdentityArrayIntMap identityArrayIntMap2;
                    IdentityArrayMap identityArrayMap;
                    Intrinsics.checkNotNullParameter(composition, "composition");
                    i3 = RecomposeScopeImpl.this.currentToken;
                    if (i3 == i) {
                        IdentityArrayIntMap identityArrayIntMap3 = identityArrayIntMap;
                        identityArrayIntMap2 = RecomposeScopeImpl.this.trackedInstances;
                        if (Intrinsics.areEqual(identityArrayIntMap3, identityArrayIntMap2) && (composition instanceof CompositionImpl)) {
                            IdentityArrayIntMap identityArrayIntMap4 = identityArrayIntMap;
                            int i4 = i;
                            RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                            int size2 = identityArrayIntMap4.getSize();
                            int i5 = 0;
                            for (int i6 = 0; i6 < size2; i6++) {
                                Object obj = identityArrayIntMap4.getKeys()[i6];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                                int i7 = identityArrayIntMap4.getValues()[i6];
                                boolean z2 = i7 != i4;
                                if (z2) {
                                    CompositionImpl compositionImpl = (CompositionImpl) composition;
                                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                                    DerivedState<?> derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                                    if (derivedState != null) {
                                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                                        identityArrayMap = recomposeScopeImpl.trackedDependencies;
                                        if (identityArrayMap != null) {
                                            identityArrayMap.remove(derivedState);
                                            if (identityArrayMap.getSize$runtime_release() == 0) {
                                                recomposeScopeImpl.trackedDependencies = null;
                                            }
                                        }
                                    }
                                }
                                if (!z2) {
                                    if (i5 != i6) {
                                        identityArrayIntMap4.getKeys()[i5] = obj;
                                        identityArrayIntMap4.getValues()[i5] = i7;
                                    }
                                    i5++;
                                }
                            }
                            int size3 = identityArrayIntMap4.getSize();
                            for (int i8 = i5; i8 < size3; i8++) {
                                identityArrayIntMap4.getKeys()[i8] = null;
                            }
                            identityArrayIntMap4.setSize(i5);
                            if (identityArrayIntMap.getSize() == 0) {
                                RecomposeScopeImpl.this.trackedInstances = null;
                            }
                        }
                    }
                }
            };
        }
        return null;
    }

    @Nullable
    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    @Nullable
    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.composition == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl != null) {
            compositionImpl.invalidate(this, null);
        }
    }

    @NotNull
    public final InvalidationResult invalidateForResult(@Nullable Object obj) {
        InvalidationResult invalidate;
        CompositionImpl compositionImpl = this.composition;
        return (compositionImpl == null || (invalidate = compositionImpl.invalidate(this, obj)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:16:0x001c->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isInvalidFor(@org.jetbrains.annotations.Nullable androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != 0) goto L4
            return r0
        L4:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r6.trackedDependencies
            if (r1 != 0) goto L9
            return r0
        L9:
            boolean r2 = r7.isNotEmpty()
            if (r2 == 0) goto L4d
            boolean r2 = r7.isEmpty()
            r3 = 0
            if (r2 == 0) goto L18
        L16:
            r7 = 1
            goto L4a
        L18:
            java.util.Iterator r7 = r7.iterator()
        L1c:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L16
            java.lang.Object r2 = r7.next()
            boolean r4 = r2 instanceof androidx.compose.runtime.DerivedState
            if (r4 == 0) goto L46
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            androidx.compose.runtime.SnapshotMutationPolicy r4 = r2.getPolicy()
            if (r4 != 0) goto L36
            androidx.compose.runtime.SnapshotMutationPolicy r4 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
        L36:
            java.lang.Object r5 = r2.getCurrentValue()
            java.lang.Object r2 = r1.get(r2)
            boolean r2 = r4.equivalent(r5, r2)
            if (r2 == 0) goto L46
            r2 = 1
            goto L47
        L46:
            r2 = 0
        L47:
            if (r2 != 0) goto L1c
            r7 = 0
        L4a:
            if (r7 == 0) goto L4d
            return r3
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet):boolean");
    }

    public final void recordRead(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        if (getRereading()) {
            return;
        }
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null) {
            identityArrayIntMap = new IdentityArrayIntMap();
            this.trackedInstances = identityArrayIntMap;
        }
        identityArrayIntMap.add(obj, this.currentToken);
        if (obj instanceof DerivedState) {
            IdentityArrayMap<DerivedState<?>, Object> identityArrayMap = this.trackedDependencies;
            if (identityArrayMap == null) {
                identityArrayMap = new IdentityArrayMap<>(0, 1, null);
                this.trackedDependencies = identityArrayMap;
            }
            identityArrayMap.set(obj, ((DerivedState) obj).getCurrentValue());
        }
    }

    public final void release() {
        this.composition = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap identityArrayIntMap;
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl == null || (identityArrayIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            int size = identityArrayIntMap.getSize();
            for (int i = 0; i < size; i++) {
                Object obj = identityArrayIntMap.getKeys()[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                int i2 = identityArrayIntMap.getValues()[i];
                compositionImpl.recordReadOf(obj);
            }
        } finally {
            setRereading(false);
        }
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final void setAnchor(@Nullable Anchor anchor) {
        this.anchor = anchor;
    }

    public final void setDefaultsInScope(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z) {
        if (z) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setRequiresRecompose(boolean z) {
        if (z) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z) {
        if (z) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final void start(int i) {
        this.currentToken = i;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.block = function2;
    }
}
