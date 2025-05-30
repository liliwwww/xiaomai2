package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidFontResourceLoaderHelper {

    @NotNull
    public static final AndroidFontResourceLoaderHelper INSTANCE = new AndroidFontResourceLoaderHelper();

    private AndroidFontResourceLoaderHelper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final Typeface create(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Typeface font = context.getResources().getFont(i);
        Intrinsics.checkNotNullExpressionValue(font, "context.resources.getFont(resourceId)");
        return font;
    }
}
