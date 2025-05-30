package androidx.compose.material;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BottomSheetScaffoldDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final BottomSheetScaffoldDefaults INSTANCE = new BottomSheetScaffoldDefaults();
    private static final float SheetElevation = C0856Dp.m5216constructorimpl(8);
    private static final float SheetPeekHeight = C0856Dp.m5216constructorimpl(56);

    private BottomSheetScaffoldDefaults() {
    }

    /* renamed from: getSheetElevation-D9Ej5fM, reason: not valid java name */
    public final float m1953getSheetElevationD9Ej5fM() {
        return SheetElevation;
    }

    /* renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m1954getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }
}
