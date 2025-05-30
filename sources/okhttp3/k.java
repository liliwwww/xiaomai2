package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class k {
    private final String[] a;

    k(a aVar) {
        List list = aVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(okhttp3.internal.a.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
            }
        }
    }

    static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(okhttp3.internal.a.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    @Nullable
    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static k g(String... strArr) {
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
            a(str);
            b(str2, str);
        }
        return new k(strArr2);
    }

    @Nullable
    public String c(String str) {
        return d(this.a, str);
    }

    public String e(int i) {
        return this.a[i * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof k) && Arrays.equals(((k) obj).a, this.a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public int h() {
        return this.a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String i(int i) {
        return this.a[(i * 2) + 1];
    }

    public List<String> j(String str) {
        int h = h();
        ArrayList arrayList = null;
        for (int i = 0; i < h; i++) {
            if (str.equalsIgnoreCase(e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(i(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h = h();
        for (int i = 0; i < h; i++) {
            sb.append(e(i));
            sb.append(": ");
            sb.append(i(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private k(String[] strArr) {
        this.a = strArr;
    }
}
