package androidx.compose.ui.platform;

import android.graphics.Matrix;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class RenderNodeLayer$Companion$getMatrix$1 extends Lambda implements Function2<DeviceRenderNode, Matrix, Unit> {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((DeviceRenderNode) obj, (Matrix) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeviceRenderNode deviceRenderNode, @NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(deviceRenderNode, "rn");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        deviceRenderNode.getMatrix(matrix);
    }
}
