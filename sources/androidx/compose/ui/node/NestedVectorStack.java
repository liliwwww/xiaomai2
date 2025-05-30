package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NestedVectorStack<T> {
    private int lastIndex;
    private int current = -1;

    @NotNull
    private int[] indexes = new int[16];

    @NotNull
    private final MutableVector<MutableVector<T>> vectors = new MutableVector<>(new MutableVector[16], 0);

    private final void pushIndex(int i) {
        int i2 = this.lastIndex;
        int[] iArr = this.indexes;
        if (i2 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.indexes = copyOf;
        }
        int[] iArr2 = this.indexes;
        int i3 = this.lastIndex;
        this.lastIndex = i3 + 1;
        iArr2[i3] = i;
    }

    public final boolean isNotEmpty() {
        int i = this.current;
        return i >= 0 && this.indexes[i] >= 0;
    }

    public final T pop() {
        int i = this.current;
        int i2 = this.indexes[i];
        MutableVector mutableVector = (MutableVector) this.vectors.getContent()[i];
        if (i2 > 0) {
            this.indexes[i] = r3[i] - 1;
        } else if (i2 == 0) {
            this.vectors.removeAt(i);
            this.current--;
        }
        return (T) mutableVector.getContent()[i2];
    }

    public final void push(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "vector");
        if (mutableVector.isNotEmpty()) {
            this.vectors.add(mutableVector);
            pushIndex(mutableVector.getSize() - 1);
            this.current++;
        }
    }
}
