package androidx.exifinterface.media;

import android.media.MediaDataSource;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ExifInterface$1 extends MediaDataSource {
    long mPosition;
    final /* synthetic */ ExifInterface this$0;
    final /* synthetic */ ExifInterface$SeekableByteOrderedDataInputStream val$in;

    ExifInterface$1(ExifInterface exifInterface, ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) {
        this.this$0 = exifInterface;
        this.val$in = exifInterface$SeekableByteOrderedDataInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.mPosition;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + this.val$in.available()) {
                    return -1;
                }
                this.val$in.seek(j);
                this.mPosition = j;
            }
            if (i2 > this.val$in.available()) {
                i2 = this.val$in.available();
            }
            int read = this.val$in.read(bArr, i, i2);
            if (read >= 0) {
                this.mPosition += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.mPosition = -1L;
        return -1;
    }
}
