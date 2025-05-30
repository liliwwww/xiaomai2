package androidx.compose.p004ui.graphics.vector;

import androidx.compose.p004ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    private static final List<PathNode> pathNodesFromArgs(float[] fArr, int i, Function1<? super float[], ? extends PathNode> function1) {
        IntProgression step = RangesKt.step(new IntRange(0, fArr.length - i), i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step, 10));
        IntIterator it = step.iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            float[] copyOfRange = ArraysKt.copyOfRange(fArr, nextInt, nextInt + i);
            Object obj = (PathNode) function1.invoke(copyOfRange);
            if ((obj instanceof PathNode.MoveTo) && nextInt > 0) {
                obj = new PathNode.LineTo(copyOfRange[0], copyOfRange[1]);
            } else if ((obj instanceof PathNode.RelativeMoveTo) && nextInt > 0) {
                obj = new PathNode.RelativeLineTo(copyOfRange[0], copyOfRange[1]);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NotNull
    public static final List<PathNode> toPathNodes(char c, @NotNull float[] fArr) {
        ArrayList arrayList;
        char c2;
        boolean z;
        char c3;
        boolean z2;
        Intrinsics.checkNotNullParameter(fArr, "args");
        if (c == 'z' || c == 'Z') {
            return CollectionsKt.listOf(PathNode.Close.INSTANCE);
        }
        if (c == 'm') {
            IntProgression step = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step, 10));
            IntIterator it = step.iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                float[] copyOfRange = ArraysKt.copyOfRange(fArr, nextInt, nextInt + 2);
                PathNode relativeMoveTo = new PathNode.RelativeMoveTo(copyOfRange[0], copyOfRange[1]);
                if ((relativeMoveTo instanceof PathNode.MoveTo) && nextInt > 0) {
                    relativeMoveTo = new PathNode.LineTo(copyOfRange[0], copyOfRange[1]);
                } else if (nextInt > 0) {
                    relativeMoveTo = new PathNode.RelativeLineTo(copyOfRange[0], copyOfRange[1]);
                }
                arrayList.add(relativeMoveTo);
            }
        } else if (c == 'M') {
            IntProgression step2 = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step2, 10));
            IntIterator it2 = step2.iterator();
            while (it2.hasNext()) {
                int nextInt2 = it2.nextInt();
                float[] copyOfRange2 = ArraysKt.copyOfRange(fArr, nextInt2, nextInt2 + 2);
                PathNode moveTo = new PathNode.MoveTo(copyOfRange2[0], copyOfRange2[1]);
                if (nextInt2 > 0) {
                    moveTo = new PathNode.LineTo(copyOfRange2[0], copyOfRange2[1]);
                } else if ((moveTo instanceof PathNode.RelativeMoveTo) && nextInt2 > 0) {
                    moveTo = new PathNode.RelativeLineTo(copyOfRange2[0], copyOfRange2[1]);
                }
                arrayList.add(moveTo);
            }
        } else if (c == 'l') {
            IntProgression step3 = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step3, 10));
            IntIterator it3 = step3.iterator();
            while (it3.hasNext()) {
                int nextInt3 = it3.nextInt();
                float[] copyOfRange3 = ArraysKt.copyOfRange(fArr, nextInt3, nextInt3 + 2);
                PathNode relativeLineTo = new PathNode.RelativeLineTo(copyOfRange3[0], copyOfRange3[1]);
                if ((relativeLineTo instanceof PathNode.MoveTo) && nextInt3 > 0) {
                    relativeLineTo = new PathNode.LineTo(copyOfRange3[0], copyOfRange3[1]);
                } else if ((relativeLineTo instanceof PathNode.RelativeMoveTo) && nextInt3 > 0) {
                    relativeLineTo = new PathNode.RelativeLineTo(copyOfRange3[0], copyOfRange3[1]);
                }
                arrayList.add(relativeLineTo);
            }
        } else if (c == 'L') {
            IntProgression step4 = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step4, 10));
            IntIterator it4 = step4.iterator();
            while (it4.hasNext()) {
                int nextInt4 = it4.nextInt();
                float[] copyOfRange4 = ArraysKt.copyOfRange(fArr, nextInt4, nextInt4 + 2);
                PathNode lineTo = new PathNode.LineTo(copyOfRange4[0], copyOfRange4[1]);
                if ((lineTo instanceof PathNode.MoveTo) && nextInt4 > 0) {
                    lineTo = new PathNode.LineTo(copyOfRange4[0], copyOfRange4[1]);
                } else if ((lineTo instanceof PathNode.RelativeMoveTo) && nextInt4 > 0) {
                    lineTo = new PathNode.RelativeLineTo(copyOfRange4[0], copyOfRange4[1]);
                }
                arrayList.add(lineTo);
            }
        } else if (c == 'h') {
            IntProgression step5 = RangesKt.step(new IntRange(0, fArr.length - 1), 1);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step5, 10));
            IntIterator it5 = step5.iterator();
            while (it5.hasNext()) {
                int nextInt5 = it5.nextInt();
                float[] copyOfRange5 = ArraysKt.copyOfRange(fArr, nextInt5, nextInt5 + 1);
                PathNode relativeHorizontalTo = new PathNode.RelativeHorizontalTo(copyOfRange5[0]);
                if ((relativeHorizontalTo instanceof PathNode.MoveTo) && nextInt5 > 0) {
                    relativeHorizontalTo = new PathNode.LineTo(copyOfRange5[0], copyOfRange5[1]);
                } else if ((relativeHorizontalTo instanceof PathNode.RelativeMoveTo) && nextInt5 > 0) {
                    relativeHorizontalTo = new PathNode.RelativeLineTo(copyOfRange5[0], copyOfRange5[1]);
                }
                arrayList.add(relativeHorizontalTo);
            }
        } else if (c == 'H') {
            IntProgression step6 = RangesKt.step(new IntRange(0, fArr.length - 1), 1);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step6, 10));
            IntIterator it6 = step6.iterator();
            while (it6.hasNext()) {
                int nextInt6 = it6.nextInt();
                float[] copyOfRange6 = ArraysKt.copyOfRange(fArr, nextInt6, nextInt6 + 1);
                PathNode horizontalTo = new PathNode.HorizontalTo(copyOfRange6[0]);
                if ((horizontalTo instanceof PathNode.MoveTo) && nextInt6 > 0) {
                    horizontalTo = new PathNode.LineTo(copyOfRange6[0], copyOfRange6[1]);
                } else if ((horizontalTo instanceof PathNode.RelativeMoveTo) && nextInt6 > 0) {
                    horizontalTo = new PathNode.RelativeLineTo(copyOfRange6[0], copyOfRange6[1]);
                }
                arrayList.add(horizontalTo);
            }
        } else if (c == 'v') {
            IntProgression step7 = RangesKt.step(new IntRange(0, fArr.length - 1), 1);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step7, 10));
            IntIterator it7 = step7.iterator();
            while (it7.hasNext()) {
                int nextInt7 = it7.nextInt();
                float[] copyOfRange7 = ArraysKt.copyOfRange(fArr, nextInt7, nextInt7 + 1);
                PathNode relativeVerticalTo = new PathNode.RelativeVerticalTo(copyOfRange7[0]);
                if ((relativeVerticalTo instanceof PathNode.MoveTo) && nextInt7 > 0) {
                    relativeVerticalTo = new PathNode.LineTo(copyOfRange7[0], copyOfRange7[1]);
                } else if ((relativeVerticalTo instanceof PathNode.RelativeMoveTo) && nextInt7 > 0) {
                    relativeVerticalTo = new PathNode.RelativeLineTo(copyOfRange7[0], copyOfRange7[1]);
                }
                arrayList.add(relativeVerticalTo);
            }
        } else if (c == 'V') {
            IntProgression step8 = RangesKt.step(new IntRange(0, fArr.length - 1), 1);
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step8, 10));
            IntIterator it8 = step8.iterator();
            while (it8.hasNext()) {
                int nextInt8 = it8.nextInt();
                float[] copyOfRange8 = ArraysKt.copyOfRange(fArr, nextInt8, nextInt8 + 1);
                PathNode verticalTo = new PathNode.VerticalTo(copyOfRange8[0]);
                if ((verticalTo instanceof PathNode.MoveTo) && nextInt8 > 0) {
                    verticalTo = new PathNode.LineTo(copyOfRange8[0], copyOfRange8[1]);
                } else if ((verticalTo instanceof PathNode.RelativeMoveTo) && nextInt8 > 0) {
                    verticalTo = new PathNode.RelativeLineTo(copyOfRange8[0], copyOfRange8[1]);
                }
                arrayList.add(verticalTo);
            }
        } else {
            char c4 = 5;
            if (c == 'c') {
                IntProgression step9 = RangesKt.step(new IntRange(0, fArr.length - 6), 6);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step9, 10));
                IntIterator it9 = step9.iterator();
                while (it9.hasNext()) {
                    int nextInt9 = it9.nextInt();
                    float[] copyOfRange9 = ArraysKt.copyOfRange(fArr, nextInt9, nextInt9 + 6);
                    PathNode relativeCurveTo = new PathNode.RelativeCurveTo(copyOfRange9[0], copyOfRange9[1], copyOfRange9[2], copyOfRange9[3], copyOfRange9[4], copyOfRange9[c4]);
                    arrayList.add((!(relativeCurveTo instanceof PathNode.MoveTo) || nextInt9 <= 0) ? (!(relativeCurveTo instanceof PathNode.RelativeMoveTo) || nextInt9 <= 0) ? relativeCurveTo : new PathNode.RelativeLineTo(copyOfRange9[0], copyOfRange9[1]) : new PathNode.LineTo(copyOfRange9[0], copyOfRange9[1]));
                    c4 = 5;
                }
            } else if (c == 'C') {
                IntProgression step10 = RangesKt.step(new IntRange(0, fArr.length - 6), 6);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step10, 10));
                IntIterator it10 = step10.iterator();
                while (it10.hasNext()) {
                    int nextInt10 = it10.nextInt();
                    float[] copyOfRange10 = ArraysKt.copyOfRange(fArr, nextInt10, nextInt10 + 6);
                    PathNode curveTo = new PathNode.CurveTo(copyOfRange10[0], copyOfRange10[1], copyOfRange10[2], copyOfRange10[3], copyOfRange10[4], copyOfRange10[5]);
                    if ((curveTo instanceof PathNode.MoveTo) && nextInt10 > 0) {
                        curveTo = new PathNode.LineTo(copyOfRange10[0], copyOfRange10[1]);
                    } else if ((curveTo instanceof PathNode.RelativeMoveTo) && nextInt10 > 0) {
                        curveTo = new PathNode.RelativeLineTo(copyOfRange10[0], copyOfRange10[1]);
                    }
                    arrayList.add(curveTo);
                }
            } else if (c == 's') {
                IntProgression step11 = RangesKt.step(new IntRange(0, fArr.length - 4), 4);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step11, 10));
                IntIterator it11 = step11.iterator();
                while (it11.hasNext()) {
                    int nextInt11 = it11.nextInt();
                    float[] copyOfRange11 = ArraysKt.copyOfRange(fArr, nextInt11, nextInt11 + 4);
                    PathNode relativeReflectiveCurveTo = new PathNode.RelativeReflectiveCurveTo(copyOfRange11[0], copyOfRange11[1], copyOfRange11[2], copyOfRange11[3]);
                    if ((relativeReflectiveCurveTo instanceof PathNode.MoveTo) && nextInt11 > 0) {
                        relativeReflectiveCurveTo = new PathNode.LineTo(copyOfRange11[0], copyOfRange11[1]);
                    } else if ((relativeReflectiveCurveTo instanceof PathNode.RelativeMoveTo) && nextInt11 > 0) {
                        relativeReflectiveCurveTo = new PathNode.RelativeLineTo(copyOfRange11[0], copyOfRange11[1]);
                    }
                    arrayList.add(relativeReflectiveCurveTo);
                }
            } else if (c == 'S') {
                IntProgression step12 = RangesKt.step(new IntRange(0, fArr.length - 4), 4);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step12, 10));
                IntIterator it12 = step12.iterator();
                while (it12.hasNext()) {
                    int nextInt12 = it12.nextInt();
                    float[] copyOfRange12 = ArraysKt.copyOfRange(fArr, nextInt12, nextInt12 + 4);
                    PathNode reflectiveCurveTo = new PathNode.ReflectiveCurveTo(copyOfRange12[0], copyOfRange12[1], copyOfRange12[2], copyOfRange12[3]);
                    if ((reflectiveCurveTo instanceof PathNode.MoveTo) && nextInt12 > 0) {
                        reflectiveCurveTo = new PathNode.LineTo(copyOfRange12[0], copyOfRange12[1]);
                    } else if ((reflectiveCurveTo instanceof PathNode.RelativeMoveTo) && nextInt12 > 0) {
                        reflectiveCurveTo = new PathNode.RelativeLineTo(copyOfRange12[0], copyOfRange12[1]);
                    }
                    arrayList.add(reflectiveCurveTo);
                }
            } else if (c == 'q') {
                IntProgression step13 = RangesKt.step(new IntRange(0, fArr.length - 4), 4);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step13, 10));
                IntIterator it13 = step13.iterator();
                while (it13.hasNext()) {
                    int nextInt13 = it13.nextInt();
                    float[] copyOfRange13 = ArraysKt.copyOfRange(fArr, nextInt13, nextInt13 + 4);
                    PathNode relativeQuadTo = new PathNode.RelativeQuadTo(copyOfRange13[0], copyOfRange13[1], copyOfRange13[2], copyOfRange13[3]);
                    if ((relativeQuadTo instanceof PathNode.MoveTo) && nextInt13 > 0) {
                        relativeQuadTo = new PathNode.LineTo(copyOfRange13[0], copyOfRange13[1]);
                    } else if ((relativeQuadTo instanceof PathNode.RelativeMoveTo) && nextInt13 > 0) {
                        relativeQuadTo = new PathNode.RelativeLineTo(copyOfRange13[0], copyOfRange13[1]);
                    }
                    arrayList.add(relativeQuadTo);
                }
            } else if (c == 'Q') {
                IntProgression step14 = RangesKt.step(new IntRange(0, fArr.length - 4), 4);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step14, 10));
                IntIterator it14 = step14.iterator();
                while (it14.hasNext()) {
                    int nextInt14 = it14.nextInt();
                    float[] copyOfRange14 = ArraysKt.copyOfRange(fArr, nextInt14, nextInt14 + 4);
                    PathNode quadTo = new PathNode.QuadTo(copyOfRange14[0], copyOfRange14[1], copyOfRange14[2], copyOfRange14[3]);
                    if ((quadTo instanceof PathNode.MoveTo) && nextInt14 > 0) {
                        quadTo = new PathNode.LineTo(copyOfRange14[0], copyOfRange14[1]);
                    } else if ((quadTo instanceof PathNode.RelativeMoveTo) && nextInt14 > 0) {
                        quadTo = new PathNode.RelativeLineTo(copyOfRange14[0], copyOfRange14[1]);
                    }
                    arrayList.add(quadTo);
                }
            } else if (c == 't') {
                IntProgression step15 = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step15, 10));
                IntIterator it15 = step15.iterator();
                while (it15.hasNext()) {
                    int nextInt15 = it15.nextInt();
                    float[] copyOfRange15 = ArraysKt.copyOfRange(fArr, nextInt15, nextInt15 + 2);
                    PathNode relativeReflectiveQuadTo = new PathNode.RelativeReflectiveQuadTo(copyOfRange15[0], copyOfRange15[1]);
                    if ((relativeReflectiveQuadTo instanceof PathNode.MoveTo) && nextInt15 > 0) {
                        relativeReflectiveQuadTo = new PathNode.LineTo(copyOfRange15[0], copyOfRange15[1]);
                    } else if ((relativeReflectiveQuadTo instanceof PathNode.RelativeMoveTo) && nextInt15 > 0) {
                        relativeReflectiveQuadTo = new PathNode.RelativeLineTo(copyOfRange15[0], copyOfRange15[1]);
                    }
                    arrayList.add(relativeReflectiveQuadTo);
                }
            } else if (c == 'T') {
                IntProgression step16 = RangesKt.step(new IntRange(0, fArr.length - 2), 2);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step16, 10));
                IntIterator it16 = step16.iterator();
                while (it16.hasNext()) {
                    int nextInt16 = it16.nextInt();
                    float[] copyOfRange16 = ArraysKt.copyOfRange(fArr, nextInt16, nextInt16 + 2);
                    PathNode reflectiveQuadTo = new PathNode.ReflectiveQuadTo(copyOfRange16[0], copyOfRange16[1]);
                    if ((reflectiveQuadTo instanceof PathNode.MoveTo) && nextInt16 > 0) {
                        reflectiveQuadTo = new PathNode.LineTo(copyOfRange16[0], copyOfRange16[1]);
                    } else if ((reflectiveQuadTo instanceof PathNode.RelativeMoveTo) && nextInt16 > 0) {
                        reflectiveQuadTo = new PathNode.RelativeLineTo(copyOfRange16[0], copyOfRange16[1]);
                    }
                    arrayList.add(reflectiveQuadTo);
                }
            } else if (c == 'a') {
                IntProgression step17 = RangesKt.step(new IntRange(0, fArr.length - 7), 7);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step17, 10));
                IntIterator it17 = step17.iterator();
                while (it17.hasNext()) {
                    int nextInt17 = it17.nextInt();
                    float[] copyOfRange17 = ArraysKt.copyOfRange(fArr, nextInt17, nextInt17 + 7);
                    float f = copyOfRange17[0];
                    float f2 = copyOfRange17[1];
                    float f3 = copyOfRange17[2];
                    boolean z3 = Float.compare(copyOfRange17[3], 0.0f) != 0;
                    if (Float.compare(copyOfRange17[4], 0.0f) != 0) {
                        c3 = 5;
                        z2 = true;
                    } else {
                        c3 = 5;
                        z2 = false;
                    }
                    PathNode relativeArcTo = new PathNode.RelativeArcTo(f, f2, f3, z3, z2, copyOfRange17[c3], copyOfRange17[6]);
                    if ((relativeArcTo instanceof PathNode.MoveTo) && nextInt17 > 0) {
                        relativeArcTo = new PathNode.LineTo(copyOfRange17[0], copyOfRange17[1]);
                    } else if ((relativeArcTo instanceof PathNode.RelativeMoveTo) && nextInt17 > 0) {
                        relativeArcTo = new PathNode.RelativeLineTo(copyOfRange17[0], copyOfRange17[1]);
                    }
                    arrayList.add(relativeArcTo);
                }
            } else {
                if (c != 'A') {
                    throw new IllegalArgumentException("Unknown command for: " + c);
                }
                IntProgression step18 = RangesKt.step(new IntRange(0, fArr.length - 7), 7);
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step18, 10));
                IntIterator it18 = step18.iterator();
                while (it18.hasNext()) {
                    int nextInt18 = it18.nextInt();
                    float[] copyOfRange18 = ArraysKt.copyOfRange(fArr, nextInt18, nextInt18 + 7);
                    float f4 = copyOfRange18[0];
                    float f5 = copyOfRange18[1];
                    float f6 = copyOfRange18[2];
                    boolean z4 = Float.compare(copyOfRange18[3], 0.0f) != 0;
                    if (Float.compare(copyOfRange18[4], 0.0f) != 0) {
                        c2 = 5;
                        z = true;
                    } else {
                        c2 = 5;
                        z = false;
                    }
                    PathNode arcTo = new PathNode.ArcTo(f4, f5, f6, z4, z, copyOfRange18[c2], copyOfRange18[6]);
                    if ((arcTo instanceof PathNode.MoveTo) && nextInt18 > 0) {
                        arcTo = new PathNode.LineTo(copyOfRange18[0], copyOfRange18[1]);
                    } else if ((arcTo instanceof PathNode.RelativeMoveTo) && nextInt18 > 0) {
                        arcTo = new PathNode.RelativeLineTo(copyOfRange18[0], copyOfRange18[1]);
                    }
                    arrayList.add(arcTo);
                }
            }
        }
        return arrayList;
    }
}
