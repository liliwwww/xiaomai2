package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BuildKt {

    @Nullable
    private static ImageVector _build;

    @NotNull
    public static final ImageVector getBuild(@NotNull Icons.Sharp sharp) {
        Intrinsics.checkNotNullParameter(sharp, "<this>");
        ImageVector imageVector = _build;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Build", Dp.m2142constructorimpl(24.0f), Dp.m2142constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.09f, 2.91f);
        pathBuilder.curveTo(10.08f, 0.9f, 7.07f, 0.49f, 4.65f, 1.67f);
        pathBuilder.lineToRelative(4.34f, 4.34f);
        pathBuilder.lineToRelative(-3.0f, 3.0f);
        pathBuilder.lineToRelative(-4.34f, -4.34f);
        pathBuilder.curveTo(0.48f, 7.1f, 0.89f, 10.09f, 2.9f, 12.1f);
        pathBuilder.curveToRelative(1.86f, 1.86f, 4.58f, 2.35f, 6.89f, 1.48f);
        pathBuilder.lineToRelative(9.82f, 9.82f);
        pathBuilder.lineToRelative(3.71f, -3.71f);
        pathBuilder.lineToRelative(-9.78f, -9.79f);
        pathBuilder.curveToRelative(0.92f, -2.34f, 0.44f, -5.1f, -1.45f, -6.99f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _build = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
