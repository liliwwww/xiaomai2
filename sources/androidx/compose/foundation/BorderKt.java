package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BorderKt {
    @NotNull
    public static final Modifier border(@NotNull Modifier modifier, @NotNull BorderStroke borderStroke, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, "border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m120borderziNgDLE(modifier, borderStroke.getWidth-D9Ej5fM(), borderStroke.getBrush(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    @NotNull
    /* renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m118borderxT4_qwU(@NotNull Modifier modifier, float f, long j, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m120borderziNgDLE(modifier, f, new SolidColor(j, null), shape);
    }

    /* renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m119borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m118borderxT4_qwU(modifier, f, j, shape);
    }

    @NotNull
    /* renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m120borderziNgDLE(@NotNull Modifier modifier, final float f, @NotNull final Brush brush, @NotNull final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$border");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("border");
                inspectorInfo.getProperties().set("width", Dp.m2140boximpl(f));
                if (brush instanceof SolidColor) {
                    inspectorInfo.getProperties().set(TypedValues$Custom.S_COLOR, Color.m1040boximpl(((SolidColor) brush).m1233getValue0d7_KjU()));
                    inspectorInfo.setValue(Color.m1040boximpl(((SolidColor) brush).m1233getValue0d7_KjU()));
                } else {
                    inspectorInfo.getProperties().set("brush", brush);
                }
                inspectorInfo.getProperties().set("shape", shape);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.BorderKt$border$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(-1498088849);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498088849, i, -1, "androidx.compose.foundation.border.<anonymous> (Border.kt:93)");
                }
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Ref();
                    composer.updateRememberedValue(rememberedValue);
                }
                Modifier then = modifier2.then(DrawModifierKt.drawWithCache(Modifier.Companion, new 1(f, shape, (Ref) rememberedValue, brush)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return then;
            }
        });
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m123shrinkKibmq7A(roundRect.m884getTopLeftCornerRadiuskKHJgLs(), f), m123shrinkKibmq7A(roundRect.m885getTopRightCornerRadiuskKHJgLs(), f), m123shrinkKibmq7A(roundRect.m883getBottomRightCornerRadiuskKHJgLs(), f), m123shrinkKibmq7A(roundRect.m882getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    private static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f, roundRect));
            path.op-N5in7k0(path, Path, PathOperation.Companion.m1184getDifferenceb3I0S0c());
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b7, code lost:
    
        if (androidx.compose.ui.graphics.ImageBitmapConfig.equals-impl(r13, r4 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.box-impl(r4.m1149getConfig_sVssgQ()) : null) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r42, androidx.compose.ui.node.Ref<androidx.compose.foundation.BorderCache> r43, final androidx.compose.ui.graphics.Brush r44, final androidx.compose.ui.graphics.Outline.Generic r45, boolean r46, float r47) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.node.Ref, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m121drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, Brush brush, long j, long j2, boolean z, float f) {
        return cacheDrawScope.onDrawWithContent(new drawRectBorder.1(brush, z ? Offset.Companion.getZero-F1C5BW0() : j, z ? cacheDrawScope.getSize-NH-jbRc() : j2, z ? Fill.INSTANCE : new Stroke(f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-SYlcjDY, reason: not valid java name */
    public static final DrawResult m122drawRoundRectBorderSYlcjDY(CacheDrawScope cacheDrawScope, Ref<BorderCache> ref, Brush brush, Outline.Rounded rounded, long j, long j2, boolean z, float f) {
        return RoundRectKt.isSimple(rounded.getRoundRect()) ? cacheDrawScope.onDrawWithContent(new drawRoundRectBorder.1(z, brush, rounded.getRoundRect().m884getTopLeftCornerRadiuskKHJgLs(), f / 2, f, j, j2, new Stroke(f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null))) : cacheDrawScope.onDrawWithContent(new drawRoundRectBorder.2(createRoundRectPath(obtain(ref).obtainPath(), rounded.getRoundRect(), f, z), brush));
    }

    private static final BorderCache obtain(Ref<BorderCache> ref) {
        BorderCache borderCache = (BorderCache) ref.getValue();
        if (borderCache != null) {
            return borderCache;
        }
        BorderCache borderCache2 = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        ref.setValue(borderCache2);
        return borderCache2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m123shrinkKibmq7A(long j, float f) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.getX-impl(j) - f), Math.max(0.0f, CornerRadius.getY-impl(j) - f));
    }
}
