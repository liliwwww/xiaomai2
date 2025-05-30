package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C1421a;
import okhttp3.internal.http2.C1454b;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.f */
/* loaded from: classes.dex */
final class C1458f implements Closeable {

    /* renamed from: g */
    private static final Logger f793g = Logger.getLogger(C1455c.class.getName());

    /* renamed from: a */
    private final BufferedSink f794a;

    /* renamed from: b */
    private final boolean f795b;

    /* renamed from: c */
    private final Buffer f796c;

    /* renamed from: d */
    private int f797d;

    /* renamed from: e */
    private boolean f798e;

    /* renamed from: f */
    final C1454b.b f799f;

    C1458f(BufferedSink bufferedSink, boolean z) {
        this.f794a = bufferedSink;
        this.f795b = z;
        Buffer buffer = new Buffer();
        this.f796c = buffer;
        this.f799f = new C1454b.b(buffer);
        this.f797d = 16384;
    }

    /* renamed from: h */
    private void m717h(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f797d, j);
            long j2 = min;
            j -= j2;
            m721c(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f794a.write(this.f796c, j2);
        }
    }

    /* renamed from: i */
    private static void m718i(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: a */
    public synchronized void m719a(C1460h c1460h) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        this.f797d = c1460h.m737f(this.f797d);
        if (c1460h.m734c() != -1) {
            this.f799f.m681e(c1460h.m734c());
        }
        m721c(0, 0, (byte) 4, (byte) 1);
        this.f794a.flush();
    }

    /* renamed from: b */
    void m720b(int i, byte b, Buffer buffer, int i2) throws IOException {
        m721c(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f794a.write(buffer, i2);
        }
    }

    /* renamed from: c */
    public void m721c(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = f793g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C1455c.m686b(false, i, i2, b, b2));
        }
        int i3 = this.f797d;
        if (i2 > i3) {
            throw C1455c.m687c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw C1455c.m687c("reserved bit set: %s", Integer.valueOf(i));
        }
        m718i(this.f794a, i2);
        this.f794a.writeByte(b & 255);
        this.f794a.writeByte(b2 & 255);
        this.f794a.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f798e = true;
        this.f794a.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        if (this.f795b) {
            Logger logger = f793g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C1421a.m480q(">> CONNECTION %s", C1455c.f756a.hex()));
            }
            this.f794a.write(C1455c.f756a.toByteArray());
            this.f794a.flush();
        }
    }

    /* renamed from: d */
    public synchronized void m722d(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw C1455c.m687c("errorCode.httpCode == -1", new Object[0]);
        }
        m721c(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f794a.writeInt(i);
        this.f794a.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.f794a.write(bArr);
        }
        this.f794a.flush();
    }

    public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        m720b(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    /* renamed from: e */
    public synchronized void m723e(boolean z, int i, List<C1453a> list) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        this.f799f.m683g(list);
        long size = this.f796c.size();
        int min = (int) Math.min(this.f797d, size);
        long j = min;
        byte b = size == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m721c(i, min, (byte) 1, b);
        this.f794a.write(this.f796c, j);
        if (size > j) {
            m717h(i, size - j);
        }
    }

    /* renamed from: f */
    public synchronized void m724f(int i, ErrorCode errorCode) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        m721c(i, 4, (byte) 3, (byte) 0);
        this.f794a.writeInt(errorCode.httpCode);
        this.f794a.flush();
    }

    public synchronized void flush() throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        this.f794a.flush();
    }

    /* renamed from: g */
    public synchronized void m725g(C1460h c1460h) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        int i = 0;
        m721c(0, c1460h.m741j() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (c1460h.m738g(i)) {
                this.f794a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f794a.writeInt(c1460h.m733b(i));
            }
            i++;
        }
        this.f794a.flush();
    }

    public int maxDataLength() {
        return this.f797d;
    }

    public synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        m721c(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f794a.writeInt(i);
        this.f794a.writeInt(i2);
        this.f794a.flush();
    }

    public synchronized void pushPromise(int i, int i2, List<C1453a> list) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        this.f799f.m683g(list);
        long size = this.f796c.size();
        int min = (int) Math.min(this.f797d - 4, size);
        long j = min;
        m721c(i, min + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
        this.f794a.writeInt(i2 & Integer.MAX_VALUE);
        this.f794a.write(this.f796c, j);
        if (size > j) {
            m717h(i, size - j);
        }
    }

    public synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.f798e) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw C1455c.m687c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        m721c(i, 4, (byte) 8, (byte) 0);
        this.f794a.writeInt((int) j);
        this.f794a.flush();
    }
}
