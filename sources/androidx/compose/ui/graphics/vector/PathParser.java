package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathParser {

    @NotNull
    private final List<PathNode> nodes = new ArrayList();

    @NotNull
    private final PathPoint currentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    @NotNull
    private final PathPoint ctrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    @NotNull
    private final PathPoint segmentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    @NotNull
    private final PathPoint reflectiveCtrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    private final void addNode(char c, float[] fArr) {
        this.nodes.addAll(PathNodeKt.toPathNodes(c, fArr));
    }

    private final void arcTo(PathNode$ArcTo pathNode$ArcTo, Path path) {
        drawArc(path, this.currentPoint.getX(), this.currentPoint.getY(), pathNode$ArcTo.getArcStartX(), pathNode$ArcTo.getArcStartY(), pathNode$ArcTo.getHorizontalEllipseRadius(), pathNode$ArcTo.getVerticalEllipseRadius(), pathNode$ArcTo.getTheta(), pathNode$ArcTo.isMoreThanHalf(), pathNode$ArcTo.isPositiveArc());
        this.currentPoint.setX(pathNode$ArcTo.getArcStartX());
        this.currentPoint.setY(pathNode$ArcTo.getArcStartY());
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = 4;
        int ceil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * cos;
        double d14 = d4 * sin;
        double d15 = (d13 * sin2) - (d14 * cos2);
        double d16 = d12 * sin;
        double d17 = d4 * cos;
        double d18 = (sin2 * d16) + (cos2 * d17);
        double d19 = d9 / ceil;
        double d20 = d5;
        double d21 = d8;
        double d22 = d18;
        double d23 = d15;
        int i = 0;
        double d24 = d6;
        while (i < ceil) {
            double d25 = d21 + d19;
            double sin3 = Math.sin(d25);
            double cos3 = Math.cos(d25);
            int i2 = ceil;
            double d26 = (d + ((d10 * cos) * cos3)) - (d14 * sin3);
            double d27 = d2 + (d10 * sin * cos3) + (d17 * sin3);
            double d28 = (d13 * sin3) - (d14 * cos3);
            double d29 = (sin3 * d16) + (cos3 * d17);
            double d30 = d25 - d21;
            double tan = Math.tan(d30 / 2);
            double sin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * tan) * tan)) - 1)) / 3;
            path.cubicTo((float) (d20 + (d23 * sin4)), (float) (d24 + (d22 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            sin = sin;
            d20 = d26;
            d16 = d16;
            d21 = d25;
            d22 = d29;
            d11 = d11;
            d23 = d28;
            cos = cos;
            ceil = i2;
            d24 = d27;
            d10 = d3;
        }
    }

    private final void close(Path path) {
        this.currentPoint.setX(this.segmentPoint.getX());
        this.currentPoint.setY(this.segmentPoint.getY());
        this.ctrlPoint.setX(this.segmentPoint.getX());
        this.ctrlPoint.setY(this.segmentPoint.getY());
        path.close();
        path.moveTo(this.currentPoint.getX(), this.currentPoint.getY());
    }

    private final float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        ArraysKt.copyInto(fArr, fArr2, 0, i, min + i);
        return fArr2;
    }

    private final void curveTo(PathNode$CurveTo pathNode$CurveTo, Path path) {
        path.cubicTo(pathNode$CurveTo.getX1(), pathNode$CurveTo.getY1(), pathNode$CurveTo.getX2(), pathNode$CurveTo.getY2(), pathNode$CurveTo.getX3(), pathNode$CurveTo.getY3());
        this.ctrlPoint.setX(pathNode$CurveTo.getX2());
        this.ctrlPoint.setY(pathNode$CurveTo.getY2());
        this.currentPoint.setX(pathNode$CurveTo.getX3());
        this.currentPoint.setY(pathNode$CurveTo.getY3());
    }

    private final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double radians = toRadians(d7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d10 = ((d * cos) + (d2 * sin)) / d5;
        double d11 = (((-d) * sin) + (d2 * cos)) / d6;
        double d12 = ((d3 * cos) + (d4 * sin)) / d5;
        double d13 = (((-d3) * sin) + (d4 * cos)) / d6;
        double d14 = d10 - d12;
        double d15 = d11 - d13;
        double d16 = 2;
        double d17 = (d10 + d12) / d16;
        double d18 = (d11 + d13) / d16;
        double d19 = (d14 * d14) + (d15 * d15);
        if (d19 == 0.0d) {
            return;
        }
        double d20 = (1.0d / d19) - 0.25d;
        if (d20 < 0.0d) {
            double sqrt = (float) (Math.sqrt(d19) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d20);
        double d21 = d14 * sqrt2;
        double d22 = sqrt2 * d15;
        if (z == z2) {
            d8 = d17 - d22;
            d9 = d18 + d21;
        } else {
            d8 = d17 + d22;
            d9 = d18 - d21;
        }
        double atan2 = Math.atan2(d11 - d9, d10 - d8);
        double atan22 = Math.atan2(d13 - d9, d12 - d8) - atan2;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d23 = d8 * d5;
        double d24 = d9 * d6;
        arcToBezier(path, (d23 * cos) - (d24 * sin), (d23 * sin) + (d24 * cos), d5, d6, d, d2, radians, atan2, atan22);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051 A[LOOP:0: B:2:0x0008->B:10:0x0051, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0054 A[EDGE_INSN: B:11:0x0054->B:12:0x0054 BREAK  A[LOOP:0: B:2:0x0008->B:10:0x0051], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void extract(java.lang.String r9, int r10, androidx.compose.ui.graphics.vector.PathParser.ExtractFloatResult r11) {
        /*
            r8 = this;
            r0 = 0
            r11.setEndWithNegativeOrDot(r0)
            r1 = r10
            r2 = 0
            r3 = 0
            r4 = 0
        L8:
            int r5 = r9.length()
            if (r1 >= r5) goto L54
            char r5 = r9.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 != r6) goto L19
        L17:
            r6 = 1
            goto L1f
        L19:
            r6 = 44
            if (r5 != r6) goto L1e
            goto L17
        L1e:
            r6 = 0
        L1f:
            if (r6 == 0) goto L24
        L21:
            r2 = 0
            r4 = 1
            goto L4e
        L24:
            r6 = 45
            if (r5 != r6) goto L30
            if (r1 == r10) goto L4d
            if (r2 != 0) goto L4d
            r11.setEndWithNegativeOrDot(r7)
            goto L21
        L30:
            r2 = 46
            if (r5 != r2) goto L3d
            if (r3 != 0) goto L39
            r2 = 0
            r3 = 1
            goto L4e
        L39:
            r11.setEndWithNegativeOrDot(r7)
            goto L21
        L3d:
            r2 = 101(0x65, float:1.42E-43)
            if (r5 != r2) goto L43
        L41:
            r2 = 1
            goto L49
        L43:
            r2 = 69
            if (r5 != r2) goto L48
            goto L41
        L48:
            r2 = 0
        L49:
            if (r2 == 0) goto L4d
            r2 = 1
            goto L4e
        L4d:
            r2 = 0
        L4e:
            if (r4 == 0) goto L51
            goto L54
        L51:
            int r1 = r1 + 1
            goto L8
        L54:
            r11.setEndPosition(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser.extract(java.lang.String, int, androidx.compose.ui.graphics.vector.PathParser$ExtractFloatResult):void");
    }

    private final float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        float[] fArr = new float[str.length()];
        ExtractFloatResult extractFloatResult = new ExtractFloatResult(0, false, 3, (DefaultConstructorMarker) null);
        int length = str.length();
        int i = 1;
        int i2 = 0;
        while (i < length) {
            extract(str, i, extractFloatResult);
            int endPosition = extractFloatResult.getEndPosition();
            if (i < endPosition) {
                String substring = str.substring(i, endPosition);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                fArr[i2] = Float.parseFloat(substring);
                i2++;
            }
            i = extractFloatResult.getEndWithNegativeOrDot() ? endPosition : endPosition + 1;
        }
        return copyOfRange(fArr, 0, i2);
    }

    private final void horizontalTo(PathNode.HorizontalTo horizontalTo, Path path) {
        path.lineTo(horizontalTo.getX(), this.currentPoint.getY());
        this.currentPoint.setX(horizontalTo.getX());
    }

    private final void lineTo(PathNode$LineTo pathNode$LineTo, Path path) {
        path.lineTo(pathNode$LineTo.getX(), pathNode$LineTo.getY());
        this.currentPoint.setX(pathNode$LineTo.getX());
        this.currentPoint.setY(pathNode$LineTo.getY());
    }

    private final void moveTo(PathNode.MoveTo moveTo, Path path) {
        this.currentPoint.setX(moveTo.getX());
        this.currentPoint.setY(moveTo.getY());
        path.moveTo(moveTo.getX(), moveTo.getY());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private final void quadTo(PathNode.QuadTo quadTo, Path path) {
        path.quadraticBezierTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
        this.ctrlPoint.setX(quadTo.getX1());
        this.ctrlPoint.setY(quadTo.getY1());
        this.currentPoint.setX(quadTo.getX2());
        this.currentPoint.setY(quadTo.getY2());
    }

    private final void reflectiveCurveTo(PathNode$ReflectiveCurveTo pathNode$ReflectiveCurveTo, boolean z, Path path) {
        if (z) {
            float f = 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.cubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), pathNode$ReflectiveCurveTo.getX1(), pathNode$ReflectiveCurveTo.getY1(), pathNode$ReflectiveCurveTo.getX2(), pathNode$ReflectiveCurveTo.getY2());
        this.ctrlPoint.setX(pathNode$ReflectiveCurveTo.getX1());
        this.ctrlPoint.setY(pathNode$ReflectiveCurveTo.getY1());
        this.currentPoint.setX(pathNode$ReflectiveCurveTo.getX2());
        this.currentPoint.setY(pathNode$ReflectiveCurveTo.getY2());
    }

    private final void reflectiveQuadTo(PathNode.ReflectiveQuadTo reflectiveQuadTo, boolean z, Path path) {
        if (z) {
            float f = 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.quadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
        this.ctrlPoint.setX(this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.reflectiveCtrlPoint.getY());
        this.currentPoint.setX(reflectiveQuadTo.getX());
        this.currentPoint.setY(reflectiveQuadTo.getY());
    }

    private final void relativeArcTo(PathNode$RelativeArcTo pathNode$RelativeArcTo, Path path) {
        float arcStartDx = pathNode$RelativeArcTo.getArcStartDx() + this.currentPoint.getX();
        float arcStartDy = pathNode$RelativeArcTo.getArcStartDy() + this.currentPoint.getY();
        drawArc(path, this.currentPoint.getX(), this.currentPoint.getY(), arcStartDx, arcStartDy, pathNode$RelativeArcTo.getHorizontalEllipseRadius(), pathNode$RelativeArcTo.getVerticalEllipseRadius(), pathNode$RelativeArcTo.getTheta(), pathNode$RelativeArcTo.isMoreThanHalf(), pathNode$RelativeArcTo.isPositiveArc());
        this.currentPoint.setX(arcStartDx);
        this.currentPoint.setY(arcStartDy);
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void relativeCurveTo(PathNode$RelativeCurveTo pathNode$RelativeCurveTo, Path path) {
        path.relativeCubicTo(pathNode$RelativeCurveTo.getDx1(), pathNode$RelativeCurveTo.getDy1(), pathNode$RelativeCurveTo.getDx2(), pathNode$RelativeCurveTo.getDy2(), pathNode$RelativeCurveTo.getDx3(), pathNode$RelativeCurveTo.getDy3());
        this.ctrlPoint.setX(this.currentPoint.getX() + pathNode$RelativeCurveTo.getDx2());
        this.ctrlPoint.setY(this.currentPoint.getY() + pathNode$RelativeCurveTo.getDy2());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeCurveTo.getDx3());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + pathNode$RelativeCurveTo.getDy3());
    }

    private final void relativeHorizontalTo(PathNode$RelativeHorizontalTo pathNode$RelativeHorizontalTo, Path path) {
        path.relativeLineTo(pathNode$RelativeHorizontalTo.getDx(), 0.0f);
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeHorizontalTo.getDx());
    }

    private final void relativeLineTo(PathNode$RelativeLineTo pathNode$RelativeLineTo, Path path) {
        path.relativeLineTo(pathNode$RelativeLineTo.getDx(), pathNode$RelativeLineTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeLineTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + pathNode$RelativeLineTo.getDy());
    }

    private final void relativeMoveTo(PathNode$RelativeMoveTo pathNode$RelativeMoveTo, Path path) {
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeMoveTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + pathNode$RelativeMoveTo.getDy());
        path.relativeMoveTo(pathNode$RelativeMoveTo.getDx(), pathNode$RelativeMoveTo.getDy());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final void relativeQuadTo(PathNode$RelativeQuadTo pathNode$RelativeQuadTo, Path path) {
        path.relativeQuadraticBezierTo(pathNode$RelativeQuadTo.getDx1(), pathNode$RelativeQuadTo.getDy1(), pathNode$RelativeQuadTo.getDx2(), pathNode$RelativeQuadTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + pathNode$RelativeQuadTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + pathNode$RelativeQuadTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeQuadTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + pathNode$RelativeQuadTo.getDy2());
    }

    private final void relativeReflectiveCurveTo(PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo, boolean z, Path path) {
        if (z) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeCubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeReflectiveCurveTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeReflectiveCurveTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeReflectiveCurveTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeReflectiveCurveTo.getDy2());
    }

    private final void relativeReflectiveQuadTo(PathNode$RelativeReflectiveQuadTo pathNode$RelativeReflectiveQuadTo, boolean z, Path path) {
        if (z) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeQuadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), pathNode$RelativeReflectiveQuadTo.getDx(), pathNode$RelativeReflectiveQuadTo.getDy());
        this.ctrlPoint.setX(this.currentPoint.getX() + this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY() + this.reflectiveCtrlPoint.getY());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + pathNode$RelativeReflectiveQuadTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + pathNode$RelativeReflectiveQuadTo.getDy());
    }

    private final void relativeVerticalTo(PathNode$RelativeVerticalTo pathNode$RelativeVerticalTo, Path path) {
        path.relativeLineTo(0.0f, pathNode$RelativeVerticalTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setY(pathPoint.getY() + pathNode$RelativeVerticalTo.getDy());
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    private final double toRadians(double d) {
        return (d / 180) * 3.141592653589793d;
    }

    private final float toRadians(float f) {
        return (f / 180.0f) * 3.1415927f;
    }

    private final void verticalTo(PathNode$VerticalTo pathNode$VerticalTo, Path path) {
        path.lineTo(this.currentPoint.getX(), pathNode$VerticalTo.getY());
        this.currentPoint.setY(pathNode$VerticalTo.getY());
    }

    @NotNull
    public final PathParser addPathNodes(@NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        this.nodes.addAll(list);
        return this;
    }

    public final void clear() {
        this.nodes.clear();
    }

    @NotNull
    public final PathParser parsePathString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "pathData");
        this.nodes.clear();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String substring = str.substring(i2, nextStart);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int length = substring.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = Intrinsics.compare(substring.charAt(!z ? i3 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            String obj = substring.subSequence(i3, length + 1).toString();
            if (obj.length() > 0) {
                addNode(obj.charAt(0), getFloats(obj));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(str.charAt(i2), new float[0]);
        }
        return this;
    }

    @NotNull
    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    @NotNull
    public final Path toPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, TypedValues.AttributesType.S_TARGET);
        path.reset();
        this.currentPoint.reset();
        this.ctrlPoint.reset();
        this.segmentPoint.reset();
        this.reflectiveCtrlPoint.reset();
        List<PathNode> list = this.nodes;
        int size = list.size();
        PathNode pathNode = null;
        int i = 0;
        while (i < size) {
            PathNode pathNode2 = list.get(i);
            if (pathNode == null) {
                pathNode = pathNode2;
            }
            if (pathNode2 instanceof PathNode$Close) {
                close(path);
            } else if (pathNode2 instanceof PathNode$RelativeMoveTo) {
                relativeMoveTo((PathNode$RelativeMoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.MoveTo) {
                moveTo((PathNode.MoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$RelativeLineTo) {
                relativeLineTo((PathNode$RelativeLineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$LineTo) {
                lineTo((PathNode$LineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$RelativeHorizontalTo) {
                relativeHorizontalTo((PathNode$RelativeHorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.HorizontalTo) {
                horizontalTo((PathNode.HorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$RelativeVerticalTo) {
                relativeVerticalTo((PathNode$RelativeVerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$VerticalTo) {
                verticalTo((PathNode$VerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$RelativeCurveTo) {
                relativeCurveTo((PathNode$RelativeCurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$CurveTo) {
                curveTo((PathNode$CurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveCurveTo((PathNode.RelativeReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode$ReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveCurveTo((PathNode$ReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode$RelativeQuadTo) {
                relativeQuadTo((PathNode$RelativeQuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.QuadTo) {
                quadTo((PathNode.QuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$RelativeReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveQuadTo((PathNode$RelativeReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveQuadTo((PathNode.ReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode$RelativeArcTo) {
                relativeArcTo((PathNode$RelativeArcTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode$ArcTo) {
                arcTo((PathNode$ArcTo) pathNode2, path);
            }
            i++;
            pathNode = pathNode2;
        }
        return path;
    }
}
