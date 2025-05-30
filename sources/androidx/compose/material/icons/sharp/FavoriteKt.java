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
public final class FavoriteKt {

    @Nullable
    private static ImageVector _favorite;

    @NotNull
    public static final ImageVector getFavorite(@NotNull Icons$Sharp icons$Sharp) {
        ImageVector.Builder m1327addPathoIyEayM;
        Intrinsics.checkNotNullParameter(icons$Sharp, "<this>");
        ImageVector imageVector = _favorite;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Favorite", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1074getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int m1208getButtKaPHkGw = StrokeCap.Companion.m1208getButtKaPHkGw();
        int m1211getBevelLxFBmk8 = StrokeJoin.Companion.m1211getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 21.35f);
        pathBuilder.lineToRelative(-1.45f, -1.32f);
        pathBuilder.curveTo(5.4f, 15.36f, 2.0f, 12.28f, 2.0f, 8.5f);
        pathBuilder.curveTo(2.0f, 5.42f, 4.42f, 3.0f, 7.5f, 3.0f);
        pathBuilder.curveToRelative(1.74f, 0.0f, 3.41f, 0.81f, 4.5f, 2.09f);
        pathBuilder.curveTo(13.09f, 3.81f, 14.76f, 3.0f, 16.5f, 3.0f);
        pathBuilder.curveTo(19.58f, 3.0f, 22.0f, 5.42f, 22.0f, 8.5f);
        pathBuilder.curveToRelative(0.0f, 3.78f, -3.4f, 6.86f, -8.55f, 11.54f);
        pathBuilder.lineTo(12.0f, 21.35f);
        pathBuilder.close();
        m1327addPathoIyEayM = builder.m1327addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m1208getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m1211getBevelLxFBmk8, (r30 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : 0.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) == 0 ? 0.0f : 1.0f, (r30 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1327addPathoIyEayM.build();
        _favorite = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
