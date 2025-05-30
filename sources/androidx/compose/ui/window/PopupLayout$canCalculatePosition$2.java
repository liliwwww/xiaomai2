package androidx.compose.ui.window;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PopupLayout$canCalculatePosition$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ PopupLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PopupLayout$canCalculatePosition$2(PopupLayout popupLayout) {
        super(0);
        this.this$0 = popupLayout;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m2254invoke() {
        return Boolean.valueOf((PopupLayout.access$getParentLayoutCoordinates(this.this$0) == null || this.this$0.getPopupContentSize-bOM6tXw() == null) ? false : true);
    }
}
