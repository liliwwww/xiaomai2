package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ShaderKt {
    public static final void transform(@NotNull Shader shader, @NotNull Function1<? super Matrix, Unit> function1) {
        Intrinsics.checkNotNullParameter(shader, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
