package androidx.compose.p004ui.text;

import androidx.compose.p004ui.text.caches.LruCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextLayoutCache {

    @NotNull
    private final LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache;

    public TextLayoutCache() {
        this(0, 1, null);
    }

    public TextLayoutCache(int i) {
        this.lruCache = new LruCache<>(i);
    }

    @Nullable
    public final TextLayoutResult get(@NotNull TextLayoutInput textLayoutInput) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "key");
        TextLayoutResult textLayoutResult = this.lruCache.get(new CacheTextLayoutInput(textLayoutInput));
        if (textLayoutResult == null || textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return null;
        }
        return textLayoutResult;
    }

    @Nullable
    public final TextLayoutResult put(@NotNull TextLayoutInput textLayoutInput, @NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "key");
        Intrinsics.checkNotNullParameter(textLayoutResult, "value");
        return this.lruCache.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult);
    }

    @Nullable
    public final TextLayoutResult remove(@NotNull TextLayoutInput textLayoutInput) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "key");
        return this.lruCache.remove(new CacheTextLayoutInput(textLayoutInput));
    }

    public /* synthetic */ TextLayoutCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }
}
