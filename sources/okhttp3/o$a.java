package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import okio.BufferedSink;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class o$a extends o {
    final /* synthetic */ mo2 a;
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ int d;

    o$a(mo2 mo2Var, int i, byte[] bArr, int i2) {
        this.a = mo2Var;
        this.b = i;
        this.c = bArr;
        this.d = i2;
    }

    public long a() {
        return this.b;
    }

    @Nullable
    public mo2 b() {
        return this.a;
    }

    public void h(BufferedSink bufferedSink) throws IOException {
        bufferedSink.write(this.c, this.d, this.b);
    }
}
