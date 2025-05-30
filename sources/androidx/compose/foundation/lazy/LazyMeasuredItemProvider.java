package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LazyMeasuredItemProvider {
    private final long childConstraints;

    @NotNull
    private final LazyListItemProvider itemProvider;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    private LazyMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, MeasuredItemFactory measuredItemFactory) {
        this.itemProvider = lazyListItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.measuredItemFactory = measuredItemFactory;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m5184getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, !z ? Constraints.m5183getMaxHeightimpl(j) : Integer.MAX_VALUE, 5, null);
    }

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, MeasuredItemFactory measuredItemFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, lazyListItemProvider, lazyLayoutMeasureScope, measuredItemFactory);
    }

    @NotNull
    /* renamed from: getAndMeasure-ZjPyQlc, reason: not valid java name */
    public final LazyMeasuredItem m1526getAndMeasureZjPyQlc(int i) {
        return this.measuredItemFactory.mo1512createItemHK0c1C0(i, this.itemProvider.getKey(i), this.measureScope.mo1615measure0kLqBqw(i, this.childConstraints));
    }

    /* renamed from: getChildConstraints-msEJaDk, reason: not valid java name */
    public final long m1527getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemProvider.getKeyToIndexMap();
    }
}
