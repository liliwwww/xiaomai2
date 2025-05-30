package androidx.compose.p004ui.tooling;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.ResourceFont;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LayoutlibFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    private final Context context;

    public LayoutlibFontResourceLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    @NotNull
    public Typeface load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        if ((font instanceof ResourceFont) && Build.VERSION.SDK_INT >= 26) {
            return ResourceFontHelper.INSTANCE.load(this.context, (ResourceFont) font);
        }
        throw new IllegalArgumentException("Unknown font type: " + font.getClass().getName());
    }
}
