package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalLayoutApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MutableWindowInsets implements WindowInsets {
    public static final int $stable = 0;

    @NotNull
    private final MutableState insets$delegate;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MutableWindowInsets() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.MutableWindowInsets.<init>():void");
    }

    public MutableWindowInsets(@NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "initialInsets");
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(windowInsets, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return getInsets().getBottom(density);
    }

    @NotNull
    public final WindowInsets getInsets() {
        return (WindowInsets) this.insets$delegate.getValue();
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getInsets().getLeft(density, layoutDirection);
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getInsets().getRight(density, layoutDirection);
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return getInsets().getTop(density);
    }

    public final void setInsets(@NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "<set-?>");
        this.insets$delegate.setValue(windowInsets);
    }

    public /* synthetic */ MutableWindowInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? WindowInsetsKt.WindowInsets(0, 0, 0, 0) : windowInsets);
    }
}
