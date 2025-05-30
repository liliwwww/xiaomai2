package androidx.exifinterface.media;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ExifInterface$SeekableByteOrderedDataInputStream extends ExifInterface.ByteOrderedDataInputStream {
    ExifInterface$SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
        super(bArr);
        ((ExifInterface.ByteOrderedDataInputStream) this).mDataInputStream.mark(Integer.MAX_VALUE);
    }

    public void seek(long j) throws IOException {
        int i = ((ExifInterface.ByteOrderedDataInputStream) this).mPosition;
        if (i > j) {
            ((ExifInterface.ByteOrderedDataInputStream) this).mPosition = 0;
            ((ExifInterface.ByteOrderedDataInputStream) this).mDataInputStream.reset();
        } else {
            j -= i;
        }
        skipFully((int) j);
    }

    ExifInterface$SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        if (inputStream.markSupported()) {
            ((ExifInterface.ByteOrderedDataInputStream) this).mDataInputStream.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
