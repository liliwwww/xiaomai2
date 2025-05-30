package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class GenericFontFamily extends SystemFontFamily {

    @NotNull
    private final String fontFamilyName;

    @NotNull
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFontFamily(@NotNull String str, @NotNull String str2) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "fontFamilyName");
        this.name = str;
        this.fontFamilyName = str2;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public String toString() {
        return this.fontFamilyName;
    }
}
