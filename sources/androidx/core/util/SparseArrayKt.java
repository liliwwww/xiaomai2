package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArray<T> sparseArray, int i) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> sparseArray, int i) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> sparseArray, T t) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> sparseArray, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        T t2 = sparseArray.get(i);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> sparseArray, int i, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t = sparseArray.get(i);
        return t == null ? (T) function0.invoke() : t;
    }

    public static final <T> int getSize(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    @NotNull
    public static final <T> IntIterator keyIterator(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return new keyIterator.1(sparseArray);
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        Intrinsics.checkNotNullParameter(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        Intrinsics.checkNotNullParameter(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey < 0 || !Intrinsics.areEqual(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@NotNull SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        sparseArray.put(i, t);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        return new valueIterator.1(sparseArray);
    }
}
