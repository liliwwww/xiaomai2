package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FlowLayoutKt$crossAxisRowArrangement$1 extends Lambda implements Function4<Integer, int[], MeasureScope, int[], Unit> {
    public static final FlowLayoutKt$crossAxisRowArrangement$1 INSTANCE = new FlowLayoutKt$crossAxisRowArrangement$1();

    FlowLayoutKt$crossAxisRowArrangement$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), (int[]) obj2, (MeasureScope) obj3, (int[]) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, @NotNull int[] iArr, @NotNull MeasureScope measureScope, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        Arrangement.INSTANCE.getTop().arrange(measureScope, i, iArr, iArr2);
    }
}
