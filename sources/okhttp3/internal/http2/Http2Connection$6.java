package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;
import okio.Buffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Http2Connection$6 extends NamedRunnable {
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ Buffer val$buffer;
    final /* synthetic */ int val$byteCount;
    final /* synthetic */ boolean val$inFinished;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$6(Http2Connection http2Connection, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
        super(str, objArr);
        this.this$0 = http2Connection;
        this.val$streamId = i;
        this.val$buffer = buffer;
        this.val$byteCount = i2;
        this.val$inFinished = z;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        try {
            boolean onData = this.this$0.j.onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
            if (onData) {
                this.this$0.v.f(this.val$streamId, ErrorCode.CANCEL);
            }
            if (onData || this.val$inFinished) {
                synchronized (this.this$0) {
                    this.this$0.x.remove(Integer.valueOf(this.val$streamId));
                }
            }
        } catch (IOException unused) {
        }
    }
}
