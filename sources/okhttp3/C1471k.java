package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.k */
/* loaded from: classes2.dex */
public final class C1471k {

    /* renamed from: a */
    private final String[] f878a;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.k$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        final List<String> f879a = new ArrayList(20);

        /* renamed from: a */
        public a m785a(String str, String str2) {
            C1471k.m775a(str);
            C1471k.m776b(str2, str);
            return m787c(str, str2);
        }

        /* renamed from: b */
        a m786b(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? m787c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? m787c("", str.substring(1)) : m787c("", str);
        }

        /* renamed from: c */
        a m787c(String str, String str2) {
            this.f879a.add(str);
            this.f879a.add(str2.trim());
            return this;
        }

        /* renamed from: d */
        public a m788d(String str, String str2) {
            C1471k.m775a(str);
            return m787c(str, str2);
        }

        /* renamed from: e */
        public C1471k m789e() {
            return new C1471k(this);
        }

        /* renamed from: f */
        public a m790f(String str) {
            int i = 0;
            while (i < this.f879a.size()) {
                if (str.equalsIgnoreCase(this.f879a.get(i))) {
                    this.f879a.remove(i);
                    this.f879a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: g */
        public a m791g(String str, String str2) {
            C1471k.m775a(str);
            C1471k.m776b(str2, str);
            m790f(str);
            m787c(str, str2);
            return this;
        }
    }

    C1471k(a aVar) {
        List<String> list = aVar.f879a;
        this.f878a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    static void m775a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(C1421a.m480q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
            }
        }
    }

    /* renamed from: b */
    static void m776b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(C1421a.m480q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    @Nullable
    /* renamed from: d */
    private static String m777d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: g */
    public static C1471k m778g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            m775a(str);
            m776b(str2, str);
        }
        return new C1471k(strArr2);
    }

    @Nullable
    /* renamed from: c */
    public String m779c(String str) {
        return m777d(this.f878a, str);
    }

    /* renamed from: e */
    public String m780e(int i) {
        return this.f878a[i * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C1471k) && Arrays.equals(((C1471k) obj).f878a, this.f878a);
    }

    /* renamed from: f */
    public a m781f() {
        a aVar = new a();
        Collections.addAll(aVar.f879a, this.f878a);
        return aVar;
    }

    /* renamed from: h */
    public int m782h() {
        return this.f878a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f878a);
    }

    /* renamed from: i */
    public String m783i(int i) {
        return this.f878a[(i * 2) + 1];
    }

    /* renamed from: j */
    public List<String> m784j(String str) {
        int m782h = m782h();
        ArrayList arrayList = null;
        for (int i = 0; i < m782h; i++) {
            if (str.equalsIgnoreCase(m780e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m783i(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m782h = m782h();
        for (int i = 0; i < m782h; i++) {
            sb.append(m780e(i));
            sb.append(": ");
            sb.append(m783i(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private C1471k(String[] strArr) {
        this.f878a = strArr;
    }
}
