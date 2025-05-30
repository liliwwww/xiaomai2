package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class q implements Closeable {
    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private Charset f() {
        mo2 j = j();
        return j != null ? j.b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static q k(@Nullable mo2 mo2Var, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new a(mo2Var, j, bufferedSource);
    }

    public static q l(@Nullable mo2 mo2Var, byte[] bArr) {
        return k(mo2Var, bArr.length, new Buffer().write(bArr));
    }

    public final InputStream c() {
        return m().inputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.a.g(m());
    }

    public final byte[] e() throws IOException {
        long g = g();
        if (g > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + g);
        }
        BufferedSource m = m();
        try {
            byte[] readByteArray = m.readByteArray();
            a(null, m);
            if (g == -1 || g == readByteArray.length) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + g + ") and stream length (" + readByteArray.length + ") disagree");
        } finally {
        }
    }

    public abstract long g();

    @Nullable
    public abstract mo2 j();

    public abstract BufferedSource m();

    public final String n() throws IOException {
        BufferedSource m = m();
        try {
            String readString = m.readString(okhttp3.internal.a.c(m, f()));
            a(null, m);
            return readString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m != null) {
                    a(th, m);
                }
                throw th2;
            }
        }
    }
}
