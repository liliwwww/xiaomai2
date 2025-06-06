package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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
    public static final ImageVector getSettings(@NotNull Icons$Sharp icons$Sharp) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(icons$Sharp, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Settings", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw = StrokeCap.Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk8 = StrokeJoin.Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.44f, 12.99f);
        pathBuilder.lineToRelative(-0.01f, 0.02f);
        pathBuilder.curveToRelative(0.04f, -0.33f, 0.08f, -0.67f, 0.08f, -1.01f);
        pathBuilder.curveToRelative(0.0f, -0.34f, -0.03f, -0.66f, -0.07f, -0.99f);
        pathBuilder.lineToRelative(0.01f, 0.02f);
        pathBuilder.lineToRelative(2.44f, -1.92f);
        pathBuilder.lineToRelative(-2.43f, -4.22f);
        pathBuilder.lineToRelative(-2.87f, 1.16f);
        pathBuilder.lineToRelative(0.01f, 0.01f);
        pathBuilder.curveToRelative(-0.52f, -0.4f, -1.09f, -0.74f, -1.71f, -1.0f);
        pathBuilder.horizontalLineToRelative(0.01f);
        pathBuilder.lineTo(14.44f, 2.0f);
        pathBuilder.horizontalLineTo(9.57f);
        pathBuilder.lineToRelative(-0.44f, 3.07f);
        pathBuilder.horizontalLineToRelative(0.01f);
        pathBuilder.curveToRelative(-0.62f, 0.26f, -1.19f, 0.6f, -1.71f, 1.0f);
        pathBuilder.lineToRelative(0.01f, -0.01f);
        pathBuilder.lineToRelative(-2.88f, -1.17f);
        pathBuilder.lineToRelative(-2.44f, 4.22f);
        pathBuilder.lineToRelative(2.44f, 1.92f);
        pathBuilder.lineToRelative(0.01f, -0.02f);
        pathBuilder.curveToRelative(-0.04f, 0.33f, -0.07f, 0.65f, -0.07f, 0.99f);
        pathBuilder.curveToRelative(0.0f, 0.34f, 0.03f, 0.68f, 0.08f, 1.01f);
        pathBuilder.lineToRelative(-0.01f, -0.02f);
        pathBuilder.lineToRelative(-2.1f, 1.65f);
        pathBuilder.lineToRelative(-0.33f, 0.26f);
        pathBuilder.lineToRelative(2.43f, 4.2f);
        pathBuilder.lineToRelative(2.88f, -1.15f);
        pathBuilder.lineToRelative(-0.02f, -0.04f);
        pathBuilder.curveToRelative(0.53f, 0.41f, 1.1f, 0.75f, 1.73f, 1.01f);
        pathBuilder.horizontalLineToRelative(-0.03f);
        pathBuilder.lineTo(9.58f, 22.0f);
        pathBuilder.horizontalLineToRelative(4.85f);
        pathBuilder.reflectiveCurveToRelative(0.03f, -0.18f, 0.06f, -0.42f);
        pathBuilder.lineToRelative(0.38f, -2.65f);
        pathBuilder.horizontalLineToRelative(-0.01f);
        pathBuilder.curveToRelative(0.62f, -0.26f, 1.2f, -0.6f, 1.73f, -1.01f);
        pathBuilder.lineToRelative(-0.02f, 0.04f);
        pathBuilder.lineToRelative(2.88f, 1.15f);
        pathBuilder.lineToRelative(2.43f, -4.2f);
        pathBuilder.reflectiveCurveToRelative(-0.14f, -0.12f, -0.33f, -0.26f);
        pathBuilder.lineToRelative(-2.11f, -1.66f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 15.5f);
        pathBuilder.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        pathBuilder.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilder.reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f);
        pathBuilder.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _settings = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
