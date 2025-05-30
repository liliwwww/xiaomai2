package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class IconKt {

    @NotNull
    private static final Modifier DefaultIconSizeModifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.m2142constructorimpl(24));

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m603Iconww6aTOc(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        composer.startReplaceableGroup(-800853103);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        long m1049copywmQWz5c$default = (i2 & 8) != 0 ? Color.m1049copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1060unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-800853103, i, -1, "androidx.compose.material.Icon (Icon.kt:56)");
        }
        m602Iconww6aTOc((Painter) VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, modifier2, m1049copywmQWz5c$default, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        return modifier.then((Size.m899equalsimpl0(painter.mo1353getIntrinsicSizeNHjbRc(), Size.Companion.m911getUnspecifiedNHjbRc()) || m604isInfiniteuvyYCjk(painter.mo1353getIntrinsicSizeNHjbRc())) ? DefaultIconSizeModifier : Modifier.Companion);
    }

    /* renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m604isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.m903getWidthimpl(j)) && Float.isInfinite(Size.m900getHeightimpl(j));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m601Iconww6aTOc(@NotNull ImageBitmap imageBitmap, @Nullable String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        composer.startReplaceableGroup(-554892675);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        long m1049copywmQWz5c$default = (i2 & 8) != 0 ? Color.m1049copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1060unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554892675, i, -1, "androidx.compose.material.Icon (Icon.kt:85)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(imageBitmap);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
            composer.updateRememberedValue(bitmapPainter);
            rememberedValue = bitmapPainter;
        }
        composer.endReplaceableGroup();
        m602Iconww6aTOc((Painter) rememberedValue, str, modifier2, m1049copywmQWz5c$default, composer, (i & 112) | 8 | (i & 896) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m602Iconww6aTOc(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, long j, @Nullable Composer composer, int i, int i2) {
        long j2;
        int i3;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer startRestartGroup = composer.startRestartGroup(-1142959010);
        Modifier modifier3 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            i3 = i & (-7169);
            j2 = Color.m1049copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m1060unboximpl(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j2 = j;
            i3 = i;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1142959010, i3, -1, "androidx.compose.material.Icon (Icon.kt:114)");
        }
        ColorFilter m1061tintxETnrds$default = Color.m1051equalsimpl0(j2, Color.Companion.getUnspecified-0d7_KjU()) ? null : ColorFilter.Companion.m1061tintxETnrds$default(ColorFilter.Companion, j2, 0, 2, null);
        startRestartGroup.startReplaceableGroup(1547385429);
        if (str != null) {
            Modifier.Companion companion = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(str);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Icon.semantics.1.1(str);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null);
        } else {
            modifier2 = Modifier.Companion;
        }
        startRestartGroup.endReplaceableGroup();
        long j3 = j2;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier3), painter), painter, false, null, ContentScale.Companion.getFit(), 0.0f, m1061tintxETnrds$default, 22, null).then(modifier2), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Icon.1(painter, str, modifier3, j3, i, i2));
    }
}
