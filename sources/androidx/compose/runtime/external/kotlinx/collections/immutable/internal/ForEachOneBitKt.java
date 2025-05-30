package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int i, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        int i2 = 0;
        while (i != 0) {
            int lowestOneBit = Integer.lowestOneBit(i);
            function2.invoke(Integer.valueOf(lowestOneBit), Integer.valueOf(i2));
            i2++;
            i ^= lowestOneBit;
        }
    }
}
