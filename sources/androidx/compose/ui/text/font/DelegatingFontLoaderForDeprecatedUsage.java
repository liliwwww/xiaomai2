package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.Font;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DelegatingFontLoaderForDeprecatedUsage implements PlatformFontLoader {

    @NotNull
    private final Object cacheKey;

    @NotNull
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForDeprecatedUsage(@NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(resourceLoader, "loader");
        this.loader = resourceLoader;
        this.cacheKey = new Object();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object awaitLoad(@NotNull Font font, @NotNull Continuation<Object> continuation) {
        return this.loader.load(font);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @NotNull
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @NotNull
    public Object loadBlocking(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return this.loader.load(font);
    }
}
