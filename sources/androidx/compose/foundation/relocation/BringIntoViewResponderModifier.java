package androidx.compose.foundation.relocation;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.modifier.ModifierLocalProvider;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class BringIntoViewResponderModifier extends BringIntoViewChildModifier implements ModifierLocalProvider<BringIntoViewParent>, BringIntoViewParent {
    public BringIntoViewResponder responder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderModifier(@NotNull BringIntoViewParent bringIntoViewParent) {
        super(bringIntoViewParent);
        Intrinsics.checkNotNullParameter(bringIntoViewParent, "defaultParent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect bringChildIntoView$localRect(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0) {
        Rect rect;
        Rect localRectOf;
        LayoutCoordinates layoutCoordinates2 = bringIntoViewResponderModifier.getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            return null;
        }
        if (!layoutCoordinates.isAttached()) {
            layoutCoordinates = null;
        }
        if (layoutCoordinates == null || (rect = (Rect) function0.invoke()) == null) {
            return null;
        }
        localRectOf = BringIntoViewResponderKt.localRectOf(layoutCoordinates2, layoutCoordinates, rect);
        return localRectOf;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    @Nullable
    public Object bringChildIntoView(@NotNull final LayoutCoordinates layoutCoordinates, @NotNull final Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation) {
        Object g = i80.g(new BringIntoViewResponderModifier$bringChildIntoView$2(this, layoutCoordinates, function0, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$parentRect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Rect m1663invoke() {
                Rect bringChildIntoView$localRect;
                bringChildIntoView$localRect = BringIntoViewResponderModifier.bringChildIntoView$localRect(BringIntoViewResponderModifier.this, layoutCoordinates, function0);
                if (bringChildIntoView$localRect != null) {
                    return BringIntoViewResponderModifier.this.getResponder().calculateRectForParent(bringChildIntoView$localRect);
                }
                return null;
            }
        }, null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<BringIntoViewParent> getKey() {
        return BringIntoViewKt.getModifierLocalBringIntoViewParent();
    }

    @NotNull
    public final BringIntoViewResponder getResponder() {
        BringIntoViewResponder bringIntoViewResponder = this.responder;
        if (bringIntoViewResponder != null) {
            return bringIntoViewResponder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("responder");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public BringIntoViewParent getValue() {
        return this;
    }

    public final void setResponder(@NotNull BringIntoViewResponder bringIntoViewResponder) {
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "<set-?>");
        this.responder = bringIntoViewResponder;
    }
}
