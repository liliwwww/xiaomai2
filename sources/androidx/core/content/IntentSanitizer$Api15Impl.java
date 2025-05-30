package androidx.core.content;

import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(15)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class IntentSanitizer$Api15Impl {
    private IntentSanitizer$Api15Impl() {
    }

    @DoNotInline
    static Intent getSelector(Intent intent) {
        return intent.getSelector();
    }

    @DoNotInline
    static void setSelector(Intent intent, Intent intent2) {
        intent.setSelector(intent2);
    }
}
