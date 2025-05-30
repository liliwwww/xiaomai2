package androidx.compose.foundation.gestures;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ContentInViewModifier$modifier$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentInViewModifier$modifier$1(ContentInViewModifier contentInViewModifier) {
        super(1);
        this.this$0 = contentInViewModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable LayoutCoordinates layoutCoordinates) {
        ContentInViewModifier.access$setFocusedChild$p(this.this$0, layoutCoordinates);
    }
}
