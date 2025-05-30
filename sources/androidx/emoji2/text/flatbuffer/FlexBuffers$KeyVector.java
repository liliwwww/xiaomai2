package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FlexBuffers$KeyVector {
    private final FlexBuffers.TypedVector vec;

    FlexBuffers$KeyVector(FlexBuffers.TypedVector typedVector) {
        this.vec = typedVector;
    }

    public FlexBuffers.Key get(int i) {
        if (i >= size()) {
            return FlexBuffers.Key.access$700();
        }
        FlexBuffers.TypedVector typedVector = this.vec;
        int i2 = typedVector.end + (i * typedVector.byteWidth);
        FlexBuffers.TypedVector typedVector2 = this.vec;
        ReadBuf readBuf = typedVector2.bb;
        return new FlexBuffers.Key(readBuf, FlexBuffers.access$200(readBuf, i2, typedVector2.byteWidth), 1);
    }

    public int size() {
        return this.vec.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < this.vec.size(); i++) {
            this.vec.get(i).toString(sb);
            if (i != this.vec.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
