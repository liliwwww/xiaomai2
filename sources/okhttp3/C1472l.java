package okhttp3;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C1421a;
import okio.Buffer;

/* compiled from: Taobao */
/* renamed from: okhttp3.l */
/* loaded from: classes2.dex */
public final class C1472l {

    /* renamed from: j */
    private static final char[] f880j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f881a;

    /* renamed from: b */
    private final String f882b;

    /* renamed from: c */
    private final String f883c;

    /* renamed from: d */
    final String f884d;

    /* renamed from: e */
    final int f885e;

    /* renamed from: f */
    private final List<String> f886f;

    /* renamed from: g */
    @Nullable
    private final List<String> f887g;

    /* renamed from: h */
    @Nullable
    private final String f888h;

    /* renamed from: i */
    private final String f889i;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.l$a */
    public static final class a {

        /* renamed from: a */
        @Nullable
        String f890a;

        /* renamed from: d */
        @Nullable
        String f893d;

        /* renamed from: f */
        final List<String> f895f;

        /* renamed from: g */
        @Nullable
        List<String> f896g;

        /* renamed from: h */
        @Nullable
        String f897h;

        /* renamed from: b */
        String f891b = "";

        /* renamed from: c */
        String f892c = "";

        /* renamed from: e */
        int f894e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f895f = arrayList;
            arrayList.add("");
        }

        @Nullable
        /* renamed from: b */
        private static String m822b(String str, int i, int i2) {
            return C1421a.m467d(C1472l.m800s(str, i, i2, false));
        }

        /* renamed from: f */
        private boolean m823f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: g */
        private boolean m824g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: i */
        private static int m825i(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(C1472l.m792a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        /* renamed from: k */
        private void m826k() {
            if (!this.f895f.remove(r0.size() - 1).isEmpty() || this.f895f.isEmpty()) {
                this.f895f.add("");
            } else {
                this.f895f.set(r0.size() - 1, "");
            }
        }

        /* renamed from: m */
        private static int m827m(String str, int i, int i2) {
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

        /* renamed from: n */
        private void m828n(String str, int i, int i2, boolean z, boolean z2) {
            String m792a = C1472l.m792a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (m823f(m792a)) {
                return;
            }
            if (m824g(m792a)) {
                m826k();
                return;
            }
            if (this.f895f.get(r11.size() - 1).isEmpty()) {
                this.f895f.set(r11.size() - 1, m792a);
            } else {
                this.f895f.add(m792a);
            }
            if (z) {
                this.f895f.add("");
            }
        }

        /* renamed from: p */
        private void m829p(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f895f.clear();
                this.f895f.add("");
                i++;
            } else {
                List<String> list = this.f895f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = C1421a.m478o(str, i3, i2, "/\\");
                boolean z = i < i2;
                m828n(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        /* renamed from: r */
        private static int m830r(String str, int i, int i2) {
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

        /* renamed from: s */
        private static int m831s(String str, int i, int i2) {
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

        /* renamed from: a */
        public C1472l m832a() {
            if (this.f890a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f893d != null) {
                return new C1472l(this);
            }
            throw new IllegalStateException("host == null");
        }

        /* renamed from: c */
        int m833c() {
            int i = this.f894e;
            return i != -1 ? i : C1472l.m796e(this.f890a);
        }

        /* renamed from: d */
        public a m834d(@Nullable String str) {
            this.f896g = str != null ? C1472l.m805z(C1472l.m793b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: e */
        public a m835e(String str) {
            Objects.requireNonNull(str, "host == null");
            String m822b = m822b(str, 0, str.length());
            if (m822b != null) {
                this.f893d = m822b;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: h */
        a m836h(@Nullable C1472l c1472l, String str) {
            int m478o;
            int i;
            int m457G = C1421a.m457G(str, 0, str.length());
            int m458H = C1421a.m458H(str, m457G, str.length());
            int m830r = m830r(str, m457G, m458H);
            if (m830r != -1) {
                if (str.regionMatches(true, m457G, "https:", 0, 6)) {
                    this.f890a = "https";
                    m457G += 6;
                } else {
                    if (!str.regionMatches(true, m457G, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, m830r) + "'");
                    }
                    this.f890a = "http";
                    m457G += 5;
                }
            } else {
                if (c1472l == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f890a = c1472l.f881a;
            }
            int m831s = m831s(str, m457G, m458H);
            char c = '?';
            char c2 = '#';
            if (m831s >= 2 || c1472l == null || !c1472l.f881a.equals(this.f890a)) {
                int i2 = m457G + m831s;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    m478o = C1421a.m478o(str, i2, m458H, "@/\\?#");
                    char charAt = m478o != m458H ? str.charAt(m478o) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = m478o;
                            this.f892c += "%40" + C1472l.m792a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int m477n = C1421a.m477n(str, i2, m478o, ':');
                            i = m478o;
                            String m792a = C1472l.m792a(str, i2, m477n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                m792a = this.f891b + "%40" + m792a;
                            }
                            this.f891b = m792a;
                            if (m477n != i) {
                                this.f892c = C1472l.m792a(str, m477n + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int m827m = m827m(str, i2, m478o);
                int i3 = m827m + 1;
                if (i3 < m478o) {
                    this.f893d = m822b(str, i2, m827m);
                    int m825i = m825i(str, i3, m478o);
                    this.f894e = m825i;
                    if (m825i == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, m478o) + '\"');
                    }
                } else {
                    this.f893d = m822b(str, i2, m827m);
                    this.f894e = C1472l.m796e(this.f890a);
                }
                if (this.f893d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, m827m) + '\"');
                }
                m457G = m478o;
            } else {
                this.f891b = c1472l.m815k();
                this.f892c = c1472l.m811g();
                this.f893d = c1472l.f884d;
                this.f894e = c1472l.f885e;
                this.f895f.clear();
                this.f895f.addAll(c1472l.m813i());
                if (m457G == m458H || str.charAt(m457G) == '#') {
                    m834d(c1472l.m814j());
                }
            }
            int m478o2 = C1421a.m478o(str, m457G, m458H, "?#");
            m829p(str, m457G, m478o2);
            if (m478o2 < m458H && str.charAt(m478o2) == '?') {
                int m477n2 = C1421a.m477n(str, m478o2, m458H, '#');
                this.f896g = C1472l.m805z(C1472l.m792a(str, m478o2 + 1, m477n2, " \"'<>#", true, false, true, true, null));
                m478o2 = m477n2;
            }
            if (m478o2 < m458H && str.charAt(m478o2) == '#') {
                this.f897h = C1472l.m792a(str, 1 + m478o2, m458H, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: j */
        public a m837j(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f892c = C1472l.m793b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: l */
        public a m838l(int i) {
            if (i > 0 && i <= 65535) {
                this.f894e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        /* renamed from: o */
        a m839o() {
            int size = this.f895f.size();
            for (int i = 0; i < size; i++) {
                this.f895f.set(i, C1472l.m793b(this.f895f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f896g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f896g.get(i2);
                    if (str != null) {
                        this.f896g.set(i2, C1472l.m793b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f897h;
            if (str2 != null) {
                this.f897h = C1472l.m793b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: q */
        public a m840q(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.f890a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f890a = "https";
            }
            return this;
        }

        /* renamed from: t */
        public a m841t(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f891b = C1472l.m793b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f890a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append(WVUtils.URL_SEPARATOR);
            }
            if (!this.f891b.isEmpty() || !this.f892c.isEmpty()) {
                sb.append(this.f891b);
                if (!this.f892c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f892c);
                }
                sb.append('@');
            }
            String str2 = this.f893d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f893d);
                    sb.append(']');
                } else {
                    sb.append(this.f893d);
                }
            }
            if (this.f894e != -1 || this.f890a != null) {
                int m833c = m833c();
                String str3 = this.f890a;
                if (str3 == null || m833c != C1472l.m796e(str3)) {
                    sb.append(':');
                    sb.append(m833c);
                }
            }
            C1472l.m799r(sb, this.f895f);
            if (this.f896g != null) {
                sb.append('?');
                C1472l.m798o(sb, this.f896g);
            }
            if (this.f897h != null) {
                sb.append('#');
                sb.append(this.f897h);
            }
            return sb.toString();
        }
    }

    C1472l(a aVar) {
        this.f881a = aVar.f890a;
        this.f882b = m801t(aVar.f891b, false);
        this.f883c = m801t(aVar.f892c, false);
        this.f884d = aVar.f893d;
        this.f885e = aVar.m833c();
        this.f886f = m802u(aVar.f895f, false);
        List<String> list = aVar.f896g;
        this.f887g = list != null ? m802u(list, true) : null;
        String str = aVar.f897h;
        this.f888h = str != null ? m801t(str, false) : null;
        this.f889i = aVar.toString();
    }

    /* renamed from: a */
    static String m792a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m804w(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i, i3);
            m795d(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        return str.substring(i, i2);
    }

    /* renamed from: b */
    static String m793b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m792a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    /* renamed from: c */
    static String m794c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        return m792a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: d */
    static void m795d(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m804w(str, i, i2)))))) {
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
                        char[] cArr = f880j;
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

    /* renamed from: e */
    public static int m796e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: l */
    public static C1472l m797l(String str) {
        return new a().m836h(null, str).m832a();
    }

    /* renamed from: o */
    static void m798o(StringBuilder sb, List<String> list) {
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

    /* renamed from: r */
    static void m799r(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: s */
    static String m800s(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                m803v(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: t */
    static String m801t(String str, boolean z) {
        return m800s(str, 0, str.length(), z);
    }

    /* renamed from: u */
    private List<String> m802u(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m801t(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: v */
    static void m803v(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int m474k = C1421a.m474k(str.charAt(i + 1));
                int m474k2 = C1421a.m474k(str.charAt(i3));
                if (m474k != -1 && m474k2 != -1) {
                    buffer.writeByte((m474k << 4) + m474k2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: w */
    static boolean m804w(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && C1421a.m474k(str.charAt(i + 1)) != -1 && C1421a.m474k(str.charAt(i3)) != -1;
    }

    /* renamed from: z */
    static List<String> m805z(String str) {
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

    /* renamed from: A */
    public String m806A() {
        return m819q("/...").m841t("").m837j("").m832a().toString();
    }

    @Nullable
    /* renamed from: B */
    public C1472l m807B(String str) {
        a m819q = m819q(str);
        if (m819q != null) {
            return m819q.m832a();
        }
        return null;
    }

    /* renamed from: C */
    public String m808C() {
        return this.f881a;
    }

    /* renamed from: D */
    public URI m809D() {
        String aVar = m818p().m839o().toString();
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
        return (obj instanceof C1472l) && ((C1472l) obj).f889i.equals(this.f889i);
    }

    @Nullable
    /* renamed from: f */
    public String m810f() {
        if (this.f888h == null) {
            return null;
        }
        return this.f889i.substring(this.f889i.indexOf(35) + 1);
    }

    /* renamed from: g */
    public String m811g() {
        if (this.f883c.isEmpty()) {
            return "";
        }
        return this.f889i.substring(this.f889i.indexOf(58, this.f881a.length() + 3) + 1, this.f889i.indexOf(64));
    }

    /* renamed from: h */
    public String m812h() {
        int indexOf = this.f889i.indexOf(47, this.f881a.length() + 3);
        String str = this.f889i;
        return this.f889i.substring(indexOf, C1421a.m478o(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f889i.hashCode();
    }

    /* renamed from: i */
    public List<String> m813i() {
        int indexOf = this.f889i.indexOf(47, this.f881a.length() + 3);
        String str = this.f889i;
        int m478o = C1421a.m478o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m478o) {
            int i = indexOf + 1;
            int m477n = C1421a.m477n(this.f889i, i, m478o, '/');
            arrayList.add(this.f889i.substring(i, m477n));
            indexOf = m477n;
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: j */
    public String m814j() {
        if (this.f887g == null) {
            return null;
        }
        int indexOf = this.f889i.indexOf(63) + 1;
        String str = this.f889i;
        return this.f889i.substring(indexOf, C1421a.m477n(str, indexOf, str.length(), '#'));
    }

    /* renamed from: k */
    public String m815k() {
        if (this.f882b.isEmpty()) {
            return "";
        }
        int length = this.f881a.length() + 3;
        String str = this.f889i;
        return this.f889i.substring(length, C1421a.m478o(str, length, str.length(), ":@"));
    }

    /* renamed from: m */
    public String m816m() {
        return this.f884d;
    }

    /* renamed from: n */
    public boolean m817n() {
        return this.f881a.equals("https");
    }

    /* renamed from: p */
    public a m818p() {
        a aVar = new a();
        aVar.f890a = this.f881a;
        aVar.f891b = m815k();
        aVar.f892c = m811g();
        aVar.f893d = this.f884d;
        aVar.f894e = this.f885e != m796e(this.f881a) ? this.f885e : -1;
        aVar.f895f.clear();
        aVar.f895f.addAll(m813i());
        aVar.m834d(m814j());
        aVar.f897h = m810f();
        return aVar;
    }

    @Nullable
    /* renamed from: q */
    public a m819q(String str) {
        try {
            return new a().m836h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f889i;
    }

    /* renamed from: x */
    public int m820x() {
        return this.f885e;
    }

    @Nullable
    /* renamed from: y */
    public String m821y() {
        if (this.f887g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m798o(sb, this.f887g);
        return sb.toString();
    }
}
