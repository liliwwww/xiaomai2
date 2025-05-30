package androidx.compose.p004ui.graphics;

import android.graphics.Path;
import android.graphics.PathMeasure;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidPathMeasure implements PathMeasure {

    @NotNull
    private final PathMeasure internalPathMeasure;

    public AndroidPathMeasure(@NotNull PathMeasure pathMeasure) {
        Intrinsics.checkNotNullParameter(pathMeasure, "internalPathMeasure");
        this.internalPathMeasure = pathMeasure;
    }

    @Override // androidx.compose.p004ui.graphics.PathMeasure
    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    @Override // androidx.compose.p004ui.graphics.PathMeasure
    public boolean getSegment(float f, float f2, @NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "destination");
        PathMeasure pathMeasure = this.internalPathMeasure;
        if (path instanceof AndroidPath) {
            return pathMeasure.getSegment(f, f2, ((AndroidPath) path).getInternalPath(), z);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.p004ui.graphics.PathMeasure
    public void setPath(@Nullable Path path, boolean z) {
        Path path2;
        PathMeasure pathMeasure = this.internalPathMeasure;
        if (path == null) {
            path2 = null;
        } else {
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            path2 = ((AndroidPath) path).getInternalPath();
        }
        pathMeasure.setPath(path2, z);
    }
}
