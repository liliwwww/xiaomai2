package androidx.compose.material;

import androidx.compose.ui.unit.IntRect;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DropdownMenuPositionProvider$1 extends Lambda implements Function2<IntRect, IntRect, Unit> {
    public static final DropdownMenuPositionProvider$1 INSTANCE = new DropdownMenuPositionProvider$1();

    DropdownMenuPositionProvider$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(intRect2, "<anonymous parameter 1>");
    }
}
