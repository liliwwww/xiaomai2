package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SpannedExtensionsKt {
    public static final boolean hasSpan(@NotNull Spanned spanned, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public static final boolean hasSpan(@NotNull Spanned spanned, @NotNull Class<?> cls, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return spanned.nextSpanTransition(i - 1, i2, cls) != i2;
    }
}
