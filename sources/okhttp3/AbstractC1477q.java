package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C1421a;
import okio.Buffer;
import okio.BufferedSource;
import tb.mo2;

/* compiled from: Taobao */
/* renamed from: okhttp3.q */
/* loaded from: classes2.dex */
public abstract class AbstractC1477q implements Closeable {

    /* compiled from: Taobao */
    /* renamed from: okhttp3.q$a */
    /* loaded from: classes.dex */
    class a extends AbstractC1477q {

        /* renamed from: a */
        final /* synthetic */ mo2 f952a;

        /* renamed from: b */
        final /* synthetic */ long f953b;

        /* renamed from: c */
        final /* synthetic */ BufferedSource f954c;

        a(mo2 mo2Var, long j, BufferedSource bufferedSource) {
            this.f952a = mo2Var;
            this.f953b = j;
            this.f954c = bufferedSource;
        }

        @Override // okhttp3.AbstractC1477q
        /* renamed from: g */
        public long mo910g() {
            return this.f953b;
        }

        @Override // okhttp3.AbstractC1477q
        @Nullable
        /* renamed from: j */
        public mo2 mo911j() {
            return this.f952a;
        }

        @Override // okhttp3.AbstractC1477q
        /* renamed from: m */
        public BufferedSource mo912m() {
            return this.f954c;
        }
    }

    /* renamed from: a */
    private static /* synthetic */ void m904a(Throwable th, AutoCloseable autoCloseable) {
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

    /* renamed from: f */
    private Charset m905f() {
        mo2 mo911j = mo911j();
        return mo911j != null ? mo911j.b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    /* renamed from: k */
    public static AbstractC1477q m906k(@Nullable mo2 mo2Var, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new a(mo2Var, j, bufferedSource);
    }

    /* renamed from: l */
    public static AbstractC1477q m907l(@Nullable mo2 mo2Var, byte[] bArr) {
        return m906k(mo2Var, bArr.length, new Buffer().write(bArr));
    }

    /* renamed from: c */
    public final InputStream m908c() {
        return mo912m().inputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C1421a.m470g(mo912m());
    }

    /* renamed from: e */
    public final byte[] m909e() throws IOException {
        long mo910g = mo910g();
        if (mo910g > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + mo910g);
        }
        BufferedSource mo912m = mo912m();
        try {
            byte[] readByteArray = mo912m.readByteArray();
            m904a(null, mo912m);
            if (mo910g == -1 || mo910g == readByteArray.length) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + mo910g + ") and stream length (" + readByteArray.length + ") disagree");
        } finally {
        }
    }

    /* renamed from: g */
    public abstract long mo910g();

    @Nullable
    /* renamed from: j */
    public abstract mo2 mo911j();

    /* renamed from: m */
    public abstract BufferedSource mo912m();

    /* renamed from: n */
    public final String m913n() throws IOException {
        BufferedSource mo912m = mo912m();
        try {
            String readString = mo912m.readString(C1421a.m466c(mo912m, m905f()));
            m904a(null, mo912m);
            return readString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (mo912m != null) {
                    m904a(th, mo912m);
                }
                throw th2;
            }
        }
    }
}
