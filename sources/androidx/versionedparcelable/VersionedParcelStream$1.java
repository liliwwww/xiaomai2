package androidx.versionedparcelable;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class VersionedParcelStream$1 extends FilterInputStream {
    final /* synthetic */ VersionedParcelStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VersionedParcelStream$1(VersionedParcelStream versionedParcelStream, InputStream inputStream) {
        super(inputStream);
        this.this$0 = versionedParcelStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i = versionedParcelStream.mFieldSize;
        if (i != -1 && versionedParcelStream.mCount >= i) {
            throw new IOException();
        }
        int read = super.read();
        this.this$0.mCount++;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i = versionedParcelStream.mFieldSize;
        if (i != -1 && versionedParcelStream.mCount >= i) {
            throw new IOException();
        }
        long skip = super.skip(j);
        if (skip > 0) {
            this.this$0.mCount += (int) skip;
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i3 = versionedParcelStream.mFieldSize;
        if (i3 != -1 && versionedParcelStream.mCount >= i3) {
            throw new IOException();
        }
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.this$0.mCount += read;
        }
        return read;
    }
}
