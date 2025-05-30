package androidx.compose.p004ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 0;

    @NotNull
    private final Function2<T, T, T> mergePolicy;

    @NotNull
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(@NotNull String str, @NotNull Function2<? super T, ? super T, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "mergePolicy");
        this.name = str;
        this.mergePolicy = function2;
    }

    @NotNull
    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final T getValue(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull KProperty<?> kProperty) {
        Object throwSemanticsGetNotSupported;
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        throwSemanticsGetNotSupported = SemanticsPropertiesKt.throwSemanticsGetNotSupported();
        return (T) throwSemanticsGetNotSupported;
    }

    @Nullable
    public final T merge(@Nullable T t, T t2) {
        return (T) this.mergePolicy.invoke(t, t2);
    }

    public final void setValue(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        semanticsPropertyReceiver.set(this, t);
    }

    @NotNull
    public String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function2<T, T, T>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Nullable
            public final T invoke(@Nullable T t, T t2) {
                return t == null ? t2 : t;
            }
        } : function2);
    }
}
