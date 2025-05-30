package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SavedStateHandleSaverKt {
    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(final Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new Function2<SaverScope, MutableState<T>, MutableState<Object>>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$mutableStateSaver$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Nullable
            public final MutableState<Object> invoke(@NotNull SaverScope saverScope, @NotNull MutableState<T> mutableState) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                Intrinsics.checkNotNullParameter(mutableState, "state");
                if (!(mutableState instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()".toString());
                }
                Object save = saver.save(saverScope, mutableState.getValue());
                SnapshotMutationPolicy<T> policy = ((SnapshotMutableState) mutableState).getPolicy();
                Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
                return SnapshotStateKt.mutableStateOf(save, policy);
            }
        }, new Function1<MutableState<Object>, MutableState<T>>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$mutableStateSaver$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Nullable
            public final MutableState<T> invoke(@NotNull MutableState<Object> mutableState) {
                T t;
                Intrinsics.checkNotNullParameter(mutableState, "it");
                if (!(mutableState instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (mutableState.getValue() != null) {
                    Saver<T, Object> saver2 = saver;
                    Object value = mutableState.getValue();
                    Intrinsics.checkNotNull(value);
                    t = saver2.restore(value);
                } else {
                    t = null;
                }
                SnapshotMutationPolicy<T> policy = ((SnapshotMutableState) mutableState).getPolicy();
                Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver$lambda$0?>");
                MutableState<T> mutableStateOf = SnapshotStateKt.mutableStateOf(t, policy);
                Intrinsics.checkNotNull(mutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver$lambda$0>");
                return mutableStateOf;
            }
        });
    }

    @SavedStateHandleSaveableApi
    @NotNull
    /* renamed from: saveable, reason: collision with other method in class */
    public static final <T> T m5614saveable(@NotNull SavedStateHandle savedStateHandle, @NotNull String str, @NotNull final Saver<T, ? extends Object> saver, @NotNull Function0<? extends T> function0) {
        T t;
        Object obj;
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(function0, "init");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        if (bundle == null || (obj = bundle.get("value")) == null || (t = saver.restore(obj)) == null) {
            t = (T) function0.invoke();
        }
        final T t2 = t;
        savedStateHandle.setSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NotNull
            public final Bundle saveState() {
                return BundleKt.bundleOf(TuplesKt.to("value", saver.save(new SavedStateHandleSaverKt$saveable$1$saveState$1$1(SavedStateHandle.Companion), t2)));
            }
        });
        return t;
    }

    public static /* synthetic */ Object saveable$default(SavedStateHandle savedStateHandle, String str, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        return m5614saveable(savedStateHandle, str, saver, function0);
    }

    @SavedStateHandleSaveableApi
    @JvmName(name = "saveableMutableState")
    @NotNull
    public static final <T, M extends MutableState<T>> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> saveableMutableState(@NotNull final SavedStateHandle savedStateHandle, @NotNull final Saver<T, ? extends Object> saver, @NotNull final Function0<? extends M> function0) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(saver, "stateSaver");
        Intrinsics.checkNotNullParameter(function0, "init");
        return new PropertyDelegateProvider<Object, ReadWriteProperty<? super Object, T>>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$3
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return m5616provideDelegate(obj, (KProperty<?>) kProperty);
            }

            @NotNull
            /* renamed from: provideDelegate, reason: collision with other method in class */
            public final ReadWriteProperty<Object, T> m5616provideDelegate(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                final MutableState saveable = SavedStateHandleSaverKt.saveable(SavedStateHandle.this, kProperty.getName(), (Saver) saver, (Function0) function0);
                return new ReadWriteProperty<Object, T>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$3$provideDelegate$1
                    @NotNull
                    public T getValue(@Nullable Object obj2, @NotNull KProperty<?> kProperty2) {
                        Intrinsics.checkNotNullParameter(kProperty2, "property");
                        return saveable.getValue();
                    }

                    public void setValue(@Nullable Object obj2, @NotNull KProperty<?> kProperty2, @NotNull T t) {
                        Intrinsics.checkNotNullParameter(kProperty2, "property");
                        Intrinsics.checkNotNullParameter(t, "value");
                        saveable.setValue(t);
                    }
                };
            }
        };
    }

    public static /* synthetic */ PropertyDelegateProvider saveableMutableState$default(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveableMutableState(savedStateHandle, saver, function0);
    }

    @SavedStateHandleSaveableApi
    @NotNull
    public static final <T> MutableState<T> saveable(@NotNull SavedStateHandle savedStateHandle, @NotNull String str, @NotNull Saver<T, ? extends Object> saver, @NotNull Function0<? extends MutableState<T>> function0) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(saver, "stateSaver");
        Intrinsics.checkNotNullParameter(function0, "init");
        return (MutableState) m5614saveable(savedStateHandle, str, mutableStateSaver(saver), (Function0) function0);
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveable(savedStateHandle, saver, function0);
    }

    @SavedStateHandleSaveableApi
    @NotNull
    public static final <T> PropertyDelegateProvider<Object, ReadOnlyProperty<Object, T>> saveable(@NotNull final SavedStateHandle savedStateHandle, @NotNull final Saver<T, ? extends Object> saver, @NotNull final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(function0, "init");
        return new PropertyDelegateProvider<Object, ReadOnlyProperty<? super Object, ? extends T>>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$2
            public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, KProperty kProperty) {
                return m5615provideDelegate(obj, (KProperty<?>) kProperty);
            }

            @NotNull
            /* renamed from: provideDelegate, reason: collision with other method in class */
            public final ReadOnlyProperty<Object, T> m5615provideDelegate(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                final Object m5614saveable = SavedStateHandleSaverKt.m5614saveable(SavedStateHandle.this, kProperty.getName(), (Saver<Object, ? extends Object>) saver, (Function0<? extends Object>) function0);
                return new ReadOnlyProperty<Object, T>() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$2$provideDelegate$1
                    @NotNull
                    public final T getValue(@Nullable Object obj2, @NotNull KProperty<?> kProperty2) {
                        Intrinsics.checkNotNullParameter(kProperty2, "<anonymous parameter 1>");
                        return m5614saveable;
                    }
                };
            }
        };
    }
}
