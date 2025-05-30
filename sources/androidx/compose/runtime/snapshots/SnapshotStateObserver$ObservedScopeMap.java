package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.HashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SnapshotStateObserver$ObservedScopeMap {

    @Nullable
    private Object currentScope;

    @Nullable
    private IdentityArrayIntMap currentScopeReads;
    private int currentToken;

    @NotNull
    private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
    private int deriveStateScopeCount;

    @NotNull
    private final Function1<State<?>, Unit> derivedStateEnterObserver;

    @NotNull
    private final Function1<State<?>, Unit> derivedStateExitObserver;

    @NotNull
    private final IdentityArraySet<Object> invalidated;

    @NotNull
    private final Function1<Object, Unit> onChanged;

    @NotNull
    private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;

    @NotNull
    private final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;

    @NotNull
    private final IdentityScopeMap<Object> valueToScopes;

    public SnapshotStateObserver$ObservedScopeMap(@NotNull Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChanged");
        this.onChanged = function1;
        this.currentToken = -1;
        this.valueToScopes = new IdentityScopeMap<>();
        this.scopeToValues = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        this.invalidated = new IdentityArraySet<>();
        this.derivedStateEnterObserver = new Function1<State<?>, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateEnterObserver$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State<?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State<?> state) {
                int i;
                Intrinsics.checkNotNullParameter(state, "it");
                SnapshotStateObserver$ObservedScopeMap snapshotStateObserver$ObservedScopeMap = SnapshotStateObserver$ObservedScopeMap.this;
                i = snapshotStateObserver$ObservedScopeMap.deriveStateScopeCount;
                snapshotStateObserver$ObservedScopeMap.deriveStateScopeCount = i + 1;
            }
        };
        this.derivedStateExitObserver = new derivedStateExitObserver.1(this);
        this.dependencyToDerivedStates = new IdentityScopeMap<>();
        this.recordedDerivedStateValues = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearObsoleteStateReads(Object obj) {
        IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
        if (identityArrayIntMap != null) {
            int size = identityArrayIntMap.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj2 = identityArrayIntMap.getKeys()[i2];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                int i3 = identityArrayIntMap.getValues()[i2];
                boolean z = i3 != this.currentToken;
                if (z) {
                    removeObservation(obj, obj2);
                }
                if (!z) {
                    if (i != i2) {
                        identityArrayIntMap.getKeys()[i] = obj2;
                        identityArrayIntMap.getValues()[i] = i3;
                    }
                    i++;
                }
            }
            int size2 = identityArrayIntMap.getSize();
            for (int i4 = i; i4 < size2; i4++) {
                identityArrayIntMap.getKeys()[i4] = null;
            }
            identityArrayIntMap.setSize(i);
        }
    }

    private final void removeObservation(Object obj, Object obj2) {
        this.valueToScopes.remove(obj2, obj);
        if (!(obj2 instanceof DerivedState) || this.valueToScopes.contains(obj2)) {
            return;
        }
        this.dependencyToDerivedStates.removeScope(obj2);
        this.recordedDerivedStateValues.remove(obj2);
    }

    public final void clear() {
        this.valueToScopes.clear();
        this.scopeToValues.clear();
        this.dependencyToDerivedStates.clear();
        this.recordedDerivedStateValues.clear();
    }

    public final void clearScopeObservations(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "scope");
        IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) this.scopeToValues.get(obj);
        if (identityArrayIntMap == null) {
            return;
        }
        int size = identityArrayIntMap.getSize();
        for (int i = 0; i < size; i++) {
            Object obj2 = identityArrayIntMap.getKeys()[i];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
            int i2 = identityArrayIntMap.getValues()[i];
            removeObservation(obj, obj2);
        }
    }

    @NotNull
    public final Function1<State<?>, Unit> getDerivedStateEnterObserver() {
        return this.derivedStateEnterObserver;
    }

    @NotNull
    public final Function1<State<?>, Unit> getDerivedStateExitObserver() {
        return this.derivedStateExitObserver;
    }

    @NotNull
    public final Function1<Object, Unit> getOnChanged() {
        return this.onChanged;
    }

    public final void notifyInvalidatedScopes() {
        IdentityArraySet<Object> identityArraySet = this.invalidated;
        Function1<Object, Unit> function1 = this.onChanged;
        int size = identityArraySet.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(identityArraySet.get(i));
        }
        this.invalidated.clear();
    }

    public final void observe(@NotNull Object obj, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(obj, "scope");
        Intrinsics.checkNotNullParameter(function0, "block");
        Object obj2 = this.currentScope;
        IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
        int i = this.currentToken;
        this.currentScope = obj;
        this.currentScopeReads = (IdentityArrayIntMap) this.scopeToValues.get(obj);
        if (this.currentToken == -1) {
            this.currentToken = SnapshotKt.currentSnapshot().getId();
        }
        function0.invoke();
        Object obj3 = this.currentScope;
        Intrinsics.checkNotNull(obj3);
        clearObsoleteStateReads(obj3);
        this.currentScope = obj2;
        this.currentScopeReads = identityArrayIntMap;
        this.currentToken = i;
    }

    public final boolean recordInvalidation(@NotNull Set<? extends Object> set) {
        IdentityScopeMap<DerivedState<?>> identityScopeMap;
        int find;
        IdentityScopeMap<Object> identityScopeMap2;
        int find2;
        Intrinsics.checkNotNullParameter(set, "changes");
        boolean z = false;
        for (Object obj : set) {
            if (this.dependencyToDerivedStates.contains(obj) && (find = (identityScopeMap = this.dependencyToDerivedStates).find(obj)) >= 0) {
                IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
                int size = scopeSetAt.size();
                for (int i = 0; i < size; i++) {
                    DerivedState derivedState = (DerivedState) scopeSetAt.get(i);
                    Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                    Object obj2 = this.recordedDerivedStateValues.get(derivedState);
                    SnapshotMutationPolicy policy = derivedState.getPolicy();
                    if (policy == null) {
                        policy = SnapshotStateKt.structuralEqualityPolicy();
                    }
                    if (!policy.equivalent(derivedState.getCurrentValue(), obj2) && (find2 = (identityScopeMap2 = this.valueToScopes).find(derivedState)) >= 0) {
                        IdentityArraySet scopeSetAt2 = identityScopeMap2.scopeSetAt(find2);
                        int size2 = scopeSetAt2.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            this.invalidated.add(scopeSetAt2.get(i2));
                            i2++;
                            z = true;
                        }
                    }
                }
            }
            IdentityScopeMap<Object> identityScopeMap3 = this.valueToScopes;
            int find3 = identityScopeMap3.find(obj);
            if (find3 >= 0) {
                IdentityArraySet scopeSetAt3 = identityScopeMap3.scopeSetAt(find3);
                int size3 = scopeSetAt3.size();
                int i3 = 0;
                while (i3 < size3) {
                    this.invalidated.add(scopeSetAt3.get(i3));
                    i3++;
                    z = true;
                }
            }
        }
        return z;
    }

    public final void recordRead(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.deriveStateScopeCount > 0) {
            return;
        }
        Object obj2 = this.currentScope;
        Intrinsics.checkNotNull(obj2);
        IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
        if (identityArrayIntMap == null) {
            identityArrayIntMap = new IdentityArrayIntMap();
            this.currentScopeReads = identityArrayIntMap;
            this.scopeToValues.set(obj2, identityArrayIntMap);
        }
        int add = identityArrayIntMap.add(obj, this.currentToken);
        if ((obj instanceof DerivedState) && add != this.currentToken) {
            DerivedState derivedState = (DerivedState) obj;
            for (Object obj3 : derivedState.getDependencies()) {
                if (obj3 == null) {
                    break;
                }
                this.dependencyToDerivedStates.add(obj3, obj);
            }
            this.recordedDerivedStateValues.put(obj, derivedState.getCurrentValue());
        }
        if (add == -1) {
            this.valueToScopes.add(obj, obj2);
        }
    }

    public final void removeScopeIf(@NotNull Function1<Object, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
        int size$runtime_release = identityArrayMap.getSize$runtime_release();
        int i = 0;
        for (int i2 = 0; i2 < size$runtime_release; i2++) {
            Object obj = identityArrayMap.getKeys$runtime_release()[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.getValues$runtime_release()[i2];
            Boolean bool = (Boolean) function1.invoke(obj);
            if (bool.booleanValue()) {
                int size = identityArrayIntMap.getSize();
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj2 = identityArrayIntMap.getKeys()[i3];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                    int i4 = identityArrayIntMap.getValues()[i3];
                    removeObservation(obj, obj2);
                }
            }
            if (!bool.booleanValue()) {
                if (i != i2) {
                    identityArrayMap.getKeys$runtime_release()[i] = obj;
                    identityArrayMap.getValues$runtime_release()[i] = identityArrayMap.getValues$runtime_release()[i2];
                }
                i++;
            }
        }
        if (identityArrayMap.getSize$runtime_release() > i) {
            int size$runtime_release2 = identityArrayMap.getSize$runtime_release();
            for (int i5 = i; i5 < size$runtime_release2; i5++) {
                identityArrayMap.getKeys$runtime_release()[i5] = null;
                identityArrayMap.getValues$runtime_release()[i5] = null;
            }
            identityArrayMap.setSize$runtime_release(i);
        }
    }
}
