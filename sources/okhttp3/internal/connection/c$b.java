package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.Source;
import okio.d;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class c$b extends d {
    private final long a;
    private long b;
    private boolean c;
    private boolean d;
    final /* synthetic */ c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c$b(c cVar, Source source, long j) {
        super(source);
        this.e = cVar;
        this.a = j;
        if (j == 0) {
            a(null);
        }
    }

    @Nullable
    IOException a(@Nullable IOException iOException) {
        if (this.c) {
            return iOException;
        }
        this.c = true;
        return this.e.a(this.b, true, false, iOException);
    }

    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            super.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        try {
            long read = delegate().read(buffer, j);
            if (read == -1) {
                a(null);
                return -1L;
            }
            long j2 = this.b + read;
            long j3 = this.a;
            if (j3 != -1 && j2 > j3) {
                throw new ProtocolException("expected " + this.a + " bytes but received " + j2);
            }
            this.b = j2;
            if (j2 == j3) {
                a(null);
            }
            return read;
        } catch (IOException e) {
            throw a(e);
        }
    }
}
