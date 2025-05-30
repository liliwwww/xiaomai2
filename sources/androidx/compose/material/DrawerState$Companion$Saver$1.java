package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DrawerState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, DrawerState, DrawerValue> {
    public static final DrawerState$Companion$Saver$1 INSTANCE = new DrawerState$Companion$Saver$1();

    DrawerState$Companion$Saver$1() {
        super(2);
    }

    @Nullable
    public final DrawerValue invoke(@NotNull SaverScope saverScope, @NotNull DrawerState drawerState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(drawerState, "it");
        return drawerState.getCurrentValue();
    }
}
