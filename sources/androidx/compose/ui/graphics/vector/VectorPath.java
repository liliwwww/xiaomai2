package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class VectorPath extends VectorNode {

    @Nullable
    private final Brush fill;
    private final float fillAlpha;

    @NotNull
    private final String name;

    @NotNull
    private final List<PathNode> pathData;
    private final int pathFillType;

    @Nullable
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;

    public /* synthetic */ VectorPath(String str, List list, int i, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, list, i, (i4 & 8) != 0 ? null : brush, (i4 & 16) != 0 ? 1.0f : f, (i4 & 32) != 0 ? null : brush2, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? 0.0f : f3, (i4 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2, (i4 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3, (i4 & 1024) != 0 ? 4.0f : f4, (i4 & 2048) != 0 ? 0.0f : f5, (i4 & 4096) != 0 ? 1.0f : f6, (i4 & 8192) != 0 ? 0.0f : f7, null);
    }

    public /* synthetic */ VectorPath(String str, List list, int i, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i, brush, f, brush2, f2, f3, i2, i3, f4, f5, f6, f7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(VectorPath.class), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        VectorPath vectorPath = (VectorPath) obj;
        if (!Intrinsics.areEqual(this.name, vectorPath.name) || !Intrinsics.areEqual(this.fill, vectorPath.fill)) {
            return false;
        }
        if (!(this.fillAlpha == vectorPath.fillAlpha) || !Intrinsics.areEqual(this.stroke, vectorPath.stroke)) {
            return false;
        }
        if (!(this.strokeAlpha == vectorPath.strokeAlpha)) {
            return false;
        }
        if (!(this.strokeLineWidth == vectorPath.strokeLineWidth) || !StrokeCap.m1247equalsimpl0(this.strokeLineCap, vectorPath.strokeLineCap) || !StrokeJoin.m1254equalsimpl0(this.strokeLineJoin, vectorPath.strokeLineJoin)) {
            return false;
        }
        if (!(this.strokeLineMiter == vectorPath.strokeLineMiter)) {
            return false;
        }
        if (!(this.trimPathStart == vectorPath.trimPathStart)) {
            return false;
        }
        if (this.trimPathEnd == vectorPath.trimPathEnd) {
            return ((this.trimPathOffset > vectorPath.trimPathOffset ? 1 : (this.trimPathOffset == vectorPath.trimPathOffset ? 0 : -1)) == 0) && PathFillType.equals-impl0(this.pathFillType, vectorPath.pathFillType) && Intrinsics.areEqual(this.pathData, vectorPath.pathData);
        }
        return false;
    }

    @Nullable
    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* renamed from: getPathFillType-Rg-k1Os, reason: not valid java name */
    public final int m1363getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    @Nullable
    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    /* renamed from: getStrokeLineCap-KaPHkGw, reason: not valid java name */
    public final int m1364getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name */
    public final int m1365getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.pathData.hashCode()) * 31;
        Brush brush = this.fill;
        int hashCode2 = (((hashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fillAlpha)) * 31;
        Brush brush2 = this.stroke;
        return ((((((((((((((((((hashCode2 + (brush2 != null ? brush2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.strokeAlpha)) * 31) + Float.floatToIntBits(this.strokeLineWidth)) * 31) + StrokeCap.m1248hashCodeimpl(this.strokeLineCap)) * 31) + StrokeJoin.m1255hashCodeimpl(this.strokeLineJoin)) * 31) + Float.floatToIntBits(this.strokeLineMiter)) * 31) + Float.floatToIntBits(this.trimPathStart)) * 31) + Float.floatToIntBits(this.trimPathEnd)) * 31) + Float.floatToIntBits(this.trimPathOffset)) * 31) + PathFillType.hashCode-impl(this.pathFillType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VectorPath(String str, List<? extends PathNode> list, int i, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7) {
        super((DefaultConstructorMarker) null);
        this.name = str;
        this.pathData = list;
        this.pathFillType = i;
        this.fill = brush;
        this.fillAlpha = f;
        this.stroke = brush2;
        this.strokeAlpha = f2;
        this.strokeLineWidth = f3;
        this.strokeLineCap = i2;
        this.strokeLineJoin = i3;
        this.strokeLineMiter = f4;
        this.trimPathStart = f5;
        this.trimPathEnd = f6;
        this.trimPathOffset = f7;
    }
}
