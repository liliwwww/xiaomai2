package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyAnimateScrollKt$animateScrollToItem$2$3 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $anim;
    final /* synthetic */ float $boundDistancePx;
    final /* synthetic */ boolean $forward;
    final /* synthetic */ int $index;
    final /* synthetic */ Ref.BooleanRef $loop;
    final /* synthetic */ Ref.IntRef $loops;
    final /* synthetic */ Ref.FloatRef $prevValue;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ float $target;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2$3(LazyAnimateScrollScope lazyAnimateScrollScope, int i, float f, Ref.FloatRef floatRef, ScrollScope scrollScope, Ref.BooleanRef booleanRef, boolean z, float f2, Ref.IntRef intRef, int i2, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef) {
        super(1);
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$index = i;
        this.$target = f;
        this.$prevValue = floatRef;
        this.$$this$scroll = scrollScope;
        this.$loop = booleanRef;
        this.$forward = z;
        this.$boundDistancePx = f2;
        this.$loops = intRef;
        this.$scrollOffset = i2;
        this.$anim = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
        Integer targetItemOffset = this.$this_animateScrollToItem.getTargetItemOffset(this.$index);
        if (targetItemOffset == null) {
            float coerceAtMost = (this.$target > 0.0f ? RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), this.$target) : RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), this.$target)) - this.$prevValue.element;
            float scrollBy = this.$$this$scroll.scrollBy(coerceAtMost);
            Integer targetItemOffset2 = this.$this_animateScrollToItem.getTargetItemOffset(this.$index);
            if (targetItemOffset2 == null && !LazyAnimateScrollKt.animateScrollToItem.2.access$invokeSuspend$isOvershot(this.$forward, this.$this_animateScrollToItem, this.$index, this.$scrollOffset)) {
                if (!(coerceAtMost == scrollBy)) {
                    animationScope.cancelAnimation();
                    this.$loop.element = false;
                    return;
                }
                this.$prevValue.element += coerceAtMost;
                if (this.$forward) {
                    if (((Number) animationScope.getValue()).floatValue() > this.$boundDistancePx) {
                        animationScope.cancelAnimation();
                    }
                } else if (((Number) animationScope.getValue()).floatValue() < (-this.$boundDistancePx)) {
                    animationScope.cancelAnimation();
                }
                if (this.$forward) {
                    if (this.$loops.element >= 2 && this.$index - this.$this_animateScrollToItem.getLastVisibleItemIndex() > this.$this_animateScrollToItem.getNumOfItemsForTeleport()) {
                        LazyAnimateScrollScope lazyAnimateScrollScope = this.$this_animateScrollToItem;
                        lazyAnimateScrollScope.snapToItem(this.$$this$scroll, this.$index - lazyAnimateScrollScope.getNumOfItemsForTeleport(), 0);
                    }
                } else if (this.$loops.element >= 2 && this.$this_animateScrollToItem.getFirstVisibleItemIndex() - this.$index > this.$this_animateScrollToItem.getNumOfItemsForTeleport()) {
                    LazyAnimateScrollScope lazyAnimateScrollScope2 = this.$this_animateScrollToItem;
                    lazyAnimateScrollScope2.snapToItem(this.$$this$scroll, this.$index + lazyAnimateScrollScope2.getNumOfItemsForTeleport(), 0);
                }
            }
            targetItemOffset = targetItemOffset2;
        }
        if (!LazyAnimateScrollKt.animateScrollToItem.2.access$invokeSuspend$isOvershot(this.$forward, this.$this_animateScrollToItem, this.$index, this.$scrollOffset)) {
            if (targetItemOffset != null) {
                throw new ItemFoundInScroll(targetItemOffset.intValue(), (AnimationState) this.$anim.element);
            }
        } else {
            this.$this_animateScrollToItem.snapToItem(this.$$this$scroll, this.$index, this.$scrollOffset);
            this.$loop.element = false;
            animationScope.cancelAnimation();
        }
    }
}
