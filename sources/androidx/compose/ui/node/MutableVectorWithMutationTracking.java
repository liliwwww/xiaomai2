package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutableVectorWithMutationTracking<T> {

    @NotNull
    private final Function0<Unit> onVectorMutated;

    @NotNull
    private final MutableVector<T> vector;

    public MutableVectorWithMutationTracking(@NotNull MutableVector<T> mutableVector, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(mutableVector, "vector");
        Intrinsics.checkNotNullParameter(function0, "onVectorMutated");
        this.vector = mutableVector;
        this.onVectorMutated = function0;
    }

    public final void add(int i, T t) {
        this.vector.add(i, t);
        this.onVectorMutated.invoke();
    }

    @NotNull
    public final List<T> asList() {
        return this.vector.asMutableList();
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final void forEach(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MutableVector<T> vector = getVector();
        int size = vector.getSize();
        if (size > 0) {
            int i = 0;
            T[] content = vector.getContent();
            do {
                function1.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final T get(int i) {
        return this.vector.getContent()[i];
    }

    @NotNull
    public final Function0<Unit> getOnVectorMutated() {
        return this.onVectorMutated;
    }

    public final int getSize() {
        return this.vector.getSize();
    }

    @NotNull
    public final MutableVector<T> getVector() {
        return this.vector;
    }

    public final T removeAt(int i) {
        T removeAt = this.vector.removeAt(i);
        this.onVectorMutated.invoke();
        return removeAt;
    }
}
