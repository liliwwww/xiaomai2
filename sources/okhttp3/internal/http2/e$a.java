package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.a;
import okhttp3.k;
import okio.Buffer;
import okio.Sink;
import okio.o;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class e$a implements Sink {
    private final Buffer a = new Buffer();
    private k b;
    boolean c;
    boolean d;
    final /* synthetic */ e e;

    e$a(e eVar) {
        this.e = eVar;
    }

    private void a(boolean z) throws IOException {
        e eVar;
        long min;
        e eVar2;
        boolean z2;
        synchronized (this.e) {
            this.e.j.enter();
            while (true) {
                try {
                    eVar = this.e;
                    if (eVar.b > 0 || this.d || this.c || eVar.k != null) {
                        break;
                    } else {
                        eVar.r();
                    }
                } finally {
                    this.e.j.exitAndThrowIfTimedOut();
                }
            }
            eVar.j.exitAndThrowIfTimedOut();
            this.e.c();
            min = Math.min(this.e.b, this.a.size());
            eVar2 = this.e;
            eVar2.b -= min;
        }
        eVar2.j.enter();
        if (z) {
            try {
                if (min == this.a.size()) {
                    z2 = true;
                    e eVar3 = this.e;
                    eVar3.d.G(eVar3.c, z2, this.a, min);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        e eVar32 = this.e;
        eVar32.d.G(eVar32.c, z2, this.a, min);
    }

    public void close() throws IOException {
        synchronized (this.e) {
            if (this.c) {
                return;
            }
            if (!this.e.h.d) {
                boolean z = this.a.size() > 0;
                if (this.b != null) {
                    while (this.a.size() > 0) {
                        a(false);
                    }
                    e eVar = this.e;
                    eVar.d.H(eVar.c, true, a.J(this.b));
                } else if (z) {
                    while (this.a.size() > 0) {
                        a(true);
                    }
                } else {
                    e eVar2 = this.e;
                    eVar2.d.G(eVar2.c, true, (Buffer) null, 0L);
                }
            }
            synchronized (this.e) {
                this.c = true;
            }
            this.e.d.flush();
            this.e.b();
        }
    }

    public void flush() throws IOException {
        synchronized (this.e) {
            this.e.c();
        }
        while (this.a.size() > 0) {
            a(false);
            this.e.d.flush();
        }
    }

    public o timeout() {
        return this.e.j;
    }

    public void write(Buffer buffer, long j) throws IOException {
        this.a.write(buffer, j);
        while (this.a.size() >= 16384) {
            a(false);
        }
    }
}
