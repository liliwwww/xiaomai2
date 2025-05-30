package androidx.compose.ui.res;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ImageVectorCache$ImageVectorEntry {
    public static final int $stable = 0;
    private final int configFlags;

    @NotNull
    private final ImageVector imageVector;

    public ImageVectorCache$ImageVectorEntry(@NotNull ImageVector imageVector, int i) {
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        this.imageVector = imageVector;
        this.configFlags = i;
    }

    public static /* synthetic */ ImageVectorCache$ImageVectorEntry copy$default(ImageVectorCache$ImageVectorEntry imageVectorCache$ImageVectorEntry, ImageVector imageVector, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            imageVector = imageVectorCache$ImageVectorEntry.imageVector;
        }
        if ((i2 & 2) != 0) {
            i = imageVectorCache$ImageVectorEntry.configFlags;
        }
        return imageVectorCache$ImageVectorEntry.copy(imageVector, i);
    }

    @NotNull
    public final ImageVector component1() {
        return this.imageVector;
    }

    public final int component2() {
        return this.configFlags;
    }

    @NotNull
    public final ImageVectorCache$ImageVectorEntry copy(@NotNull ImageVector imageVector, int i) {
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        return new ImageVectorCache$ImageVectorEntry(imageVector, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVectorCache$ImageVectorEntry)) {
            return false;
        }
        ImageVectorCache$ImageVectorEntry imageVectorCache$ImageVectorEntry = (ImageVectorCache$ImageVectorEntry) obj;
        return Intrinsics.areEqual(this.imageVector, imageVectorCache$ImageVectorEntry.imageVector) && this.configFlags == imageVectorCache$ImageVectorEntry.configFlags;
    }

    public final int getConfigFlags() {
        return this.configFlags;
    }

    @NotNull
    public final ImageVector getImageVector() {
        return this.imageVector;
    }

    public int hashCode() {
        return (this.imageVector.hashCode() * 31) + this.configFlags;
    }

    @NotNull
    public String toString() {
        return "ImageVectorEntry(imageVector=" + this.imageVector + ", configFlags=" + this.configFlags + ')';
    }
}
