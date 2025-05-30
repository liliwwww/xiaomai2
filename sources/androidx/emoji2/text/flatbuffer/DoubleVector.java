package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 8, byteBuffer);
        return this;
    }

    public double get(int i) {
        return this.f359bb.getDouble(__element(i));
    }
}
