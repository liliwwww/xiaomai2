package androidx.compose.runtime.collection;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutableVectorKt {
    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[i], 0);
    }

    public static /* synthetic */ MutableVector MutableVector$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 16;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[i], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i) {
        int size = list.size();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i, int i2) {
        int size = list.size();
        if (i > i2) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i + ") is less than 0.");
        }
        if (i2 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is more than than the list size (" + size + ')');
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return new MutableVector<>(tArr, tArr.length);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = function1.invoke(Integer.valueOf(i2));
        }
        return new MutableVector<>(objArr, i);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[16], 0);
    }
}
