package androidx.compose.ui.text.font;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TypefaceHelperMethodsApi28 {

    @NotNull
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    private TypefaceHelperMethodsApi28() {
    }

    @DoNotInline
    @RequiresApi(28)
    @NotNull
    public final android.graphics.Typeface create(@NotNull android.graphics.Typeface typeface, int i, boolean z) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        android.graphics.Typeface create = android.graphics.Typeface.create(typeface, i, z);
        Intrinsics.checkNotNullExpressionValue(create, "create(typeface, finalFontWeight, finalFontStyle)");
        return create;
    }
}
