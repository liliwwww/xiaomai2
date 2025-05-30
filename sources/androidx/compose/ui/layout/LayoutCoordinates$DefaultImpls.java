package androidx.compose.ui.layout;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.dd2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutCoordinates$DefaultImpls {
    @Deprecated
    /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    public static void m2055transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        dd2.b(layoutCoordinates, layoutCoordinates2, fArr);
    }
}
