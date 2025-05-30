package okhttp3.internal.http2;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class Http2Connection$b {
    public static final Http2Connection$b REFUSE_INCOMING_STREAMS = new a();

    /* compiled from: Taobao */
    class a extends Http2Connection$b {
        a() {
        }

        @Override // okhttp3.internal.http2.Http2Connection$b
        public void b(e eVar) throws IOException {
            eVar.d(ErrorCode.REFUSED_STREAM, (IOException) null);
        }
    }

    public void a(Http2Connection http2Connection) {
    }

    public abstract void b(e eVar) throws IOException;
}
