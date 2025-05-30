package androidx.compose.material.icons;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.graphics.vector.PathBuilder;
import androidx.compose.p004ui.graphics.vector.VectorKt;
import androidx.compose.p004ui.unit.C0856Dp;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    @PublishedApi
    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    @NotNull
    public static final ImageVector materialIcon(@NotNull String str, @NotNull Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return ((ImageVector.Builder) function1.invoke(new ImageVector.Builder(str, C0856Dp.m5216constructorimpl(24.0f), C0856Dp.m5216constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null))).build();
    }

    @NotNull
    /* renamed from: materialPath-YwgOQQI, reason: not valid java name */
    public static final ImageVector.Builder m2336materialPathYwgOQQI(@NotNull ImageVector.Builder builder, float f, float f2, int i, @NotNull Function1<? super PathBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(builder, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m2813getBlack0d7_KjU(), null);
        int m3092getButtKaPHkGw = StrokeCap.Companion.m3092getButtKaPHkGw();
        int m3102getBevelLxFBmk8 = StrokeJoin.Companion.m3102getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m3310addPathoIyEayM$default(builder, pathBuilder.getNodes(), i, "", solidColor, f, null, f2, 1.0f, m3092getButtKaPHkGw, m3102getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m2337materialPathYwgOQQI$default(ImageVector.Builder builder, float f, float f2, int i, Function1 function1, int i2, Object obj) {
        float f3 = (i2 & 1) != 0 ? 1.0f : f;
        float f4 = (i2 & 2) != 0 ? 1.0f : f2;
        int defaultFillType = (i2 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        Intrinsics.checkNotNullParameter(builder, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function1, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m2813getBlack0d7_KjU(), null);
        int m3092getButtKaPHkGw = StrokeCap.Companion.m3092getButtKaPHkGw();
        int m3102getBevelLxFBmk8 = StrokeJoin.Companion.m3102getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m3310addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, f3, null, f4, 1.0f, m3092getButtKaPHkGw, m3102getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }
}
