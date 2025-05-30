package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class DocumentsContractCompat$DocumentsContractApi19Impl {
    private DocumentsContractCompat$DocumentsContractApi19Impl() {
    }

    @DoNotInline
    public static Uri buildDocumentUri(String str, String str2) {
        return DocumentsContract.buildDocumentUri(str, str2);
    }

    @DoNotInline
    static boolean deleteDocument(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        return DocumentsContract.deleteDocument(contentResolver, uri);
    }

    @DoNotInline
    static String getDocumentId(Uri uri) {
        return DocumentsContract.getDocumentId(uri);
    }

    @DoNotInline
    static boolean isDocumentUri(Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }
}
