package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class BringIntoViewResponderModifier$bringChildIntoView$2$1$1 extends FunctionReferenceImpl implements Function0<Rect> {
    final /* synthetic */ Function0<Rect> $boundsProvider;
    final /* synthetic */ LayoutCoordinates $childCoordinates;
    final /* synthetic */ BringIntoViewResponderModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderModifier$bringChildIntoView$2$1$1(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0) {
        super(0, Intrinsics.Kotlin.class, "localRect", "bringChildIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderModifier;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
        this.this$0 = bringIntoViewResponderModifier;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = function0;
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Rect m527invoke() {
        return BringIntoViewResponderModifier.access$bringChildIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
    }
}
