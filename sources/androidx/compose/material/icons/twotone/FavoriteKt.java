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
public final class FavoriteKt {

    @Nullable
    private static ImageVector _favorite;

    @NotNull
    public static final ImageVector getFavorite(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _favorite;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Favorite", Dp.m2142constructorimpl(24.0f), Dp.m2142constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.Companion;
        SolidColor solidColor = new SolidColor(companion.getBlack-0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int i = companion2.getButt-KaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int i2 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(16.5f, 5.0f);
        pathBuilder.curveToRelative(-1.54f, 0.0f, -3.04f, 0.99f, -3.56f, 2.36f);
        pathBuilder.horizontalLineToRelative(-1.87f);
        pathBuilder.curveTo(10.54f, 5.99f, 9.04f, 5.0f, 7.5f, 5.0f);
        pathBuilder.curveTo(5.5f, 5.0f, 4.0f, 6.5f, 4.0f, 8.5f);
        pathBuilder.curveToRelative(0.0f, 2.89f, 3.14f, 5.74f, 7.9f, 10.05f);
        pathBuilder.lineToRelative(0.1f, 0.1f);
        pathBuilder.lineToRelative(0.1f, -0.1f);
        pathBuilder.curveTo(16.86f, 14.24f, 20.0f, 11.39f, 20.0f, 8.5f);
        pathBuilder.curveToRelative(0.0f, -2.0f, -1.5f, -3.5f, -3.5f, -3.5f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.getBlack-0d7_KjU(), null);
        int i3 = companion2.getButt-KaPHkGw();
        int i4 = companion3.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(16.5f, 3.0f);
        pathBuilder2.curveToRelative(-1.74f, 0.0f, -3.41f, 0.81f, -4.5f, 2.09f);
        pathBuilder2.curveTo(10.91f, 3.81f, 9.24f, 3.0f, 7.5f, 3.0f);
        pathBuilder2.curveTo(4.42f, 3.0f, 2.0f, 5.42f, 2.0f, 8.5f);
        pathBuilder2.curveToRelative(0.0f, 3.78f, 3.4f, 6.86f, 8.55f, 11.54f);
        pathBuilder2.lineTo(12.0f, 21.35f);
        pathBuilder2.lineToRelative(1.45f, -1.32f);
        pathBuilder2.curveTo(18.6f, 15.36f, 22.0f, 12.28f, 22.0f, 8.5f);
        pathBuilder2.curveTo(22.0f, 5.42f, 19.58f, 3.0f, 16.5f, 3.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.1f, 18.55f);
        pathBuilder2.lineToRelative(-0.1f, 0.1f);
        pathBuilder2.lineToRelative(-0.1f, -0.1f);
        pathBuilder2.curveTo(7.14f, 14.24f, 4.0f, 11.39f, 4.0f, 8.5f);
        pathBuilder2.curveTo(4.0f, 6.5f, 5.5f, 5.0f, 7.5f, 5.0f);
        pathBuilder2.curveToRelative(1.54f, 0.0f, 3.04f, 0.99f, 3.57f, 2.36f);
        pathBuilder2.horizontalLineToRelative(1.87f);
        pathBuilder2.curveTo(13.46f, 5.99f, 14.96f, 5.0f, 16.5f, 5.0f);
        pathBuilder2.curveToRelative(2.0f, 0.0f, 3.5f, 1.5f, 3.5f, 3.5f);
        pathBuilder2.curveToRelative(0.0f, 2.89f, -3.14f, 5.74f, -7.9f, 10.05f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i3, i4, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _favorite = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
