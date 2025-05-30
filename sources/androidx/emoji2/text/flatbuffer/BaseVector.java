package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BaseVector {

    /* renamed from: bb */
    protected ByteBuffer f359bb;
    private int element_size;
    private int length;
    private int vector;

    protected int __element(int i) {
        return this.vector + (i * this.element_size);
    }

    protected void __reset(int i, int i2, ByteBuffer byteBuffer) {
        this.f359bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i;
            this.length = byteBuffer.getInt(i - 4);
            this.element_size = i2;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, null);
    }
}
