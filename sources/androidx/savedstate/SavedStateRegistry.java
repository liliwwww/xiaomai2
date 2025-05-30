package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.si4;

/* compiled from: Taobao */
@SuppressLint({"RestrictedApi"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SavedStateRegistry {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;

    @NotNull
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;

    @Nullable
    private Recreator$SavedStateProvider recreatorProvider;

    @Nullable
    private Bundle restoredState;

    /* compiled from: Taobao */
    public interface AutoRecreated {
        void onRecreated(@NotNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: Taobao */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Taobao */
    public interface SavedStateProvider {
        @NotNull
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performAttach$lambda-4, reason: not valid java name */
    public static final void m2814performAttach$lambda4(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(lifecycle$Event, "event");
        if (lifecycle$Event == Lifecycle$Event.ON_START) {
            savedStateRegistry.isAllowingSavingState = true;
        } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
            savedStateRegistry.isAllowingSavingState = false;
        }
    }

    @MainThread
    @Nullable
    public final Bundle consumeRestoredStateForKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.restoredState;
        boolean z = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z = true;
        }
        if (!z) {
            this.restoredState = null;
        }
        return bundle2;
    }

    @Nullable
    public final SavedStateProvider getSavedStateProvider(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "components");
            String key = next.getKey();
            SavedStateProvider value = next.getValue();
            if (Intrinsics.areEqual(key, str)) {
                return value;
            }
        }
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(@NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (!(!this.attached)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.addObserver(new si4(this));
        this.attached = true;
    }

    @MainThread
    public final void performRestore$savedstate_release(@Nullable Bundle bundle) {
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.isRestored)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.restoredState = bundle != null ? bundle.getBundle(SAVED_COMPONENTS_KEY) : null;
        this.isRestored = true;
    }

    @MainThread
    public final void performSave(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
    }

    @MainThread
    public final void registerSavedStateProvider(@NotNull String str, @NotNull SavedStateProvider savedStateProvider) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(savedStateProvider, "provider");
        if (!(this.components.putIfAbsent(str, savedStateProvider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.savedstate.Recreator$SavedStateProvider] */
    @MainThread
    public final void runOnNextRecreation(@NotNull Class<? extends AutoRecreated> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (!this.isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator$SavedStateProvider recreator$SavedStateProvider = this.recreatorProvider;
        Recreator$SavedStateProvider recreator$SavedStateProvider2 = recreator$SavedStateProvider;
        if (recreator$SavedStateProvider == null) {
            recreator$SavedStateProvider2 = new SavedStateProvider(this) { // from class: androidx.savedstate.Recreator$SavedStateProvider

                @NotNull
                private final Set<String> classes;

                {
                    Intrinsics.checkNotNullParameter(this, "registry");
                    this.classes = new LinkedHashSet();
                    this.registerSavedStateProvider("androidx.savedstate.Restarter", this);
                }

                public final void add(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "className");
                    this.classes.add(str);
                }

                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                @NotNull
                public Bundle saveState() {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.classes));
                    return bundle;
                }
            };
        }
        this.recreatorProvider = recreator$SavedStateProvider2;
        try {
            cls.getDeclaredConstructor(new Class[0]);
            Recreator$SavedStateProvider recreator$SavedStateProvider3 = this.recreatorProvider;
            if (recreator$SavedStateProvider3 != null) {
                String name = cls.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                recreator$SavedStateProvider3.add(name);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z) {
        this.isAllowingSavingState = z;
    }

    @MainThread
    public final void unregisterSavedStateProvider(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.components.remove(str);
    }
}
