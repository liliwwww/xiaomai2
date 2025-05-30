package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface TwoWayConverter<T, V extends AnimationVector> {
    @NotNull
    Function1<V, T> getConvertFromVector();

    @NotNull
    Function1<T, V> getConvertToVector();
}
