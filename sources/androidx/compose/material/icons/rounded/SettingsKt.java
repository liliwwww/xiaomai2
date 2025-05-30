package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SettingsKt {

    @Nullable
    private static ImageVector _settings;

    @NotNull
    public static final ImageVector getSettings(@NotNull Icons$Rounded icons$Rounded) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(icons$Rounded, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Settings", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw = StrokeCap.Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk8 = StrokeJoin.Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.5f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -0.23f, -0.01f, -0.45f, -0.03f, -0.68f);
        pathBuilder.lineToRelative(1.86f, -1.41f);
        pathBuilder.curveToRelative(0.4f, -0.3f, 0.51f, -0.86f, 0.26f, -1.3f);
        pathBuilder.lineToRelative(-1.87f, -3.23f);
        pathBuilder.curveToRelative(-0.25f, -0.44f, -0.79f, -0.62f, -1.25f, -0.42f);
        pathBuilder.lineToRelative(-2.15f, 0.91f);
        pathBuilder.curveToRelative(-0.37f, -0.26f, -0.76f, -0.49f, -1.17f, -0.68f);
        pathBuilder.lineToRelative(-0.29f, -2.31f);
        pathBuilder.curveTo(14.8f, 2.38f, 14.37f, 2.0f, 13.87f, 2.0f);
        pathBuilder.horizontalLineToRelative(-3.73f);
        pathBuilder.curveTo(9.63f, 2.0f, 9.2f, 2.38f, 9.14f, 2.88f);
        pathBuilder.lineTo(8.85f, 5.19f);
        pathBuilder.curveToRelative(-0.41f, 0.19f, -0.8f, 0.42f, -1.17f, 0.68f);
        pathBuilder.lineTo(5.53f, 4.96f);
        pathBuilder.curveToRelative(-0.46f, -0.2f, -1.0f, -0.02f, -1.25f, 0.42f);
        pathBuilder.lineTo(2.41f, 8.62f);
        pathBuilder.curveToRelative(-0.25f, 0.44f, -0.14f, 0.99f, 0.26f, 1.3f);
        pathBuilder.lineToRelative(1.86f, 1.41f);
        pathBuilder.curveTo(4.51f, 11.55f, 4.5f, 11.77f, 4.5f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(0.01f, 0.45f, 0.03f, 0.68f);
        pathBuilder.lineToRelative(-1.86f, 1.41f);
        pathBuilder.curveToRelative(-0.4f, 0.3f, -0.51f, 0.86f, -0.26f, 1.3f);
        pathBuilder.lineToRelative(1.87f, 3.23f);
        pathBuilder.curveToRelative(0.25f, 0.44f, 0.79f, 0.62f, 1.25f, 0.42f);
        pathBuilder.lineToRelative(2.15f, -0.91f);
        pathBuilder.curveToRelative(0.37f, 0.26f, 0.76f, 0.49f, 1.17f, 0.68f);
        pathBuilder.lineToRelative(0.29f, 2.31f);
        pathBuilder.curveTo(9.2f, 21.62f, 9.63f, 22.0f, 10.13f, 22.0f);
        pathBuilder.horizontalLineToRelative(3.73f);
        pathBuilder.curveToRelative(0.5f, 0.0f, 0.93f, -0.38f, 0.99f, -0.88f);
        pathBuilder.lineToRelative(0.29f, -2.31f);
        pathBuilder.curveToRelative(0.41f, -0.19f, 0.8f, -0.42f, 1.17f, -0.68f);
        pathBuilder.lineToRelative(2.15f, 0.91f);
        pathBuilder.curveToRelative(0.46f, 0.2f, 1.0f, 0.02f, 1.25f, -0.42f);
        pathBuilder.lineToRelative(1.87f, -3.23f);
        pathBuilder.curveToRelative(0.25f, -0.44f, 0.14f, -0.99f, -0.26f, -1.3f);
        pathBuilder.lineToRelative(-1.86f, -1.41f);
        pathBuilder.curveTo(19.49f, 12.45f, 19.5f, 12.23f, 19.5f, 12.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.04f, 15.5f);
        pathBuilder.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        pathBuilder.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilder.reflectiveCurveTo(13.97f, 15.5f, 12.04f, 15.5f);
        pathBuilder.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _settings = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
