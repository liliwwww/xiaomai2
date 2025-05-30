package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PlatformSpanStyle {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final PlatformSpanStyle Default = new PlatformSpanStyle();

    public boolean equals(@Nullable Object obj) {
        return this == obj || (obj instanceof PlatformSpanStyle);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public final PlatformSpanStyle merge(@Nullable PlatformSpanStyle platformSpanStyle) {
        return this;
    }

    @NotNull
    public String toString() {
        return "PlatformSpanStyle()";
    }
}
