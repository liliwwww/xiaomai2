package androidx.core.content;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap<>();

    FileProvider$SimplePathStrategy(String str) {
        this.mAuthority = str;
    }

    void addRoot(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.mRoots.put(str, file.getCanonicalFile());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
        }
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public File getFileForUri(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        File file = this.mRoots.get(decode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, decode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (canonicalFile.getPath().startsWith(file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public Uri getUriForFile(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry<String, File> entry = null;
            for (Map.Entry<String, File> entry2 : this.mRoots.entrySet()) {
                String path = entry2.getValue().getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            }
            String path2 = entry.getValue().getPath();
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(path2.endsWith(WVNativeCallbackUtil.SEPERATER) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), WVNativeCallbackUtil.SEPERATER)).build();
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }
}
