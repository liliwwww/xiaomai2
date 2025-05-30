package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RemoteInput$Api28Impl {
    private RemoteInput$Api28Impl() {
    }

    @DoNotInline
    static int getResultsSource(Intent intent) {
        return RemoteInput.getResultsSource(intent);
    }

    @DoNotInline
    static void setResultsSource(Intent intent, int i) {
        RemoteInput.setResultsSource(intent, i);
    }
}
