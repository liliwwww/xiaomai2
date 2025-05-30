package androidx.compose.runtime.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ThreadMap {

    @NotNull
    private final long[] keys;
    private final int size;

    @NotNull
    private final Object[] values;

    public ThreadMap(int i, @NotNull long[] jArr, @NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(jArr, "keys");
        Intrinsics.checkNotNullParameter(objArr, "values");
        this.size = i;
        this.keys = jArr;
        this.values = objArr;
    }

    private final int find(long j) {
        int i = this.size - 1;
        if (i == -1) {
            return -1;
        }
        int i2 = 0;
        if (i == 0) {
            long[] jArr = this.keys;
            if (jArr[0] == j) {
                return 0;
            }
            return jArr[0] > j ? -2 : -1;
        }
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            long j2 = this.keys[i3] - j;
            if (j2 < 0) {
                i2 = i3 + 1;
            } else {
                if (j2 <= 0) {
                    return i3;
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    @Nullable
    public final Object get(long j) {
        int find = find(j);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    @NotNull
    public final ThreadMap newWith(long j, @Nullable Object obj) {
        int i = this.size;
        Object[] objArr = this.values;
        int length = objArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (objArr[i3] != null) {
                i4++;
            }
            i3++;
        }
        int i5 = i4 + 1;
        long[] jArr = new long[i5];
        Object[] objArr2 = new Object[i5];
        if (i5 > 1) {
            int i6 = 0;
            while (true) {
                if (i2 >= i5 || i6 >= i) {
                    break;
                }
                long j2 = this.keys[i6];
                Object obj2 = this.values[i6];
                if (j2 > j) {
                    jArr[i2] = j;
                    objArr2[i2] = obj;
                    i2++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i2] = j2;
                    objArr2[i2] = obj2;
                    i2++;
                }
                i6++;
            }
            if (i6 == i) {
                int i7 = i5 - 1;
                jArr[i7] = j;
                objArr2[i7] = obj;
            } else {
                while (i2 < i5) {
                    long j3 = this.keys[i6];
                    Object obj3 = this.values[i6];
                    if (obj3 != null) {
                        jArr[i2] = j3;
                        objArr2[i2] = obj3;
                        i2++;
                    }
                    i6++;
                }
            }
        } else {
            jArr[0] = j;
            objArr2[0] = obj;
        }
        return new ThreadMap(i5, jArr, objArr2);
    }

    public final boolean trySet(long j, @Nullable Object obj) {
        int find = find(j);
        if (find < 0) {
            return false;
        }
        this.values[find] = obj;
        return true;
    }
}
