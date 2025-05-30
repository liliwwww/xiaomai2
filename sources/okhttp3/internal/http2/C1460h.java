package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.h */
/* loaded from: classes.dex */
public final class C1460h {

    /* renamed from: a */
    private int f807a;

    /* renamed from: b */
    private final int[] f808b = new int[10];

    /* renamed from: a */
    void m732a() {
        this.f807a = 0;
        Arrays.fill(this.f808b, 0);
    }

    /* renamed from: b */
    int m733b(int i) {
        return this.f808b[i];
    }

    /* renamed from: c */
    int m734c() {
        if ((this.f807a & 2) != 0) {
            return this.f808b[1];
        }
        return -1;
    }

    /* renamed from: d */
    int m735d() {
        if ((this.f807a & 128) != 0) {
            return this.f808b[7];
        }
        return 65535;
    }

    /* renamed from: e */
    int m736e(int i) {
        return (this.f807a & 16) != 0 ? this.f808b[4] : i;
    }

    /* renamed from: f */
    int m737f(int i) {
        return (this.f807a & 32) != 0 ? this.f808b[5] : i;
    }

    /* renamed from: g */
    boolean m738g(int i) {
        return ((1 << i) & this.f807a) != 0;
    }

    /* renamed from: h */
    void m739h(C1460h c1460h) {
        for (int i = 0; i < 10; i++) {
            if (c1460h.m738g(i)) {
                m740i(i, c1460h.m733b(i));
            }
        }
    }

    /* renamed from: i */
    C1460h m740i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f808b;
            if (i < iArr.length) {
                this.f807a = (1 << i) | this.f807a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* renamed from: j */
    int m741j() {
        return Integer.bitCount(this.f807a);
    }
}
