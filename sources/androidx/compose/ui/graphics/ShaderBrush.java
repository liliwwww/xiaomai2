package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;

    @Nullable
    private Shader internalShader;

    public ShaderBrush() {
        super((DefaultConstructorMarker) null);
        this.createdSize = Size.Companion.m911getUnspecifiedNHjbRc();
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public final void m1216applyToPq9zytI(long j, @NotNull Paint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m899equalsimpl0(this.createdSize, j)) {
            shader = mo1027createShaderuvyYCjk(j);
            this.internalShader = shader;
            this.createdSize = j;
        }
        long j2 = paint.getColor-0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1051equalsimpl0(j2, companion.getBlack-0d7_KjU())) {
            paint.setColor-8_81llA(companion.getBlack-0d7_KjU());
        }
        if (!Intrinsics.areEqual(paint.getShader(), shader)) {
            paint.setShader(shader);
        }
        if (paint.getAlpha() == f) {
            return;
        }
        paint.setAlpha(f);
    }

    @NotNull
    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo1027createShaderuvyYCjk(long j);
}
