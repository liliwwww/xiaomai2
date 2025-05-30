package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import java.io.PrintStream;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class KeyFrameArray$CustomArray {
    private static final int EMPTY = 999;
    int count;
    int[] keys = new int[101];
    CustomAttribute[] values = new CustomAttribute[101];

    public KeyFrameArray$CustomArray() {
        clear();
    }

    public void append(int i, CustomAttribute customAttribute) {
        if (this.values[i] != null) {
            remove(i);
        }
        this.values[i] = customAttribute;
        int[] iArr = this.keys;
        int i2 = this.count;
        this.count = i2 + 1;
        iArr[i2] = i;
        Arrays.sort(iArr);
    }

    public void clear() {
        Arrays.fill(this.keys, EMPTY);
        Arrays.fill(this.values, (Object) null);
        this.count = 0;
    }

    public void dump() {
        System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
        System.out.print("K: [");
        int i = 0;
        while (i < this.count) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append(i == 0 ? "" : ", ");
            sb.append(valueAt(i));
            printStream.print(sb.toString());
            i++;
        }
        System.out.println("]");
    }

    public int keyAt(int i) {
        return this.keys[i];
    }

    public void remove(int i) {
        this.values[i] = null;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = this.count;
            if (i2 >= i4) {
                this.count = i4 - 1;
                return;
            }
            int[] iArr = this.keys;
            if (i == iArr[i2]) {
                iArr[i2] = EMPTY;
                i3++;
            }
            if (i2 != i3) {
                iArr[i2] = iArr[i3];
            }
            i3++;
            i2++;
        }
    }

    public int size() {
        return this.count;
    }

    public CustomAttribute valueAt(int i) {
        return this.values[this.keys[i]];
    }
}
