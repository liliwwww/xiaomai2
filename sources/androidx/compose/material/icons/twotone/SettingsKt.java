package androidx.compose.material.icons.twotone;

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
public final class SettingsKt {

    @Nullable
    private static ImageVector _settings;

    @NotNull
    public static final ImageVector getSettings(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Settings", Dp.m2142constructorimpl(24.0f), Dp.m2142constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.Companion;
        SolidColor solidColor = new SolidColor(companion.getBlack-0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int i = companion2.getButt-KaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int i2 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.28f, 8.6f);
        pathBuilder.lineToRelative(-0.7f, -1.21f);
        pathBuilder.lineToRelative(-1.27f, 0.51f);
        pathBuilder.lineToRelative(-1.06f, 0.43f);
        pathBuilder.lineToRelative(-0.91f, -0.7f);
        pathBuilder.curveToRelative(-0.39f, -0.3f, -0.8f, -0.54f, -1.23f, -0.71f);
        pathBuilder.lineToRelative(-1.06f, -0.43f);
        pathBuilder.lineToRelative(-0.16f, -1.13f);
        pathBuilder.lineTo(12.7f, 4.0f);
        pathBuilder.horizontalLineToRelative(-1.4f);
        pathBuilder.lineToRelative(-0.19f, 1.35f);
        pathBuilder.lineToRelative(-0.16f, 1.13f);
        pathBuilder.lineToRelative(-1.06f, 0.44f);
        pathBuilder.curveToRelative(-0.41f, 0.17f, -0.82f, 0.41f, -1.25f, 0.73f);
        pathBuilder.lineToRelative(-0.9f, 0.68f);
        pathBuilder.lineToRelative(-1.05f, -0.42f);
        pathBuilder.lineToRelative(-1.27f, -0.52f);
        pathBuilder.lineToRelative(-0.7f, 1.21f);
        pathBuilder.lineToRelative(1.08f, 0.84f);
        pathBuilder.lineToRelative(0.89f, 0.7f);
        pathBuilder.lineToRelative(-0.14f, 1.13f);
        pathBuilder.curveToRelative(-0.03f, 0.3f, -0.05f, 0.53f, -0.05f, 0.73f);
        pathBuilder.reflectiveCurveToRelative(0.02f, 0.43f, 0.05f, 0.73f);
        pathBuilder.lineToRelative(0.14f, 1.13f);
        pathBuilder.lineToRelative(-0.89f, 0.7f);
        pathBuilder.lineToRelative(-1.08f, 0.84f);
        pathBuilder.lineToRelative(0.7f, 1.21f);
        pathBuilder.lineToRelative(1.27f, -0.51f);
        pathBuilder.lineToRelative(1.06f, -0.43f);
        pathBuilder.lineToRelative(0.91f, 0.7f);
        pathBuilder.curveToRelative(0.39f, 0.3f, 0.8f, 0.54f, 1.23f, 0.71f);
        pathBuilder.lineToRelative(1.06f, 0.43f);
        pathBuilder.lineToRelative(0.16f, 1.13f);
        pathBuilder.lineToRelative(0.19f, 1.36f);
        pathBuilder.horizontalLineToRelative(1.39f);
        pathBuilder.lineToRelative(0.19f, -1.35f);
        pathBuilder.lineToRelative(0.16f, -1.13f);
        pathBuilder.lineToRelative(1.06f, -0.43f);
        pathBuilder.curveToRelative(0.41f, -0.17f, 0.82f, -0.41f, 1.25f, -0.73f);
        pathBuilder.lineToRelative(0.9f, -0.68f);
        pathBuilder.lineToRelative(1.04f, 0.42f);
        pathBuilder.lineToRelative(1.27f, 0.51f);
        pathBuilder.lineToRelative(0.7f, -1.21f);
        pathBuilder.lineToRelative(-1.08f, -0.84f);
        pathBuilder.lineToRelative(-0.89f, -0.7f);
        pathBuilder.lineToRelative(0.14f, -1.13f);
        pathBuilder.curveToRelative(0.04f, -0.31f, 0.05f, -0.52f, 0.05f, -0.73f);
        pathBuilder.curveToRelative(0.0f, -0.21f, -0.02f, -0.43f, -0.05f, -0.73f);
        pathBuilder.lineToRelative(-0.14f, -1.13f);
        pathBuilder.lineToRelative(0.89f, -0.7f);
        pathBuilder.lineToRelative(1.1f, -0.84f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 16.0f);
        pathBuilder.curveToRelative(-2.21f, 0.0f, -4.0f, -1.79f, -4.0f, -4.0f);
        pathBuilder.reflectiveCurveToRelative(1.79f, -4.0f, 4.0f, -4.0f);
        pathBuilder.reflectiveCurveToRelative(4.0f, 1.79f, 4.0f, 4.0f);
        pathBuilder.reflectiveCurveToRelative(-1.79f, 4.0f, -4.0f, 4.0f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.getBlack-0d7_KjU(), null);
        int i3 = companion2.getButt-KaPHkGw();
        int i4 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(19.43f, 12.98f);
        pathBuilder2.curveToRelative(0.04f, -0.32f, 0.07f, -0.64f, 0.07f, -0.98f);
        pathBuilder2.curveToRelative(0.0f, -0.34f, -0.03f, -0.66f, -0.07f, -0.98f);
        pathBuilder2.lineToRelative(2.11f, -1.65f);
        pathBuilder2.curveToRelative(0.19f, -0.15f, 0.24f, -0.42f, 0.12f, -0.64f);
        pathBuilder2.lineToRelative(-2.0f, -3.46f);
        pathBuilder2.curveToRelative(-0.09f, -0.16f, -0.26f, -0.25f, -0.44f, -0.25f);
        pathBuilder2.curveToRelative(-0.06f, 0.0f, -0.12f, 0.01f, -0.17f, 0.03f);
        pathBuilder2.lineToRelative(-2.49f, 1.0f);
        pathBuilder2.curveToRelative(-0.52f, -0.4f, -1.08f, -0.73f, -1.69f, -0.98f);
        pathBuilder2.lineToRelative(-0.38f, -2.65f);
        pathBuilder2.curveTo(14.46f, 2.18f, 14.25f, 2.0f, 14.0f, 2.0f);
        pathBuilder2.horizontalLineToRelative(-4.0f);
        pathBuilder2.curveToRelative(-0.25f, 0.0f, -0.46f, 0.18f, -0.49f, 0.42f);
        pathBuilder2.lineToRelative(-0.38f, 2.65f);
        pathBuilder2.curveToRelative(-0.61f, 0.25f, -1.17f, 0.59f, -1.69f, 0.98f);
        pathBuilder2.lineToRelative(-2.49f, -1.0f);
        pathBuilder2.curveToRelative(-0.06f, -0.02f, -0.12f, -0.03f, -0.18f, -0.03f);
        pathBuilder2.curveToRelative(-0.17f, 0.0f, -0.34f, 0.09f, -0.43f, 0.25f);
        pathBuilder2.lineToRelative(-2.0f, 3.46f);
        pathBuilder2.curveToRelative(-0.13f, 0.22f, -0.07f, 0.49f, 0.12f, 0.64f);
        pathBuilder2.lineToRelative(2.11f, 1.65f);
        pathBuilder2.curveToRelative(-0.04f, 0.32f, -0.07f, 0.65f, -0.07f, 0.98f);
        pathBuilder2.reflectiveCurveToRelative(0.03f, 0.66f, 0.07f, 0.98f);
        pathBuilder2.lineToRelative(-2.11f, 1.65f);
        pathBuilder2.curveToRelative(-0.19f, 0.15f, -0.24f, 0.42f, -0.12f, 0.64f);
        pathBuilder2.lineToRelative(2.0f, 3.46f);
        pathBuilder2.curveToRelative(0.09f, 0.16f, 0.26f, 0.25f, 0.44f, 0.25f);
        pathBuilder2.curveToRelative(0.06f, 0.0f, 0.12f, -0.01f, 0.17f, -0.03f);
        pathBuilder2.lineToRelative(2.49f, -1.0f);
        pathBuilder2.curveToRelative(0.52f, 0.4f, 1.08f, 0.73f, 1.69f, 0.98f);
        pathBuilder2.lineToRelative(0.38f, 2.65f);
        pathBuilder2.curveToRelative(0.03f, 0.24f, 0.24f, 0.42f, 0.49f, 0.42f);
        pathBuilder2.horizontalLineToRelative(4.0f);
        pathBuilder2.curveToRelative(0.25f, 0.0f, 0.46f, -0.18f, 0.49f, -0.42f);
        pathBuilder2.lineToRelative(0.38f, -2.65f);
        pathBuilder2.curveToRelative(0.61f, -0.25f, 1.17f, -0.59f, 1.69f, -0.98f);
        pathBuilder2.lineToRelative(2.49f, 1.0f);
        pathBuilder2.curveToRelative(0.06f, 0.02f, 0.12f, 0.03f, 0.18f, 0.03f);
        pathBuilder2.curveToRelative(0.17f, 0.0f, 0.34f, -0.09f, 0.43f, -0.25f);
        pathBuilder2.lineToRelative(2.0f, -3.46f);
        pathBuilder2.curveToRelative(0.12f, -0.22f, 0.07f, -0.49f, -0.12f, -0.64f);
        pathBuilder2.lineToRelative(-2.11f, -1.65f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.45f, 11.27f);
        pathBuilder2.curveToRelative(0.04f, 0.31f, 0.05f, 0.52f, 0.05f, 0.73f);
        pathBuilder2.curveToRelative(0.0f, 0.21f, -0.02f, 0.43f, -0.05f, 0.73f);
        pathBuilder2.lineToRelative(-0.14f, 1.13f);
        pathBuilder2.lineToRelative(0.89f, 0.7f);
        pathBuilder2.lineToRelative(1.08f, 0.84f);
        pathBuilder2.lineToRelative(-0.7f, 1.21f);
        pathBuilder2.lineToRelative(-1.27f, -0.51f);
        pathBuilder2.lineToRelative(-1.04f, -0.42f);
        pathBuilder2.lineToRelative(-0.9f, 0.68f);
        pathBuilder2.curveToRelative(-0.43f, 0.32f, -0.84f, 0.56f, -1.25f, 0.73f);
        pathBuilder2.lineToRelative(-1.06f, 0.43f);
        pathBuilder2.lineToRelative(-0.16f, 1.13f);
        pathBuilder2.lineToRelative(-0.2f, 1.35f);
        pathBuilder2.horizontalLineToRelative(-1.4f);
        pathBuilder2.lineToRelative(-0.19f, -1.35f);
        pathBuilder2.lineToRelative(-0.16f, -1.13f);
        pathBuilder2.lineToRelative(-1.06f, -0.43f);
        pathBuilder2.curveToRelative(-0.43f, -0.18f, -0.83f, -0.41f, -1.23f, -0.71f);
        pathBuilder2.lineToRelative(-0.91f, -0.7f);
        pathBuilder2.lineToRelative(-1.06f, 0.43f);
        pathBuilder2.lineToRelative(-1.27f, 0.51f);
        pathBuilder2.lineToRelative(-0.7f, -1.21f);
        pathBuilder2.lineToRelative(1.08f, -0.84f);
        pathBuilder2.lineToRelative(0.89f, -0.7f);
        pathBuilder2.lineToRelative(-0.14f, -1.13f);
        pathBuilder2.curveToRelative(-0.03f, -0.31f, -0.05f, -0.54f, -0.05f, -0.74f);
        pathBuilder2.reflectiveCurveToRelative(0.02f, -0.43f, 0.05f, -0.73f);
        pathBuilder2.lineToRelative(0.14f, -1.13f);
        pathBuilder2.lineToRelative(-0.89f, -0.7f);
        pathBuilder2.lineToRelative(-1.08f, -0.84f);
        pathBuilder2.lineToRelative(0.7f, -1.21f);
        pathBuilder2.lineToRelative(1.27f, 0.51f);
        pathBuilder2.lineToRelative(1.04f, 0.42f);
        pathBuilder2.lineToRelative(0.9f, -0.68f);
        pathBuilder2.curveToRelative(0.43f, -0.32f, 0.84f, -0.56f, 1.25f, -0.73f);
        pathBuilder2.lineToRelative(1.06f, -0.43f);
        pathBuilder2.lineToRelative(0.16f, -1.13f);
        pathBuilder2.lineToRelative(0.2f, -1.35f);
        pathBuilder2.horizontalLineToRelative(1.39f);
        pathBuilder2.lineToRelative(0.19f, 1.35f);
        pathBuilder2.lineToRelative(0.16f, 1.13f);
        pathBuilder2.lineToRelative(1.06f, 0.43f);
        pathBuilder2.curveToRelative(0.43f, 0.18f, 0.83f, 0.41f, 1.23f, 0.71f);
        pathBuilder2.lineToRelative(0.91f, 0.7f);
        pathBuilder2.lineToRelative(1.06f, -0.43f);
        pathBuilder2.lineToRelative(1.27f, -0.51f);
        pathBuilder2.lineToRelative(0.7f, 1.21f);
        pathBuilder2.lineToRelative(-1.07f, 0.85f);
        pathBuilder2.lineToRelative(-0.89f, 0.7f);
        pathBuilder2.lineToRelative(0.14f, 1.13f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 8.0f);
        pathBuilder2.curveToRelative(-2.21f, 0.0f, -4.0f, 1.79f, -4.0f, 4.0f);
        pathBuilder2.reflectiveCurveToRelative(1.79f, 4.0f, 4.0f, 4.0f);
        pathBuilder2.reflectiveCurveToRelative(4.0f, -1.79f, 4.0f, -4.0f);
        pathBuilder2.reflectiveCurveToRelative(-1.79f, -4.0f, -4.0f, -4.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 14.0f);
        pathBuilder2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder2.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i3, i4, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _settings = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
