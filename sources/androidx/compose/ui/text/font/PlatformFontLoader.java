package androidx.compose.ui.text.font;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PlatformFontLoader {
    @Nullable
    Object awaitLoad(@NotNull Font font, @NotNull Continuation<Object> continuation);

    @Nullable
    Object getCacheKey();

    @Nullable
    Object loadBlocking(@NotNull Font font);
}
