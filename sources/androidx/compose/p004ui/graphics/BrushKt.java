package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BrushKt {
    @NotNull
    public static final ShaderBrush ShaderBrush(@NotNull final Shader shader) {
        Intrinsics.checkNotNullParameter(shader, "shader");
        return new ShaderBrush() { // from class: androidx.compose.ui.graphics.BrushKt$ShaderBrush$1
            @Override // androidx.compose.p004ui.graphics.ShaderBrush
            @NotNull
            /* renamed from: createShader-uvyYCjk, reason: not valid java name */
            public Shader mo2762createShaderuvyYCjk(long j) {
                return shader;
            }
        };
    }
}
