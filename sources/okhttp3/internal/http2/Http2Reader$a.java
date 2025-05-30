package okhttp3.internal.http2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Http2Reader$a implements Source {
    private final BufferedSource a;
    int b;
    byte c;
    int d;
    int e;
    short f;

    Http2Reader$a(BufferedSource bufferedSource) {
        this.a = bufferedSource;
    }

    private void a() throws IOException {
        int i = this.d;
        int h = Http2Reader.h(this.a);
        this.e = h;
        this.b = h;
        byte readByte = (byte) (this.a.readByte() & 255);
        this.c = (byte) (this.a.readByte() & 255);
        Logger logger = Http2Reader.e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.b(true, this.d, this.b, readByte, this.c));
        }
        int readInt = this.a.readInt() & Integer.MAX_VALUE;
        this.d = readInt;
        if (readByte != 9) {
            throw c.d("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(readByte)});
        }
        if (readInt != i) {
            throw c.d("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
    }

    public void close() throws IOException {
    }

    public long read(Buffer buffer, long j) throws IOException {
        while (true) {
            int i = this.e;
            if (i != 0) {
                long read = this.a.read(buffer, Math.min(j, i));
                if (read == -1) {
                    return -1L;
                }
                this.e = (int) (this.e - read);
                return read;
            }
            this.a.skip(this.f);
            this.f = (short) 0;
            if ((this.c & 4) != 0) {
                return -1L;
            }
            a();
        }
    }

    public o timeout() {
        return this.a.timeout();
    }
}
