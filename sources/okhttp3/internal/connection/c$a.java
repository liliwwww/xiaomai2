package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.Sink;
import okio.c;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class c$a extends c {
    private boolean a;
    private long b;
    private long c;
    private boolean d;
    final /* synthetic */ c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c$a(c cVar, Sink sink, long j) {
        super(sink);
        this.e = cVar;
        this.b = j;
    }

    @Nullable
    private IOException a(@Nullable IOException iOException) {
        if (this.a) {
            return iOException;
        }
        this.a = true;
        return this.e.a(this.c, false, true, iOException);
    }

    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        long j = this.b;
        if (j != -1 && this.c != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }

    public void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            throw a(e);
        }
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        long j2 = this.b;
        if (j2 == -1 || this.c + j <= j2) {
            try {
                super.write(buffer, j);
                this.c += j;
                return;
            } catch (IOException e) {
                throw a(e);
            }
        }
        throw new ProtocolException("expected " + this.b + " bytes but received " + (this.c + j));
    }
}
