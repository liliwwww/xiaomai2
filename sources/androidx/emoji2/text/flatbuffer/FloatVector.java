package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    public float get(int i) {
        return this.bb.getFloat(__element(i));
    }
}
