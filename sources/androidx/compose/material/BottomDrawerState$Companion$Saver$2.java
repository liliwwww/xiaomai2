package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BottomDrawerState$Companion$Saver$2 extends Lambda implements Function1<BottomDrawerValue, BottomDrawerState> {
    final /* synthetic */ Function1<BottomDrawerValue, Boolean> $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomDrawerState$Companion$Saver$2(Function1<? super BottomDrawerValue, Boolean> function1) {
        super(1);
        this.$confirmStateChange = function1;
    }

    @Nullable
    public final BottomDrawerState invoke(@NotNull BottomDrawerValue bottomDrawerValue) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "it");
        return new BottomDrawerState(bottomDrawerValue, this.$confirmStateChange);
    }
}
