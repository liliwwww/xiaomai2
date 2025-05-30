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
public final class RefreshKt {

    @Nullable
    private static ImageVector _refresh;

    @NotNull
    public static final ImageVector getRefresh(@NotNull Icons$Sharp icons$Sharp) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(icons$Sharp, "<this>");
        ImageVector imageVector = _refresh;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Refresh", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw = StrokeCap.Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk8 = StrokeJoin.Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.65f, 6.35f);
        pathBuilder.curveTo(16.2f, 4.9f, 14.21f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveToRelative(-4.42f, 0.0f, -7.99f, 3.58f, -7.99f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(3.57f, 8.0f, 7.99f, 8.0f);
        pathBuilder.curveToRelative(3.73f, 0.0f, 6.84f, -2.55f, 7.73f, -6.0f);
        pathBuilder.horizontalLineToRelative(-2.08f);
        pathBuilder.curveToRelative(-0.82f, 2.33f, -3.04f, 4.0f, -5.65f, 4.0f);
        pathBuilder.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
        pathBuilder.reflectiveCurveToRelative(2.69f, -6.0f, 6.0f, -6.0f);
        pathBuilder.curveToRelative(1.66f, 0.0f, 3.14f, 0.69f, 4.22f, 1.78f);
        pathBuilder.lineTo(13.0f, 11.0f);
        pathBuilder.horizontalLineToRelative(7.0f);
        pathBuilder.verticalLineTo(4.0f);
        pathBuilder.lineToRelative(-2.35f, 2.35f);
        pathBuilder.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _refresh = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
