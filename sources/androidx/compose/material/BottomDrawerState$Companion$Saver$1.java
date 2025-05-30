package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BottomDrawerState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, BottomDrawerState, BottomDrawerValue> {
    public static final BottomDrawerState$Companion$Saver$1 INSTANCE = new BottomDrawerState$Companion$Saver$1();

    BottomDrawerState$Companion$Saver$1() {
        super(2);
    }

    @Nullable
    public final BottomDrawerValue invoke(@NotNull SaverScope saverScope, @NotNull BottomDrawerState bottomDrawerState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(bottomDrawerState, "it");
        return bottomDrawerState.getCurrentValue();
    }
}
