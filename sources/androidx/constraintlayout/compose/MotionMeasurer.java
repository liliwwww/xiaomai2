package androidx.constraintlayout.compose;

import android.graphics.Matrix;
import android.taobao.windvane.connect.HttpConnector;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bV\u0010WJ;\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011Je\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010'\u001a\u00020\u000b2\n\u0010!\u001a\u00060\u001fj\u0002` 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0002H\u0002JI\u00104\u001a\u00020\u000b*\u00020(2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J1\u00108\u001a\u00020\u000b*\u00020(2\u0006\u00105\u001a\u00020+2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J\u0006\u00109\u001a\u00020\u0019Jc\u0010?\u001a\u00020<2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010;\u001a\u00020:ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J\u0012\u0010@\u001a\u00020\u000b2\n\u0010!\u001a\u00060\u001fj\u0002` J\b\u0010A\u001a\u00020\u000bH\u0016J\u0013\u0010C\u001a\u00020\u000b*\u00020BH\u0007¢\u0006\u0004\bC\u0010DJ&\u0010J\u001a\u0002002\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020Eø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bH\u0010IJ\u0016\u0010K\u001a\u00020\u00192\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020EJ\u0006\u0010L\u001a\u00020\u000bJ(\u0010O\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010P\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0019\u0010\u0018\u001a\u00020R8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010S\u001a\u0004\bT\u0010U\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/constraintlayout/compose/MotionMeasurer;", "Landroidx/constraintlayout/compose/Measurer;", "", "optimizationLevel", "Landroidx/constraintlayout/compose/ConstraintSet;", "constraintSet", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "measureConstraintSet--hBUhpc", "(ILandroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;J)V", "measureConstraintSet", "", "needsRemeasure-BRTryo0", "(J)Z", "needsRemeasure", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "constraintSetStart", "constraintSetEnd", "Landroidx/constraintlayout/compose/Transition;", "transition", "", "progress", "remeasure", "recalculateInterpolation-36Wf7g4", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;Ljava/util/List;IFZ)V", "recalculateInterpolation", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "", HttpConnector.REDIRECT_LOCATION, "", "types", "count", "encodeKeyFrames", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "parentWidth", "parentHeight", "Landroidx/constraintlayout/core/state/WidgetFrame;", "startFrame", "endFrame", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "drawFrameDebug-PE3pjmc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFLandroidx/constraintlayout/core/state/WidgetFrame;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawFrameDebug", TypedValues.AttributesType.S_FRAME, "drawFrame-g2O1Hgs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawFrame", "getProgress", "Landroidx/compose/ui/layout/MeasureScope;", "measureScope", "Landroidx/compose/ui/unit/IntSize;", "performInterpolationMeasure-OQbXsTc", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;Ljava/util/List;IFLandroidx/compose/ui/layout/MeasureScope;)J", "performInterpolationMeasure", "encodeRoot", "computeLayoutResult", "Landroidx/compose/foundation/layout/BoxScope;", "drawDebug", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/runtime/Composer;I)V", "", "id", "name", "getCustomColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "getCustomColor", "getCustomFloat", "clearConstraintSets", "start", "end", "initWith", Key.MOTIONPROGRESS, "F", "Landroidx/constraintlayout/core/state/Transition;", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "<init>", "()V", "compose_release"}, k = 1, mv = {1, 5, 1})
@PublishedApi
/* loaded from: classes.dex */
public final class MotionMeasurer extends Measurer {
    private float motionProgress;

    @NotNull
    private final androidx.constraintlayout.core.state.Transition transition = new androidx.constraintlayout.core.state.Transition();

    /* renamed from: drawFrame-g2O1Hgs, reason: not valid java name */
    private final void m5564drawFrameg2O1Hgs(DrawScope drawScope, WidgetFrame widgetFrame, PathEffect pathEffect, long j) {
        if (widgetFrame.isDefaultTransform()) {
            w51.K(drawScope, j, OffsetKt.Offset(widgetFrame.left, widgetFrame.top), SizeKt.Size(widgetFrame.width(), widgetFrame.height()), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, pathEffect, 14, null), null, 0, 104, null);
            return;
        }
        Matrix matrix = new Matrix();
        if (!Float.isNaN(widgetFrame.rotationZ)) {
            matrix.preRotate(widgetFrame.rotationZ, widgetFrame.centerX(), widgetFrame.centerY());
        }
        matrix.preScale(Float.isNaN(widgetFrame.scaleX) ? 1.0f : widgetFrame.scaleX, Float.isNaN(widgetFrame.scaleY) ? 1.0f : widgetFrame.scaleY, widgetFrame.centerX(), widgetFrame.centerY());
        int i = widgetFrame.left;
        int i2 = widgetFrame.top;
        int i3 = widgetFrame.right;
        int i4 = widgetFrame.bottom;
        float[] fArr = {i, i2, i3, i2, i3, i4, i, i4};
        matrix.mapPoints(fArr);
        w51.C(drawScope, j, OffsetKt.Offset(fArr[0], fArr[1]), OffsetKt.Offset(fArr[2], fArr[3]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        w51.C(drawScope, j, OffsetKt.Offset(fArr[2], fArr[3]), OffsetKt.Offset(fArr[4], fArr[5]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        w51.C(drawScope, j, OffsetKt.Offset(fArr[4], fArr[5]), OffsetKt.Offset(fArr[6], fArr[7]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        w51.C(drawScope, j, OffsetKt.Offset(fArr[6], fArr[7]), OffsetKt.Offset(fArr[0], fArr[1]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawFrameDebug-PE3pjmc, reason: not valid java name */
    public final void m5565drawFrameDebugPE3pjmc(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, PathEffect pathEffect, long j) {
        m5564drawFrameg2O1Hgs(drawScope, widgetFrame, pathEffect, j);
        m5564drawFrameg2O1Hgs(drawScope, widgetFrame2, pathEffect, j);
        int numberKeyPositions = this.transition.getNumberKeyPositions(widgetFrame);
        new MotionRenderDebug(23.0f).draw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame.widget.stringId), 1000, 1, (int) f, (int) f2);
        if (numberKeyPositions == 0) {
            return;
        }
        float[] fArr = new float[numberKeyPositions];
        float[] fArr2 = new float[numberKeyPositions];
        float[] fArr3 = new float[numberKeyPositions];
        this.transition.fillKeyPositions(widgetFrame, fArr, fArr2, fArr3);
        widgetFrame.centerX();
        widgetFrame.centerY();
        int i = 0;
        int i2 = numberKeyPositions - 1;
        if (i2 < 0) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            float f3 = fArr3[i] / 100.0f;
            float f4 = 1 - f3;
            float width = (widgetFrame.width() * f4) + (widgetFrame2.width() * f3);
            float height = (f4 * widgetFrame.height()) + (f3 * widgetFrame2.height());
            float f5 = (fArr[i] * f) + (width / 2.0f);
            float f6 = (fArr2[i] * f2) + (height / 2.0f);
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(f5 - 20.0f, f6);
            Path.lineTo(f5, f6 + 20.0f);
            Path.lineTo(f5 + 20.0f, f6);
            Path.lineTo(f5, f6 - 20.0f);
            Path.close();
            w51.G(drawScope, Path, j, 1.0f, new Stroke(3.0f, 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
            if (i == i2) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private final void encodeKeyFrames(StringBuilder json, float[] location, int[] types, int[] progress, int count) {
        if (count == 0) {
            return;
        }
        json.append("keyTypes : [");
        int i = 0;
        if (count > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = types[i2];
                StringBuilder sb = new StringBuilder();
                sb.append(' ');
                sb.append(i4);
                sb.append(',');
                json.append(sb.toString());
                if (i3 >= count) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        json.append("],\n");
        json.append("keyPos : [");
        int i5 = count * 2;
        if (i5 > 0) {
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                float f = location[i6];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(' ');
                sb2.append(f);
                sb2.append(',');
                json.append(sb2.toString());
                if (i7 >= i5) {
                    break;
                } else {
                    i6 = i7;
                }
            }
        }
        json.append("],\n ");
        json.append("keyFrames : [");
        if (count > 0) {
            while (true) {
                int i8 = i + 1;
                int i9 = progress[i];
                StringBuilder sb3 = new StringBuilder();
                sb3.append(' ');
                sb3.append(i9);
                sb3.append(',');
                json.append(sb3.toString());
                if (i8 >= count) {
                    break;
                } else {
                    i = i8;
                }
            }
        }
        json.append("],\n ");
    }

    /* renamed from: measureConstraintSet--hBUhpc, reason: not valid java name */
    private final void m5566measureConstraintSethBUhpc(int optimizationLevel, ConstraintSet constraintSet, List<? extends Measurable> measurables, long constraints) {
        boolean z;
        String obj;
        getState().reset();
        constraintSet.applyTo(getState(), measurables);
        getState().apply(getRoot());
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        Intrinsics.checkNotNullExpressionValue(children, "root.children");
        int size = children.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                children.get(i).setAnimated(true);
                if (i2 > size) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        m5535applyRootSizeBRTryo0(constraints);
        getRoot().updateHierarchy();
        z = MotionLayoutKt.DEBUG;
        if (z) {
            getRoot().setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children2 = getRoot().getChildren();
            Intrinsics.checkNotNullExpressionValue(children2, "root.children");
            for (ConstraintWidget constraintWidget : children2) {
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                Object layoutId = measurable == null ? null : LayoutIdKt.getLayoutId(measurable);
                String str = "NOTAG";
                if (layoutId != null && (obj = layoutId.toString()) != null) {
                    str = obj;
                }
                constraintWidget.setDebugName(str);
            }
        }
        ArrayList<ConstraintWidget> children3 = getRoot().getChildren();
        Intrinsics.checkNotNullExpressionValue(children3, "root.children");
        for (ConstraintWidget constraintWidget2 : children3) {
            Object companionWidget2 = constraintWidget2.getCompanionWidget();
            Measurable measurable2 = companionWidget2 instanceof Measurable ? (Measurable) companionWidget2 : null;
            Object layoutId2 = measurable2 == null ? null : LayoutIdKt.getLayoutId(measurable2);
            if (layoutId2 == null) {
                layoutId2 = measurable2 == null ? null : ConstraintLayoutTagKt.getConstraintLayoutId(measurable2);
            }
            constraintWidget2.stringId = layoutId2 == null ? null : layoutId2.toString();
        }
        getRoot().setOptimizationLevel(optimizationLevel);
        getRoot().measure(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4 A[SYNTHETIC] */
    /* renamed from: needsRemeasure-BRTryo0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean m5567needsRemeasureBRTryo0(long r8) {
        /*
            r7 = this;
            androidx.constraintlayout.core.state.Transition r0 = r7.transition
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != 0) goto La4
            java.util.Map r0 = r7.getFrameCache()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L15
            goto La4
        L15:
            boolean r0 = androidx.compose.p004ui.unit.Constraints.m5181getHasFixedHeightimpl(r8)
            if (r0 == 0) goto L29
            androidx.constraintlayout.compose.State r0 = r7.getState()
            int r2 = androidx.compose.p004ui.unit.Constraints.m5183getMaxHeightimpl(r8)
            boolean r0 = r0.sameFixedHeight(r2)
            if (r0 == 0) goto L3d
        L29:
            boolean r0 = androidx.compose.p004ui.unit.Constraints.m5182getHasFixedWidthimpl(r8)
            if (r0 == 0) goto L3e
            androidx.constraintlayout.compose.State r0 = r7.getState()
            int r8 = androidx.compose.p004ui.unit.Constraints.m5184getMaxWidthimpl(r8)
            boolean r8 = r0.sameFixedWidth(r8)
            if (r8 != 0) goto L3e
        L3d:
            return r1
        L3e:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = r7.getRoot()
            java.util.ArrayList r8 = r8.getChildren()
            java.lang.String r9 = "root.children"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r9 = r8.size()
            int r9 = r9 + (-1)
            r0 = 0
            if (r9 < 0) goto La3
            r2 = 0
        L56:
            int r3 = r2 + 1
            java.lang.Object r2 = r8.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            java.lang.Object r4 = r2.getCompanionWidget()
            boolean r5 = r4 instanceof androidx.compose.p004ui.layout.Measurable
            if (r5 == 0) goto L69
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.p004ui.layout.Measurable) r4
            goto L6a
        L69:
            r4 = 0
        L6a:
            if (r4 != 0) goto L6e
        L6c:
            r2 = 0
            goto L9b
        L6e:
            androidx.constraintlayout.core.state.Transition r5 = r7.getTransition()
            androidx.constraintlayout.core.state.WidgetFrame r2 = r5.getInterpolated(r2)
            if (r2 != 0) goto L79
            goto L6c
        L79:
            java.util.Map r5 = r7.getPlaceables()
            java.lang.Object r4 = r5.get(r4)
            androidx.compose.ui.layout.Placeable r4 = (androidx.compose.p004ui.layout.Placeable) r4
            if (r4 != 0) goto L86
            goto L6c
        L86:
            int r5 = r4.getWidth()
            int r4 = r4.getHeight()
            int r6 = r2.width()
            if (r5 != r6) goto L9a
            int r2 = r2.height()
            if (r4 == r2) goto L6c
        L9a:
            r2 = 1
        L9b:
            if (r2 == 0) goto L9e
            goto La4
        L9e:
            if (r3 <= r9) goto La1
            goto La3
        La1:
            r2 = r3
            goto L56
        La3:
            r1 = 0
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionMeasurer.m5567needsRemeasureBRTryo0(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0125, code lost:
    
        if (r9.intValue() != r7) goto L45;
     */
    /* renamed from: recalculateInterpolation-36Wf7g4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m5568recalculateInterpolation36Wf7g4(long r13, androidx.compose.p004ui.unit.LayoutDirection r15, androidx.constraintlayout.compose.ConstraintSet r16, androidx.constraintlayout.compose.ConstraintSet r17, androidx.constraintlayout.compose.Transition r18, java.util.List<? extends androidx.compose.p004ui.layout.Measurable> r19, int r20, float r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionMeasurer.m5568recalculateInterpolation36Wf7g4(long, androidx.compose.ui.unit.LayoutDirection, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.Transition, java.util.List, int, float, boolean):void");
    }

    public final void clearConstraintSets() {
        this.transition.clear();
        getFrameCache().clear();
    }

    @Override // androidx.constraintlayout.compose.Measurer
    public void computeLayoutResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        encodeRoot(sb);
        int[] iArr = new int[50];
        int[] iArr2 = new int[50];
        float[] fArr = new float[100];
        Iterator<ConstraintWidget> it = getRoot().getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            WidgetFrame start = this.transition.getStart(next.stringId);
            WidgetFrame end = this.transition.getEnd(next.stringId);
            WidgetFrame interpolated = this.transition.getInterpolated(next.stringId);
            float[] path = this.transition.getPath(next.stringId);
            int keyFrames = this.transition.getKeyFrames(next.stringId, fArr, iArr, iArr2);
            sb.append(' ' + ((Object) next.stringId) + ": {");
            sb.append(" interpolated : ");
            interpolated.serialize(sb, true);
            sb.append(", start : ");
            start.serialize(sb);
            sb.append(", end : ");
            end.serialize(sb);
            encodeKeyFrames(sb, fArr, iArr, iArr2, keyFrames);
            sb.append(" path : [");
            Intrinsics.checkNotNullExpressionValue(path, "path");
            int i = 0;
            int length = path.length;
            while (i < length) {
                float f = path[i];
                i++;
                sb.append(' ' + f + " ,");
            }
            sb.append(" ] ");
            sb.append("}, ");
        }
        sb.append(" }");
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if (layoutInformationReceiver == null) {
            return;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "json.toString()");
        layoutInformationReceiver.setLayoutInformation(sb2);
    }

    @Composable
    public final void drawDebug(@NotNull final BoxScope boxScope, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(436942847);
        CanvasKt.Canvas(boxScope.matchParentSize(Modifier.Companion), new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionMeasurer$drawDebug$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                PathEffect dashPathEffect = PathEffect.Companion.dashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
                Iterator<ConstraintWidget> it = MotionMeasurer.this.getRoot().getChildren().iterator();
                while (it.hasNext()) {
                    ConstraintWidget next = it.next();
                    WidgetFrame start = MotionMeasurer.this.getTransition().getStart(next);
                    WidgetFrame end = MotionMeasurer.this.getTransition().getEnd(next);
                    MotionMeasurer motionMeasurer = MotionMeasurer.this;
                    drawScope.getDrawContext().getTransform().translate(2.0f, 2.0f);
                    float m2625getWidthimpl = Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc());
                    float m2622getHeightimpl = Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc());
                    Intrinsics.checkNotNullExpressionValue(start, "startFrame");
                    Intrinsics.checkNotNullExpressionValue(end, "endFrame");
                    Color.Companion companion = Color.Companion;
                    motionMeasurer.m5565drawFrameDebugPE3pjmc(drawScope, m2625getWidthimpl, m2622getHeightimpl, start, end, dashPathEffect, companion.m2824getWhite0d7_KjU());
                    drawScope.getDrawContext().getTransform().translate(-2.0f, -2.0f);
                    MotionMeasurer.this.m5565drawFrameDebugPE3pjmc(drawScope, Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc()), Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc()), start, end, dashPathEffect, companion.m2814getBlue0d7_KjU());
                }
            }
        }, startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionMeasurer$drawDebug$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                MotionMeasurer.this.drawDebug(boxScope, composer2, i | 1);
            }
        });
    }

    public final void encodeRoot(@NotNull StringBuilder json) {
        Intrinsics.checkNotNullParameter(json, "json");
        json.append("  root: {");
        json.append("interpolated: { left:  0,");
        json.append("  top:  0,");
        json.append("  right:   " + getRoot().getWidth() + " ,");
        json.append("  bottom:  " + getRoot().getHeight() + " ,");
        json.append(" } }");
    }

    /* renamed from: getCustomColor-WaAFU9c, reason: not valid java name */
    public final long m5569getCustomColorWaAFU9c(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!this.transition.contains(id)) {
            return Color.Companion.m2813getBlack0d7_KjU();
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), this.motionProgress);
        return ColorKt.Color(this.transition.getInterpolated(id).getCustomColor(name));
    }

    public final float getCustomFloat(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!this.transition.contains(id)) {
            return 0.0f;
        }
        WidgetFrame start = this.transition.getStart(id);
        WidgetFrame end = this.transition.getEnd(id);
        float customFloat = start.getCustomFloat(name);
        float customFloat2 = end.getCustomFloat(name);
        float f = this.motionProgress;
        return ((1.0f - f) * customFloat) + (f * customFloat2);
    }

    /* renamed from: getProgress, reason: from getter */
    public final float getMotionProgress() {
        return this.motionProgress;
    }

    @NotNull
    public final androidx.constraintlayout.core.state.Transition getTransition() {
        return this.transition;
    }

    public final void initWith(@NotNull ConstraintSet start, @NotNull ConstraintSet end, @Nullable Transition transition, float progress) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        clearConstraintSets();
        start.applyTo(this.transition, 0);
        end.applyTo(this.transition, 1);
        this.transition.interpolate(0, 0, progress);
        if (transition == null) {
            return;
        }
        transition.applyTo(this.transition, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006c, code lost:
    
        if (r10 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        if (r1.intValue() != Integer.MIN_VALUE) goto L25;
     */
    /* renamed from: performInterpolationMeasure-OQbXsTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m5570performInterpolationMeasureOQbXsTc(long r13, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.unit.LayoutDirection r15, @org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.ConstraintSet r16, @org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.ConstraintSet r17, @org.jetbrains.annotations.Nullable androidx.constraintlayout.compose.Transition r18, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.p004ui.layout.Measurable> r19, int r20, float r21, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.layout.MeasureScope r22) {
        /*
            r12 = this;
            r11 = r12
            r0 = r22
            java.lang.String r1 = "layoutDirection"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "constraintSetStart"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "constraintSetEnd"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "measurables"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "measureScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r12.setDensity(r0)
            r12.setMeasureScope(r0)
            boolean r10 = r12.m5567needsRemeasureBRTryo0(r13)
            float r0 = r11.motionProgress
            int r0 = (r0 > r21 ? 1 : (r0 == r21 ? 0 : -1))
            if (r0 != 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L6e
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = r12.getLayoutInformationReceiver()
            r1 = 0
            if (r0 != 0) goto L41
            r0 = r1
            goto L49
        L41:
            int r0 = r0.getForcedWidth()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L49:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L4e
            goto L54
        L4e:
            int r0 = r0.intValue()
            if (r0 == r2) goto L6c
        L54:
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = r12.getLayoutInformationReceiver()
            if (r0 != 0) goto L5b
            goto L63
        L5b:
            int r0 = r0.getForcedHeight()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
        L63:
            if (r1 != 0) goto L66
            goto L6e
        L66:
            int r0 = r1.intValue()
            if (r0 != r2) goto L6e
        L6c:
            if (r10 == 0) goto L80
        L6e:
            r0 = r12
            r1 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r0.m5568recalculateInterpolation36Wf7g4(r1, r3, r4, r5, r6, r7, r8, r9, r10)
        L80:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r12.getRoot()
            int r0 = r0.getWidth()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.getRoot()
            int r1 = r1.getHeight()
            long r0 = androidx.compose.p004ui.unit.IntSizeKt.IntSize(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionMeasurer.m5570performInterpolationMeasureOQbXsTc(long, androidx.compose.ui.unit.LayoutDirection, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.Transition, java.util.List, int, float, androidx.compose.ui.layout.MeasureScope):long");
    }
}
