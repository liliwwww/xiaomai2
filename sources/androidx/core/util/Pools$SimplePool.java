package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Pools$SimplePool<T> implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mPoolSize;

    public Pools$SimplePool(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.mPool = new Object[i];
    }

    private boolean isInPool(@NonNull T t) {
        for (int i = 0; i < this.mPoolSize; i++) {
            if (this.mPool[i] == t) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        int i = this.mPoolSize;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.mPoolSize = i - 1;
        return t;
    }

    public boolean release(@NonNull T t) {
        if (isInPool(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.mPoolSize = i + 1;
        return true;
    }
}
