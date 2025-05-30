package androidx.compose.ui.text.font;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class AndroidFont implements Font {
    public static final int $stable = 0;
    private final int loadingStrategy;

    @NotNull
    private final TypefaceLoader typefaceLoader;

    @NotNull
    private final FontVariation$Settings variationSettings;

    private AndroidFont(int i, TypefaceLoader typefaceLoader, FontVariation$Settings fontVariation$Settings) {
        this.loadingStrategy = i;
        this.typefaceLoader = typefaceLoader;
        this.variationSettings = fontVariation$Settings;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getLoadingStrategy-PKNRLFQ, reason: not valid java name */
    public final int mo1897getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    @NotNull
    public final TypefaceLoader getTypefaceLoader() {
        return this.typefaceLoader;
    }

    @NotNull
    public final FontVariation$Settings getVariationSettings() {
        return this.variationSettings;
    }

    private AndroidFont(int i, TypefaceLoader typefaceLoader) {
        this(i, typefaceLoader, new FontVariation$Settings(new FontVariation$Setting[0]));
    }
}
