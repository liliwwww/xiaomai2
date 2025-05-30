package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;
import tb.y51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidCursorHandle_androidKt$drawCursorHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final AndroidCursorHandle_androidKt$drawCursorHandle$1 INSTANCE = new AndroidCursorHandle_androidKt$drawCursorHandle$1();

    AndroidCursorHandle_androidKt$drawCursorHandle$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-2126899193);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2126899193, i, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:62)");
        }
        final long j = ((TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getHandleColor-0d7_KjU();
        Modifier.Companion companion = Modifier.Companion;
        Color color = Color.box-impl(j);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(color);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
                    Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                    final float f = Size.getWidth-impl(cacheDrawScope.m943getSizeNHjbRc()) / 2.0f;
                    final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, f);
                    final ColorFilter colorFilter = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j, 0, 2, (Object) null);
                    return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1.1
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
                            float f2 = f;
                            ImageBitmap imageBitmap = createHandleImage;
                            ColorFilter colorFilter2 = colorFilter;
                            DrawContext drawContext = contentDrawScope.getDrawContext();
                            long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
                            drawContext.getCanvas().save();
                            DrawTransform transform = drawContext.getTransform();
                            y51.g(transform, f2, 0.0f, 2, (Object) null);
                            transform.rotate-Uv8p0NA(45.0f, Offset.Companion.m1024getZeroF1C5BW0());
                            w51.A(contentDrawScope, imageBitmap, 0L, 0.0f, (DrawStyle) null, colorFilter2, 0, 46, (Object) null);
                            drawContext.getCanvas().restore();
                            drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
                        }
                    });
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(companion, (Function1) rememberedValue));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
