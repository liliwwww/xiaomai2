package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public interface MutableState<T> extends State<T> {
    T component1();

    @NotNull
    Function1<T, Unit> component2();

    @Override // androidx.compose.runtime.State
    T getValue();

    void setValue(T t);
}
