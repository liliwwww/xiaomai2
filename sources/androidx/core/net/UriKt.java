package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(this)");
        return fromFile;
    }
}
