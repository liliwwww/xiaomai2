package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FlowLayoutKt$breakDownItems$nextSize$1 extends Lambda implements Function1<Placeable, Unit> {
    final /* synthetic */ Placeable[] $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$breakDownItems$nextSize$1(Placeable[] placeableArr) {
        super(1);
        this.$placeables = placeableArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Placeable placeable) {
        this.$placeables[0] = placeable;
    }
}
