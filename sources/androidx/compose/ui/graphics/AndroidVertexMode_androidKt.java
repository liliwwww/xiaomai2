package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import androidx.compose.ui.graphics.VertexMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidVertexMode_androidKt {
    @NotNull
    /* renamed from: toAndroidVertexMode-JOOmi9M, reason: not valid java name */
    public static final Canvas.VertexMode m1041toAndroidVertexModeJOOmi9M(int i) {
        VertexMode.Companion companion = VertexMode.Companion;
        return VertexMode.m1227equalsimpl0(i, companion.getTriangles-c2xauaI()) ? Canvas.VertexMode.TRIANGLES : VertexMode.m1227equalsimpl0(i, companion.getTriangleStrip-c2xauaI()) ? Canvas.VertexMode.TRIANGLE_STRIP : VertexMode.m1227equalsimpl0(i, companion.getTriangleFan-c2xauaI()) ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
    }
}
