package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.k;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class m extends o {
    private final ByteString a;
    private final mo2 b;
    private final List<b> c;
    private long d = -1;
    public static final mo2 MIXED = mo2.c("multipart/mixed");
    public static final mo2 ALTERNATIVE = mo2.c("multipart/alternative");
    public static final mo2 DIGEST = mo2.c("multipart/digest");
    public static final mo2 PARALLEL = mo2.c("multipart/parallel");
    public static final mo2 FORM = mo2.c("multipart/form-data");
    private static final byte[] e = {58, 32};
    private static final byte[] f = {13, 10};
    private static final byte[] g = {45, 45};

    /* compiled from: Taobao */
    public static final class a {
        private final ByteString a;
        private mo2 b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(String str, String str2) {
            return c(b.b(str, str2));
        }

        public a b(String str, @Nullable String str2, o oVar) {
            return c(b.c(str, str2, oVar));
        }

        public a c(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.c.add(bVar);
            return this;
        }

        public m d() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new m(this.a, this.b, this.c);
        }

        public a(String str) {
            this.b = m.MIXED;
            this.c = new ArrayList();
            this.a = ByteString.encodeUtf8(str);
        }
    }

    /* compiled from: Taobao */
    public static final class b {

        @Nullable
        final k a;
        final o b;

        private b(@Nullable k kVar, o oVar) {
            this.a = kVar;
            this.b = oVar;
        }

        public static b a(@Nullable k kVar, o oVar) {
            Objects.requireNonNull(oVar, "body == null");
            if (kVar != null && kVar.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (kVar == null || kVar.c("Content-Length") == null) {
                return new b(kVar, oVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static b b(String str, String str2) {
            return c(str, null, o.c(null, str2));
        }

        public static b c(String str, @Nullable String str2, o oVar) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            m.i(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                m.i(sb, str2);
            }
            return a(new k.a().d("Content-Disposition", sb.toString()).e(), oVar);
        }
    }

    m(ByteString byteString, mo2 mo2Var, List<b> list) {
        this.a = byteString;
        this.b = mo2.c(mo2Var + "; boundary=" + byteString.utf8());
        this.c = okhttp3.internal.a.t(list);
    }

    static void i(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
    }

    private long j(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        BufferedSink bufferedSink2;
        if (z) {
            bufferedSink = new Buffer();
            bufferedSink2 = bufferedSink;
        } else {
            bufferedSink2 = null;
        }
        int size = this.c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.c.get(i);
            k kVar = bVar.a;
            o oVar = bVar.b;
            bufferedSink.write(g);
            bufferedSink.write(this.a);
            bufferedSink.write(f);
            if (kVar != null) {
                int h = kVar.h();
                for (int i2 = 0; i2 < h; i2++) {
                    bufferedSink.writeUtf8(kVar.e(i2)).write(e).writeUtf8(kVar.i(i2)).write(f);
                }
            }
            mo2 b2 = oVar.b();
            if (b2 != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(b2.toString()).write(f);
            }
            long a2 = oVar.a();
            if (a2 != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(a2).write(f);
            } else if (z) {
                bufferedSink2.clear();
                return -1L;
            }
            byte[] bArr = f;
            bufferedSink.write(bArr);
            if (z) {
                j += a2;
            } else {
                oVar.h(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = g;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.a);
        bufferedSink.write(bArr2);
        bufferedSink.write(f);
        if (!z) {
            return j;
        }
        long size2 = j + bufferedSink2.size();
        bufferedSink2.clear();
        return size2;
    }

    @Override // okhttp3.o
    public long a() throws IOException {
        long j = this.d;
        if (j != -1) {
            return j;
        }
        long j2 = j(null, true);
        this.d = j2;
        return j2;
    }

    @Override // okhttp3.o
    public mo2 b() {
        return this.b;
    }

    @Override // okhttp3.o
    public void h(BufferedSink bufferedSink) throws IOException {
        j(bufferedSink, false);
    }
}
