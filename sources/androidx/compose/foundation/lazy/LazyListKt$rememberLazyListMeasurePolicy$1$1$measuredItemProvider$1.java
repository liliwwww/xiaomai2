package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 implements MeasuredItemFactory {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ int $itemsCount;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ int $spaceBetweenItems;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ long $visualItemOffset;

    LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(int i, int i2, LazyLayoutMeasureScope lazyLayoutMeasureScope, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, boolean z2, int i3, int i4, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j) {
        this.$itemsCount = i;
        this.$spaceBetweenItems = i2;
        this.$this_null = lazyLayoutMeasureScope;
        this.$isVertical = z;
        this.$horizontalAlignment = horizontal;
        this.$verticalAlignment = vertical;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i3;
        this.$afterContentPadding = i4;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$visualItemOffset = j;
    }

    @Override // androidx.compose.foundation.lazy.MeasuredItemFactory
    @NotNull
    /* renamed from: createItem-HK0c1C0, reason: not valid java name */
    public final LazyMeasuredItem mo429createItemHK0c1C0(int i, @NotNull Object obj, @NotNull List<? extends Placeable> list) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(list, "placeables");
        return new LazyMeasuredItem(i, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, this.$placementAnimator, i == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj, (DefaultConstructorMarker) null);
    }
}
