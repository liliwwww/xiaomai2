package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m2142constructorimpl(24);
    private static final float CheckboxSize = Dp.m2142constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m2142constructorimpl(f);
        StrokeWidth = Dp.m2142constructorimpl(f);
        RadiusSize = Dp.m2142constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0060  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Checkbox(boolean r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, boolean r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r31, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026f A[LOOP:0: B:102:0x026d->B:103:0x026f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0190 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d3  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CheckboxImpl(boolean r34, androidx.compose.ui.state.ToggleableState r35, androidx.compose.ui.Modifier r36, androidx.compose.material.CheckboxColors r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-10, reason: not valid java name */
    public static final long m535CheckboxImpl$lambda10(State<Color> state) {
        return ((Color) state.getValue()).m1060unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-4, reason: not valid java name */
    public static final float m536CheckboxImpl$lambda4(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-6, reason: not valid java name */
    public static final float m537CheckboxImpl$lambda6(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-8, reason: not valid java name */
    public static final long m538CheckboxImpl$lambda8(State<Color> state) {
        return ((Color) state.getValue()).m1060unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-9, reason: not valid java name */
    public static final long m539CheckboxImpl$lambda9(State<Color> state) {
        return ((Color) state.getValue()).m1060unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0066  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TriStateCheckbox(@org.jetbrains.annotations.NotNull final androidx.compose.ui.state.ToggleableState r25, @org.jetbrains.annotations.Nullable final kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, boolean r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r29, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m547drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float m903getWidthimpl = Size.m903getWidthimpl(drawScope.mo1321getSizeNHjbRc());
        if (Color.m1051equalsimpl0(j, j2)) {
            w51.M(drawScope, j, 0L, SizeKt.Size(m903getWidthimpl, m903getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f4 = m903getWidthimpl - (2 * f2);
        w51.M(drawScope, j, OffsetKt.Offset(f2, f2), SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        float f5 = m903getWidthimpl - f2;
        w51.M(drawScope, j2, OffsetKt.Offset(f3, f3), SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m548drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.getSquare-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float m903getWidthimpl = Size.m903getWidthimpl(drawScope.mo1321getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * m903getWidthimpl, lerp3 * m903getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(lerp * m903getWidthimpl, lerp2 * m903getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * m903getWidthimpl, m903getWidthimpl * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        w51.G(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }
}
