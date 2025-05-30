package androidx.compose.runtime.snapshots;

import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;

    @NotNull
    private int[] handles;
    private int size;

    @NotNull
    private int[] values = new int[16];

    @NotNull
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i = 0;
            int i2 = length * 2;
            int[] iArr = new int[i2];
            while (i < i2) {
                int i3 = i + 1;
                iArr[i] = i3;
                i = i3;
            }
            ArraysKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, (Object) null);
            this.handles = iArr;
        }
        int i4 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i4];
        return i4;
    }

    private final void ensure(int i) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (i <= length) {
            return;
        }
        int i2 = length * 2;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        ArraysKt.copyInto$default(iArr, iArr2, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(this.index, iArr3, 0, 0, 0, 14, (Object) null);
        this.values = iArr2;
        this.index = iArr3;
    }

    private final void freeHandle(int i) {
        this.handles[i] = this.firstFreeHandle;
        this.firstFreeHandle = i;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i);
    }

    private final void shiftDown(int i) {
        int[] iArr = this.values;
        int i2 = this.size >> 1;
        while (i < i2) {
            int i3 = (i + 1) << 1;
            int i4 = i3 - 1;
            if (i3 >= this.size || iArr[i3] >= iArr[i4]) {
                if (iArr[i4] >= iArr[i]) {
                    return;
                }
                swap(i4, i);
                i = i4;
            } else {
                if (iArr[i3] >= iArr[i]) {
                    return;
                }
                swap(i3, i);
                i = i3;
            }
        }
    }

    private final void shiftUp(int i) {
        int[] iArr = this.values;
        int i2 = iArr[i];
        while (i > 0) {
            int i3 = ((i + 1) >> 1) - 1;
            if (iArr[i3] <= i2) {
                return;
            }
            swap(i3, i);
            i = i3;
        }
    }

    private final void swap(int i, int i2) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
        int i4 = iArr2[i];
        iArr2[i] = iArr2[i2];
        iArr2[i2] = i4;
        iArr3[iArr2[i]] = i;
        iArr3[iArr2[i2]] = i2;
    }

    public final int add(int i) {
        ensure(this.size + 1);
        int i2 = this.size;
        this.size = i2 + 1;
        int allocateHandle = allocateHandle();
        this.values[i2] = i;
        this.index[i2] = allocateHandle;
        this.handles[allocateHandle] = i2;
        shiftUp(i2);
        return allocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int i) {
        return this.size > 0 ? this.values[0] : i;
    }

    public final void remove(int i) {
        int i2 = this.handles[i];
        swap(i2, this.size - 1);
        this.size--;
        shiftUp(i2);
        shiftDown(i2);
        freeHandle(i);
    }

    public final void validate() {
        int i = this.size;
        int i2 = 1;
        while (i2 < i) {
            int i3 = i2 + 1;
            int[] iArr = this.values;
            if (iArr[(i3 >> 1) - 1] > iArr[i2]) {
                throw new IllegalStateException(("Index " + i2 + " is out of place").toString());
            }
            i2 = i3;
        }
    }

    public final void validateHandle(int i, int i2) {
        int i3 = this.handles[i];
        if (this.index[i3] != i) {
            throw new IllegalStateException(("Index for handle " + i + " is corrupted").toString());
        }
        if (this.values[i3] == i2) {
            return;
        }
        throw new IllegalStateException(("Value for handle " + i + " was " + this.values[i3] + " but was supposed to be " + i2).toString());
    }
}
