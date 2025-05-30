package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.MutableState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SavedStateHandleSaverKt$saveable$3$provideDelegate$1<T> implements ReadWriteProperty<Object, T> {
    final /* synthetic */ MutableState<T> $mutableState;

    SavedStateHandleSaverKt$saveable$3$provideDelegate$1(MutableState<T> mutableState) {
        this.$mutableState = mutableState;
    }

    @NotNull
    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (T) this.$mutableState.getValue();
    }

    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, @NotNull T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        this.$mutableState.setValue(t);
    }
}
