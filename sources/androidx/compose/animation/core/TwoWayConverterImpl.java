package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class TwoWayConverterImpl<T, V extends AnimationVector> implements TwoWayConverter<T, V> {

    @NotNull
    private final Function1<V, T> convertFromVector;

    @NotNull
    private final Function1<T, V> convertToVector;

    /* JADX WARN: Multi-variable type inference failed */
    public TwoWayConverterImpl(@NotNull Function1<? super T, ? extends V> function1, @NotNull Function1<? super V, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(function1, "convertToVector");
        Intrinsics.checkNotNullParameter(function12, "convertFromVector");
        this.convertToVector = function1;
        this.convertFromVector = function12;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public Function1<V, T> getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public Function1<T, V> getConvertToVector() {
        return this.convertToVector;
    }
}
