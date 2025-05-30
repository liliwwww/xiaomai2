package androidx.core.os;

import android.os.Environment;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class EnvironmentCompat$Api21Impl {
    private EnvironmentCompat$Api21Impl() {
    }

    @DoNotInline
    static String getExternalStorageState(File file) {
        return Environment.getExternalStorageState(file);
    }
}
