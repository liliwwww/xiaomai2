package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import androidx.collection.LruCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.AndroidPreloadedFont;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Deprecated(message = "Duplicate cache")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidTypefaceCache {

    @NotNull
    public static final AndroidTypefaceCache INSTANCE = new AndroidTypefaceCache();

    @NotNull
    private static final LruCache<String, Typeface> cache = new LruCache<>(16);

    private AndroidTypefaceCache() {
    }

    @Nullable
    public final String getKey(@NotNull Context context, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(font, "font");
        if (!(font instanceof ResourceFont)) {
            if (font instanceof AndroidPreloadedFont) {
                return ((AndroidPreloadedFont) font).getCacheKey();
            }
            throw new IllegalArgumentException("Unknown font type: " + font);
        }
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(((ResourceFont) font).getResId(), typedValue, true);
        StringBuilder sb = new StringBuilder();
        sb.append("res:");
        CharSequence charSequence = typedValue.string;
        String obj = charSequence != null ? charSequence.toString() : null;
        Intrinsics.checkNotNull(obj);
        sb.append(obj);
        return sb.toString();
    }

    @NotNull
    public final Typeface getOrCreate(@NotNull Context context, @NotNull Font font) {
        Typeface loadBlocking;
        Typeface typeface;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(font, "font");
        String key = getKey(context, font);
        if (key != null && (typeface = (Typeface) cache.get(key)) != null) {
            Intrinsics.checkNotNullExpressionValue(typeface, "it");
            return typeface;
        }
        if (font instanceof ResourceFont) {
            if (Build.VERSION.SDK_INT >= 26) {
                loadBlocking = AndroidResourceFontLoaderHelper.INSTANCE.create(context, ((ResourceFont) font).getResId());
            } else {
                loadBlocking = ResourcesCompat.getFont(context, ((ResourceFont) font).getResId());
                Intrinsics.checkNotNull(loadBlocking);
                Intrinsics.checkNotNullExpressionValue(loadBlocking, "{\n                    Re…esId)!!\n                }");
            }
        } else {
            if (!(font instanceof AndroidFont)) {
                throw new IllegalArgumentException("Unknown font type: " + font);
            }
            AndroidFont androidFont = (AndroidFont) font;
            loadBlocking = androidFont.getTypefaceLoader().loadBlocking(context, androidFont);
        }
        if (loadBlocking != null) {
            if (key != null) {
            }
            return loadBlocking;
        }
        throw new IllegalArgumentException("Unable to load font " + font);
    }
}
