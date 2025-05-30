package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C1421a;
import okio.Buffer;
import okio.BufferedSink;
import tb.mo2;

/* compiled from: Taobao */
/* renamed from: okhttp3.i */
/* loaded from: classes2.dex */
public final class C1420i extends AbstractC1475o {

    /* renamed from: c */
    private static final mo2 f562c = mo2.c("application/x-www-form-urlencoded");

    /* renamed from: a */
    private final List<String> f563a;

    /* renamed from: b */
    private final List<String> f564b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.i$a */
    public static final class a {

        /* renamed from: a */
        private final List<String> f565a;

        /* renamed from: b */
        private final List<String> f566b;

        /* renamed from: c */
        @Nullable
        private final Charset f567c;

        public a() {
            this(null);
        }

        /* renamed from: a */
        public a m449a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f565a.add(C1472l.m794c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f567c));
            this.f566b.add(C1472l.m794c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f567c));
            return this;
        }

        /* renamed from: b */
        public C1420i m450b() {
            return new C1420i(this.f565a, this.f566b);
        }

        public a(@Nullable Charset charset) {
            this.f565a = new ArrayList();
            this.f566b = new ArrayList();
            this.f567c = charset;
        }
    }

    C1420i(List<String> list, List<String> list2) {
        this.f563a = C1421a.m483t(list);
        this.f564b = C1421a.m483t(list2);
    }

    /* renamed from: i */
    private long m445i(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer = z ? new Buffer() : bufferedSink.buffer();
        int size = this.f563a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f563a.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f564b.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: a */
    public long mo446a() {
        return m445i(null, true);
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: b */
    public mo2 mo447b() {
        return f562c;
    }

    @Override // okhttp3.AbstractC1475o
    /* renamed from: h */
    public void mo448h(BufferedSink bufferedSink) throws IOException {
        m445i(bufferedSink, false);
    }
}
