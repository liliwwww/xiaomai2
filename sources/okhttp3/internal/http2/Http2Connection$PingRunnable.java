package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Http2Connection$PingRunnable extends NamedRunnable {
    final int payload1;
    final int payload2;
    final boolean reply;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$PingRunnable(Http2Connection http2Connection, boolean z, int i, int i2) {
        super("OkHttp %s ping %08x%08x", http2Connection.d, Integer.valueOf(i), Integer.valueOf(i2));
        this.this$0 = http2Connection;
        this.reply = z;
        this.payload1 = i;
        this.payload2 = i2;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        this.this$0.I(this.reply, this.payload1, this.payload2);
    }
}
