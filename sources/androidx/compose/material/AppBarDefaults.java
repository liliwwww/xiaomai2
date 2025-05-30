package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class AppBarDefaults {
    public static final int $stable = 0;

    @NotNull
    private static final PaddingValues ContentPadding;

    @NotNull
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = C0856Dp.m5216constructorimpl(4);
    private static final float BottomAppBarElevation = C0856Dp.m5216constructorimpl(8);

    static {
        float f;
        float f2;
        f = AppBarKt.AppBarHorizontalPadding;
        f2 = AppBarKt.AppBarHorizontalPadding;
        ContentPadding = PaddingKt.m1391PaddingValuesa9UjIt4$default(f, 0.0f, f2, 0.0f, 10, null);
    }

    private AppBarDefaults() {
    }

    /* renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m1916getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m1917getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }
}
