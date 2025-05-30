package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DrawScopeKt {
    /* renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m1336clipPathKD09W0M(@NotNull DrawScope drawScope, @NotNull Path path, int i, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1327clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    /* renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m1337clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.getIntersect-rtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1327clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    /* renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m1338clipRectrOu3jXo(@NotNull DrawScope drawScope, float f, float f2, float f3, float f4, int i, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1328clipRectN_I0leg(f, f2, f3, f4, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    /* renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m1339clipRectrOu3jXo$default(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1 function1, int i2, Object obj) {
        float f5 = (i2 & 1) != 0 ? 0.0f : f;
        float f6 = (i2 & 2) != 0 ? 0.0f : f2;
        if ((i2 & 4) != 0) {
            f3 = Size.m903getWidthimpl(drawScope.mo1321getSizeNHjbRc());
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Size.m900getHeightimpl(drawScope.mo1321getSizeNHjbRc());
        }
        float f8 = f4;
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.getIntersect-rtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1328clipRectN_I0leg(f5, f6, f7, f8, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    public static final void drawIntoCanvas(@NotNull DrawScope drawScope, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, float f2, float f3, float f4, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f3, f4);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f, -f2, -f3, -f4);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    /* renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m1340rotateRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1331rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m1341rotateRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo1320getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1331rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m1342rotateRadRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1331rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m1343rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo1320getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1331rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m1344scaleFgt4K4Q(@NotNull DrawScope drawScope, float f, float f2, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1332scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m1345scaleFgt4K4Q$default(DrawScope drawScope, float f, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.mo1320getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1332scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m1346scaleRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1332scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    /* renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m1347scaleRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo1320getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1332scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }

    public static final void translate(@NotNull DrawScope drawScope, float f, float f2, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static final void withTransform(@NotNull DrawScope drawScope, @NotNull Function1<? super DrawTransform, Unit> function1, @NotNull Function1<? super DrawScope, Unit> function12) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transformBlock");
        Intrinsics.checkNotNullParameter(function12, "drawBlock");
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        function1.invoke(drawContext.getTransform());
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        function1.invoke(drawScope);
        float f2 = -f;
        drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, float f2, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }
}
