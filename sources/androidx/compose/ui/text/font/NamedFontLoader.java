package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NamedFontLoader implements AndroidFont.TypefaceLoader {

    @NotNull
    public static final NamedFontLoader INSTANCE = new NamedFontLoader();

    private NamedFontLoader() {
    }

    @Nullable
    public Object awaitLoad(@NotNull Context context, @NotNull AndroidFont androidFont, @NotNull Continuation<? super Typeface> continuation) {
        throw new UnsupportedOperationException("All preloaded fonts are optional local.");
    }

    @Nullable
    public Typeface loadBlocking(@NotNull Context context, @NotNull AndroidFont androidFont) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(androidFont, "font");
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = androidFont instanceof DeviceFontFamilyNameFont ? (DeviceFontFamilyNameFont) androidFont : null;
        if (deviceFontFamilyNameFont != null) {
            return deviceFontFamilyNameFont.loadCached(context);
        }
        return null;
    }
}
