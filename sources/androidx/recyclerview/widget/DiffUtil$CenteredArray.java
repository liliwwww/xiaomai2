package androidx.recyclerview.widget;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DiffUtil$CenteredArray {
    private final int[] mData;
    private final int mMid;

    DiffUtil$CenteredArray(int i) {
        int[] iArr = new int[i];
        this.mData = iArr;
        this.mMid = iArr.length / 2;
    }

    int[] backingData() {
        return this.mData;
    }

    public void fill(int i) {
        Arrays.fill(this.mData, i);
    }

    int get(int i) {
        return this.mData[i + this.mMid];
    }

    void set(int i, int i2) {
        this.mData[i + this.mMid] = i2;
    }
}
