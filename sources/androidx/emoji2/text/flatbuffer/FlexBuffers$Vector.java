package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FlexBuffers$Vector extends FlexBuffers.Sized {
    private static final FlexBuffers$Vector EMPTY_VECTOR = new FlexBuffers$Vector(FlexBuffers.access$000(), 1, 1);

    FlexBuffers$Vector(ReadBuf readBuf, int i, int i2) {
        super(readBuf, i, i2);
    }

    public static FlexBuffers$Vector empty() {
        return EMPTY_VECTOR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlexBuffers.Reference get(int i) {
        long size = size();
        long j = i;
        if (j >= size) {
            return FlexBuffers.Reference.access$600();
        }
        return new FlexBuffers.Reference(this.bb, this.end + (i * this.byteWidth), this.byteWidth, FlexBuffers$Unsigned.byteToUnsignedInt(this.bb.get((int) (this.end + (size * this.byteWidth) + j))));
    }

    public boolean isEmpty() {
        return this == EMPTY_VECTOR;
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ String toString() {
        return super/*androidx.emoji2.text.flatbuffer.FlexBuffers$Object*/.toString();
    }

    public StringBuilder toString(StringBuilder sb) {
        sb.append("[ ");
        int size = size();
        for (int i = 0; i < size; i++) {
            get(i).toString(sb);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb;
    }
}
