package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C1421a;
import okio.BufferedSink;
import tb.mo2;

/* compiled from: Taobao */
/* renamed from: okhttp3.o */
/* loaded from: classes2.dex */
public abstract class AbstractC1475o {

    /* compiled from: Taobao */
    /* renamed from: okhttp3.o$a */
    /* loaded from: classes.dex */
    class a extends AbstractC1475o {

        /* renamed from: a */
        final /* synthetic */ mo2 f921a;

        /* renamed from: b */
        final /* synthetic */ int f922b;

        /* renamed from: c */
        final /* synthetic */ byte[] f923c;

        /* renamed from: d */
        final /* synthetic */ int f924d;

        a(mo2 mo2Var, int i, byte[] bArr, int i2) {
            this.f921a = mo2Var;
            this.f922b = i;
            this.f923c = bArr;
            this.f924d = i2;
        }

        @Override // okhttp3.AbstractC1475o
        /* renamed from: a */
        public long mo446a() {
            return this.f922b;
        }

        @Override // okhttp3.AbstractC1475o
        @Nullable
        /* renamed from: b */
        public mo2 mo447b() {
            return this.f921a;
        }

        @Override // okhttp3.AbstractC1475o
        /* renamed from: h */
        public void mo448h(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.f923c, this.f924d, this.f922b);
        }
    }

    /* renamed from: c */
    public static AbstractC1475o m868c(@Nullable mo2 mo2Var, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (mo2Var != null && (charset = mo2Var.a()) == null) {
            charset = StandardCharsets.UTF_8;
            mo2Var = mo2.d(mo2Var + "; charset=utf-8");
        }
        return m869d(mo2Var, str.getBytes(charset));
    }

    /* renamed from: d */
    public static AbstractC1475o m869d(@Nullable mo2 mo2Var, byte[] bArr) {
        return m870e(mo2Var, bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public static AbstractC1475o m870e(@Nullable mo2 mo2Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        C1421a.m469f(bArr.length, i, i2);
        return new a(mo2Var, i2, bArr, i);
    }

    /* renamed from: a */
    public abstract long mo446a() throws IOException;

    @Nullable
    /* renamed from: b */
    public abstract mo2 mo447b();

    /* renamed from: f */
    public boolean m871f() {
        return false;
    }

    /* renamed from: g */
    public boolean m872g() {
        return false;
    }

    /* renamed from: h */
    public abstract void mo448h(BufferedSink bufferedSink) throws IOException;
}
