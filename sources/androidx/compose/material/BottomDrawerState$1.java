package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BottomDrawerState$1 extends Lambda implements Function1<BottomDrawerValue, Boolean> {
    public static final BottomDrawerState$1 INSTANCE = new BottomDrawerState$1();

    BottomDrawerState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull BottomDrawerValue bottomDrawerValue) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "it");
        return Boolean.TRUE;
    }
}
