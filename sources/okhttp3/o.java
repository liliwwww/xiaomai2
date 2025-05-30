package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.BufferedSink;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class o {
    public static o c(@Nullable mo2 mo2Var, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (mo2Var != null && (charset = mo2Var.a()) == null) {
            charset = StandardCharsets.UTF_8;
            mo2Var = mo2.d(mo2Var + "; charset=utf-8");
        }
        return d(mo2Var, str.getBytes(charset));
    }

    public static o d(@Nullable mo2 mo2Var, byte[] bArr) {
        return e(mo2Var, bArr, 0, bArr.length);
    }

    public static o e(@Nullable mo2 mo2Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        okhttp3.internal.a.f(bArr.length, i, i2);
        return new a(mo2Var, i2, bArr, i);
    }

    public abstract long a() throws IOException;

    @Nullable
    public abstract mo2 b();

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract void h(BufferedSink bufferedSink) throws IOException;
}
