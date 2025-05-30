package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class UtilsKt {
    public static final int LOG_MAX_BUFFER_SIZE = 5;
    public static final int MAX_BUFFER_SIZE = 32;
    public static final int MAX_BUFFER_SIZE_MINUS_ONE = 31;
    public static final int MUTABLE_BUFFER_SIZE = 33;

    public static final int indexSegment(int i, int i2) {
        return (i >> i2) & 31;
    }

    @NotNull
    public static final <E> PersistentList<E> persistentVectorOf() {
        return SmallPersistentVector.Companion.getEMPTY();
    }

    @NotNull
    public static final Object[] presizedBufferWith(@Nullable Object obj) {
        Object[] objArr = new Object[32];
        objArr[0] = obj;
        return objArr;
    }

    public static final int rootSize(int i) {
        return (i - 1) & (-32);
    }
}
