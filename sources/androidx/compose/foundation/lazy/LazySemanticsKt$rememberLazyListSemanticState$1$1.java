package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazySemanticsKt$rememberLazyListSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ LazyListState $state;

    LazySemanticsKt$rememberLazyListSemanticState$1$1(boolean z, LazyListState lazyListState, LazyLayoutItemProvider lazyLayoutItemProvider, boolean z2) {
        this.$reverseScrolling = z;
        this.$state = lazyListState;
        this.$itemProvider = lazyLayoutItemProvider;
        this.$isVertical = z2;
    }

    @Nullable
    public Object animateScrollBy(float f, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.$state, f, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    @NotNull
    public CollectionInfo collectionInfo() {
        return this.$isVertical ? new CollectionInfo(-1, 1) : new CollectionInfo(1, -1);
    }

    @NotNull
    public ScrollAxisRange scrollAxisRange() {
        final LazyListState lazyListState = this.$state;
        Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m269invoke() {
                return Float.valueOf(lazyListState.getFirstVisibleItemIndex() + (lazyListState.getFirstVisibleItemScrollOffset() / 100000.0f));
            }
        };
        final LazyListState lazyListState2 = this.$state;
        final LazyLayoutItemProvider lazyLayoutItemProvider = this.$itemProvider;
        return new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m270invoke() {
                float firstVisibleItemIndex;
                float firstVisibleItemScrollOffset;
                if (lazyListState2.getCanScrollForward()) {
                    firstVisibleItemIndex = lazyLayoutItemProvider.getItemCount();
                    firstVisibleItemScrollOffset = 1.0f;
                } else {
                    firstVisibleItemIndex = lazyListState2.getFirstVisibleItemIndex();
                    firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset() / 100000.0f;
                }
                return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
            }
        }, this.$reverseScrolling);
    }

    @Nullable
    public Object scrollToItem(int i, @NotNull Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyListState.scrollToItem$default(this.$state, i, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }
}
