package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ConcurrencyHelpers$Handler28Impl {
    private ConcurrencyHelpers$Handler28Impl() {
    }

    @DoNotInline
    public static Handler createAsync(Looper looper) {
        return Handler.createAsync(looper);
    }
}
