package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazySemanticsKt {
    @Composable
    @NotNull
    public static final LazyLayoutSemanticState rememberLazyGridSemanticState(@NotNull final LazyGridState lazyGridState, @NotNull final LazyLayoutItemProvider lazyLayoutItemProvider, final boolean z, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyGridState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(-1950437665);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1950437665, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:30)");
        }
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(lazyGridState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(lazyLayoutItemProvider)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(z)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object animateScrollBy(float f, @NotNull Continuation<? super Unit> continuation) {
                    Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(lazyGridState, f, null, continuation, 2, null);
                    return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @NotNull
                public CollectionInfo collectionInfo() {
                    return new CollectionInfo(-1, -1);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @NotNull
                public ScrollAxisRange scrollAxisRange() {
                    final LazyGridState lazyGridState2 = lazyGridState;
                    Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m471invoke() {
                            return Float.valueOf(lazyGridState2.getFirstVisibleItemIndex() + (lazyGridState2.getFirstVisibleItemScrollOffset() / 100000.0f));
                        }
                    };
                    final LazyGridState lazyGridState3 = lazyGridState;
                    final LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
                    return new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m472invoke() {
                            float firstVisibleItemIndex;
                            float firstVisibleItemScrollOffset;
                            if (lazyGridState3.getCanScrollForward()) {
                                firstVisibleItemIndex = lazyLayoutItemProvider2.getItemCount();
                                firstVisibleItemScrollOffset = 1.0f;
                            } else {
                                firstVisibleItemIndex = lazyGridState3.getFirstVisibleItemIndex();
                                firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset() / 100000.0f;
                            }
                            return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
                        }
                    }, z);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object scrollToItem(int i2, @NotNull Continuation<? super Unit> continuation) {
                    Object scrollToItem$default = LazyGridState.scrollToItem$default(lazyGridState, i2, 0, continuation, 2, (Object) null);
                    return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        LazySemanticsKt$rememberLazyGridSemanticState$1$1 lazySemanticsKt$rememberLazyGridSemanticState$1$1 = (LazySemanticsKt$rememberLazyGridSemanticState$1$1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazySemanticsKt$rememberLazyGridSemanticState$1$1;
    }
}
