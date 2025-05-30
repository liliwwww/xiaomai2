package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable$PlacementScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListMeasureKt$measureLazyList$1 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    public static final LazyListMeasureKt$measureLazyList$1 INSTANCE = new LazyListMeasureKt$measureLazyList$1();

    LazyListMeasureKt$measureLazyList$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$invoke");
    }
}
