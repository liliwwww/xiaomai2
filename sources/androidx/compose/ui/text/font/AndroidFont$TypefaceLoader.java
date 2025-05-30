package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface AndroidFont$TypefaceLoader {
    @Nullable
    Object awaitLoad(@NotNull Context context, @NotNull AndroidFont androidFont, @NotNull Continuation<? super android.graphics.Typeface> continuation);

    @Nullable
    android.graphics.Typeface loadBlocking(@NotNull Context context, @NotNull AndroidFont androidFont);
}
