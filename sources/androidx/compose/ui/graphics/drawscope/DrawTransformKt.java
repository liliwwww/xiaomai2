package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DrawTransformKt {
    public static final void inset(@NotNull DrawTransform drawTransform, float f, float f2) {
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f, f2, f, f2);
    }

    public static /* synthetic */ void inset$default(DrawTransform drawTransform, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f, f2, f, f2);
    }

    /* renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m1310rotateRad0AR0LA0(@NotNull DrawTransform drawTransform, float f, long j) {
        Intrinsics.checkNotNullParameter(drawTransform, "$this$rotateRad");
        drawTransform.rotate-Uv8p0NA(DegreesKt.degrees(f), j);
    }

    /* renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m1311rotateRad0AR0LA0$default(DrawTransform drawTransform, float f, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawTransform.getCenter-F1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawTransform, "$this$rotateRad");
        drawTransform.rotate-Uv8p0NA(DegreesKt.degrees(f), j);
    }

    /* renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m1312scale0AR0LA0(@NotNull DrawTransform drawTransform, float f, long j) {
        Intrinsics.checkNotNullParameter(drawTransform, "$this$scale");
        drawTransform.scale-0AR0LA0(f, f, j);
    }

    /* renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m1313scale0AR0LA0$default(DrawTransform drawTransform, float f, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawTransform.getCenter-F1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawTransform, "$this$scale");
        drawTransform.scale-0AR0LA0(f, f, j);
    }

    public static final void inset(@NotNull DrawTransform drawTransform, float f) {
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f, f, f, f);
    }
}
