package androidx.compose.foundation.lazy;

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
public final class LazySemanticsKt {
    @Composable
    @NotNull
    public static final LazyLayoutSemanticState rememberLazyListSemanticState(@NotNull final LazyListState lazyListState, @NotNull final LazyLayoutItemProvider lazyLayoutItemProvider, final boolean z, final boolean z2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(1624527721);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624527721, i, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazySemantics.kt:30)");
        }
        boolean z3 = ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(lazyLayoutItemProvider)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(z)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z2)) || (i & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object animateScrollBy(float f, @NotNull Continuation<? super Unit> continuation) {
                    Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(lazyListState, f, null, continuation, 2, null);
                    return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @NotNull
                public CollectionInfo collectionInfo() {
                    return z2 ? new CollectionInfo(-1, 1) : new CollectionInfo(1, -1);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @NotNull
                public ScrollAxisRange scrollAxisRange() {
                    final LazyListState lazyListState2 = lazyListState;
                    Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m1528invoke() {
                            return Float.valueOf(LazyListState.this.getFirstVisibleItemIndex() + (LazyListState.this.getFirstVisibleItemScrollOffset() / 100000.0f));
                        }
                    };
                    final LazyListState lazyListState3 = lazyListState;
                    final LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
                    return new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m1529invoke() {
                            float firstVisibleItemIndex;
                            float firstVisibleItemScrollOffset;
                            if (LazyListState.this.getCanScrollForward()) {
                                firstVisibleItemIndex = lazyLayoutItemProvider2.getItemCount();
                                firstVisibleItemScrollOffset = 1.0f;
                            } else {
                                firstVisibleItemIndex = LazyListState.this.getFirstVisibleItemIndex();
                                firstVisibleItemScrollOffset = LazyListState.this.getFirstVisibleItemScrollOffset() / 100000.0f;
                            }
                            return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
                        }
                    }, z);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                @Nullable
                public Object scrollToItem(int i2, @NotNull Continuation<? super Unit> continuation) {
                    Object scrollToItem$default = LazyListState.scrollToItem$default(lazyListState, i2, 0, continuation, 2, null);
                    return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        LazySemanticsKt$rememberLazyListSemanticState$1$1 lazySemanticsKt$rememberLazyListSemanticState$1$1 = (LazySemanticsKt$rememberLazyListSemanticState$1$1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazySemanticsKt$rememberLazyListSemanticState$1$1;
    }
}
