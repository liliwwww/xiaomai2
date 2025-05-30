package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;

    @NotNull
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver;

    @Nullable
    private ObserverHandle applyUnsubscribe;

    @Nullable
    private ObservedScopeMap currentMap;
    private boolean isPaused;

    @NotNull
    private final MutableVector<ObservedScopeMap> observedScopeMaps;

    @NotNull
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;

    @NotNull
    private final AtomicReference<Object> pendingChanges;

    @NotNull
    private final Function1<Object, Unit> readObserver;
    private boolean sendingNotifications;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static final class ObservedScopeMap {

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

        public ObservedScopeMap(@NotNull Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onChanged");
            this.onChanged = function1;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap<>();
            this.scopeToValues = new IdentityArrayMap<>(0, 1, null);
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
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i + 1;
                }
            };
            this.derivedStateExitObserver = new Function1<State<?>, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateExitObserver$1
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
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i - 1;
                }
            };
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
            IdentityArrayIntMap identityArrayIntMap = this.scopeToValues.get(obj);
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

    public SnapshotStateObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.onChangedExecutor = function1;
        this.pendingChanges = new AtomicReference<>(null);
        this.applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Set<? extends Object>) obj, (Snapshot) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
                boolean drainChanges;
                Intrinsics.checkNotNullParameter(set, "applied");
                Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                SnapshotStateObserver.this.addChanges(set);
                drainChanges = SnapshotStateObserver.this.drainChanges();
                if (drainChanges) {
                    SnapshotStateObserver.this.sendNotifications();
                }
            }
        };
        this.readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2447invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2447invoke(@NotNull Object obj) {
                boolean z;
                MutableVector mutableVector;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap;
                Intrinsics.checkNotNullParameter(obj, "state");
                z = SnapshotStateObserver.this.isPaused;
                if (z) {
                    return;
                }
                mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                synchronized (mutableVector) {
                    observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    observedScopeMap.recordRead(obj);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        Object plus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                plus = set;
            } else if (obj instanceof Set) {
                plus = CollectionsKt.listOf(new Set[]{(Set) obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                plus = CollectionsKt.plus((Collection) obj, CollectionsKt.listOf(set));
            }
        } while (!this.pendingChanges.compareAndSet(obj, plus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> removeChanges = removeChanges();
            if (removeChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        if (!content[i].recordInvalidation(removeChanges) && !z2) {
                            z2 = false;
                            i++;
                        }
                        z2 = true;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> function1) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (observedScopeMap.getOnChanged() == function1) {
                    break;
                }
                i++;
            } while (i < size);
        }
        observedScopeMap = null;
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    int i = 0;
                    ObservedScopeMap[] content = mutableVector.getContent();
                    do {
                        function1.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object obj2;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!this.pendingChanges.compareAndSet(obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2448invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2448invoke() {
                MutableVector mutableVector;
                boolean z;
                boolean drainChanges;
                MutableVector mutableVector2;
                do {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        z = snapshotStateObserver.sendingNotifications;
                        if (!z) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size > 0) {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((SnapshotStateObserver.ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } finally {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    drainChanges = SnapshotStateObserver.this.drainChanges();
                } while (drainChanges);
            }
        });
    }

    public final void clear(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "scope");
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                ObservedScopeMap[] content = mutableVector.getContent();
                do {
                    content[i].clearScopeObservations(obj);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(@NotNull Function1<Object, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                ObservedScopeMap[] content = mutableVector.getContent();
                do {
                    content[i].removeScopeIf(function1);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyChanges(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(set, snapshot);
    }

    public final <T> void observeReads(@NotNull T t, @NotNull Function1<? super T, Unit> function1, @NotNull final Function0<Unit> function0) {
        ObservedScopeMap ensureMap;
        Intrinsics.checkNotNullParameter(t, "scope");
        Intrinsics.checkNotNullParameter(function1, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(function1);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            Object obj = ensureMap.currentScope;
            IdentityArrayIntMap identityArrayIntMap = ensureMap.currentScopeReads;
            int i = ensureMap.currentToken;
            ensureMap.currentScope = t;
            ensureMap.currentScopeReads = (IdentityArrayIntMap) ensureMap.scopeToValues.get(t);
            if (ensureMap.currentToken == -1) {
                ensureMap.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            SnapshotStateKt.observeDerivedStateRecalculations(ensureMap.getDerivedStateEnterObserver(), ensureMap.getDerivedStateExitObserver(), new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$observeReads$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2446invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2446invoke() {
                    Function1<Object, Unit> function12;
                    Snapshot.Companion companion = Snapshot.Companion;
                    function12 = SnapshotStateObserver.this.readObserver;
                    companion.observe(function12, null, function0);
                }
            });
            Object obj2 = ensureMap.currentScope;
            Intrinsics.checkNotNull(obj2);
            ensureMap.clearObsoleteStateReads(obj2);
            ensureMap.currentScope = obj;
            ensureMap.currentScopeReads = identityArrayIntMap;
            ensureMap.currentToken = i;
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                ObservedScopeMap[] content = mutableVector.getContent();
                do {
                    content[i].clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
