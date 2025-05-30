package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class IdentityArrayIntMap {
    private int size;

    @NotNull
    private Object[] keys = new Object[4];

    @NotNull
    private int[] values = new int[4];

    private final int find(Object obj) {
        int i = this.size - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = this.keys[i3];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i2 = i3 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    return obj2 == obj ? i3 : findExactIndex(i3, obj, identityHashCode);
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj2 = this.keys[i3];
            if (obj2 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj2) != i2) {
                break;
            }
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (true) {
            if (i4 >= i5) {
                i4 = this.size;
                break;
            }
            Object obj3 = this.keys[i4];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
            i4++;
        }
        return -(i4 + 1);
    }

    @PublishedApi
    public static /* synthetic */ void getKeys$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSize$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    public final int add(@NotNull Object obj, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(obj, "key");
        if (this.size > 0) {
            i2 = find(obj);
            if (i2 >= 0) {
                int[] iArr = this.values;
                int i3 = iArr[i2];
                iArr[i2] = i;
                return i3;
            }
        } else {
            i2 = -1;
        }
        int i4 = -(i2 + 1);
        int i5 = this.size;
        Object[] objArr = this.keys;
        if (i5 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            int[] iArr2 = new int[objArr.length * 2];
            int i6 = i4 + 1;
            ArraysKt.copyInto(objArr, objArr2, i6, i4, i5);
            ArraysKt.copyInto(this.values, iArr2, i6, i4, this.size);
            ArraysKt.copyInto$default(this.keys, objArr2, 0, 0, i4, 6, (Object) null);
            ArraysKt.copyInto$default(this.values, iArr2, 0, 0, i4, 6, (Object) null);
            this.keys = objArr2;
            this.values = iArr2;
        } else {
            int i7 = i4 + 1;
            ArraysKt.copyInto(objArr, objArr, i7, i4, i5);
            int[] iArr3 = this.values;
            ArraysKt.copyInto(iArr3, iArr3, i7, i4, this.size);
        }
        this.keys[i4] = obj;
        this.values[i4] = i;
        this.size++;
        return -1;
    }

    public final boolean any(@NotNull Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size = getSize();
        for (int i = 0; i < size; i++) {
            Object obj = getKeys()[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            if (((Boolean) function2.invoke(obj, Integer.valueOf(getValues()[i]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(@NotNull Function2<Object, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size = getSize();
        for (int i = 0; i < size; i++) {
            Object obj = getKeys()[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            function2.invoke(obj, Integer.valueOf(getValues()[i]));
        }
    }

    public final int get(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        int find = find(obj);
        if (find >= 0) {
            return this.values[find];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    @NotNull
    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        int find = find(obj);
        if (find < 0) {
            return false;
        }
        int i = this.size;
        if (find < i - 1) {
            Object[] objArr = this.keys;
            int i2 = find + 1;
            ArraysKt.copyInto(objArr, objArr, find, i2, i);
            int[] iArr = this.values;
            ArraysKt.copyInto(iArr, iArr, find, i2, this.size);
        }
        int i3 = this.size - 1;
        this.size = i3;
        this.keys[i3] = null;
        return true;
    }

    public final void removeValueIf(@NotNull Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = getKeys()[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            int i3 = getValues()[i2];
            if (!((Boolean) function2.invoke(obj, Integer.valueOf(i3))).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = i3;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i4 = i; i4 < size2; i4++) {
            getKeys()[i4] = null;
        }
        setSize(i);
    }

    public final void setKeys(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void setValues(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.values = iArr;
    }
}
