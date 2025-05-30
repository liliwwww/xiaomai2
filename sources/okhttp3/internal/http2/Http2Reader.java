package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C1421a;
import okhttp3.internal.http2.C1454b;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class Http2Reader implements Closeable {

    /* renamed from: e */
    static final Logger f723e = Logger.getLogger(C1455c.class.getName());

    /* renamed from: a */
    private final BufferedSource f724a;

    /* renamed from: b */
    private final C1451a f725b;

    /* renamed from: c */
    private final boolean f726c;

    /* renamed from: d */
    final C1454b.a f727d;

    /* compiled from: Taobao */
    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<C1453a> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<C1453a> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, C1460h c1460h);

        void windowUpdate(int i, long j);
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.Http2Reader$a */
    /* loaded from: classes2.dex */
    static final class C1451a implements Source {

        /* renamed from: a */
        private final BufferedSource f728a;

        /* renamed from: b */
        int f729b;

        /* renamed from: c */
        byte f730c;

        /* renamed from: d */
        int f731d;

        /* renamed from: e */
        int f732e;

        /* renamed from: f */
        short f733f;

        C1451a(BufferedSource bufferedSource) {
            this.f728a = bufferedSource;
        }

        /* renamed from: a */
        private void m657a() throws IOException {
            int i = this.f731d;
            int m647h = Http2Reader.m647h(this.f728a);
            this.f732e = m647h;
            this.f729b = m647h;
            byte readByte = (byte) (this.f728a.readByte() & 255);
            this.f730c = (byte) (this.f728a.readByte() & 255);
            Logger logger = Http2Reader.f723e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C1455c.m686b(true, this.f731d, this.f729b, readByte, this.f730c));
            }
            int readInt = this.f728a.readInt() & Integer.MAX_VALUE;
            this.f731d = readInt;
            if (readByte != 9) {
                throw C1455c.m688d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw C1455c.m688d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() throws IOException {
        }

        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.f732e;
                if (i != 0) {
                    long read = this.f728a.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f732e = (int) (this.f732e - read);
                    return read;
                }
                this.f728a.skip(this.f733f);
                this.f733f = (short) 0;
                if ((this.f730c & 4) != 0) {
                    return -1L;
                }
                m657a();
            }
        }

        public o timeout() {
            return this.f728a.timeout();
        }
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f724a = bufferedSource;
        this.f726c = z;
        C1451a c1451a = new C1451a(bufferedSource);
        this.f725b = c1451a;
        this.f727d = new C1454b.a(4096, c1451a);
    }

    /* renamed from: a */
    static int m642a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw C1455c.m688d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    /* renamed from: d */
    private void m643d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw C1455c.m688d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw C1455c.m688d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short readByte = (b & 8) != 0 ? (short) (this.f724a.readByte() & 255) : (short) 0;
        handler.data(z, i2, this.f724a, m642a(i, b, readByte));
        this.f724a.skip(readByte);
    }

    /* renamed from: e */
    private void m644e(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw C1455c.m688d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw C1455c.m688d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.f724a.readInt();
        int readInt2 = this.f724a.readInt();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw C1455c.m688d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.f724a.readByteString(i3);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    /* renamed from: f */
    private List<C1453a> m645f(int i, short s, byte b, int i2) throws IOException {
        C1451a c1451a = this.f725b;
        c1451a.f732e = i;
        c1451a.f729b = i;
        c1451a.f733f = s;
        c1451a.f730c = b;
        c1451a.f731d = i2;
        this.f727d.m675k();
        return this.f727d.m673e();
    }

    /* renamed from: g */
    private void m646g(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw C1455c.m688d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short readByte = (b & 8) != 0 ? (short) (this.f724a.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            m649j(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, m645f(m642a(i, b, readByte), readByte, b, i2));
    }

    /* renamed from: h */
    static int m647h(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: i */
    private void m648i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw C1455c.m688d("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw C1455c.m688d("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b & 1) != 0, this.f724a.readInt(), this.f724a.readInt());
    }

    /* renamed from: j */
    private void m649j(Handler handler, int i) throws IOException {
        int readInt = this.f724a.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.f724a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: k */
    private void m650k(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw C1455c.m688d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw C1455c.m688d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m649j(handler, i2);
    }

    /* renamed from: l */
    private void m651l(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw C1455c.m688d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short readByte = (b & 8) != 0 ? (short) (this.f724a.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.f724a.readInt() & Integer.MAX_VALUE, m645f(m642a(i - 4, b, readByte), readByte, b, i2));
    }

    /* renamed from: m */
    private void m652m(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw C1455c.m688d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw C1455c.m688d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.f724a.readInt();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw C1455c.m688d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        handler.rstStream(i2, fromHttp2);
    }

    /* renamed from: n */
    private void m653n(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw C1455c.m688d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw C1455c.m688d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i % 6 != 0) {
            throw C1455c.m688d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        C1460h c1460h = new C1460h();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.f724a.readShort() & 65535;
            int readInt = this.f724a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    readShort = 7;
                    if (readInt < 0) {
                        throw C1455c.m688d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw C1455c.m688d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw C1455c.m688d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            c1460h.m740i(readShort, readInt);
        }
        handler.settings(false, c1460h);
    }

    /* renamed from: o */
    private void m654o(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw C1455c.m688d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.f724a.readInt() & 2147483647L;
        if (readInt == 0) {
            throw C1455c.m688d("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        handler.windowUpdate(i2, readInt);
    }

    /* renamed from: b */
    public boolean m655b(boolean z, Handler handler) throws IOException {
        try {
            this.f724a.require(9L);
            int m647h = m647h(this.f724a);
            if (m647h < 0 || m647h > 16384) {
                throw C1455c.m688d("FRAME_SIZE_ERROR: %s", Integer.valueOf(m647h));
            }
            byte readByte = (byte) (this.f724a.readByte() & 255);
            if (z && readByte != 4) {
                throw C1455c.m688d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            }
            byte readByte2 = (byte) (this.f724a.readByte() & 255);
            int readInt = this.f724a.readInt() & Integer.MAX_VALUE;
            Logger logger = f723e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C1455c.m686b(true, readInt, m647h, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    m643d(handler, m647h, readByte2, readInt);
                    return true;
                case 1:
                    m646g(handler, m647h, readByte2, readInt);
                    return true;
                case 2:
                    m650k(handler, m647h, readByte2, readInt);
                    return true;
                case 3:
                    m652m(handler, m647h, readByte2, readInt);
                    return true;
                case 4:
                    m653n(handler, m647h, readByte2, readInt);
                    return true;
                case 5:
                    m651l(handler, m647h, readByte2, readInt);
                    return true;
                case 6:
                    m648i(handler, m647h, readByte2, readInt);
                    return true;
                case 7:
                    m644e(handler, m647h, readByte2, readInt);
                    return true;
                case 8:
                    m654o(handler, m647h, readByte2, readInt);
                    return true;
                default:
                    this.f724a.skip(m647h);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public void m656c(Handler handler) throws IOException {
        if (this.f726c) {
            if (!m655b(true, handler)) {
                throw C1455c.m688d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        BufferedSource bufferedSource = this.f724a;
        ByteString byteString = C1455c.f756a;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger = f723e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C1421a.m480q("<< CONNECTION %s", readByteString.hex()));
        }
        if (!byteString.equals(readByteString)) {
            throw C1455c.m688d("Expected a connection header but was %s", readByteString.utf8());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f724a.close();
    }
}
