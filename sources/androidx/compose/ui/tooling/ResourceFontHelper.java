package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.font.ResourceFont;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ResourceFontHelper {

    @NotNull
    public static final ResourceFontHelper INSTANCE = new ResourceFontHelper();

    private ResourceFontHelper() {
    }

    @DoNotInline
    @NotNull
    public final Typeface load(@NotNull Context context, @NotNull ResourceFont resourceFont) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFont, "font");
        Typeface font = context.getResources().getFont(resourceFont.getResId());
        Intrinsics.checkNotNullExpressionValue(font, "context.resources.getFont(font.resId)");
        return font;
    }
}
