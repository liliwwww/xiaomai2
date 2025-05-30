package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class l {
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    private final String b;
    private final String c;
    final String d;
    final int e;
    private final List<String> f;

    @Nullable
    private final List<String> g;

    @Nullable
    private final String h;
    private final String i;

    /* compiled from: Taobao */
    public static final class a {

        @Nullable
        String a;

        @Nullable
        String d;
        final List<String> f;

        @Nullable
        List<String> g;

        @Nullable
        String h;
        String b = "";
        String c = "";
        int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        @Nullable
        private static String b(String str, int i, int i2) {
            return okhttp3.internal.a.d(l.s(str, i, i2, false));
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int i(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(l.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void k() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        private static int m(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private void n(String str, int i, int i2, boolean z, boolean z2) {
            String a = l.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a)) {
                return;
            }
            if (g(a)) {
                k();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }

        private void p(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.internal.a.o(str, i3, i2, "/\\");
                boolean z = i < i2;
                n(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private static int r(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int s(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public l a() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d != null) {
                return new l(this);
            }
            throw new IllegalStateException("host == null");
        }

        int c() {
            int i = this.e;
            return i != -1 ? i : l.e(this.a);
        }

        public a d(@Nullable String str) {
            this.g = str != null ? l.z(l.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            Objects.requireNonNull(str, "host == null");
            String b = b(str, 0, str.length());
            if (b != null) {
                this.d = b;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        a h(@Nullable l lVar, String str) {
            int o;
            int i;
            int G = okhttp3.internal.a.G(str, 0, str.length());
            int H = okhttp3.internal.a.H(str, G, str.length());
            int r = r(str, G, H);
            if (r != -1) {
                if (str.regionMatches(true, G, "https:", 0, 6)) {
                    this.a = "https";
                    G += 6;
                } else {
                    if (!str.regionMatches(true, G, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, r) + "'");
                    }
                    this.a = "http";
                    G += 5;
                }
            } else {
                if (lVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.a = lVar.a;
            }
            int s = s(str, G, H);
            char c = '?';
            char c2 = '#';
            if (s >= 2 || lVar == null || !lVar.a.equals(this.a)) {
                int i2 = G + s;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    o = okhttp3.internal.a.o(str, i2, H, "@/\\?#");
                    char charAt = o != H ? str.charAt(o) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = o;
                            this.c += "%40" + l.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int n = okhttp3.internal.a.n(str, i2, o, ':');
                            i = o;
                            String a = l.a(str, i2, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a = this.b + "%40" + a;
                            }
                            this.b = a;
                            if (n != i) {
                                this.c = l.a(str, n + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int m = m(str, i2, o);
                int i3 = m + 1;
                if (i3 < o) {
                    this.d = b(str, i2, m);
                    int i4 = i(str, i3, o);
                    this.e = i4;
                    if (i4 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, o) + '\"');
                    }
                } else {
                    this.d = b(str, i2, m);
                    this.e = l.e(this.a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, m) + '\"');
                }
                G = o;
            } else {
                this.b = lVar.k();
                this.c = lVar.g();
                this.d = lVar.d;
                this.e = lVar.e;
                this.f.clear();
                this.f.addAll(lVar.i());
                if (G == H || str.charAt(G) == '#') {
                    d(lVar.j());
                }
            }
            int o2 = okhttp3.internal.a.o(str, G, H, "?#");
            p(str, G, o2);
            if (o2 < H && str.charAt(o2) == '?') {
                int n2 = okhttp3.internal.a.n(str, o2, H, '#');
                this.g = l.z(l.a(str, o2 + 1, n2, " \"'<>#", true, false, true, true, null));
                o2 = n2;
            }
            if (o2 < H && str.charAt(o2) == '#') {
                this.h = l.a(str, 1 + o2, H, "", true, false, false, false, null);
            }
            return this;
        }

        public a j(String str) {
            Objects.requireNonNull(str, "password == null");
            this.c = l.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a l(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        a o() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, l.b(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, l.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = l.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a q(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        public a t(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = l.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int c = c();
                String str3 = this.a;
                if (str3 == null || c != l.e(str3)) {
                    sb.append(':');
                    sb.append(c);
                }
            }
            l.r(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                l.o(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    l(a aVar) {
        this.a = aVar.a;
        this.b = t(aVar.b, false);
        this.c = t(aVar.c, false);
        this.d = aVar.d;
        this.e = aVar.c();
        this.f = u(aVar.f, false);
        List<String> list = aVar.g;
        this.g = list != null ? u(list, true) : null;
        String str = aVar.h;
        this.h = str != null ? t(str, false) : null;
        this.i = aVar.toString();
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || w(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i, i3);
            d(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        return str.substring(i, i2);
    }

    static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    static String c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static void d(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !w(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = j;
                        buffer.writeByte(cArr[(readByte >> 4) & 15]);
                        buffer.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static l l(String str) {
        return new a().h(null, str).a();
    }

    static void o(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static void r(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static String s(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                v(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static String t(String str, boolean z) {
        return s(str, 0, str.length(), z);
    }

    private List<String> u(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? t(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void v(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int k = okhttp3.internal.a.k(str.charAt(i + 1));
                int k2 = okhttp3.internal.a.k(str.charAt(i3));
                if (k != -1 && k2 != -1) {
                    buffer.writeByte((k << 4) + k2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean w(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.a.k(str.charAt(i + 1)) != -1 && okhttp3.internal.a.k(str.charAt(i3)) != -1;
    }

    static List<String> z(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String A() {
        return q("/...").t("").j("").a().toString();
    }

    @Nullable
    public l B(String str) {
        a q = q(str);
        if (q != null) {
            return q.a();
        }
        return null;
    }

    public String C() {
        return this.a;
    }

    public URI D() {
        String aVar = p().o().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof l) && ((l) obj).i.equals(this.i);
    }

    @Nullable
    public String f() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    public String g() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, this.i.indexOf(64));
    }

    public String h() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.a.o(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public List<String> i() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        int o = okhttp3.internal.a.o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < o) {
            int i = indexOf + 1;
            int n = okhttp3.internal.a.n(this.i, i, o, '/');
            arrayList.add(this.i.substring(i, n));
            indexOf = n;
        }
        return arrayList;
    }

    @Nullable
    public String j() {
        if (this.g == null) {
            return null;
        }
        int indexOf = this.i.indexOf(63) + 1;
        String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.a.n(str, indexOf, str.length(), '#'));
    }

    public String k() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return this.i.substring(length, okhttp3.internal.a.o(str, length, str.length(), ":@"));
    }

    public String m() {
        return this.d;
    }

    public boolean n() {
        return this.a.equals("https");
    }

    public a p() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = k();
        aVar.c = g();
        aVar.d = this.d;
        aVar.e = this.e != e(this.a) ? this.e : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.d(j());
        aVar.h = f();
        return aVar;
    }

    @Nullable
    public a q(String str) {
        try {
            return new a().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.i;
    }

    public int x() {
        return this.e;
    }

    @Nullable
    public String y() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        o(sb, this.g);
        return sb.toString();
    }
}
