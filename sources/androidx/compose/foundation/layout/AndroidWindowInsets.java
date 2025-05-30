package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidWindowInsets implements WindowInsets {

    @NotNull
    private final MutableState insets$delegate;

    @NotNull
    private final MutableState isVisible$delegate;

    @NotNull
    private final String name;
    private final int type;

    public AndroidWindowInsets(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.type = i;
        this.name = str;
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(Insets.NONE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final void setVisible(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidWindowInsets) && this.type == ((AndroidWindowInsets) obj).type;
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return getInsets$foundation_layout_release().bottom;
    }

    @NotNull
    public final Insets getInsets$foundation_layout_release() {
        return (Insets) this.insets$delegate.getValue();
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getInsets$foundation_layout_release().left;
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getInsets$foundation_layout_release().right;
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return getInsets$foundation_layout_release().top;
    }

    public final int getType$foundation_layout_release() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    public final boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    public final void setInsets$foundation_layout_release(@NotNull Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "<set-?>");
        this.insets$delegate.setValue(insets);
    }

    @NotNull
    public String toString() {
        return this.name + '(' + getInsets$foundation_layout_release().left + ", " + getInsets$foundation_layout_release().top + ", " + getInsets$foundation_layout_release().right + ", " + getInsets$foundation_layout_release().bottom + ')';
    }

    public final void update$foundation_layout_release(@NotNull WindowInsetsCompat windowInsetsCompat, int i) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
        if (i == 0 || (i & this.type) != 0) {
            setInsets$foundation_layout_release(windowInsetsCompat.getInsets(this.type));
            setVisible(windowInsetsCompat.isVisible(this.type));
        }
    }
}
