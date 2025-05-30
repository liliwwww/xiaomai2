package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MetadataItem$Vector extends BaseVector {
    public MetadataItem$Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    public MetadataItem get(int i) {
        return get(new MetadataItem(), i);
    }

    public MetadataItem get(MetadataItem metadataItem, int i) {
        return metadataItem.__assign(MetadataItem.access$000(__element(i), this.bb), this.bb);
    }
}
