package androidx.compose.ui.geometry;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutableRectKt {
    @NotNull
    public static final Rect toRect(@NotNull MutableRect mutableRect) {
        Intrinsics.checkNotNullParameter(mutableRect, "<this>");
        return new Rect(mutableRect.getLeft(), mutableRect.getTop(), mutableRect.getRight(), mutableRect.getBottom());
    }
}
