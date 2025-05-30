package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(25)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class InputConnectionCompat$Api25Impl {
    private InputConnectionCompat$Api25Impl() {
    }

    @DoNotInline
    static boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int i, Bundle bundle) {
        return inputConnection.commitContent(inputContentInfo, i, bundle);
    }
}
