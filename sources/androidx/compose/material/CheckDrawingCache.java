package androidx.compose.material;

import androidx.compose.p004ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathMeasure;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
final class CheckDrawingCache {

    @NotNull
    private final Path checkPath;

    @NotNull
    private final PathMeasure pathMeasure;

    @NotNull
    private final Path pathToDraw;

    public CheckDrawingCache() {
        this(null, null, null, 7, null);
    }

    public CheckDrawingCache(@NotNull Path path, @NotNull PathMeasure pathMeasure, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "checkPath");
        Intrinsics.checkNotNullParameter(pathMeasure, "pathMeasure");
        Intrinsics.checkNotNullParameter(path2, "pathToDraw");
        this.checkPath = path;
        this.pathMeasure = pathMeasure;
        this.pathToDraw = path2;
    }

    @NotNull
    public final Path getCheckPath() {
        return this.checkPath;
    }

    @NotNull
    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    @NotNull
    public final Path getPathToDraw() {
        return this.pathToDraw;
    }

    public /* synthetic */ CheckDrawingCache(Path path, PathMeasure pathMeasure, Path path2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AndroidPath_androidKt.Path() : path, (i & 2) != 0 ? AndroidPathMeasure_androidKt.PathMeasure() : pathMeasure, (i & 4) != 0 ? AndroidPath_androidKt.Path() : path2);
    }
}
