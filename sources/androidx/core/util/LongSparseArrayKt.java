package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> longSparseArray, T t) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        T t2 = longSparseArray.get(j);
        return t2 == null ? t : t2;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t == null ? (T) function0.invoke() : t;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongIterator keyIterator(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return new keyIterator.1(longSparseArray);
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        Intrinsics.checkNotNullParameter(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        Intrinsics.checkNotNullParameter(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean remove(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !Intrinsics.areEqual(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
