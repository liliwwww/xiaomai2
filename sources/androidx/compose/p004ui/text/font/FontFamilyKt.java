package androidx.compose.p004ui.text.font;

import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FontFamilyKt {
    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull List<? extends Font> list) {
        Intrinsics.checkNotNullParameter(list, "fonts");
        return new FontListFontFamily(list);
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Font... fontArr) {
        Intrinsics.checkNotNullParameter(fontArr, "fonts");
        return new FontListFontFamily(ArraysKt.asList(fontArr));
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        return new LoadedFontFamily(typeface);
    }
}
