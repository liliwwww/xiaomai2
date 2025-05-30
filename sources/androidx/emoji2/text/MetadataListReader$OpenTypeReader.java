package androidx.emoji2.text;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface MetadataListReader$OpenTypeReader {
    public static final int UINT16_BYTE_COUNT = 2;
    public static final int UINT32_BYTE_COUNT = 4;

    long getPosition();

    int readTag() throws IOException;

    long readUnsignedInt() throws IOException;

    int readUnsignedShort() throws IOException;

    void skip(int i) throws IOException;
}
