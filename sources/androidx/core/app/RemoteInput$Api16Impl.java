package androidx.core.app;

import android.content.ClipData;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RemoteInput$Api16Impl {
    private RemoteInput$Api16Impl() {
    }

    @DoNotInline
    static ClipData getClipData(Intent intent) {
        return intent.getClipData();
    }

    @DoNotInline
    static void setClipData(Intent intent, ClipData clipData) {
        intent.setClipData(clipData);
    }
}
