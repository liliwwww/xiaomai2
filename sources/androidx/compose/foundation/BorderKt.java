package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.CacheDrawScope;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.draw.DrawResult;
import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.CornerRadiusKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.geometry.RoundRectKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.ClipOp;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathOperation;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.node.Ref;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BorderKt {
    @NotNull
    public static final Modifier border(@NotNull Modifier modifier, @NotNull BorderStroke borderStroke, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, OutlinedTextFieldKt.BorderId);
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m1128borderziNgDLE(modifier, borderStroke.m1134getWidthD9Ej5fM(), borderStroke.getBrush(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    @NotNull
    /* renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m1126borderxT4_qwU(@NotNull Modifier modifier, float f, long j, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m1128borderziNgDLE(modifier, f, new SolidColor(j, null), shape);
    }

    /* renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1127borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m1126borderxT4_qwU(modifier, f, j, shape);
    }

    @NotNull
    /* renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m1128borderziNgDLE(@NotNull Modifier modifier, final float f, @NotNull final Brush brush, @NotNull final Shape shape) {
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
                inspectorInfo.setName(OutlinedTextFieldKt.BorderId);
                inspectorInfo.getProperties().set("width", C0856Dp.m5214boximpl(f));
                if (brush instanceof SolidColor) {
                    inspectorInfo.getProperties().set(TypedValues.Custom.S_COLOR, Color.m2777boximpl(((SolidColor) brush).m3074getValue0d7_KjU()));
                    inspectorInfo.setValue(Color.m2777boximpl(((SolidColor) brush).m3074getValue0d7_KjU()));
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
                final Ref ref = (Ref) rememberedValue;
                Modifier.Companion companion = Modifier.Companion;
                final float f2 = f;
                final Shape shape2 = shape;
                final Brush brush2 = brush;
                Modifier then = modifier2.then(DrawModifierKt.drawWithCache(companion, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderKt$border$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @NotNull
                    public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
                        DrawResult m1129drawRectBorderNsqcLGU;
                        DrawResult m1130drawRoundRectBorderSYlcjDY;
                        DrawResult drawGenericBorder;
                        DrawResult drawContentWithoutBorder;
                        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                        if (!(cacheDrawScope.mo1283toPx0680j_4(f2) >= 0.0f && Size.m2624getMinDimensionimpl(cacheDrawScope.m2466getSizeNHjbRc()) > 0.0f)) {
                            drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
                            return drawContentWithoutBorder;
                        }
                        float f3 = 2;
                        float min = Math.min(C0856Dp.m5221equalsimpl0(f2, C0856Dp.Companion.m5234getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo1283toPx0680j_4(f2)), (float) Math.ceil(Size.m2624getMinDimensionimpl(cacheDrawScope.m2466getSizeNHjbRc()) / f3));
                        float f4 = min / f3;
                        long Offset = OffsetKt.Offset(f4, f4);
                        long Size = SizeKt.Size(Size.m2625getWidthimpl(cacheDrawScope.m2466getSizeNHjbRc()) - min, Size.m2622getHeightimpl(cacheDrawScope.m2466getSizeNHjbRc()) - min);
                        boolean z = f3 * min > Size.m2624getMinDimensionimpl(cacheDrawScope.m2466getSizeNHjbRc());
                        Outline mo1164createOutlinePq9zytI = shape2.mo1164createOutlinePq9zytI(cacheDrawScope.m2466getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                        if (mo1164createOutlinePq9zytI instanceof Outline.Generic) {
                            drawGenericBorder = BorderKt.drawGenericBorder(cacheDrawScope, ref, brush2, (Outline.Generic) mo1164createOutlinePq9zytI, z, min);
                            return drawGenericBorder;
                        }
                        if (mo1164createOutlinePq9zytI instanceof Outline.Rounded) {
                            m1130drawRoundRectBorderSYlcjDY = BorderKt.m1130drawRoundRectBorderSYlcjDY(cacheDrawScope, ref, brush2, (Outline.Rounded) mo1164createOutlinePq9zytI, Offset, Size, z, min);
                            return m1130drawRoundRectBorderSYlcjDY;
                        }
                        if (!(mo1164createOutlinePq9zytI instanceof Outline.Rectangle)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        m1129drawRectBorderNsqcLGU = BorderKt.m1129drawRectBorderNsqcLGU(cacheDrawScope, brush2, Offset, Size, z, min);
                        return m1129drawRectBorderNsqcLGU;
                    }
                }));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return then;
            }
        });
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m1131shrinkKibmq7A(roundRect.m2606getTopLeftCornerRadiuskKHJgLs(), f), m1131shrinkKibmq7A(roundRect.m2607getTopRightCornerRadiuskKHJgLs(), f), m1131shrinkKibmq7A(roundRect.m2605getBottomRightCornerRadiuskKHJgLs(), f), m1131shrinkKibmq7A(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    private static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f, roundRect));
            path.mo2690opN5in7k0(path, Path, PathOperation.Companion.m3039getDifferenceb3I0S0c());
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
    
        if (androidx.compose.p004ui.graphics.ImageBitmapConfig.m2968equalsimpl(r13, r4 != null ? androidx.compose.p004ui.graphics.ImageBitmapConfig.m2966boximpl(r4.mo2665getConfig_sVssgQ()) : null) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.p004ui.draw.DrawResult drawGenericBorder(androidx.compose.p004ui.draw.CacheDrawScope r42, androidx.compose.p004ui.node.Ref<androidx.compose.foundation.BorderCache> r43, final androidx.compose.p004ui.graphics.Brush r44, final androidx.compose.ui.graphics.Outline.Generic r45, boolean r46, float r47) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.node.Ref, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m1129drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, final Brush brush, long j, long j2, boolean z, float f) {
        final long m2572getZeroF1C5BW0 = z ? Offset.Companion.m2572getZeroF1C5BW0() : j;
        final long m2466getSizeNHjbRc = z ? cacheDrawScope.m2466getSizeNHjbRc() : j2;
        final DrawStyle stroke = z ? Fill.INSTANCE : new Stroke(f, 0.0f, 0, 0, null, 30, null);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                w51.J(contentDrawScope, Brush.this, m2572getZeroF1C5BW0, m2466getSizeNHjbRc, 0.0f, stroke, (ColorFilter) null, 0, 104, (Object) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-SYlcjDY, reason: not valid java name */
    public static final DrawResult m1130drawRoundRectBorderSYlcjDY(CacheDrawScope cacheDrawScope, Ref<BorderCache> ref, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        if (!RoundRectKt.isSimple(rounded.getRoundRect())) {
            final Path createRoundRectPath = createRoundRectPath(obtain(ref).obtainPath(), rounded.getRoundRect(), f, z);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRoundRectBorder$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                    Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                    contentDrawScope.drawContent();
                    w51.F(contentDrawScope, Path.this, brush, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                }
            });
        }
        final long m2606getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m2606getTopLeftCornerRadiuskKHJgLs();
        final float f2 = f / 2;
        final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRoundRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                long m1131shrinkKibmq7A;
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                if (z) {
                    w51.L(contentDrawScope, brush, 0L, 0L, m2606getTopLeftCornerRadiuskKHJgLs, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
                    return;
                }
                float m2531getXimpl = CornerRadius.m2531getXimpl(m2606getTopLeftCornerRadiuskKHJgLs);
                float f3 = f2;
                if (m2531getXimpl >= f3) {
                    Brush brush2 = brush;
                    long j3 = j;
                    long j4 = j2;
                    m1131shrinkKibmq7A = BorderKt.m1131shrinkKibmq7A(m2606getTopLeftCornerRadiuskKHJgLs, f3);
                    w51.L(contentDrawScope, brush2, j3, j4, m1131shrinkKibmq7A, 0.0f, stroke, (ColorFilter) null, 0, 208, (Object) null);
                    return;
                }
                float f4 = f;
                float m2625getWidthimpl = Size.m2625getWidthimpl(contentDrawScope.mo3205getSizeNHjbRc()) - f;
                float m2622getHeightimpl = Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc()) - f;
                int m2775getDifferencertfAjoo = ClipOp.Companion.m2775getDifferencertfAjoo();
                Brush brush3 = brush;
                long j5 = m2606getTopLeftCornerRadiuskKHJgLs;
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo3214clipRectN_I0leg(f4, f4, m2625getWidthimpl, m2622getHeightimpl, m2775getDifferencertfAjoo);
                w51.L(contentDrawScope, brush3, 0L, 0L, j5, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
                drawContext.getCanvas().restore();
                drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
            }
        });
    }

    private static final BorderCache obtain(Ref<BorderCache> ref) {
        BorderCache value = ref.getValue();
        if (value != null) {
            return value;
        }
        BorderCache borderCache = new BorderCache(null, null, null, null, 15, null);
        ref.setValue(borderCache);
        return borderCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m1131shrinkKibmq7A(long j, float f) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m2531getXimpl(j) - f), Math.max(0.0f, CornerRadius.m2532getYimpl(j) - f));
    }
}
