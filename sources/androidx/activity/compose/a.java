package androidx.activity.compose;

import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.compose.runtime.State;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback {
    public final /* synthetic */ State a;

    public final void onActivityResult(Object obj) {
        ActivityResultRegistryKt.rememberLauncherForActivityResult.1.a(this.a, obj);
    }
}
