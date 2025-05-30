package okhttp3.internal.p011ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.o;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.ws.b */
/* loaded from: classes2.dex */
final class C1469b {

    /* renamed from: a */
    final boolean f859a;

    /* renamed from: b */
    final Random f860b;

    /* renamed from: c */
    final BufferedSink f861c;

    /* renamed from: d */
    final Buffer f862d;

    /* renamed from: e */
    boolean f863e;

    /* renamed from: f */
    final Buffer f864f = new Buffer();

    /* renamed from: g */
    final a f865g = new a();

    /* renamed from: h */
    boolean f866h;

    /* renamed from: i */
    private final byte[] f867i;

    /* renamed from: j */
    private final Buffer.c f868j;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.b$a */
    final class a implements Sink {

        /* renamed from: a */
        int f869a;

        /* renamed from: b */
        long f870b;

        /* renamed from: c */
        boolean f871c;

        /* renamed from: d */
        boolean f872d;

        a() {
        }

        public void close() throws IOException {
            if (this.f872d) {
                throw new IOException("closed");
            }
            C1469b c1469b = C1469b.this;
            c1469b.m768d(this.f869a, c1469b.f864f.size(), this.f871c, true);
            this.f872d = true;
            C1469b.this.f866h = false;
        }

        public void flush() throws IOException {
            if (this.f872d) {
                throw new IOException("closed");
            }
            C1469b c1469b = C1469b.this;
            c1469b.m768d(this.f869a, c1469b.f864f.size(), this.f871c, false);
            this.f871c = false;
        }

        public o timeout() {
            return C1469b.this.f861c.timeout();
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.f872d) {
                throw new IOException("closed");
            }
            C1469b.this.f864f.write(buffer, j);
            boolean z = this.f871c && this.f870b != -1 && C1469b.this.f864f.size() > this.f870b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long completeSegmentByteCount = C1469b.this.f864f.completeSegmentByteCount();
            if (completeSegmentByteCount <= 0 || z) {
                return;
            }
            C1469b.this.m768d(this.f869a, completeSegmentByteCount, this.f871c, false);
            this.f871c = false;
        }
    }

    C1469b(boolean z, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.f859a = z;
        this.f861c = bufferedSink;
        this.f862d = bufferedSink.buffer();
        this.f860b = random;
        this.f867i = z ? new byte[4] : null;
        this.f868j = z ? new Buffer.c() : null;
    }

    /* renamed from: c */
    private void m765c(int i, ByteString byteString) throws IOException {
        if (this.f863e) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f862d.writeByte(i | 128);
        if (this.f859a) {
            this.f862d.writeByte(size | 128);
            this.f860b.nextBytes(this.f867i);
            this.f862d.write(this.f867i);
            if (size > 0) {
                long size2 = this.f862d.size();
                this.f862d.write(byteString);
                this.f862d.readAndWriteUnsafe(this.f868j);
                this.f868j.b(size2);
                C1468a.m763b(this.f868j, this.f867i);
                this.f868j.close();
            }
        } else {
            this.f862d.writeByte(size);
            this.f862d.write(byteString);
        }
        this.f861c.flush();
    }

    /* renamed from: a */
    Sink m766a(int i, long j) {
        if (this.f866h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f866h = true;
        a aVar = this.f865g;
        aVar.f869a = i;
        aVar.f870b = j;
        aVar.f871c = true;
        aVar.f872d = false;
        return aVar;
    }

    /* renamed from: b */
    void m767b(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                C1468a.m764c(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            m765c(8, byteString2);
        } finally {
            this.f863e = true;
        }
    }

    /* renamed from: d */
    void m768d(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.f863e) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.f862d.writeByte(i);
        int i2 = this.f859a ? 128 : 0;
        if (j <= 125) {
            this.f862d.writeByte(((int) j) | i2);
        } else if (j <= 65535) {
            this.f862d.writeByte(i2 | 126);
            this.f862d.writeShort((int) j);
        } else {
            this.f862d.writeByte(i2 | 127);
            this.f862d.writeLong(j);
        }
        if (this.f859a) {
            this.f860b.nextBytes(this.f867i);
            this.f862d.write(this.f867i);
            if (j > 0) {
                long size = this.f862d.size();
                this.f862d.write(this.f864f, j);
                this.f862d.readAndWriteUnsafe(this.f868j);
                this.f868j.b(size);
                C1468a.m763b(this.f868j, this.f867i);
                this.f868j.close();
            }
        } else {
            this.f862d.write(this.f864f, j);
        }
        this.f861c.emit();
    }

    /* renamed from: e */
    void m769e(ByteString byteString) throws IOException {
        m765c(9, byteString);
    }

    /* renamed from: f */
    void m770f(ByteString byteString) throws IOException {
        m765c(10, byteString);
    }
}
