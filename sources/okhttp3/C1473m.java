package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.internal.C1421a;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import tb.mo2;

/* compiled from: Taobao */
/* renamed from: okhttp3.m */
/* loaded from: classes2.dex */
public final class C1473m extends AbstractC1475o {

    /* renamed from: a */
    private final ByteString f901a;

    /* renamed from: b */
    private final mo2 f902b;

    /* renamed from: c */
    private final List<b> f903c;

    /* renamed from: d */
    private long f904d = -1;
    public static final mo2 MIXED = mo2.c("multipart/mixed");
    public static final mo2 ALTERNATIVE = mo2.c("multipart/alternative");
    public static final mo2 DIGEST = mo2.c("multipart/digest");
    public static final mo2 PARALLEL = mo2.c("multipart/parallel");
    public static final mo2 FORM = mo2.c("multipart/form-data");

    /* renamed from: e */
    private static final byte[] f898e = {58, 32};

    /* renamed from: f */
    private static final byte[] f899f = {13, 10};

    /* renamed from: g */
    private static final byte[] f900g = {45, 45};

    /* compiled from: Taobao */
    /* renamed from: okhttp3.m$a */
    public static final class a {

        /* renamed from: a */
        private final ByteString f905a;

        /* renamed from: b */
        private mo2 f906b;

        /* renamed from: c */
        private final List<b> f907c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        /* renamed from: a */
        public a m844a(String str, String str2) {
            return m846c(b.m849b(str, str2));
        }

        /* renamed from: b */
        public a m845b(String str, @Nullable String str2, AbstractC1475o abstractC1475o) {
            return m846c(b.m850c(str, str2, abstractC1475o));
        }

        /* renamed from: c */
        public a m846c(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.f907c.add(bVar);
            return this;
        }

        /* renamed from: d */
        public C1473m m847d() {
            if (this.f907c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new C1473m(this.f905a, this.f906b, this.f907c);
        }

        public a(String str) {
            this.f906b = C1473m.MIXED;
            this.f907c = new ArrayList();
            this.f905a = ByteString.encodeUtf8(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.m$b */
    public static final class b {

        /* renamed from: a */
        @Nullable
        final C1471k f908a;

        /* renamed from: b */
        final AbstractC1475o f909b;

        private b(@Nullable C1471k c1471k, AbstractC1475o abstractC1475o) {
            this.f908a = c1471k;
            this.f909b = abstractC1475o;
        }

        /* renamed from: a */
        public static b m848a(@Nullable C1471k c1471k, AbstractC1475o abstractC1475o) {
            Objects.requireNonNull(abstractC1475o, "body == null");
            if (c1471k != null && c1471k.m779c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (c1471k == null || c1471k.m779c("Content-Length") == null) {
                return new b(c1471k, abstractC1475o);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        /* renamed from: b */
        public static b m849b(String str, String str2) {
            return m850c(str, null, AbstractC1475o.m868c(null, str2));
        }

        /* renamed from: c */
        public static b m850c(String str, @Nullable String str2, AbstractC1475o abstractC1475o) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            C1473m.m842i(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                C1473m.m842i(sb, str2);
            }
            return m848a(new C1471k.a().m788d("Content-Disposition", sb.toString()).m789e(), abstractC1475o);
        }
    }

    C1473m(ByteString byteString, mo2 mo2Var, List<b> list) {
        this.f901a = byteString;
        this.f902b = mo2.c(mo2Var + "; boundary=" + byteString.utf8());
        this.f903c = C1421a.m483t(list);
    }

    /* renamed from: i */
    static void m842i(StringBuilder sb, String str) {
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

    /* renamed from: j */
    private long m843j(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        BufferedSink bufferedSink2;
        if (z) {
            bufferedSink = new Buffer();
            bufferedSink2 = bufferedSink;
        } else {
            bufferedSink2 = null;
        }
        int size = this.f903c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.f903c.get(i);
            C1471k c1471k = bVar.f908a;
            AbstractC1475o abstractC1475o = bVar.f909b;
            bufferedSink.write(f900g);
            bufferedSink.write(this.f901a);
            bufferedSink.write(f899f);
            if (c1471k != null) {
                int m782h = c1471k.m782h();
                for (int i2 = 0; i2 < m782h; i2++) {
                    bufferedSink.writeUtf8(c1471k.m780e(i2)).write(f898e).writeUtf8(c1471k.m783i(i2)).write(f899f);
                }
            }
            mo2 mo447b = abstractC1475o.mo447b();
            if (mo447b != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(mo447b.toString()).write(f899f);
            }
            long mo446a = abstractC1475o.mo446a();
            if (mo446a != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(mo446a).write(f899f);
            } else if (z) {
                bufferedSink2.clear();
                return -1L;
            }
            byte[] bArr = f899f;
            bufferedSink.write(bArr);
            if (z) {
                j += mo446a;
            } else {
                abstractC1475o.mo448h(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = f900g;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.f901a);
        bufferedSink.write(bArr2);
        bufferedSink.write(f899f);
        if (!z) {
            return j;
        }
        long size2 = j + bufferedSink2.size();
        bufferedSink2.clear();
        return size2;
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: a */
    public long mo446a() throws IOException {
        long j = this.f904d;
        if (j != -1) {
            return j;
        }
        long m843j = m843j(null, true);
        this.f904d = m843j;
        return m843j;
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: b */
    public mo2 mo447b() {
        return this.f902b;
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: h */
    public void mo448h(BufferedSink bufferedSink) throws IOException {
        m843j(bufferedSink, false);
    }
}
