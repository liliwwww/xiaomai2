package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BringIntoViewRequesterModifier extends BringIntoViewChildModifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterModifier(@NotNull BringIntoViewParent bringIntoViewParent) {
        super(bringIntoViewParent);
        Intrinsics.checkNotNullParameter(bringIntoViewParent, "defaultParent");
    }

    @Nullable
    public final Object bringIntoView(@Nullable final Rect rect, @NotNull Continuation<? super Unit> continuation) {
        Object bringChildIntoView;
        BringIntoViewParent parent = getParent();
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        return (layoutCoordinates != null && (bringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterModifier$bringIntoView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Rect m350invoke() {
                Rect rect2 = Rect.this;
                if (rect2 != null) {
                    return rect2;
                }
                LayoutCoordinates layoutCoordinates2 = this.getLayoutCoordinates();
                if (layoutCoordinates2 != null) {
                    return SizeKt.m924toRectuvyYCjk(IntSizeKt.m2202toSizeozmzZPI(layoutCoordinates2.mo1522getSizeYbymL2g()));
                }
                return null;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? bringChildIntoView : Unit.INSTANCE;
    }
}
