package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SavedStateHandleSaverKt {
    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new mutableStateSaver.1.1(saver), new mutableStateSaver.1.2(saver));
    }

    @SavedStateHandleSaveableApi
    @NotNull
    /* renamed from: saveable, reason: collision with other method in class */
    public static final <T> T m2810saveable(@NotNull SavedStateHandle savedStateHandle, @NotNull String str, @NotNull final Saver<T, ? extends Object> saver, @NotNull Function0<? extends T> function0) {
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
                return BundleKt.bundleOf(new Pair[]{TuplesKt.to("value", saver.save(new saveState.1.1(SavedStateHandle.Companion), t2))});
            }
        });
        return t;
    }

    public static /* synthetic */ Object saveable$default(SavedStateHandle savedStateHandle, String str, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        return m2810saveable(savedStateHandle, str, saver, function0);
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
                return m2812provideDelegate(obj, (KProperty<?>) kProperty);
            }

            @NotNull
            /* renamed from: provideDelegate, reason: collision with other method in class */
            public final ReadWriteProperty<Object, T> m2812provideDelegate(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                return new provideDelegate.1(SavedStateHandleSaverKt.saveable(SavedStateHandle.this, kProperty.getName(), (Saver) saver, (Function0) function0));
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
        return (MutableState) m2810saveable(savedStateHandle, str, mutableStateSaver(saver), (Function0) function0);
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
                return m2811provideDelegate(obj, (KProperty<?>) kProperty);
            }

            @NotNull
            /* renamed from: provideDelegate, reason: collision with other method in class */
            public final ReadOnlyProperty<Object, T> m2811provideDelegate(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                return new provideDelegate.1(SavedStateHandleSaverKt.m2810saveable(SavedStateHandle.this, kProperty.getName(), (Saver) saver, (Function0) function0));
            }
        };
    }
}
