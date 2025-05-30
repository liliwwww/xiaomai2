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
public final class PlaceKt {

    @Nullable
    private static ImageVector _place;

    @NotNull
    public static final ImageVector getPlace(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _place;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Place", Dp.m2142constructorimpl(24.0f), Dp.m2142constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.Companion;
        SolidColor solidColor = new SolidColor(companion.getBlack-0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int i = companion2.getButt-KaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int i2 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(18.5f, 10.2f);
        pathBuilder.curveToRelative(0.0f, 2.57f, -2.1f, 5.79f, -6.16f, 9.51f);
        pathBuilder.lineTo(12.0f, 20.01f);
        pathBuilder.lineToRelative(-0.34f, -0.31f);
        pathBuilder.curveTo(7.6f, 15.99f, 5.5f, 12.77f, 5.5f, 10.2f);
        pathBuilder.curveToRelative(0.0f, -3.84f, 2.82f, -6.7f, 6.5f, -6.7f);
        pathBuilder.reflectiveCurveTo(18.5f, 6.35f, 18.5f, 10.2f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.getBlack-0d7_KjU(), null);
        int i3 = companion2.getButt-KaPHkGw();
        int i4 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(12.0f, 2.0f);
        pathBuilder2.curveToRelative(4.2f, 0.0f, 8.0f, 3.22f, 8.0f, 8.2f);
        pathBuilder2.curveToRelative(0.0f, 3.32f, -2.67f, 7.25f, -8.0f, 11.8f);
        pathBuilder2.curveToRelative(-5.33f, -4.55f, -8.0f, -8.48f, -8.0f, -11.8f);
        pathBuilder2.curveTo(4.0f, 5.22f, 7.8f, 2.0f, 12.0f, 2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(18.0f, 10.2f);
        pathBuilder2.curveTo(18.0f, 6.57f, 15.35f, 4.0f, 12.0f, 4.0f);
        pathBuilder2.reflectiveCurveToRelative(-6.0f, 2.57f, -6.0f, 6.2f);
        pathBuilder2.curveToRelative(0.0f, 2.34f, 1.95f, 5.44f, 6.0f, 9.14f);
        pathBuilder2.curveTo(16.05f, 15.64f, 18.0f, 12.54f, 18.0f, 10.2f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 12.0f);
        pathBuilder2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder2.reflectiveCurveTo(13.1f, 12.0f, 12.0f, 12.0f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i3, i4, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _place = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
