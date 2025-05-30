package androidx.compose.p004ui.text.input;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class GapBuffer_jvmKt {
    public static final void toCharArray(@NotNull String str, @NotNull char[] cArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "destination");
        str.getChars(i2, i3, cArr, i);
    }
}
