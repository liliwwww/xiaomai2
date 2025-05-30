package androidx.compose.p004ui.graphics;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidPath_androidKt {
    @NotNull
    public static final Path Path() {
        Path path = null;
        return new AndroidPath(path, 1, path);
    }

    @NotNull
    public static final Path asAndroidPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (path instanceof AndroidPath) {
            return ((AndroidPath) path).getInternalPath();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @NotNull
    public static final Path asComposePath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return new AndroidPath(path);
    }
}
