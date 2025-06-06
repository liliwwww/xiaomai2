package androidx.compose.material;

import androidx.compose.runtime.Immutable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FabPlacement {
    private final int height;
    private final boolean isDocked;
    private final int left;
    private final int width;

    public FabPlacement(boolean z, int i, int i2, int i3) {
        this.isDocked = z;
        this.left = i;
        this.width = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isDocked() {
        return this.isDocked;
    }
}
