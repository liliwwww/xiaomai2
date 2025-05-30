package androidx.compose.foundation.text;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class StringHelpers_jvmKt {
    @NotNull
    public static final StringBuilder appendCodePointX(@NotNull StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder appendCodePoint = sb.appendCodePoint(i);
        Intrinsics.checkNotNullExpressionValue(appendCodePoint, "appendCodePointX");
        return appendCodePoint;
    }
}
