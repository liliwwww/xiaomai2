package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidTypefaceWrapper implements AndroidTypeface {

    @Nullable
    private final FontFamily fontFamily;

    @NotNull
    private final Typeface typeface;

    public AndroidTypefaceWrapper(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    @Nullable
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface m2466getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return this.typeface;
    }

    @NotNull
    public final Typeface getTypeface() {
        return this.typeface;
    }
}
