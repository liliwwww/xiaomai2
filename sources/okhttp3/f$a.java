package okhttp3;

import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class f$a {
    boolean a;

    @Nullable
    String[] b;

    @Nullable
    String[] c;
    boolean d;

    f$a(boolean z) {
        this.a = z;
    }

    public f a() {
        return new f(this);
    }

    public f$a b(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.b = (String[]) strArr.clone();
        return this;
    }

    public f$a c(d... dVarArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[dVarArr.length];
        for (int i = 0; i < dVarArr.length; i++) {
            strArr[i] = dVarArr[i].a;
        }
        return b(strArr);
    }

    public f$a d(boolean z) {
        if (!this.a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        this.d = z;
        return this;
    }

    public f$a e(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.c = (String[]) strArr.clone();
        return this;
    }

    public f$a f(TlsVersion... tlsVersionArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[tlsVersionArr.length];
        for (int i = 0; i < tlsVersionArr.length; i++) {
            strArr[i] = tlsVersionArr[i].javaName;
        }
        return e(strArr);
    }

    public f$a(f fVar) {
        this.a = fVar.a;
        this.b = fVar.c;
        this.c = fVar.d;
        this.d = fVar.b;
    }
}
