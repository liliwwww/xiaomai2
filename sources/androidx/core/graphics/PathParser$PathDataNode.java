package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PathParser$PathDataNode {
    public float[] mParams;
    public char mType;

    PathParser$PathDataNode(char c, float[] fArr) {
        this.mType = c;
        this.mParams = fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        char c3 = c2;
        float f9 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        switch (c3) {
            case 'A':
            case 'a':
                i = 7;
                break;
            case 'C':
            case 'c':
                i = 6;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i = 1;
                break;
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't':
            default:
                i = 2;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i = 4;
                break;
            case 'Z':
            case 'z':
                path.close();
                path.moveTo(f13, f14);
                f9 = f13;
                f11 = f9;
                f10 = f14;
                f12 = f10;
                i = 2;
                break;
        }
        float f15 = f9;
        float f16 = f10;
        float f17 = f13;
        float f18 = f14;
        int i3 = 0;
        char c4 = c;
        while (i3 < fArr2.length) {
            if (c3 != 'A') {
                if (c3 == 'C') {
                    i2 = i3;
                    int i4 = i2 + 2;
                    int i5 = i2 + 3;
                    int i6 = i2 + 4;
                    int i7 = i2 + 5;
                    path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                    f15 = fArr2[i6];
                    float f19 = fArr2[i7];
                    float f20 = fArr2[i4];
                    float f21 = fArr2[i5];
                    f16 = f19;
                    f12 = f21;
                    f11 = f20;
                } else if (c3 == 'H') {
                    i2 = i3;
                    int i8 = i2 + 0;
                    path.lineTo(fArr2[i8], f16);
                    f15 = fArr2[i8];
                } else if (c3 == 'Q') {
                    i2 = i3;
                    int i9 = i2 + 0;
                    int i10 = i2 + 1;
                    int i11 = i2 + 2;
                    int i12 = i2 + 3;
                    path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                    float f22 = fArr2[i9];
                    float f23 = fArr2[i10];
                    f15 = fArr2[i11];
                    f16 = fArr2[i12];
                    f11 = f22;
                    f12 = f23;
                } else if (c3 == 'V') {
                    i2 = i3;
                    int i13 = i2 + 0;
                    path.lineTo(f15, fArr2[i13]);
                    f16 = fArr2[i13];
                } else if (c3 != 'a') {
                    if (c3 != 'c') {
                        if (c3 == 'h') {
                            int i14 = i3 + 0;
                            path.rLineTo(fArr2[i14], 0.0f);
                            f15 += fArr2[i14];
                        } else if (c3 != 'q') {
                            if (c3 == 'v') {
                                int i15 = i3 + 0;
                                path.rLineTo(0.0f, fArr2[i15]);
                                f4 = fArr2[i15];
                            } else if (c3 == 'L') {
                                int i16 = i3 + 0;
                                int i17 = i3 + 1;
                                path.lineTo(fArr2[i16], fArr2[i17]);
                                f15 = fArr2[i16];
                                f16 = fArr2[i17];
                            } else if (c3 == 'M') {
                                int i18 = i3 + 0;
                                f15 = fArr2[i18];
                                int i19 = i3 + 1;
                                f16 = fArr2[i19];
                                if (i3 > 0) {
                                    path.lineTo(fArr2[i18], fArr2[i19]);
                                } else {
                                    path.moveTo(fArr2[i18], fArr2[i19]);
                                    i2 = i3;
                                    f18 = f16;
                                    f17 = f15;
                                }
                            } else if (c3 == 'S') {
                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                    f15 = (f15 * 2.0f) - f11;
                                    f16 = (f16 * 2.0f) - f12;
                                }
                                float f24 = f16;
                                int i20 = i3 + 0;
                                int i21 = i3 + 1;
                                int i22 = i3 + 2;
                                int i23 = i3 + 3;
                                path.cubicTo(f15, f24, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                f = fArr2[i20];
                                f2 = fArr2[i21];
                                f15 = fArr2[i22];
                                f16 = fArr2[i23];
                                f11 = f;
                                f12 = f2;
                            } else if (c3 == 'T') {
                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                    f15 = (f15 * 2.0f) - f11;
                                    f16 = (f16 * 2.0f) - f12;
                                }
                                int i24 = i3 + 0;
                                int i25 = i3 + 1;
                                path.quadTo(f15, f16, fArr2[i24], fArr2[i25]);
                                float f25 = fArr2[i24];
                                float f26 = fArr2[i25];
                                i2 = i3;
                                f12 = f16;
                                f11 = f15;
                                f15 = f25;
                                f16 = f26;
                            } else if (c3 == 'l') {
                                int i26 = i3 + 0;
                                int i27 = i3 + 1;
                                path.rLineTo(fArr2[i26], fArr2[i27]);
                                f15 += fArr2[i26];
                                f4 = fArr2[i27];
                            } else if (c3 == 'm') {
                                int i28 = i3 + 0;
                                f15 += fArr2[i28];
                                int i29 = i3 + 1;
                                f16 += fArr2[i29];
                                if (i3 > 0) {
                                    path.rLineTo(fArr2[i28], fArr2[i29]);
                                } else {
                                    path.rMoveTo(fArr2[i28], fArr2[i29]);
                                    i2 = i3;
                                    f18 = f16;
                                    f17 = f15;
                                }
                            } else if (c3 == 's') {
                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                    float f27 = f15 - f11;
                                    f5 = f16 - f12;
                                    f6 = f27;
                                } else {
                                    f6 = 0.0f;
                                    f5 = 0.0f;
                                }
                                int i30 = i3 + 0;
                                int i31 = i3 + 1;
                                int i32 = i3 + 2;
                                int i33 = i3 + 3;
                                path.rCubicTo(f6, f5, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                f = fArr2[i30] + f15;
                                f2 = fArr2[i31] + f16;
                                f15 += fArr2[i32];
                                f3 = fArr2[i33];
                            } else if (c3 == 't') {
                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                    f7 = f15 - f11;
                                    f8 = f16 - f12;
                                } else {
                                    f8 = 0.0f;
                                    f7 = 0.0f;
                                }
                                int i34 = i3 + 0;
                                int i35 = i3 + 1;
                                path.rQuadTo(f7, f8, fArr2[i34], fArr2[i35]);
                                float f28 = f7 + f15;
                                float f29 = f8 + f16;
                                f15 += fArr2[i34];
                                f16 += fArr2[i35];
                                f12 = f29;
                                f11 = f28;
                            }
                            f16 += f4;
                        } else {
                            int i36 = i3 + 0;
                            int i37 = i3 + 1;
                            int i38 = i3 + 2;
                            int i39 = i3 + 3;
                            path.rQuadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                            f = fArr2[i36] + f15;
                            f2 = fArr2[i37] + f16;
                            f15 += fArr2[i38];
                            f3 = fArr2[i39];
                        }
                        i2 = i3;
                    } else {
                        int i40 = i3 + 2;
                        int i41 = i3 + 3;
                        int i42 = i3 + 4;
                        int i43 = i3 + 5;
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                        f = fArr2[i40] + f15;
                        f2 = fArr2[i41] + f16;
                        f15 += fArr2[i42];
                        f3 = fArr2[i43];
                    }
                    f16 += f3;
                    f11 = f;
                    f12 = f2;
                    i2 = i3;
                } else {
                    int i44 = i3 + 5;
                    int i45 = i3 + 6;
                    i2 = i3;
                    drawArc(path, f15, f16, fArr2[i44] + f15, fArr2[i45] + f16, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f15 += fArr2[i44];
                    f16 += fArr2[i45];
                }
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            } else {
                i2 = i3;
                int i46 = i2 + 5;
                int i47 = i2 + 6;
                drawArc(path, f15, f16, fArr2[i46], fArr2[i47], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                f15 = fArr2[i46];
                f16 = fArr2[i47];
            }
            f12 = f16;
            f11 = f15;
            i3 = i2 + i;
            c4 = c2;
            c3 = c4;
        }
        fArr[0] = f15;
        fArr[1] = f16;
        fArr[2] = f11;
        fArr[3] = f12;
        fArr[4] = f17;
        fArr[5] = f18;
    }

    private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d11 = -d10;
        double d12 = d11 * cos;
        double d13 = d4 * sin;
        double d14 = (d12 * sin2) - (d13 * cos2);
        double d15 = d11 * sin;
        double d16 = d4 * cos;
        double d17 = (sin2 * d15) + (cos2 * d16);
        double d18 = d9 / ceil;
        double d19 = d8;
        double d20 = d17;
        double d21 = d14;
        int i = 0;
        double d22 = d5;
        double d23 = d6;
        while (i < ceil) {
            double d24 = d19 + d18;
            double sin3 = Math.sin(d24);
            double cos3 = Math.cos(d24);
            double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
            double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
            double d27 = (d12 * sin3) - (d13 * cos3);
            double d28 = (sin3 * d15) + (cos3 * d16);
            double d29 = d24 - d19;
            double tan = Math.tan(d29 / 2.0d);
            double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
            double d30 = d22 + (d21 * sin4);
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
            i++;
            d18 = d18;
            sin = sin;
            d22 = d25;
            d15 = d15;
            cos = cos;
            d19 = d24;
            d20 = d28;
            d21 = d27;
            ceil = ceil;
            d23 = d26;
            d10 = d3;
        }
    }

    private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = f;
        double d4 = d3 * cos;
        double d5 = f2;
        double d6 = f5;
        double d7 = (d4 + (d5 * sin)) / d6;
        double d8 = ((-f) * sin) + (d5 * cos);
        double d9 = f6;
        double d10 = d8 / d9;
        double d11 = f4;
        double d12 = ((f3 * cos) + (d11 * sin)) / d6;
        double d13 = (((-f3) * sin) + (d11 * cos)) / d9;
        double d14 = d7 - d12;
        double d15 = d10 - d13;
        double d16 = (d7 + d12) / 2.0d;
        double d17 = (d10 + d13) / 2.0d;
        double d18 = (d14 * d14) + (d15 * d15);
        if (d18 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d19 = (1.0d / d18) - 0.25d;
        if (d19 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d18);
            float sqrt = (float) (Math.sqrt(d18) / 1.99999d);
            drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d19);
        double d20 = d14 * sqrt2;
        double d21 = sqrt2 * d15;
        if (z == z2) {
            d = d16 - d21;
            d2 = d17 + d20;
        } else {
            d = d16 + d21;
            d2 = d17 - d20;
        }
        double atan2 = Math.atan2(d10 - d2, d7 - d);
        double atan22 = Math.atan2(d13 - d2, d12 - d) - atan2;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d22 = d * d6;
        double d23 = d2 * d9;
        arcToBezier(path, (d22 * cos) - (d23 * sin), (d22 * sin) + (d23 * cos), d6, d9, d3, d5, radians, atan2, atan22);
    }

    public static void nodesToPath(PathParser$PathDataNode[] pathParser$PathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            addCommand(path, fArr, c, pathParser$PathDataNodeArr[i].mType, pathParser$PathDataNodeArr[i].mParams);
            c = pathParser$PathDataNodeArr[i].mType;
        }
    }

    public void interpolatePathDataNode(PathParser$PathDataNode pathParser$PathDataNode, PathParser$PathDataNode pathParser$PathDataNode2, float f) {
        this.mType = pathParser$PathDataNode.mType;
        int i = 0;
        while (true) {
            float[] fArr = pathParser$PathDataNode.mParams;
            if (i >= fArr.length) {
                return;
            }
            this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathParser$PathDataNode2.mParams[i] * f);
            i++;
        }
    }

    PathParser$PathDataNode(PathParser$PathDataNode pathParser$PathDataNode) {
        this.mType = pathParser$PathDataNode.mType;
        float[] fArr = pathParser$PathDataNode.mParams;
        this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
    }
}
