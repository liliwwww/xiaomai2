package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DrawerState$Companion$Saver$2 extends Lambda implements Function1<DrawerValue, DrawerState> {
    final /* synthetic */ Function1<DrawerValue, Boolean> $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerState$Companion$Saver$2(Function1<? super DrawerValue, Boolean> function1) {
        super(1);
        this.$confirmStateChange = function1;
    }

    @Nullable
    public final DrawerState invoke(@NotNull DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return new DrawerState(drawerValue, this.$confirmStateChange);
    }
}
