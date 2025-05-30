package androidx.lifecycle.viewmodel.compose;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SavedStateHandleSaverKt$saveable$2$provideDelegate$1<T> implements ReadOnlyProperty<Object, T> {
    final /* synthetic */ T $value;

    SavedStateHandleSaverKt$saveable$2$provideDelegate$1(T t) {
        this.$value = t;
    }

    @NotNull
    public final T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<anonymous parameter 1>");
        return this.$value;
    }
}
