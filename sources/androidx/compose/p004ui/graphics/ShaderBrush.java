package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;

    @Nullable
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m2633getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.p004ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo2740applyToPq9zytI(long j, @NotNull Paint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m2621equalsimpl0(this.createdSize, j)) {
            shader = mo2762createShaderuvyYCjk(j);
            this.internalShader = shader;
            this.createdSize = j;
        }
        long mo2671getColor0d7_KjU = paint.mo2671getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m2788equalsimpl0(mo2671getColor0d7_KjU, companion.m2813getBlack0d7_KjU())) {
            paint.mo2677setColor8_81llA(companion.m2813getBlack0d7_KjU());
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
    public abstract Shader mo2762createShaderuvyYCjk(long j);
}
