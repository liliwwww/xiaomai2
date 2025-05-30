package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class i extends o {
    private static final mo2 c = mo2.c("application/x-www-form-urlencoded");
    private final List<String> a;
    private final List<String> b;

    /* compiled from: Taobao */
    public static final class a {
        private final List<String> a;
        private final List<String> b;

        @Nullable
        private final Charset c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.a.add(l.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(l.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public i b() {
            return new i(this.a, this.b);
        }

        public a(@Nullable Charset charset) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }
    }

    i(List<String> list, List<String> list2) {
        this.a = okhttp3.internal.a.t(list);
        this.b = okhttp3.internal.a.t(list2);
    }

    private long i(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer = z ? new Buffer() : bufferedSink.buffer();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.a.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.b.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.o
    public long a() {
        return i(null, true);
    }

    @Override // okhttp3.o
    public mo2 b() {
        return c;
    }

    @Override // okhttp3.o
    public void h(BufferedSink bufferedSink) throws IOException {
        i(bufferedSink, false);
    }
}
