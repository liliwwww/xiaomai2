package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Outline$Generic extends Outline {

    @NotNull
    private final Path path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Outline$Generic(@NotNull Path path) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Outline$Generic) && Intrinsics.areEqual(this.path, ((Outline$Generic) obj).path);
    }

    @NotNull
    public Rect getBounds() {
        return this.path.getBounds();
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    public int hashCode() {
        return this.path.hashCode();
    }
}
