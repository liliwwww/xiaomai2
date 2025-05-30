package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ShaderKt {
    @NotNull
    /* renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m3060ImageShaderF49vj9s(@NotNull ImageBitmap imageBitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return AndroidShader_androidKt.m2695ActualImageShaderF49vj9s(imageBitmap, i, i2);
    }

    /* renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m3061ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = TileMode.Companion.m3112getClamp3opZhB0();
        }
        if ((i3 & 4) != 0) {
            i2 = TileMode.Companion.m3112getClamp3opZhB0();
        }
        return m3060ImageShaderF49vj9s(imageBitmap, i, i2);
    }

    @NotNull
    /* renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m3062LinearGradientShaderVjE6UOU(long j, long j2, @NotNull List<Color> list, @Nullable List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2696ActualLinearGradientShaderVjE6UOU(j, j2, list, list2, i);
    }

    /* renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m3063LinearGradientShaderVjE6UOU$default(long j, long j2, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.Companion.m3112getClamp3opZhB0();
        }
        return m3062LinearGradientShaderVjE6UOU(j, j2, list, list3, i);
    }

    @NotNull
    /* renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m3064RadialGradientShader8uybcMk(long j, float f, @NotNull List<Color> list, @Nullable List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2697ActualRadialGradientShader8uybcMk(j, f, list, list2, i);
    }

    /* renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m3065RadialGradientShader8uybcMk$default(long j, float f, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.Companion.m3112getClamp3opZhB0();
        }
        return m3064RadialGradientShader8uybcMk(j, f, list, list3, i);
    }

    @NotNull
    /* renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m3066SweepGradientShader9KIMszo(long j, @NotNull List<Color> list, @Nullable List<Float> list2) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2698ActualSweepGradientShader9KIMszo(j, list, list2);
    }

    /* renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m3067SweepGradientShader9KIMszo$default(long j, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        return m3066SweepGradientShader9KIMszo(j, list, list2);
    }
}
