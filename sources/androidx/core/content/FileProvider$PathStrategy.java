package androidx.core.content;

import android.net.Uri;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface FileProvider$PathStrategy {
    File getFileForUri(Uri uri);

    Uri getUriForFile(File file);
}
