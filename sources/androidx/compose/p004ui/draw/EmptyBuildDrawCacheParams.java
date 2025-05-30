package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DensityKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class EmptyBuildDrawCacheParams implements BuildDrawCacheParams {

    @NotNull
    public static final EmptyBuildDrawCacheParams INSTANCE = new EmptyBuildDrawCacheParams();
    private static final long size = Size.Companion.m2633getUnspecifiedNHjbRc();

    @NotNull
    private static final LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @NotNull
    private static final Density density = DensityKt.Density(1.0f, 1.0f);

    private EmptyBuildDrawCacheParams() {
    }

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    @NotNull
    public Density getDensity() {
        return density;
    }

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return layoutDirection;
    }

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public long mo2465getSizeNHjbRc() {
        return size;
    }
}
