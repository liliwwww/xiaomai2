package androidx.core.os;

import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(22)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MessageCompat$Api22Impl {
    private MessageCompat$Api22Impl() {
    }

    @DoNotInline
    static boolean isAsynchronous(Message message) {
        return message.isAsynchronous();
    }

    @DoNotInline
    static void setAsynchronous(Message message, boolean z) {
        message.setAsynchronous(z);
    }
}
