package okhttp3.internal.http2;

import okhttp3.internal.C1421a;
import okio.ByteString;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.a */
/* loaded from: classes.dex */
public final class C1453a {

    /* renamed from: a */
    public final ByteString f734a;

    /* renamed from: b */
    public final ByteString f735b;

    /* renamed from: c */
    final int f736c;
    public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public C1453a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1453a)) {
            return false;
        }
        C1453a c1453a = (C1453a) obj;
        return this.f734a.equals(c1453a.f734a) && this.f735b.equals(c1453a.f735b);
    }

    public int hashCode() {
        return ((527 + this.f734a.hashCode()) * 31) + this.f735b.hashCode();
    }

    public String toString() {
        return C1421a.m480q("%s: %s", this.f734a.utf8(), this.f735b.utf8());
    }

    public C1453a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public C1453a(ByteString byteString, ByteString byteString2) {
        this.f734a = byteString;
        this.f735b = byteString2;
        this.f736c = byteString.size() + 32 + byteString2.size();
    }
}
