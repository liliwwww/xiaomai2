package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AppBarDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m2142constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m2142constructorimpl(8);

    @NotNull
    private static final PaddingValues ContentPadding = PaddingKt.PaddingValues-a9UjIt4$default(AppBarKt.access$getAppBarHorizontalPadding$p(), 0.0f, AppBarKt.access$getAppBarHorizontalPadding$p(), 0.0f, 10, (Object) null);

    private AppBarDefaults() {
    }

    /* renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m496getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m497getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }
}
