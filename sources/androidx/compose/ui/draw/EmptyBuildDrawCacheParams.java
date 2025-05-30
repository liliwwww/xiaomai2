package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EmptyBuildDrawCacheParams implements BuildDrawCacheParams {

    @NotNull
    public static final EmptyBuildDrawCacheParams INSTANCE = new EmptyBuildDrawCacheParams();
    private static final long size = Size.Companion.getUnspecified-NH-jbRc();

    @NotNull
    private static final LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @NotNull
    private static final Density density = DensityKt.Density(1.0f, 1.0f);

    private EmptyBuildDrawCacheParams() {
    }

    @NotNull
    public Density getDensity() {
        return density;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return layoutDirection;
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m956getSizeNHjbRc() {
        return size;
    }
}
