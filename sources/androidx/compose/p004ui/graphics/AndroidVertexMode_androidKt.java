package androidx.compose.p004ui.graphics;

import android.graphics.Canvas;
import androidx.compose.p004ui.graphics.VertexMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidVertexMode_androidKt {
    @NotNull
    /* renamed from: toAndroidVertexMode-JOOmi9M, reason: not valid java name */
    public static final Canvas.VertexMode m2701toAndroidVertexModeJOOmi9M(int i) {
        VertexMode.Companion companion = VertexMode.Companion;
        return VertexMode.m3134equalsimpl0(i, companion.m3140getTrianglesc2xauaI()) ? Canvas.VertexMode.TRIANGLES : VertexMode.m3134equalsimpl0(i, companion.m3139getTriangleStripc2xauaI()) ? Canvas.VertexMode.TRIANGLE_STRIP : VertexMode.m3134equalsimpl0(i, companion.m3138getTriangleFanc2xauaI()) ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
    }
}
