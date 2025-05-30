package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BackdropScaffoldState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, BackdropScaffoldState, BackdropValue> {
    public static final BackdropScaffoldState$Companion$Saver$1 INSTANCE = new BackdropScaffoldState$Companion$Saver$1();

    BackdropScaffoldState$Companion$Saver$1() {
        super(2);
    }

    @Nullable
    public final BackdropValue invoke(@NotNull SaverScope saverScope, @NotNull BackdropScaffoldState backdropScaffoldState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(backdropScaffoldState, "it");
        return backdropScaffoldState.getCurrentValue();
    }
}
