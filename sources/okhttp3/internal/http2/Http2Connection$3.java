package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Http2Connection$3 extends NamedRunnable {
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$3(Http2Connection http2Connection, String str, Object... objArr) {
        super(str, objArr);
        this.this$0 = http2Connection;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        this.this$0.I(false, 2, 0);
    }
}
