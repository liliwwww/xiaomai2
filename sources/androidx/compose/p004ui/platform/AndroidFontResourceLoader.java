package androidx.compose.p004ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "Replaced with PlatformFontLoader during the introduction of async fonts, all usages should be replaced", replaceWith = @ReplaceWith(expression = "PlatformFontLoader", imports = {}))
/* loaded from: classes2.dex */
public final class AndroidFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    private final Context context;

    public AndroidFontResourceLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    @NotNull
    public Typeface load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        if (!(font instanceof ResourceFont)) {
            throw new IllegalArgumentException("Unknown font type: " + font);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return AndroidFontResourceLoaderHelper.INSTANCE.create(this.context, ((ResourceFont) font).getResId());
        }
        Typeface font2 = ResourcesCompat.getFont(this.context, ((ResourceFont) font).getResId());
        Intrinsics.checkNotNull(font2);
        Intrinsics.checkNotNullExpressionValue(font2, "{\n                    Re…esId)!!\n                }");
        return font2;
    }
}
