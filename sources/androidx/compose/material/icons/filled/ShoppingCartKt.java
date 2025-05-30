package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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
public final class ShoppingCartKt {

    @Nullable
    private static ImageVector _shoppingCart;

    @NotNull
    public static final ImageVector getShoppingCart(@NotNull Icons$Filled icons$Filled) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(icons$Filled, "<this>");
        ImageVector imageVector = _shoppingCart;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ShoppingCart", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw = StrokeCap.Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk8 = StrokeJoin.Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(7.0f, 18.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        pathBuilder.reflectiveCurveTo(5.9f, 22.0f, 7.0f, 22.0f);
        pathBuilder.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(1.0f, 2.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.lineToRelative(3.6f, 7.59f);
        pathBuilder.lineToRelative(-1.35f, 2.45f);
        pathBuilder.curveToRelative(-0.16f, 0.28f, -0.25f, 0.61f, -0.25f, 0.96f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(12.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.lineTo(7.42f, 15.0f);
        pathBuilder.curveToRelative(-0.14f, 0.0f, -0.25f, -0.11f, -0.25f, -0.25f);
        pathBuilder.lineToRelative(0.03f, -0.12f);
        pathBuilder.lineToRelative(0.9f, -1.63f);
        pathBuilder.horizontalLineToRelative(7.45f);
        pathBuilder.curveToRelative(0.75f, 0.0f, 1.41f, -0.41f, 1.75f, -1.03f);
        pathBuilder.lineToRelative(3.58f, -6.49f);
        pathBuilder.curveToRelative(0.08f, -0.14f, 0.12f, -0.31f, 0.12f, -0.48f);
        pathBuilder.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        pathBuilder.lineTo(5.21f, 4.0f);
        pathBuilder.lineToRelative(-0.94f, -2.0f);
        pathBuilder.lineTo(1.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(17.0f, 18.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(0.89f, 2.0f, 1.99f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _shoppingCart = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
