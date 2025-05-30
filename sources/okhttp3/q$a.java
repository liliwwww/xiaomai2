package okhttp3;

import javax.annotation.Nullable;
import okio.BufferedSource;
import tb.mo2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class q$a extends q {
    final /* synthetic */ mo2 a;
    final /* synthetic */ long b;
    final /* synthetic */ BufferedSource c;

    q$a(mo2 mo2Var, long j, BufferedSource bufferedSource) {
        this.a = mo2Var;
        this.b = j;
        this.c = bufferedSource;
    }

    public long g() {
        return this.b;
    }

    @Nullable
    public mo2 j() {
        return this.a;
    }

    public BufferedSource m() {
        return this.c;
    }
}
