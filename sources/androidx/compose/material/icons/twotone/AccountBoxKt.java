package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color$Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap$Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin$Companion;
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
public final class AccountBoxKt {

    @Nullable
    private static ImageVector _accountBox;

    @NotNull
    public static final ImageVector getAccountBox(@NotNull Icons.TwoTone twoTone) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _accountBox;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.AccountBox", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color$Companion color$Companion = Color.Companion;
        SolidColor solidColor = new SolidColor(color$Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        StrokeCap$Companion strokeCap$Companion = StrokeCap.Companion;
        int m1208getButtKaPHkGw = strokeCap$Companion.m1208getButtKaPHkGw();
        StrokeJoin$Companion strokeJoin$Companion = StrokeJoin.Companion;
        int m1211getBevelLxFBmk8 = strokeJoin$Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(5.0f, 17.86f);
        pathBuilder.curveTo(6.8f, 16.09f, 9.27f, 15.0f, 12.0f, 15.0f);
        pathBuilder.reflectiveCurveToRelative(5.2f, 1.09f, 7.0f, 2.86f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.verticalLineTo(17.86f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 6.0f);
        pathBuilder.curveToRelative(1.93f, 0.0f, 3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilder.reflectiveCurveTo(13.93f, 13.0f, 12.0f, 13.0f);
        pathBuilder.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder.reflectiveCurveTo(10.07f, 6.0f, 12.0f, 6.0f);
        pathBuilder.close();
        builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(color$Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw2 = strokeCap$Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk82 = strokeJoin$Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(19.0f, 3.0f);
        pathBuilder2.horizontalLineTo(5.0f);
        pathBuilder2.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        pathBuilder2.verticalLineToRelative(14.0f);
        pathBuilder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder2.horizontalLineToRelative(14.0f);
        pathBuilder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.verticalLineTo(5.0f);
        pathBuilder2.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.0f, 19.0f);
        pathBuilder2.horizontalLineTo(7.0f);
        pathBuilder2.verticalLineToRelative(-0.24f);
        pathBuilder2.curveTo(8.42f, 17.62f, 10.16f, 17.0f, 12.0f, 17.0f);
        pathBuilder2.reflectiveCurveToRelative(3.58f, 0.62f, 5.0f, 1.76f);
        pathBuilder2.verticalLineTo(19.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(19.0f, 17.86f);
        pathBuilder2.curveTo(17.2f, 16.09f, 14.73f, 15.0f, 12.0f, 15.0f);
        pathBuilder2.reflectiveCurveToRelative(-5.2f, 1.09f, -7.0f, 2.86f);
        pathBuilder2.verticalLineTo(5.0f);
        pathBuilder2.horizontalLineToRelative(14.0f);
        pathBuilder2.verticalLineTo(17.86f);
        pathBuilder2.close();
        builder.m1327addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk82, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = new SolidColor(color$Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw3 = strokeCap$Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk83 = strokeJoin$Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 13.0f);
        pathBuilder3.curveToRelative(1.93f, 0.0f, 3.5f, -1.57f, 3.5f, -3.5f);
        pathBuilder3.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        pathBuilder3.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        pathBuilder3.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 8.0f);
        pathBuilder3.curveToRelative(0.83f, 0.0f, 1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder3.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        pathBuilder3.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder3.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        pathBuilder3.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk83, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _accountBox = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
