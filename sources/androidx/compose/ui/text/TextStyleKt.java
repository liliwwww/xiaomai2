package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextStyleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    @NotNull
    public static final TextStyle lerp(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, float f) {
        Intrinsics.checkNotNullParameter(textStyle, "start");
        Intrinsics.checkNotNullParameter(textStyle2, "stop");
        return new TextStyle(SpanStyleKt.lerp(textStyle.toSpanStyle(), textStyle2.toSpanStyle(), f), ParagraphStyleKt.lerp(textStyle.toParagraphStyle(), textStyle2.toParagraphStyle(), f));
    }

    @NotNull
    public static final TextStyle resolveDefaults(@NotNull TextStyle textStyle, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, "direction");
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(textStyle.getSpanStyle$ui_text_release()), ParagraphStyleKt.resolveParagraphStyleDefaults(textStyle.getParagraphStyle$ui_text_release(), layoutDirection), textStyle.getPlatformStyle());
    }

    /* renamed from: resolveTextDirection-Yj3eThk, reason: not valid java name */
    public static final int m1896resolveTextDirectionYj3eThk(@NotNull LayoutDirection layoutDirection, @Nullable TextDirection textDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        TextDirection.Companion companion = TextDirection.Companion;
        if (textDirection == null ? false : TextDirection.m2070equalsimpl0(textDirection.m2073unboximpl(), companion.getContent-s_7X-co())) {
            int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i == 1) {
                return companion.getContentOrLtr-s_7X-co();
            }
            if (i == 2) {
                return companion.getContentOrRtl-s_7X-co();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (textDirection != null) {
            return textDirection.m2073unboximpl();
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i2 == 1) {
            return companion.getLtr-s_7X-co();
        }
        if (i2 == 2) {
            return companion.getRtl-s_7X-co();
        }
        throw new NoWhenBranchMatchedException();
    }
}
