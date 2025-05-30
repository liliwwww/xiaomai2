package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.p004ui.semantics.CollectionInfo;
import androidx.compose.p004ui.semantics.ScrollAxisRange;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LazyStaggeredGridSemanticsKt {
    @Composable
    @NotNull
    public static final LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState(@NotNull final LazyStaggeredGridState lazyStaggeredGridState, @NotNull final LazyLayoutItemProvider lazyLayoutItemProvider, final boolean z, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(-1098582625);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1098582625, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridSemanticState (LazyStaggeredGridSemantics.kt:29)");
        }
        boolean changed = composer.changed(lazyStaggeredGridState) | ((((i & 112) ^ 48) > 32 && composer.changed(lazyLayoutItemProvider)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(z)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object animateScrollBy(float f, @NotNull Continuation<? super Unit> continuation) {
                    Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(lazyStaggeredGridState, f, null, continuation, 2, null);
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
                    final LazyStaggeredGridState lazyStaggeredGridState2 = lazyStaggeredGridState;
                    Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m1641invoke() {
                            return Float.valueOf(LazyStaggeredGridState.this.getFirstVisibleItemIndex() + (LazyStaggeredGridState.this.getFirstVisibleItemScrollOffset() / 100000.0f));
                        }
                    };
                    final LazyStaggeredGridState lazyStaggeredGridState3 = lazyStaggeredGridState;
                    final LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
                    return new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m1642invoke() {
                            float firstVisibleItemIndex;
                            float firstVisibleItemScrollOffset;
                            if (LazyStaggeredGridState.this.getCanScrollForward()) {
                                firstVisibleItemIndex = lazyLayoutItemProvider2.getItemCount();
                                firstVisibleItemScrollOffset = 1.0f;
                            } else {
                                firstVisibleItemIndex = LazyStaggeredGridState.this.getFirstVisibleItemIndex();
                                firstVisibleItemScrollOffset = LazyStaggeredGridState.this.getFirstVisibleItemScrollOffset() / 100000.0f;
                            }
                            return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
                        }
                    }, z);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object scrollToItem(int i2, @NotNull Continuation<? super Unit> continuation) {
                    Object scrollToItem$default = LazyStaggeredGridState.scrollToItem$default(lazyStaggeredGridState, i2, 0, continuation, 2, null);
                    return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        C0551x9388a700 c0551x9388a700 = (C0551x9388a700) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c0551x9388a700;
    }
}
