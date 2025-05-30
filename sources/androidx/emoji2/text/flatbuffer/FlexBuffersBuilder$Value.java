package androidx.emoji2.text.flatbuffer;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class FlexBuffersBuilder$Value {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final double dValue;
    long iValue;
    int key;
    final int minBitWidth;
    final int type;

    FlexBuffersBuilder$Value(int i, int i2, int i3, long j) {
        this.key = i;
        this.type = i2;
        this.minBitWidth = i3;
        this.iValue = j;
        this.dValue = Double.MIN_VALUE;
    }

    static FlexBuffersBuilder$Value blob(int i, int i2, int i3, int i4) {
        return new FlexBuffersBuilder$Value(i, i3, i4, i2);
    }

    static FlexBuffersBuilder$Value bool(int i, boolean z) {
        return new FlexBuffersBuilder$Value(i, 26, 0, z ? 1L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int elemWidth(int i, int i2) {
        return elemWidth(this.type, this.minBitWidth, this.iValue, i, i2);
    }

    static FlexBuffersBuilder$Value float32(int i, float f) {
        return new FlexBuffersBuilder$Value(i, 3, 2, f);
    }

    static FlexBuffersBuilder$Value float64(int i, double d) {
        return new FlexBuffersBuilder$Value(i, 3, 3, d);
    }

    static FlexBuffersBuilder$Value int16(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 1, 1, i2);
    }

    static FlexBuffersBuilder$Value int32(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 1, 2, i2);
    }

    static FlexBuffersBuilder$Value int64(int i, long j) {
        return new FlexBuffersBuilder$Value(i, 1, 3, j);
    }

    static FlexBuffersBuilder$Value int8(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 1, 0, i2);
    }

    private static byte packedType(int i, int i2) {
        return (byte) (i | (i2 << 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int paddingBytes(int i, int i2) {
        return ((~i) + 1) & (i2 - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte storedPackedType() {
        return storedPackedType(0);
    }

    private int storedWidth(int i) {
        return FlexBuffers.isTypeInline(this.type) ? Math.max(this.minBitWidth, i) : this.minBitWidth;
    }

    static FlexBuffersBuilder$Value uInt16(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 2, 1, i2);
    }

    static FlexBuffersBuilder$Value uInt32(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 2, 2, i2);
    }

    static FlexBuffersBuilder$Value uInt64(int i, long j) {
        return new FlexBuffersBuilder$Value(i, 2, 3, j);
    }

    static FlexBuffersBuilder$Value uInt8(int i, int i2) {
        return new FlexBuffersBuilder$Value(i, 2, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int elemWidth(int i, int i2, long j, int i3, int i4) {
        if (FlexBuffers.isTypeInline(i)) {
            return i2;
        }
        for (int i5 = 1; i5 <= 32; i5 *= 2) {
            int widthUInBits = FlexBuffersBuilder.widthUInBits((int) (((paddingBytes(i3, i5) + i3) + (i4 * i5)) - j));
            if ((1 << widthUInBits) == i5) {
                return widthUInBits;
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte storedPackedType(int i) {
        return packedType(storedWidth(i), this.type);
    }

    FlexBuffersBuilder$Value(int i, int i2, int i3, double d) {
        this.key = i;
        this.type = i2;
        this.minBitWidth = i3;
        this.dValue = d;
        this.iValue = Long.MIN_VALUE;
    }
}
