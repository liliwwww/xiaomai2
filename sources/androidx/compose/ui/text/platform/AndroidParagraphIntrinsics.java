package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {

    @NotNull
    private final CharSequence charSequence;

    @NotNull
    private final Density density;
    private final boolean emojiCompatProcessed;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    @NotNull
    private final List<TypefaceDirtyTracker> resolvedTypefaces;

    @NotNull
    private final List<AnnotatedString.Range<SpanStyle>> spanStyles;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final String text;
    private final int textDirectionHeuristic;

    @NotNull
    private final AndroidTextPaint textPaint;

    public AndroidParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull FontFamily.Resolver resolver, @NotNull Density density) {
        boolean hasEmojiCompat;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "density");
        this.text = str;
        this.style = textStyle;
        this.spanStyles = list;
        this.placeholders = list2;
        this.fontFamilyResolver = resolver;
        this.density = density;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density.getDensity());
        this.textPaint = androidTextPaint;
        this.resolvedTypefaces = new ArrayList();
        hasEmojiCompat = AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(textStyle);
        boolean booleanValue = !hasEmojiCompat ? false : ((Boolean) EmojiCompatStatus.INSTANCE.getFontLoaded().getValue()).booleanValue();
        this.emojiCompatProcessed = booleanValue;
        int m1991resolveTextDirectionHeuristics9GRLPo0 = AndroidParagraphIntrinsics_androidKt.m1991resolveTextDirectionHeuristics9GRLPo0(textStyle.getTextDirection-mmuk1to(), textStyle.getLocaleList());
        this.textDirectionHeuristic = m1991resolveTextDirectionHeuristics9GRLPo0;
        resolveTypeface.1 r11 = new resolveTypeface.1(this);
        TextPaintExtensions_androidKt.setTextMotion(androidTextPaint, textStyle.getTextMotion());
        CharSequence createCharSequence = AndroidParagraphHelper_androidKt.createCharSequence(str, androidTextPaint.getTextSize(), textStyle, CollectionsKt.plus(CollectionsKt.listOf(new AnnotatedString.Range(TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, textStyle.toSpanStyle(), r11, density), 0, str.length())), list), list2, density, r11, booleanValue);
        this.charSequence = createCharSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(createCharSequence, androidTextPaint, m1991resolveTextDirectionHeuristics9GRLPo0);
    }

    @NotNull
    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public boolean getHasStaleResolvedFonts() {
        boolean z;
        boolean hasEmojiCompat;
        List<TypefaceDirtyTracker> list = this.resolvedTypefaces;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            if (list.get(i).isStaleResolvedFont()) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            if (this.emojiCompatProcessed) {
                return false;
            }
            hasEmojiCompat = AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(this.style);
            if (!hasEmojiCompat || !((Boolean) EmojiCompatStatus.INSTANCE.getFontLoaded().getValue()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics$ui_text_release() {
        return this.layoutIntrinsics;
    }

    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final List<AnnotatedString.Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getTextDirectionHeuristic$ui_text_release() {
        return this.textDirectionHeuristic;
    }

    @NotNull
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.textPaint;
    }
}
