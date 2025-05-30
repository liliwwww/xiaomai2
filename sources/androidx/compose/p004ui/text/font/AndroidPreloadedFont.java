package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class AndroidPreloadedFont extends AndroidFont {
    private boolean didInitWithContext;
    private final int style;

    @Nullable
    private Typeface typeface;

    @NotNull
    private final FontWeight weight;

    private AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m4826getBlockingPKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, settings, null);
        this.weight = fontWeight;
        this.style = i;
    }

    public /* synthetic */ AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontWeight, i, settings);
    }

    @Nullable
    public abstract Typeface doLoad$ui_text_release(@Nullable Context context);

    @Nullable
    public abstract String getCacheKey();

    @Override // androidx.compose.p004ui.text.font.Font
    /* renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public final int mo4790getStyle_LCdwA() {
        return this.style;
    }

    @Nullable
    public final Typeface getTypeface$ui_text_release() {
        return this.typeface;
    }

    @Override // androidx.compose.p004ui.text.font.Font
    @NotNull
    public final FontWeight getWeight() {
        return this.weight;
    }

    @Nullable
    public final Typeface loadCached$ui_text_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.didInitWithContext && this.typeface == null) {
            this.typeface = doLoad$ui_text_release(context);
        }
        this.didInitWithContext = true;
        return this.typeface;
    }

    public final void setTypeface$ui_text_release(@Nullable Typeface typeface) {
        this.typeface = typeface;
    }
}
